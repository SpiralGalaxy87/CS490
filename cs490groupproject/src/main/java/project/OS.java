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

    public OS(int timeUnitLength) {
        
        this.timeUnitLength = timeUnitLength;
        
        //start out paused
        this.isPaused = false;

        
        //time starts at 0
        this.curTime = 0;
        
        //finihsed processes start out empty
        this.finishedProcesses = new ProcessQueue();
    }
    

    public void addCPU(CPU cpu)
    {
        cpuList.add(cpu);
    }
    
    public void timeStep(){
        
    }
    
    public void displayStatus(){
        
    }
    
    public void setIsPaused(boolean isPaused){
        this.isPaused = isPaused;
    }
    
    public double computeThrougput()
    {
        return 0.0;
    }
    
    public void importProcesses(String filename){
    
    }
}
