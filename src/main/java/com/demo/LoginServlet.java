package com.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(
        description = "login servlet testing",
        urlPatterns = {"/LoginServlet"}
)
public class LoginServlet extends HttpServlet {
    private final String userNamePattern = "^[A-Z][a-zA-z]{2,}$";
    private final String passwordPattern="^(?=.{8,})(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9]*[^A-Za-z0-9][A-Za-z0-9]*$";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputUserName = req.getParameter("userName");
        String inputPassword = req.getParameter("password");
        String password = "pass";
        if (Pattern.matches(userNamePattern, inputUserName) && Pattern.matches(passwordPattern,inputPassword)) {
            req.setAttribute("user", inputUserName);
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter writer = resp.getWriter();
            writer.println("<font color=red>Either username or password is Wrong</font>");
            dispatcher.include(req, resp);
        }
    }

}
