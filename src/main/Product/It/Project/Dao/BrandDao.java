package It.Project.Dao;

import It.Project.Model.Brand;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrandDao {
    private static final String url = "jdbc:postgresql://138.68.52.248:5432/gr11";
    private static final String user = "gruppa11";
    private static final String password = "1e23qwe34";

    public Connection connect() {
        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);

            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public Brand getBrand(int id) {
        String SQL = "Select id , name  from brand where id = ?;";
        Brand brand = new Brand();
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                brand.setId(rs.getInt("id"));
                brand.setName(rs.getString("name"));
                System.out.println(brand);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return brand;
    }

    public List<Brand> getAllBrands() {
        String SQL = "select  * from brand ";
        List<Brand> brandList = new ArrayList<>();
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                brandList.add(new Brand(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return brandList;

    }

    public void addBrand(Brand brand) {
        String SQL = "insert into brand (name) values(?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setString(1, brand.getName());
            stmt.executeUpdate();
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean deleteBrands(int id) {
        String SQL = "delete  from brand where id = ?;";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    public Brand updateBrands(Brand brand) {
        String SQL = "Update brand set name=? where id = ?;";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setString(1, brand.getName());
            stmt.setInt(2, brand.getId());
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return brand;
    }
}