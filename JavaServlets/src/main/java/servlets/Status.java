package servlets;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/status")
public class Status extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String codeParam = request.getParameter("code");
        int code = 200;

        try {
            code = Integer.parseInt(codeParam);
        } catch (Exception ignored) {}

        response.setStatus(code);
        response.getWriter().println("Código de status enviado: " + code);
    }
}

