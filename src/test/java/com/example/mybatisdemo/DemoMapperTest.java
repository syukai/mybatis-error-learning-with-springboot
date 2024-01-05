package com.example.mybatisdemo;

import org.apache.ibatis.binding.BindingException;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
class DemoMapperTest {

    @Autowired
    DemoMapper mapper;

    @Autowired
    NotFoundMapper notFoundMapper;

    @Test
    void insertとgetが動くことの確認() {
        mapper.insert("a002", "name", 0);
        Demo demo = mapper.get();
        assertEquals("name", demo.name);

    }

    @Test
    void insert() {
    }

    @Test
    void マッパーXMLが見つからないとBindingException出る() {
        assertThrows(BindingException.class, () -> notFoundMapper.get());
    }
}