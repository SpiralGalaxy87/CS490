/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Annaleise, Jake, Benjamin
 */
public class CPU implements Runnable{
    private OS o;
    private Process curProcess;
    private int timeRemaining;
    private int id;
    
    public CPU(int id, OS o) {
        this.id = id;
        this.o = o;
        this.timeRemaining = 0;
    }
    
    //This is used in the GUI to display the current action of the CPU.
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
    public int getID() {
        return id;
    }
    
    //This is what the 'thread' runs.

    public void run(){
        //We use while(true) to loop this forever.
        while(true){
            //if the ready queue is not empty, grab it!
            if (o.getReadyQueue().size() > 0) {
                //if the CPU isn't currently working on a process... grab the next one available.
                if(this.timeRemaining <= 0){
                    this.curProcess = o.getReadyQueue().dequeue();
                    try {
                        this.timeRemaining = this.curProcess.getServiceTime();
                        System.out.println("  ...  cpu" + this.id + " thread starting " + this.curProcess.getProcessID() + ", working for " + this.timeRemaining + " time units.");
                    }
                    catch(NullPointerException ex) {
                        
                    }
                }
                //with the process grabbed, sleep for each time unit
                while(this.timeRemaining > 0){
                    try {
                        Thread.sleep((long)(o.getTimeUnitLength()));
                        this.timeRemaining--;
                    } 
                    catch (InterruptedException ex) {
                        return;
                    }
                }
                //once the time remaining has lapsed to zero, set the process' finish time and add to finished list.
                try {
                    this.curProcess.setFinishTime(o.getCurTime());
                    
                    //set turnaround time
                    //set normalized turnaround time: turnaround / service
                    
                    o.getFinishedProcesses().enqueue(this.curProcess);
                    curProcess = null;
                }
                catch(NullPointerException ex) {
                }
            }
            //well, nothing here, so lets wait until there is one there
            else {
                try {
                    Thread.sleep((long)(o.getTimeUnitLength()));
                    
                } 
                catch (InterruptedException ex) {
                // TBD catch and deal with exception ere
                    //System.out.println("Exception caught: " + ex + " with " + this.timeRemaining + " time remaining");
                    return;
                }
            }
        }
        
    }
}
