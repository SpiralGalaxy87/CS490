/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Jeni, Jake, Annaleise, Benjamin
 */

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
//import static project.GUI_Driver.os;

public class Main {
    
    private static OS os;
    private static GUI_Driver gui;
    
    public static void main(String args[]) throws FileNotFoundException
    {    
        
        // Functionality originally from GUI_Driver, moved to contain only one main function
         /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Driver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Driver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Driver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Driver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //ProcessQueue processQueue = new ProcessQueue();
        os = new OS(400);
        
        //create CPUs
        CPU cpu1 = new CPU(1, os);
        CPU cpu2 = new CPU(2, os);
        
        os.addCPU(cpu1);
        os.addCPU(cpu2);
        
        
        /* Read in file to create processes and store in the ProcessQueue */
        // pass the path to the file as a parameter, create scanner
        
        File configFile = new File("config.txt");
        Scanner sc = new Scanner(configFile);
        String line;
        String fileName = "";
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            if(!line.startsWith("#"))
            {
                fileName = line;
            }
        }
        sc.close();
        
        File inFile = new File(fileName);
        sc = new Scanner(inFile);
        //read info through scanner, create processes from it
        while (sc.hasNextLine())
        {
            line = sc.nextLine();
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
            
            Process newProcess = new Process(arrivalTime, processID, serviceTime, priority);
            
            for (CPU cpu : os.getCPUList()) {
                cpu.getFutureQueue().enqueue(newProcess);
            }
        }
        
        //test
        //System.out.println(queue1.display());

       
        
        gui = new GUI_Driver(os);
        
        gui.setVisible(true);
    }
    
    public Main()
    {
        System.out.println("Main class initialized");
    }
}
