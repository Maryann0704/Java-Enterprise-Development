package by.pvt.product.add;

import by.pvt.pojo.ProductCatalogItem;
import by.pvt.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.logging.Logger;

@Controller
@RequestMapping("/add-product")
public class AddProductController {

    private static Logger log = Logger.getLogger("addProductController");

    @Autowired
    ProductCatalogItemValidator validator;

    @Autowired
    private
    ProductCatalogService productCatalogService;

    @GetMapping
    public ModelAndView showAddProductView() {
        ModelAndView view = new ModelAndView();
        view.setViewName("addProduct");
        return view;
    }

    @PostMapping
    public String submitAddProductForm(
            @ModelAttribute ("item") ProductCatalogItem item,
            @RequestParam("file") MultipartFile file,
            BindingResult result
    ) throws IOException {
        validator.validate(item, result);
        if (result.hasErrors()) {
            return "addProduct";
        }
        log.info("Call submitAddProductForm: " + item);
        log.info("Principal: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        log.info("File: " + file);
        item.setProductImage(file.getBytes());
        //saveToFile(file);

        if (!productCatalogService.addItem(item)) {
            return "addProductError";
        }
        return "addProductOk";
    }

    /*private boolean saveToFile(MultipartFile file) {
        try (FileOutputStream fos = new FileOutputStream(file.getName())) {
            if (file.isEmpty()) return false;

            byte[] bytes = file.getBytes();
            fos.write(bytes);

            return true;
        } catch (IOException e) {
            log.severe(e.getMessage());
            return false;
        }
    }*/
}
