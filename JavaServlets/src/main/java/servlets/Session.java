package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/session")
public class Session extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        String nomeUsuario = null;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("usuario".equals(c.getName())) {
                    nomeUsuario = c.getValue();
                    break;
                }
            }
        }

        if (nomeUsuario == null) {
            nomeUsuario = "X";
            Cookie cookie = new Cookie("usuario", nomeUsuario);
            cookie.setMaxAge(60 * 60 * 24); // 1 dia
            response.addCookie(cookie);
            out.println("Primeira visita. Cookie criado!");
        } else {
            out.println("Bem-vindo de volta, usuário '" + nomeUsuario + "'.");
        }
    }
}

