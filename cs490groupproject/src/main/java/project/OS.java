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
    public ProcessQueue readyQueue;
    private ProcessQueue finishedProcesses;
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
        
        //finihsed processes start out empty
        this.readyQueue = new ProcessQueue();
        this.finishedProcesses = new ProcessQueue();
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
    
    public void addCPU(CPU cpu)
    {
        cpuList.add(cpu);
    }
    
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

    public void stopCPUs()
    {
        for (Thread t : cpuThreadList)
        {
            t.interrupt();
        }
        //this.cpuThread.interrupt();
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

    public ArrayList<CPU> getCPUList(){
        return this.cpuList;
    }
}
