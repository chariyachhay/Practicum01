import javax.swing.JFileChooser;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class PersonReader {
    public static void main(String[] args) {
        ArrayList<String[]> persons = new ArrayList<>();

        // Open file chooser window
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null); // This will pop up a window

        if(result == JFileChooser.APPROVE_OPTION){
            Path filePath = chooser.getSelectedFile().toPath();

            try {
                // Read each line of the file
                for(String line : Files.readAllLines(filePath)){
                    String[] fields = line.split(",");
                    persons.add(fields);
                }

                // Print table header
                System.out.printf("%-8s %-10s %-10s %-6s %-6s%n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("==========================================");

                // Print each record
                for(String[] p : persons){
                    System.out.printf("%-8s %-10s %-10s %-6s %-6s%n", p[0], p[1], p[2], p[3], p[4]);
                }

            } catch(Exception e){
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }
}
