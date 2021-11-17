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
    private int timeQuantum; //used by rr. length of time quantum, set by user.  
    private int quantumRemaining; //used by rr. ammount of time remaining in current quantum.
    
    public CPU(int id, OS o) {
        this.id = id;
        this.o = o;
        this.timeRemaining = 0;
        this.timeQuantum = 10; //later set this with user input;
        this.quantumRemaining = this.timeQuantum;
        
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
    
    @Override
    public void run(){ 
        if(this.id == 2){
          this.roundRobin();  
        }
        else{
           this.fcfs(); 
        }
    }
    
    public void fcfs(){
        //While the CPU isn't paused...
        //while(!o.getPaused()){
        while(true){
            //if the ready queue is not empty, grab it!
            if (readyQueue.size() > 0) {
                //if the CPU isn't currently working on a process... grab the next one available.
                if(this.timeRemaining <= 0){
                    this.curProcess = readyQueue.dequeue();
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
                    
                    finishedQueue.enqueue(this.curProcess);
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
//    
    
    public void roundRobin(){
        //While the CPU isn't paused...
        while(true){
            if (readyQueue.size() > 0 || this.curProcess != null) {
                
                if(this.curProcess == null){ //if we don't currently have a process
                    this.curProcess = readyQueue.dequeue(); //grab the first process from the ready queue
                }
                if(this.quantumRemaining <= 0){ //if the time quantum has expired...
                    if(this.curProcess.getTimeRemaining() > 0){ //if there is still time left on the current process
                        readyQueue.enqueue(this.curProcess);            //add the current process to the back of the queue
                    }
                    else // if the current process has finished
                    {
                      this.curProcess.setFinishTime(o.getCurTime());    //set finish time
                      finishedQueue.enqueue(this.curProcess);           //add to the finished queue (insead of the ready queue)
                    }
                    
                    this.curProcess = readyQueue.dequeue();             // and get the next process from the front of the list
                    try {
                        System.out.println("  ...  cpu" + this.id + " thread starting " + this.curProcess.getProcessID() + ", working for " + this.curProcess.getTimeRemaining() + " time units.");
                    }
                    catch(NullPointerException ex) {   
                    }
                    this.quantumRemaining = this.timeQuantum; //reset time quantum
                }
                else if(this.curProcess.getTimeRemaining() <= 0){// if we have finished the current process in the middle of a time quantum
                    this.curProcess.setFinishTime(o.getCurTime());  //set the finish time
                    finishedQueue.enqueue(this.curProcess);         //add to the finished queue (instead of the ready queue)
                    this.curProcess = readyQueue.dequeue();         //get a new process from the ready queue
                    try {
                        System.out.println("  ...  cpu" + this.id + " thread starting " + this.curProcess.getProcessID() + ", working for " + this.timeRemaining + " time units.");
                    }
                    catch(NullPointerException ex) {   
                    }
                    this.timeRemaining = this.timeQuantum; //reset time quantum
                }
                else //we are in the middle of a time quantum and can continue processing
                {
                    try {
                    Thread.sleep((long)(o.getTimeUnitLength()));
       
                    this.curProcess.setTimeRemaining(this.curProcess.getTimeRemaining() - 1); //decrement the process's time remaining
                    this.quantumRemaining--;                                                  //decrement the time quantum
                    } 
                    catch (InterruptedException ex) {
                        return;
                    }
                }
            }
            //well, there are no processes in the ready queue, so lets wait until there is one there
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
