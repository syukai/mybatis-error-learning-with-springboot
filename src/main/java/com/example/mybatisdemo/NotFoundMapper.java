package com.example.mybatisdemo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NotFoundMapper {
    String get();
}
