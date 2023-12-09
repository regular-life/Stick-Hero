package com.project.stickhero;

import java.io.*;

public class TextFileHandler
{

    private static final String TEXT_FILE_PATH = "C:\\Users\\yashb\\OneDrive\\Desktop\\Codes\\College-Codes\\Stick-Hero\\src\\main\\java\\com\\project\\stickhero\\HighestScore";

    public static void addDataToTextFile(String data)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEXT_FILE_PATH, false)))
        {
            // Append data to the text file
            writer.write(data);
            writer.newLine(); // Add a newline for each entry
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    public static String readDataFromTextFile()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(TEXT_FILE_PATH)))
        {
            String line;

            // Read and print each line from the text file
            line = reader.readLine() ;
            return line;
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return "" ;
    }
}
