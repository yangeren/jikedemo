package com.example.jikedemo.service;

import com.example.jikedemo.controller.PDFAction;

public class DependencyInjector {

    public void start() {

    }

    public void shutDown() {

    }

    public Object getObject(Class type) {
        if (type == PDFService.class) {
            return new PDFService();
        } else if (type == PDFAction.class) {
            PDFService pdfService = (PDFService) getObject(PDFService.class);
            PDFAction action = new PDFAction();
            action.setPdfService(pdfService);
            return action;
        }

        return null;
    }
}
