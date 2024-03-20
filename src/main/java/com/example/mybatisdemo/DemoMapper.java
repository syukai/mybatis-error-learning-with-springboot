package com.example.mybatisdemo;

import com.example.mybatisdemo.model.DemoPk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DemoMapper {

    List<Demo> get();

    Demo getById(@Param("pk") DemoPk pk);

    void insert(@Param("pk") String pk, @Param("name") String name, @Param("quantity") int quantity);

    Demo wrongSelect(@Param("pk")DemoPk pk);

    Demo wrongBind(@Param("pk")DemoPk pk);
    Demo wrongProperty(@Param("pk")DemoPk pk);

    Demo wrongTable();

    Demo wrongColumn();

    Demo2 badConstructor();
}
