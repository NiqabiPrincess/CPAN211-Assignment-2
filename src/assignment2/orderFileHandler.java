package assignment2;

import java.io.*;

public class OrderFileHandler {

    private static final String FILE_NAME = "Orders.txt";

    public static void saveOrder(String name, String phone, String cake, String size, boolean freeDelivery) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write("Name: " + name);
            writer.newLine();
            writer.write("Phone: " + phone);
            writer.newLine();
            writer.write("Cake: " + cake);
            writer.newLine();
            writer.write("Size: " + size);
            writer.newLine();
            writer.write("Free Delivery: " + (freeDelivery ? "Yes" : "No"));
            writer.newLine();
            writer.write("-----------------------------");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving order: " + e.getMessage());
        }
    }
}
