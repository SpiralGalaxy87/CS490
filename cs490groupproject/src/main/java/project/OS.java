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
public class OS implements Runnable {
    
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
    private ProcessQueue futureQueue;
    private int timeUnitLength;
    private boolean isPaused;
    private ArrayList<CPU> cpuList = new ArrayList<>();
    private ArrayList<Thread> cpuThreadList = new ArrayList<>();

    public OS(int timeUnitLength) {
        
        this.timeUnitLength = timeUnitLength;
        this.isPaused = true;
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
    }
    public int getTimeUnitLength() {
        return this.timeUnitLength;
    }
    
    public int getCurTime(){
        
        return this.curTime;
    }
    
    public int incrementCurTime(){
        return ++curTime;
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
        Thread t = new Thread(this);    // add start thread for gui updates
        t.start();
        System.out.println("Started the OS thread");
        
    }
    
    @Override
    public void run(){
        while(true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) { }
            if (!isPaused) {
                for (CPU cpu : cpuList) {
                    cpu.step();
                }
                incrementCurTime();
            }
        }   
    }
    
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
