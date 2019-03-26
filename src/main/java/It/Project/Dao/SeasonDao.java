package It.Project.Dao;

import It.Project.Model.Season;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeasonDao {
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

    public Season getSeason(int id) {
        String SQL = "Select id,season from season where id = ?";
        Season season = new Season();
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                season.setId(rs.getInt("id"));
                season.setSeason(rs.getString("season"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error getSeason");
        }
        return season;
    }

    public List<Season> getAllSeason() {
        String SQL = "select * from season";
        List<Season> seasons = new ArrayList<>();
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                seasons.add(new Season(rs.getInt("id"), rs.getString("season")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error getAllSeason");
        }
        return seasons;
    }

    public Season updateSeason(Season season) {
        String SQL = "update season set season = ? where id = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, season.getSeason());
            stmt.setInt(2, season.getId());
            stmt.execute();
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error update Season");
        }
        return season;

    }

    public boolean deleteSeason(int id) {
        String SQL = "delete from season where id = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            System.out.println("Error delete Season");
            return false;
        }
        return true;
    }

    public boolean addSeason(Season season) {
        String SQL = "insert into season (season) values (?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, season.getSeason());
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error add season");
            return false;
        }
        return true;

    }

}
