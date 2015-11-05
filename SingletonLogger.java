/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonlogger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Achilleas
 */
public class SingletonLogger {

    protected static SingletonLogger instance = null;
    protected static // Assume default encoding.
            FileWriter fileWriter;
    protected static // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter;
    // The name of the file to open.
    protected static String fileName = "logfile.txt";
    
    protected SingletonLogger() {
    // exists only to defeat instantiation.     
    }
    
    protected static SingletonLogger getInstance() {
        if (instance == null) {
            instance = new SingletonLogger();
            try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
           
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        }
    return instance;

    }

}
