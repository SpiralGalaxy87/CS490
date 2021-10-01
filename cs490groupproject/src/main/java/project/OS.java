package project;

import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Annaleise
 */
public class OS {
    private int curTime;
    private ProcessQueue finishedProcesses;
    private int timeUnitLength;
    private boolean isPaused;
    private ArrayList<CPU> cpuList = new ArrayList<>();
    private Thread cpuThread; //later we can make this a list of cpuThreads

    public OS(int timeUnitLength) {
        
        this.timeUnitLength = timeUnitLength;
        
        //start out paused
        this.isPaused = false;
        
        //time starts at 0
        this.curTime = 0;
        
        //finihsed processes start out empty
        this.finishedProcesses = new ProcessQueue();
    }
    
    public void setTimeUnitLength(int length)
    {
        this.timeUnitLength = length;
        for (CPU i : cpuList) {
            i.setTimeUnitLength(length);
        }
    }
    
    public void addCPU(CPU cpu)
    {
        cpuList.add(cpu);
    }
    
    public void startCPUs()
    {
        //this just starts the single CPU right now. 
        //later this should loop to start up threads for every CPU in cpuList
        CPU cpu = cpuList.get(0);
        Thread t = new Thread(cpu);    // add this cpu object to a thread and start the thread
        this.cpuThread = t;
        t.start();
        System.out.println("Started the thread");

//        // without the join, either thread can complete before the other
//        try {
//            t.join();  // wait for my thread to complete
//        } catch (Exception e) {
//            // TO DO handle system error here
//        }
//        System.out.println("Main program exiting");
    }

    public void stopCPUs()
    {
        this.cpuThread.interrupt();
    }   

    public void timeStep(){
        
    }
    
    public String displayStatus(){
        String status = "Completed Processes:\n";
        if (finishedProcesses.processes != null)
        {
            for (Process process : finishedProcesses.processes)
            {
                status += "Process " + process.getProcessID() + "\n";
            }
        }
        else
            status += "N/A\n";
        status += "Current throughput = " + computeThroughput() + "\n";
        status += "Current time = " + curTime + " units";
        
        return status;
    }
    
    public void setIsPaused(boolean isPaused){
        this.isPaused = isPaused;
    }
    
    public double computeThroughput()
    {
        return 0.0;
    }
    
    public void importProcesses(String filename){
    
    }
}
