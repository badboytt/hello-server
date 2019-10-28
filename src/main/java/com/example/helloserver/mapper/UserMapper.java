package com.example.helloserver.mapper;

import com.example.helloserver.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> selectAll();

    @Select("select * from user where no = #{no}")
    List<User> select(User user);

    @Insert("insert into user (name,age,no,id) value (#{name},#{age},#{no},#{id})")
    int insert(User user);

    @Update("update user set age = #{age} where no = #{no}")
    int update(User user);

    @Insert("<script>" +
            "insert into user (id,name,age,no) values " +
            " <foreach collection ='list' item='it' separator =','>" +
            " (#{it.id},#{it.name},#{it.age},#{it.no})" +
            " </foreach >" +
            "</script>")
    int insertBatch(@Param("list") List<User> userList);
}
