package controllers;

import java.sql.SQLException;
import java.util.List;

import models.Species;
import repositories.SpeciesRepository;

public class ZooController {
    private SpeciesRepository speciesRepository = new SpeciesRepository();

    public String addSpecies(String name, String latinName) {
        Species species = new Species(name, latinName);
        try {
            return speciesRepository.addSpecies(species);
        } catch (SQLException e) {
            return "Failed to add species: " + e;
        }
    }

    public List<Species> getAllSpecies() throws SQLException {
        return speciesRepository.getAllSpecies();
    }

    public String updateSpeciesById(int id, String name, String latinName) throws SQLException {
        Species species = new Species(id, name, latinName);
        return speciesRepository.updateSpeciesById(species);
    }

}
