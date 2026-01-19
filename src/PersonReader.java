import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PersonReader {
    public static void main(String[] args) {

        // Use JFileChooser to let user pick the file
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            Path file = chooser.getSelectedFile().toPath();

            // Print table header
            System.out.printf("%-8s %-12s %-12s %-8s %-6s%n",
                    "ID#", "Firstname", "Lastname", "Title", "YOB");
            System.out.println("==============================================");

            try {
                BufferedReader reader = Files.newBufferedReader(file);
                String line;

                // Read each line from the file
                while ((line = reader.readLine()) != null) {

                    // Split CSV record
                    String[] fields = line.split(",");

                    // Display formatted output
                    System.out.printf("%-8s %-12s %-12s %-8s %-6s%n",
                            fields[0],
                            fields[1],
                            fields[2],
                            fields[3],
                            fields[4]);
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
