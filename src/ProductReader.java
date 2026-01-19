import javax.swing.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;

public class ProductReader {
    public static void main(String[] args) throws IOException {
        System.out.println("=== Product Reader ===");

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("src")); // start in src folder
        int result = chooser.showOpenDialog(null);

        if(result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getName());

            List<String> lines = Files.readAllLines(selectedFile.toPath());

            System.out.printf("%-8s %-15s %-30s %-10s%n", "ID#", "Name", "Description", "Cost");
            System.out.println("============================================================");

            for(String line : lines) {
                String[] parts = line.split(",\\s*");
                System.out.printf("%-8s %-15s %-30s %-10s%n", parts[0], parts[1], parts[2], parts[3]);
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
