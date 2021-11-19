/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Comparator;

/**
 *
 * @author Annaleise, Jake, Benjamin
 */
public class CPU implements Runnable{
    private OS o;
    private ProcessQueue readyQueue;
    private ProcessQueue  finishedQueue;
    private Process curProcess;
    private int timeRemaining;
    private int id;
    
    public CPU(int id, OS o) {
        this.id = id;
        this.o = o;
        this.timeQuantumLength = 2; //later set this with user input;
        this.quantumRemaining = this.timeQuantumLength;
        
        if(this.id == 2){ //for round robin, always insert at the back of the queue
            this.readyQueue = new ProcessQueue(new Comparator<Process>() {
                @Override
                public int compare(Process left, Process right) {
                    return 1;
                }
            }); 
        }
        else //for first come first served, use the priority/arrival sorted queue
        {
          this.readyQueue = new ProcessQueue();  
        }
        
        //use the unique constructor to sort by finish time.
        this.finishedQueue = new ProcessQueue(new Comparator<Process>() {
            @Override
            public int compare(Process left, Process right) {
                int returnVal;
                if (left.getFinishTime() < right.getFinishTime())
                {
                    returnVal = -1;
                }
                else if (left.getFinishTime() > right.getFinishTime())
                {
                    returnVal = 1;
                }
                else
                {
                    returnVal = 0;
                }
                return returnVal;
            }
        });
    }
    public ProcessQueue getFinishedQueue(){
        
        return this.finishedQueue;
    }
    public String displayQueueState() {
        
        String state = "";
        for (Process p : readyQueue.getProcess())
        {
            state += p.getProcessID();
            state += "\t";
            state += p.getServiceTime();
            state += "\n";
        }  
        return state;
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
    
    public String displayFinished(){
        String status = "";
        if (finishedQueue.getProcess() != null)
        {
            for (Process process : finishedQueue.getProcess())
            {
                String line = "";
                line += String.format("%1$-13s", process.getProcessID());
                line += String.format("%1$-12d", process.getArrivalTime());
                line += String.format("%1$-13d", process.getServiceTime());
                line += String.format("%1$-13d", process.getFinishTime());
                line += String.format("%1$-7d", process.getTurnTime());
                line += String.format("%1$-7d", process.getNormalTurnTime());
                status += line + "\n";
                //status += process.getProcessID() + "\t" + process.getArrivalTime() + "\t" + process.getServiceTime()+ "\t" + process.getFinishTime() + "\t" + process.getTurnTime() + "\t" + process.getNormalTurnTime() + "\n";
            }
        }
        //status += "Current throughput = " + computeThroughput() + "\n";
        //status += "Current time = " + curTime + " units";
        
        return status;
    }
    
    public int getID() {
        return id;
    }
    //This is what the 'thread' runs.
    
    public ProcessQueue getReadyQueue(){
        
        return this.readyQueue;
    }
     
    public void step(){
        while(futureQueue.size() > 0 && futureQueue.peek().getArrivalTime()==o.getCurTime()) {
            readyQueue.enqueue(futureQueue.dequeue());
        }
        if(this.id == 1){
                //If the readyQueue is not empty, and we don't have a current process, grab the next one.
            if((curProcess == null || curProcess.getTimeRemaining() == 0) && readyQueue.size() > 0) {
                curProcess = readyQueue.dequeue();
                System.out.println("  ...  cpu" + this.id + " starting work on " + curProcess.getProcessID() + ", working for " + curProcess.getTimeRemaining() + " time units.");
            }
            try {
                Thread.sleep((long)(o.getTimeUnitLength()));
            } catch (InterruptedException ex) {
                return;
            }
            if (curProcess != null) {
                curProcess.setTimeRemaining(curProcess.getTimeRemaining() - 1);
            }
            if (curProcess != null && curProcess.getTimeRemaining() == 0) {
                curProcess.setFinishTime(o.getCurTime()+1);
                finishedQueue.enqueue(this.curProcess);
                curProcess = null;
            } 
            
        }
        else{
            //roundRobin_step();
        }
    }
    
    public void roundRobin(){
        //While the CPU isn't paused...
        while(true){
            while(this.futureQueue.size() > 0 && this.futureQueue.peek().getArrivalTime()==this.curTime) {
                this.readyQueue.enqueue(this.futureQueue.dequeue());
            } 
            if (readyQueue.size() > 0 || this.curProcess != null) { //if there are processes in the queue, or we currently have a process we are working on...
                
                if(this.curProcess == null){ //if we don't currently have a process...
                    this.curProcess = readyQueue.dequeue(); //grab the first process from the ready queue
                }
                if(this.quantumRemaining <= 0){ //if the time quantum has expired...
                    if(this.curProcess.getTimeRemaining() > 0){         //if there is still time left on the current process
                        readyQueue.enqueue(this.curProcess);            //add the current process to the back of the queue
                    }
                    else                                                //if the current process has finished
                    {
                      this.curProcess.setFinishTime(this.curTime);    //set finish time
                      finishedQueue.enqueue(this.curProcess);           //add to the finished queue (insead of the ready queue)
                    }
                    
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
