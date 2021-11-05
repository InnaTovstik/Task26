package org.example;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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
            Map<String, String[]> map = request.getParameterMap();
            for (Map.Entry<String, String[]> item : map.entrySet()) {
                String[] mapValues = item.getValue();
                for (String mapValue : mapValues) {
                    response.getWriter().println("Key: " + item.getKey() + "Value: " + mapValue);
                }
            }
         countGet = ClickOutput.returnCountClick(countGet);
        } else if (method == "POST") {
            response.getWriter().println("from POST");
            countPost = ClickOutput.returnCountClick(countPost);
        }
        response.getWriter().println("GET: " + countGet);
        response.getWriter().println("POST: " + countPost);
    }
}