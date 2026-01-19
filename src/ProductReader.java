import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProductReader {
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            Path file = chooser.getSelectedFile().toPath();

            // Table header
            System.out.printf("%-8s %-15s %-25s %-8s%n",
                    "ID#", "Name", "Description", "Cost");
            System.out.println("======================================================");

            try {
                BufferedReader reader = Files.newBufferedReader(file);
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] fields = line.split(",");

                    System.out.printf("%-8s %-15s %-25s $%-8s%n",
                            fields[0],
                            fields[1],
                            fields[2],
                            fields[3]);
                }

                reader.close();
            }
            catch (IOException e) {
                System.out.println("Error reading the file.");
            }
        }
        else {
            System.out.println("No file selected.");
        }
    }
}
