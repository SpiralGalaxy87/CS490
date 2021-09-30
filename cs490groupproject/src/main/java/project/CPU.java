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

    public CPU(ProcessQueue readyQueue) {
        this.readyQueue = readyQueue;

        this.curProcess = this.readyQueue.dequeue();
        this.timeRemaining = this.curProcess.getServiceTime();
    }
    
    public void displayStatus(){
        
    }
    
    public void runProcess(){
        
    }
    
}
