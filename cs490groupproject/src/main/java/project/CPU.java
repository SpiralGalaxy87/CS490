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
public class CPU{
    private OS o;
    private ProcessQueue futureQueue;
    private ProcessQueue readyQueue;
    private ProcessQueue finishedQueue;
    private Process curProcess;
    private int id;
    private int timeQuantumLength; //used by rr. length of time quantum, set by user.  
    private int quantumRemaining; //used by rr. ammount of time remaining in current quantum.
    private double averageNTAT;
    
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
        
        //use the unique constructor to sort by arrival time.
        this.futureQueue = new ProcessQueue(new Comparator<Process>() {
            @Override
            public int compare(Process left, Process right) {
                int returnVal;
                if (left.getArrivalTime() < right.getArrivalTime())
                {
                    returnVal = -1;
                }
                else if (left.getArrivalTime() > right.getArrivalTime())
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
    
    public ProcessQueue getFutureQueue(){
        return this.futureQueue;
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
            status += "Time Remaining = " + this.curProcess.getTimeRemaining() + "\n";
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
    
    public double getAverageNTAT(){
        averageNTAT=0;
        if (finishedQueue.getProcess() != null)
        {
            for (Process process : finishedQueue.getProcess())
            {
                averageNTAT+=process.getNormalTurnTime();
            }
        }
        return averageNTAT;
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
}
