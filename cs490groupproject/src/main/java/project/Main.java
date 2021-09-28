/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Jeni, Jake, Annaleise, Ben
 */

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
    
    public OS os;
    public GUI_Driver gui;
    
    public static void main(String args[]) throws FileNotFoundException
    {
    
        
        /* Read in file to create processes and store in the ProcessQueue */
        // pass the path to the file as a parameter, create scanner
        File inFile = new File("input.txt");
        Scanner sc = new Scanner(inFile);
        //read info through scanner, create processes from it
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            //System.out.println(line);
            
            Scanner lineSc = new Scanner(line).useDelimiter("\\s*,\\s");
            
            //arrival time
            int arrivalTime = lineSc.nextInt();
            
            //process id
            String processID = lineSc.next();
            
            //service time
            int serviceTime = lineSc.nextInt();
            
            //priority
            int priority = lineSc.nextInt();
            
            
            //Process newProcess = new Process(arrivalTime, processID, serviceTime, priority);
            
            //System.out.println(newProcess.display());
            
        }
        //
    
    }
    
    public Main()
    {
        os = new OS(100);
        gui = new GUI_Driver(os);
    }
}
