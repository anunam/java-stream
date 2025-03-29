package Iostreams;

import java.io.*;

public class ConvertUppercaseToLowercase {
    public static void main(String[] args) {
        String sourceFile = "input.txt";
        String destinationFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destinationFile), "UTF-8"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }

            System.out.println("File successfully converted to lowercase and saved as " + destinationFile);
        } catch (IOException e) {
            System.out.println("Error: An IO exception occurred.");
            e.printStackTrace();
        }
    }
}
