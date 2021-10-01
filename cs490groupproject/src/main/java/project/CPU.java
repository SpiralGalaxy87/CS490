/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Annaleise, Jake
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
    public void setTimeUnitLength(int length)
    {
        this.timeUnitLength = length;
    }
    public String displayStatus()
    {
        String status = ("CPU " + key) + "\n";
        if (curProcess != null)
        {
            status += "Exec: Process " + curProcess.getProcessID() + "\n";
            status += "Time Remaining = " + timeRemaining + "\n";
        }
        else
        {
            status += "Exec: idle\n" + "Time Remaining = N/A\n";
        }        
        return status;
    }

    public void run(){
        while(this.readyQueue.size() > 0){

            if(this.timeRemaining == 0){
                this.curProcess = this.readyQueue.dequeue();
                this.timeRemaining = this.curProcess.getServiceTime();
            }   
           
            System.out.println("  ...  cpu thread starting " + this.curProcess.getProcessID() + ", working for " + this.timeRemaining + " time units.");

            while(this.timeRemaining > 0){
                try {
                    Thread.sleep((long)(this.timeUnitLength));
                    this.timeRemaining--;
                } 
                catch (InterruptedException ex) {
                // TBD catch and deal with exception ere
                    System.out.println("Exception caught: " + ex + " with " + this.timeRemaining + " time remaining");
                    return;
                }
            }
            System.out.println(this.curProcess.getProcessID() + " finished");
        }
    }
}
