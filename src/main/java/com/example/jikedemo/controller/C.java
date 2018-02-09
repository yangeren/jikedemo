package com.example.jikedemo.controller;

public class C {
    private B b;

    public C(B b) {
        this.b = b;
    }

    public void importantMethod() {
        b.usefulMethod();
    }
}
