import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import controllers.ZooController;
import models.Species;
import utils.Tools;

public class App {
    private static ZooController zc = new ZooController();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        promptUpdateSpecies();
    }

    private static void promptAddSpecies() {
        Tools.clearConsole();
        String name = Tools.validateString(input, "Enter the species name");
        String latinName = Tools.validateString(input, "Enter the species latin name");
        System.out.println(zc.addSpecies(name, latinName));
        Tools.waitForUser(input);
    }

    private static void printAllSpecies() {
        try {
            List<Species> species = zc.getAllSpecies();
            for (Species sp : species) {
                System.out.println(sp);
            }
        } catch (SQLException e) {
            System.out.println("Error getting species: " + e);
        }
    }

    private static void promptUpdateSpecies() {
        Tools.clearConsole();
        printAllSpecies();
        int id = Tools.validateInt(input, "Enter the species id");
        String name = Tools.validateString(input, "Enter the species name");
        String latinName = Tools.validateString(input, "Enter the species latin name");
        try {
            System.out.println(zc.updateSpeciesById(id, name, latinName));
        } catch (SQLException e) {
            System.out.println("Error updating species: " + e);
        }
        Tools.waitForUser(input);
    }
}
