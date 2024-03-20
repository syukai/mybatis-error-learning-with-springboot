package com.example.mybatisdemo.model;

public class DemoPk {
    public String value;

    public DemoPk(String pk) {
        this.value = pk;
    }

    public String getThrowProp() throws Exception {
        throw new Exception("hoge");
    }
}
