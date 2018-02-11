package com.example.jikedemo.controller;

import com.example.jikedemo.service.PDFService;

public class PDFAction {
    private PDFService pdfService;

    public void setPdfService(PDFService pdfService) {
        this.pdfService = pdfService;
    }

    public void createPDF(String path, String input) {
        pdfService.createPDF(path, input);
    }
}
