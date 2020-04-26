package com.servlet;

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
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "name", value = "^[A-Z]{1}+[a-z]{2,}$"),
                @WebInitParam(name = "user", value = "Akshay"),
                @WebInitParam(name = "password", value = "^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[~!@#$%^&*()_+?<>/{}])(?=.*?[a-z]).{8,}$")
        }
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // GET USER AND PASSWORD
        String nameOfUser = request.getParameter("nameOfUser");
        String userLogin = request.getParameter("userLogin");
        String pwd = request.getParameter("pwd");

        // GET SERVLET CONFIG
        String name = getServletConfig().getInitParameter("name");
        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");

        if (userLogin.equals(userID) && Pattern.matches(password, pwd) && Pattern.matches(name, nameOfUser)) {
            request.setAttribute("userID", userLogin);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=green>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
    }
}
