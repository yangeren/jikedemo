package com.example.jikedemo.controller;

import com.example.jikedemo.service.DependencyInjector;

import javax.servlet.ReadListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ControllerServletPDF", urlPatterns = {"/form", "/pdf"})
public class ControllerServletPDF extends HttpServlet{

    private DependencyInjector dependencyInjector;

    @Override
    public void init() throws ServletException {
        dependencyInjector = new DependencyInjector();
        dependencyInjector.start();
    }

    @Override
    public void destroy() {
        dependencyInjector.shutDown();
    }
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ReadListener r = null;

        String uri = request.getRequestURI();

        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);
        if ("form".equals(action)) {
            String dispatchUrl = "/jsp/Form.jsp";
        }
    }
}
