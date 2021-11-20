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
public class CPU extends Thread {
    private int curTime;
    private OS o;
    private final ProcessQueue futureQueue;
    private ProcessQueue readyQueue;
    private ProcessQueue finishedQueue;
    private Process curProcess;
    private int id;
    private int timeQuantumLength; //used by rr. length of time quantum, set by user.  
    private int quantumRemaining; //used by rr. ammount of time remaining in current quantum.
    
    public CPU(int id, OS o) {
        this.curTime = 0;
        this.id = id;
        this.o = o;
        this.timeQuantumLength = 2; //later set this with user input;
        this.quantumRemaining = this.timeQuantumLength;
        
        switch (this.id) {
            case 1:
                this.readyQueue = new ProcessQueue(new Comparator<Process>() {
                    @Override
                    public int compare(Process left, Process right) {
                        if (left.getResponseRatio() < right.getResponseRatio())
                        {
                            return 1;
                        }
                        else //if (left.getResponseRatio() >= right.getResponseRatio())
                        {
                            return -1;
                        }
                    }
                }); break;
            case 2:
                System.out.println("this is working");
                //for round robin, always insert at the back of the queue
                this.readyQueue = new ProcessQueue(new Comparator<Process>() {
                    @Override
                    public int compare(Process left, Process right) {
                        if (left.getQueueArrivalTime() < right.getQueueArrivalTime())
                        {
                            return -1;
                        }
                        else if (left.getQueueArrivalTime() > right.getQueueArrivalTime())
                        {
                            return 1;
                        }
                        else
                        {
                            return 1; //revisit this
                        }
                        
                    }
                }); break;
        //for first come first served, use the priority/arrival sorted queue
            default:
                this.readyQueue = new ProcessQueue();
                break;  
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
    
    public int getCurTime(){
        return this.curTime;
    }
    
    public ProcessQueue getFutureQueue(){
        return this.futureQueue;
    }
    
    public ProcessQueue getFinishedQueue(){        
        return this.finishedQueue;
    }
    
    public String displayQueueState() {
        
        String state = "";
        for (Process p : readyQueue.getPriorityQueue())
        {
            state += p.getProcessID();
            state += "\t";
            state += p.getServiceTime();
            if (id == 1) //hrrn
            {
                state += "\t";
                state += p.getResponseRatio();
            }
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
        if (finishedQueue.getPriorityQueue() != null)
        {
            for (Process process : finishedQueue.getPriorityQueue())
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
    
    public double getSumNTAT(){
        int sumNTAT=0;
        if (finishedQueue.getPriorityQueue() != null)
        {
            for (Process process : finishedQueue.getPriorityQueue())
            {
                sumNTAT+=process.getNormalTurnTime();
            }
        }
        return sumNTAT;
    }
    
    public boolean isFinished()
    {
        return (readyQueue.size() == 0 && curProcess == null);
    }
    
    public int getID() {
        return id;
    }
    
    //This is what the 'thread' runs.
    @Override
    public void run(){ 
        while(true) {
            //Check to see if future queue has processes to transfer to readyQueue
            while(this.futureQueue.size() > 0 && this.futureQueue.peek().getArrivalTime()<=this.curTime) {
                Process temp = this.futureQueue.dequeue();
                temp.setQueueArrivalTime(curTime);
                readyQueue.enqueue(temp);
            }
            
            System.out.println("Time: " + this.curTime + "\n\n" + this.readyQueue.display());
            if(this.id == 1)//hrrn
            {
                //If we do not have a current process and readyQueue is not empty
                if (curProcess == null && readyQueue.size() != 0) {
                    //calculate response ratios and rebuild readyqueue
                    Object[] objectList = readyQueue.getPriorityQueue().toArray();
                    ProcessQueue tempQueue = new ProcessQueue(new Comparator<Process>() {
                        @Override
                        public int compare(Process left, Process right) {
                            if (left.getResponseRatio() < right.getResponseRatio())
                            {
                                return 1;
                            }
                            else //if (left.getResponseRatio() >= right.getResponseRatio())
                            {
                                return -1;
                            }
                        }
                    });
                    for (Object objectList1 : objectList) {
                        Process p = (Process) objectList1; 
                        p.calculateResponseRatio(curTime);
                        //System.out.println("Process " + p.getProcessID() + " response ratio: " + p.getResponseRatio());
                        tempQueue.enqueue(p);
                    }
                    readyQueue = tempQueue;
                    //dequeue one and set as current process
                    curProcess = readyQueue.dequeue();
                }
            }
            else if (this.id == 2)//round robin
            {
                if (curProcess == null && readyQueue.size() != 0) //if there are processes in the queue and we aren't working on one...
                { 
                    curProcess = readyQueue.dequeue();
                    quantumRemaining = Math.min(timeQuantumLength, curProcess.getTimeRemaining());
                    
                }
            }
            //sleep
            try {
                Thread.sleep((long)(o.getTimeUnitLength()));
            } catch (InterruptedException ex) { }
            //increment time
            this.curTime++;
            
            if(this.id == 1) // hrrn
            {
                //if we do have a current process
                if (curProcess != null){
                    //decrement timeRemaining
                    curProcess.setTimeRemaining(curProcess.getTimeRemaining()-1);
                    //if timeRemaining is now 0 then
                    if(curProcess.getTimeRemaining() == 0){
                        //set finished time on current process
                        curProcess.setFinishTime(curTime);
                        System.out.println(curProcess.getProcessID() + " finished at time: " + curTime);
                        //enqueue current process to finishedQueue
                        finishedQueue.enqueue(curProcess);
                        //set current process to null
                        curProcess = null;
                    }
                }
            }
            else if (this.id == 2) //round robin
            {
                //if we do have a current process
                if (curProcess != null)
                {
                    //decrement quantumRemaining.
                    quantumRemaining--;
                    //decrement timeRemaining (total)
                    curProcess.setTimeRemaining(curProcess.getTimeRemaining() - 1);
                    
                    
                    //if process finished... set it's finish time.
                    if(curProcess.getTimeRemaining() == 0)
                    {
                        curProcess.setFinishTime(curTime);
                        finishedQueue.enqueue(curProcess);
                        curProcess = null;
                    }
                    
                    //if quantumRemaining = 0, return curProcess to back of queue.
                    if(curProcess != null && quantumRemaining == 0)
                    {
                        curProcess.setQueueArrivalTime(curTime);
                        readyQueue.enqueue(curProcess);
                        curProcess = null;
                    }
                }
            }
            //update gui
            o.getGUI().updateCPU(id);
        }
    }
}    

                 
    
//    public void fcfs(){
//        //While the CPU isn't paused...
//        //while(!o.getPaused()){
//        while(true){
//            while(this.futureQueue.size() > 0 && this.futureQueue.peek().getArrivalTime()==this.curTime) {
//                this.readyQueue.enqueue(this.futureQueue.dequeue());
//            }      
//            //if the ready queue is not empty, grab it!
//            if (readyQueue.size() > 0 || this.curProcess != null) {
//                //if the CPU isn't currently working on a process... grab the next one available.
//                if(this.curProcess == null || this.curProcess.getTimeRemaining() <= 0){
//                    this.curProcess = readyQueue.dequeue();
//                    try {
//                        System.out.println("  ...  cpu" + this.id + " thread starting " + this.curProcess.getProcessID() + ", working for " + this.curProcess.getTimeRemaining() + " time units.");
//                    }
//                    catch(NullPointerException ex) {
//                        
//                    }
//                }
//                //with the process grabbed, sleep for each time unit
//                while(this.curProcess.getTimeRemaining() > 0){
//                    try {
//                        Thread.sleep((long)(o.getTimeUnitLength()));
//                        this.curTime++;
//                        this.curProcess.setTimeRemaining(this.curProcess.getTimeRemaining() - 1);
//                    } 
//                    catch (InterruptedException ex) {
//                        return;
//                    }
//                }
//                //once the time remaining has lapsed to zero, set the process' finish time and add to finished list.
//                try {
//                    this.curProcess.setFinishTime(this.curTime - 1);
//                    
//                    //set turnaround time
//                    //set normalized turnaround time: turnaround / service
//                    
//                    finishedQueue.enqueue(this.curProcess);
//                    curProcess = null;
//                }
//                catch(NullPointerException ex) {
//                }
//            }
//            //well, nothing here, so lets wait until there is one there
//            else {
//                try {
//                    Thread.sleep((long)(o.getTimeUnitLength()));
//                    this.curTime++;
//                } 
//                catch (InterruptedException ex) {
//                // TBD catch and deal with exception ere
//                    //System.out.println("Exception caught: " + ex + " with " + this.timeRemaining + " time remaining");
//                    return;
//                }
//            }
//        } 
//    } 
//    
//    public void roundRobin(){
//        //While the CPU isn't paused...
//        while(true){
//            while(this.futureQueue.size() > 0 && this.futureQueue.peek().getArrivalTime()==this.curTime) {
//                this.readyQueue.enqueue(this.futureQueue.dequeue());
//            } 
//            if (readyQueue.size() > 0 || this.curProcess != null) { //if there are processes in the queue, or we currently have a process we are working on...
//                
//                if(this.curProcess == null){ //if we don't currently have a process...
//                    this.curProcess = readyQueue.dequeue(); //grab the first process from the ready queue
//                }
//                if(this.quantumRemaining <= 0){ //if the time quantum has expired...
//                    if(this.curProcess.getTimeRemaining() > 0){         //if there is still time left on the current process
//                        readyQueue.enqueue(this.curProcess);            //add the current process to the back of the queue
//                    }
//                    else                                                //if the current process has finished
//                    {
//                      this.curProcess.setFinishTime(this.curTime);    //set finish time
//                      finishedQueue.enqueue(this.curProcess);           //add to the finished queue (insead of the ready queue)
//                    }
//                    
//                    this.curProcess = readyQueue.dequeue();             //and get the next process from the front of the list
//                    try {
//                        System.out.println("  ...  cpu" + this.id + " thread starting " + this.curProcess.getProcessID() + ", working for " + this.curProcess.getTimeRemaining() + " time units.");
//                    }
//                    catch(NullPointerException ex) {   
//                    }
//                    this.quantumRemaining = this.timeQuantumLength; //reset time quantum
//                }
//                else if(this.curProcess.getTimeRemaining() <= 0){// if we have finished the current process in the middle of a time quantum
//                    this.curProcess.setFinishTime(this.curTime);  //set the finish time
//                    finishedQueue.enqueue(this.curProcess);         //add to the finished queue (instead of the ready queue)
//                    this.curProcess = readyQueue.dequeue();         //get a new process from the ready queue
//                    try {
//                        System.out.println("  ...  cpu" + this.id + " thread starting " + this.curProcess.getProcessID() + ", working for " + this.curProcess.getTimeRemaining() + " time units.");
//                    }
//                    catch(NullPointerException ex) {   
//                    }
//                    this.quantumRemaining = this.timeQuantumLength; //reset time quantum
//                }
//                else //we are in the middle of a time quantum and can continue processing
//                {
//                    try {
//                        Thread.sleep((long)(o.getTimeUnitLength()));
//                        this.curTime++;
//
//                        this.curProcess.setTimeRemaining(this.curProcess.getTimeRemaining() - 1); //decrement the process's time remaining
//                        this.quantumRemaining--;                                                  //decrement the time quantum
//                    } 
//                    catch (InterruptedException ex) {
//                        return;
//                    }
//                }
//            }
//            //well, there are no processes in the ready queue, so lets wait until there is one there
//            else {
//                try {
//                    Thread.sleep((long)(o.getTimeUnitLength()));
//                    this.curTime++;
//                } 
//                catch (InterruptedException ex) {
//                // TBD catch and deal with exception ere
//                    //System.out.println("Exception caught: " + ex + " with " + this.timeRemaining + " time remaining");
//                    return;
//                }
//            }
//        } 
//    }
//    
//    public void hrrn()
//    {
//        //Each time step:
//        while(true) {
//            //Check to see if future queue has processes to transfer to readyQueue
//            while(this.futureQueue.size() > 0 && this.futureQueue.peek().getArrivalTime()<=this.curTime) {
//                readyQueue.enqueue(this.futureQueue.dequeue());
//            }
//            //If we do not have a current process
//            if (curProcess == null) {
//                //if ready queue is not empty then
//                if (readyQueue.size() != 0) {
//                    //calculate response ratios and rebuild readyqueue
//                    Object[] objectList = readyQueue.getPriorityQueue().toArray();
//                    ProcessQueue tempQueue = new ProcessQueue(new Comparator<Process>() {
//                        @Override
//                        public int compare(Process left, Process right) {
//                            if (left.getResponseRatio() < right.getResponseRatio())
//                            {
//                                return 1;
//                            }
//                            else //if (left.getResponseRatio() >= right.getResponseRatio())
//                            {
//                                return -1;
//                            }
//                        }
//                    });
//                    for (Object objectList1 : objectList) {
//                        Process p = (Process) objectList1; 
//                        p.calculateResponseRatio(curTime);
//                        //System.out.println("Process " + p.getProcessID() + " response ratio: " + p.getResponseRatio());
//                        tempQueue.enqueue(p);
//                    }
//                    readyQueue = tempQueue;
//                    //dequeue one and set as current process
//                    curProcess = readyQueue.dequeue();
//                }
//                //else, if ready queue is empty, do nothing.
//            }
//            //sleep
//            try {
//                Thread.sleep((long)(o.getTimeUnitLength()));
//            } catch (InterruptedException ex) { }
//            //increment time
//            this.curTime++;
//            //if we do have a current process
//            if (this.curProcess != null){
//                //decrement timeRemaining
//                this.curProcess.setTimeRemaining(this.curProcess.getTimeRemaining()-1);
//                //if timeRemaining is now 0 then
//                if(this.curProcess.getTimeRemaining() == 0){
//                    //set finished time on current process
//                    this.curProcess.setFinishTime(curTime);
//                    //enqueue current process to finishedQueue
//                    finishedQueue.enqueue(this.curProcess);
//                    //set current process to null
//                    this.curProcess = null;
//                }
//            }
//        }
        
        
//        while(true){
//            while(this.futureQueue.size() > 0 && this.futureQueue.peek().getArrivalTime()<=this.curTime) {
//                readyQueue.enqueue(this.futureQueue.dequeue());
//            }
//            if ((curProcess != null && curProcess.getTimeRemaining() <= 0) || curProcess == null) {
//                
//                //if we don't currently have a process...
//                //reorder readyQueue as needed once processes arrive.
//                Object[] objectList = readyQueue.toArray();
//                ProcessQueue tempQueue = new ProcessQueue(new Comparator<Process>() {
//                    @Override
//                    public int compare(Process left, Process right) {
//                        if (left.getResponseRatio() < right.getResponseRatio())
//                        {
//                            return 1;
//                        }
//                        else //if (left.getResponseRatio() >= right.getResponseRatio())
//                        {
//                            return -1;
//                        }
//                    }
//                });
//
//                for (Object objectList1 : objectList) {
//                    Process p = (Process) objectList1; 
//                    p.calculateResponseRatio(curTime);
//                    //System.out.println("Process " + p.getProcessID() + " response ratio: " + p.getResponseRatio());
//                    tempQueue.enqueue(p);
//                }
//                readyQueue = tempQueue;
//                curProcess = readyQueue.dequeue(); //grab the first process from the ready queue
//                
//                //with the process grabbed, sleep for each time unit
//                while(curProcess.getTimeRemaining() > 0){
//                    try {
//                        Thread.sleep((long)(o.getTimeUnitLength()));
//                        this.curTime++;
//                        while(this.futureQueue.size() > 0 && this.futureQueue.peek().getArrivalTime()==this.curTime) {
//                            readyQueue.enqueue(this.futureQueue.dequeue());
//                        }
//                        this.curProcess.setTimeRemaining(this.curProcess.getTimeRemaining() - 1);
//                    } 
//                    catch (InterruptedException ex) {
//                        return;
//                    }
//                }
//                //once the time remaining has lapsed to zero, set the process' finish time and add to finished list.
//                try {
//                    curProcess.setFinishTime(curTime);
//                    finishedQueue.enqueue(curProcess);
//                    curProcess = null;
//                }
//                catch(NullPointerException ex) {
//                }
//            }
//            //well, nothing here, so lets wait until there is one there
//            else {
//                try {
//                    Thread.sleep((long)(o.getTimeUnitLength()));
//                    this.curTime++;
//                    while(this.futureQueue.size() > 0 && this.futureQueue.peek().getArrivalTime()==this.curTime) {
//                        readyQueue.enqueue(this.futureQueue.dequeue());
//                    }
//                } 
//                catch (InterruptedException ex) {
//                // TBD catch and deal with exception ere
//                    //System.out.println("Exception caught: " + ex + " with " + this.timeRemaining + " time remaining");
//                    return;
//                }
//            }
////        }
    //}
//}
