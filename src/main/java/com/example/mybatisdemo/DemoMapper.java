package com.example.mybatisdemo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DemoMapper {

    Demo get();

    void insert(@Param("id") String id, @Param("name") String name, @Param("quantity") int quantity);
}
