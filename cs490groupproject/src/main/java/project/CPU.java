/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Annaleise
 */
public class CPU implements Runnable{
    private ProcessQueue readyQueue;
    private Process curProcess;
    private int timeRemaining;

    public CPU(ProcessQueue readyQueue) {
        this.readyQueue = readyQueue;
        this.curProcess = this.readyQueue.dequeue();
        this.timeRemaining = this.curProcess.getServiceTime();
    }
    
    public void displayStatus(){
        
    }
    
    public void run(){


        System.out.println("  ...  cpu thread starting wait for " + this.curProcess.getServiceTime());
        try {
            
            Thread.sleep((long)(this.curProcess.getServiceTime() * 1000));  // sleepN needs to be converted to milliseconds
        } catch (InterruptedException ex) {
            // TBD catch and deal with exception ere
           System.out.println("Exception caught: " + ex);

        }
        System.out.println("  ...  ...  Slumber thread has woken up ");
    }
    
}
