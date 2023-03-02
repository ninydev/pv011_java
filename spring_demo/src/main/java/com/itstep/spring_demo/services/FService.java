package com.itstep.spring_demo.services;

public class FService {

    final int a;
    final int b;
    final int c;
    final int d;
    FService(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public float plus() {
        return ((a/b) + (c/d));
    }

}
