import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {
    public static void main(String[] args)
    {
        // Product Writer
//        a. ID (String)
//        b. Name (String)
//        c. Description (String)
//        d. Cost (double)

        String ID = "";
        String name = "";
        String desc = "";
        double cost = 0.0;
        String csvRec = "";
        boolean done = false;

        Scanner in = new Scanner(System.in);
        ArrayList<String> recs = new ArrayList<>();

        // Loop and collect product data
        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter Product ID");
            name = SafeInput.getNonZeroLenString(in, "Enter Product Name");
            desc = SafeInput.getNonZeroLenString(in, "Enter Product Description");
            cost = SafeInput.getDouble(in, "Enter Product Cost");

            csvRec = ID + ", " + name + ", " + desc + ", " + cost;
            recs.add(csvRec);

            done = SafeInput.getYNConfirm(in, "Are you done");
        } while(!done);

        // Write file to src folder
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(String rec : recs)
            {
                writer.write(rec, 0, rec.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Product data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
