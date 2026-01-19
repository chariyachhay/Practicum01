import java.util.*;
import java.io.*;
import java.nio.file.*;

public class ProductWriter {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        List<String> products = new ArrayList<>();
        boolean addMore = true;

        System.out.println("=== Product Writer ===");

        while(addMore) {
            String id = SafeInput.getNonZeroLenString(in, "Enter Product ID");
            String name = SafeInput.getNonZeroLenString(in, "Enter Product Name");
            String desc = SafeInput.getNonZeroLenString(in, "Enter Product Description");
            double cost = SafeInput.getDouble(in, "Enter Product Cost");

            String line = String.format("%s, %s, %s, %.1f", id, name, desc, cost);
            products.add(line);

            addMore = SafeInput.getYNConfirm(in, "Add another product?");
        }

        String fileName = SafeInput.getNonZeroLenString(in, "Enter file name to save (e.g., ProductTestData.txt)");

        Path filePath = Paths.get("src", fileName);
        Files.write(filePath, products);

        System.out.println("File saved successfully: " + filePath.toAbsolutePath());
    }
}
