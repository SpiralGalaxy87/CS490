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
import static project.GUI_Driver.os;

public class Main {
    
    public static OS os;
    public static GUI_Driver gui;
    
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

        os = new OS(100);
        gui = new GUI_Driver(os);
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gui.setVisible(true);
            }
        });
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
    }
    
    public Main()
    {
        System.out.println("Main class initialized");
        
    }
}
