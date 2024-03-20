package com.example.mybatisdemo;

public class Demo2 {
    private Demo2(Demo demo) {
        this.pk = demo.pk;
    }
//    private Demo2(int quantity) {
//        this.quantity =quantity;
//    }

    public String pk;
    public String name;
    public int quantity;
}
