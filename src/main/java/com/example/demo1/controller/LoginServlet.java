package com.example.demo1.controller;

import com.example.demo1.dao.EmployeeDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check if username and password match
        if (isValidUser(username, password)) {
            // If valid, create a session and redirect to success page
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Storing username in cookie
            Cookie usernameCookie = new Cookie("username", username);
            usernameCookie.setMaxAge(30 * 24 * 60 * 60); // Cookie valid for 30 days
            response.addCookie(usernameCookie);

            response.sendRedirect("welcome.jsp");
        } else {
            // If not valid, redirect back to login page with error message
            response.sendRedirect("login.jsp?error=1");
        }
    }

    // Dummy method for user validation (replace with actual database check)
    private boolean isValidUser(String username, String password) {
        // Connect to the database
        try (Connection connection = EmployeeDao.getConnection()) {
            String query = "SELECT * FROM employee WHERE username = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    // If a user with the provided username and password exists
                    return resultSet.next();
                }
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        }
        return false;
    }
}
