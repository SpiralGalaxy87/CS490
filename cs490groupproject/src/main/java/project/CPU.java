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
public class CPU {
    private ProcessQueue readyQueue;
    private Process curProcess;
    private int timeRemaining;
    private static int key = 1; // creates unique CPU ID for when we process multiple CPUs

    public CPU(ProcessQueue readyQueue) {
        this.readyQueue = readyQueue;
        this.curProcess = this.readyQueue.pop();
        this.timeRemaining = this.curProcess.getServiceTime();
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
    
    public void runProcess(){
        
    }
    
}
