package com.example.pos.servlet;

import com.example.pos.DBConnection;
import com.example.pos.model.Product;
import com.google.gson.Gson;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        List<Product> products = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM products")) {
            while (rs.next()) {
                products.add(new Product(
                  rs.getInt("id"),
                  rs.getString("name"),
                  rs.getDouble("price"),
                  rs.getInt("quantity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.getWriter().write(new Gson().toJson(products));
    }
}