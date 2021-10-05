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
    private OS o;
    //private ProcessQueue readyQueue;
    private Process curProcess;
    private int timeRemaining;
    private int id;
    
    public CPU(int id, OS o) {
        this.id = id;
        this.o = o;
        this.timeRemaining = 0;
    }
    public String displayStatus()
    {
        String status = ("CPU " + id) + "\n";
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
        while(o.readyQueue.size() > 0){

            if(this.timeRemaining == 0){
                this.curProcess = o.readyQueue.dequeue();
                this.timeRemaining = this.curProcess.getServiceTime();
            }   
           
            System.out.println("  ...  cpu thread starting " + this.curProcess.getProcessID() + ", working for " + this.timeRemaining + " time units.");

            while(this.timeRemaining > 0){
                try {
                    Thread.sleep((long)(o.getTimeUnitLength()));
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
