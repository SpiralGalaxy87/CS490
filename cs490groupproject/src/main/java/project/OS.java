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
    
    private int timeUnitLength;
    private boolean isPaused;
    private GUI_Driver gui;
    private final ArrayList<CPU> cpuList = new ArrayList<>();

    public OS(int timeUnitLength) {
        
        this.timeUnitLength = timeUnitLength;
        
        //start out paused
        this.isPaused = false;
    }

    public void setTimeUnitLength(int length)
    {
        this.timeUnitLength = length;
    }
    public int getTimeUnitLength() {
        return this.timeUnitLength;
    }
    
    public void addCPU(CPU cpu)
    {
        cpuList.add(cpu);
    }
    
    //this method BEGINS the multiple threads needed to run the CPUs.
    public void startCPUs()
    {
        //loop to start up threads for every CPU in cpuList
        for (CPU cpu : cpuList) {
            cpu.start();
            System.out.println("Started thread for CPU " + cpu.getID());
        }
    }
    
    //this method STOPS the multiple threads running the CPUs.
    public void stopCPUs()
    {
        for (CPU cpu : cpuList)
        {
            cpu.interrupt();
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
    
    public GUI_Driver getGUI() {
        return this.gui;
    }
    public void setGUI(GUI_Driver gui) {
        this.gui = gui;
    }
}
