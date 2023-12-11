package com.project.stickhero;

import java.io.*;

public class TextFileHandler
{

//    private static final String TEXT_FILE_PATH = "/home/yash/Downloads/Stick-Hero/src/main/java/com/project/stickhero/HighestScore";

    private static final String TEXT_FILE_PATH = System.getProperty("user.dir") + "/src/main/java/com/project/stickhero/HighestScore";

    public static void addDataToTextFile(String data)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEXT_FILE_PATH, false)))
        {
            writer.write(data);
            writer.newLine();
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
            line = reader.readLine() ;
            return line;
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return "" ;
    }

    public static void main(String[] args)
    {
        System.out.println(readDataFromTextFile());
        int sc = Integer.parseInt(readDataFromTextFile());
        System.out.println(sc);
    }
}
