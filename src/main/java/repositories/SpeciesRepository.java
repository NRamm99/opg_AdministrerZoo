package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DatabaseConfig;
import models.Species;

public class SpeciesRepository {

    public String addSpecies(Species species) throws SQLException {
        String sql = "INSERT INTO species (name, latin_name) VALUES (?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, species.getName());
            stmt.setString(2, species.getLatinName());

            stmt.executeUpdate();
            return "Species successfully added!";
        } catch (SQLException e) {
            return "Failed to add species: " + e;
        }
    }

    public List<Species> getAllSpecies() throws SQLException {
        String sql = "SELECT id, name, latin_name FROM species";

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            List<Species> species = new ArrayList<>();

            while (rs.next()) {
                species.add(new Species(rs.getInt("id"), rs.getString("name"), rs.getString("latin_name")));
            }
            return species;
        }
    }

    public String updateSpeciesById(Species species) throws SQLException {
        String sql = "UPDATE species SET name = ?, latin_name = ? WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, species.getName());
            stmt.setString(2, species.getLatinName());
            stmt.setInt(3, species.getId());
            stmt.executeUpdate();
            return "Species successfully updated!";
        } catch (SQLException e) {
            return "Failed to update species: " + e;
        }
    }

    public Species getSpeciesById(int id) throws SQLException {
        String sql = "SELECT id, name, latin_name FROM species WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            return new Species(rs.getInt("id"), rs.getString("name"), rs.getString("latin_name"));
        } catch (SQLException e) {
            return null;
        }
    }
}
