package project;

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
    private boolean isPlaying;

    public OS(int timeUnitLength) {
        
        this.timeUnitLength = timeUnitLength;
        
        //start out paused
        this.isPlaying = false;
        
        //time starts at 0
        this.curTime = 0;
        
        //finihsed processes start out empty
        this.finishedProcesses = new ProcessQueue();
    }
    
    public void timeStep(){
        
    }
    
    public void displayStatus(){
        
    }
    
    public void togglePlaying(){
        isPlaying = !isPlaying;
    }
    
    public double computeThrougput()
    {
        return 0.0;
    }
    
    public void importProcesses(String filename){
    
    }
}
