package project;

import java.util.ArrayList;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Annaleise, Benjamin
 * 
 */
public class OS {
    
    private Comparator<Process> arrivalComparator = new Comparator<Process>() {
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
    };
    
    private int curTime;
    
    //private ProcessQueue readyQueue;
    private ProcessQueue futureQueue;
    //private ProcessQueue  finishedProcesses;
    private int timeUnitLength;
    private boolean isPaused;
    private ArrayList<CPU> cpuList = new ArrayList<>();
    //private Thread cpuThread; //later we can make this a list of cpuThreads
    private ArrayList<Thread> cpuThreadList = new ArrayList<>();

    public OS(int timeUnitLength) {
        
        this.timeUnitLength = timeUnitLength;
        
        //start out paused
        this.isPaused = false;
        //time starts at 0
        this.curTime = 0;
        
        
        
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
    
    
    public void setTimeUnitLength(int length)
    {
        this.timeUnitLength = length;
        //for (CPU i : cpuList) {
        //    i.setTimeUnitLength(length);
        //}
    }
    public int getTimeUnitLength() {
        return this.timeUnitLength;
    }
    
    public int getCurTime(){
        
        return this.curTime;
    }
    
    public int incrementCurTime(){
        this.curTime++;
        
        return curTime;
    }
    
    public ProcessQueue getFutureQueue(){
        
        return this.futureQueue;
    }
    
    
    public void addCPU(CPU cpu)
    {
        cpuList.add(cpu);
    }
    
    //this method BEGINS the multiple threads needed to run the CPUs.
    public void startCPUs()
    {
        
        //this just starts the single CPU right now. 
        //later this should loop to start up threads for every CPU in cpuList
        for (CPU cpu : cpuList) {
            Thread t = new Thread(cpu);
            this.cpuThreadList.add(t);
            t.start();
            System.out.println("Started thread for CPU " + cpu.getID());
        }
    }
    //this method STOPS the multiple threads running the CPUs.
    public void stopCPUs()
    {
        for (Thread t : cpuThreadList)
        {
            t.interrupt();
        }
        //this.cpuThread.interrupt();
    }   
    
    
    //this is used to display the processes that have arrived but haven't been run yet. Ready. Waiting.
    
    //this is used to display the finished processes and all their stats.
    
    
    public void setPaused(boolean isPaused){
        this.isPaused = isPaused;
    }
    public boolean getPaused() {
        return this.isPaused;
    }

    public ArrayList<CPU> getCPUList(){
        return this.cpuList;
    }
    public ArrayList<Thread> getCPUThreadList(){
        return this.cpuThreadList;
    }
}
