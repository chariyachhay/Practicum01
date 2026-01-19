import java.util.*;
import java.nio.file.*;
import java.io.*;

public class PersonGenerator {
    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);  // Must pass this to SafeInput
        List<String> persons = new ArrayList<>();

        System.out.println("=== Person Generator ===");

        boolean addMore = true;
        while (addMore) {
            // Use SafeInput to collect each field
            String id = SafeInput.getNonZeroLenString(pipe, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(pipe, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(pipe, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(pipe, "Enter Title");
            int yearOfBirth = SafeInput.getInt(pipe, "Enter Year of Birth");

            // Combine into CSV format
            String record = id + "," + firstName + "," + lastName + "," + title + "," + yearOfBirth;
            persons.add(record);

            // Ask if the user wants to add another person
            addMore = SafeInput.getYNConfirm(pipe, "Add another person?");
        }

        // Ask for file name to save
        String fileName = SafeInput.getNonZeroLenString(pipe, "Enter file name to save (e.g., PersonTestData.txt)");

        // Write the list to the file
        Path file = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (String person : persons) {
                writer.write(person);
                writer.newLine();
            }
            System.out.println("File saved successfully: " + file.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        pipe.close();  // Close scanner when done
    }
}
