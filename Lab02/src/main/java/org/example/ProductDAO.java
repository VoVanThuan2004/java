package org.example;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO <P extends Product, L extends Long> implements Repository {
    private Connection conn;

    public ProductDAO(String args[]) {
        this.conn = ConnectDatabase.getConnection(args);
        SetDataBase.setUpDB(conn);
    }

    @Override
    public List<Product> readAll() {
        List<Product> result = new ArrayList<Product>();
        try {
            PreparedStatement ptm = conn.prepareStatement("select * from product");
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                String color = rs.getString("color");

                Product p = new Product(name, price, color);
                p.setId(id);
                result.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Object read(Object id) {
        int id_product = 0;
        String name = "";
        Double price = 0.0;
        String color = "";
        try {
            PreparedStatement ptm = conn.prepareStatement("select * from product where id = ?");
            ptm.setInt(1, Integer.parseInt(id.toString()));
            ResultSet rs = ptm.executeQuery();

            while (rs.next()) {
                id_product = rs.getInt("id");
                name = rs.getString("name");
                price = rs.getDouble("price");
                color = rs.getString("color");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Product p = new Product(name, price, color);
        p.setId(id_product);
        return p;
    }

    @Override
    public Object add(Object object) {
        Product product = (Product) object;
        Product result = null;
        try {
            PreparedStatement ptm = conn.prepareStatement("insert into product (name, price, color) values (?, ?, ?)");
            ptm.setString(1, product.getName());
            ptm.setDouble(2, product.getPrice());
            ptm.setString(3, product.getColor());
            ptm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public boolean update(Object object) {
        Product p = (Product) object;
        try {
            PreparedStatement ptm = conn.prepareStatement("update product set name = ?, price = ?, color = ? where id = ?");
            ptm.setString(1, p.getName());
            ptm.setDouble(2, p.getPrice());
            ptm.setString(3, p.getColor());
            ptm.setInt(4, p.getId());

            if (ptm.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Object id) {
        try {
            PreparedStatement ptm = conn.prepareStatement("delete from product where id = ?");
            ptm.setInt(1, Integer.parseInt(id.toString()));

            if (ptm.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
