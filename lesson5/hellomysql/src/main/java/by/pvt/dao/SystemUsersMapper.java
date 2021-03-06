package by.pvt.dao;

import by.pvt.dto.SystemUsers;
import by.pvt.dto.SystemUsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemUsersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_users
     *
     * @mbg.generated Thu Jul 25 18:41:17 MSK 2019
     */
    long countByExample(SystemUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_users
     *
     * @mbg.generated Thu Jul 25 18:41:17 MSK 2019
     */
    int deleteByExample(SystemUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_users
     *
     * @mbg.generated Thu Jul 25 18:41:17 MSK 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_users
     *
     * @mbg.generated Thu Jul 25 18:41:17 MSK 2019
     */
    int insert(SystemUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_users
     *
     * @mbg.generated Thu Jul 25 18:41:17 MSK 2019
     */
    int insertSelective(SystemUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_users
     *
     * @mbg.generated Thu Jul 25 18:41:17 MSK 2019
     */
    List<SystemUsers> selectByExample(SystemUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_users
     *
     * @mbg.generated Thu Jul 25 18:41:17 MSK 2019
     */
    SystemUsers selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_users
     *
     * @mbg.generated Thu Jul 25 18:41:17 MSK 2019
     */
    int updateByExampleSelective(@Param("record") SystemUsers record, @Param("example") SystemUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_users
     *
     * @mbg.generated Thu Jul 25 18:41:17 MSK 2019
     */
    int updateByExample(@Param("record") SystemUsers record, @Param("example") SystemUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_users
     *
     * @mbg.generated Thu Jul 25 18:41:17 MSK 2019
     */
    int updateByPrimaryKeySelective(SystemUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_users
     *
     * @mbg.generated Thu Jul 25 18:41:17 MSK 2019
     */
    int updateByPrimaryKey(SystemUsers record);
}