package org.example;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {

    private int countGet = 0;
    private int countPost = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doTask(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doTask(request, response);
    }

    private void doTask(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String method = request.getMethod();
        if (method == "GET") {
            String author = request.getParameter("author");
            String book = request.getParameter("book");
            response.getWriter().println("author:" + author + " book:" + book);
            countGet = ClickOutput.returnCountClick(countGet);
        } else if (method == "POST") {
            response.getWriter().println("from POST");
            countPost = ClickOutput.returnCountClick(countPost);
        }
        response.getWriter().println("GET: " + countGet);
        response.getWriter().println("POST: " + countPost);
    }
}