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
    private int timeUnitLength;

    public CPU(ProcessQueue readyQueue) {
        this.readyQueue = readyQueue;
        //this.curProcess = this.readyQueue.dequeue();
        //this.timeRemaining = this.curProcess.getServiceTime();
        this.timeRemaining = 0;
        this.timeUnitLength = 1000; //time unit length in ms
    }
    
    public void displayStatus(){
        
    }
    
    public void run(){
        while(this.readyQueue.size() > 0){

            if(this.timeRemaining == 0){
                this.curProcess = this.readyQueue.dequeue();
                this.timeRemaining = this.curProcess.getServiceTime();
            }   
           
            System.out.println("  ...  cpu thread starting " + this.curProcess.getProcessID() + ", working for " + this.curProcess.getServiceTime() + " time units.");

            while(this.timeRemaining > 0){
                try {
                    Thread.sleep((long)(this.timeUnitLength));
                    this.timeRemaining--;
                } 
                catch (InterruptedException ex) {
                // TBD catch and deal with exception ere
                    System.out.println("Exception caught: " + ex);
                    return;
                }
            }
            System.out.println(this.curProcess.getProcessID() + " finished");

            this.curProcess = this.readyQueue.dequeue();
            this.timeRemaining = this.curProcess.getServiceTime();
        }
    }
}
