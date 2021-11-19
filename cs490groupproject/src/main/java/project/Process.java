/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Annaleise
 */

public class Process implements Comparable<Process> {
    private int arrivalTime;
    private String processID;
    private int serviceTime;
    private int priority;
    private int finishTime;
    private int turnTime;
    private int normalTurnTime;
    private int timeRemaining; // this is the remaining service time, used by the round robin algorithm
    private double responseRatio = 1.0; //response ratio for current time, calculated every time a process finishes running

    
    //basic constructor
    public Process(int arrivalTime, String processID, int serviceTime, int priority) {
        this.arrivalTime = arrivalTime;
        this.processID = processID;
        this.serviceTime = serviceTime;
        this.finishTime = -1;       //finishTime set later, not at start. -1 means never finished yet.
        this.priority = priority;
        this.timeRemaining = serviceTime;
 
    }
    
    public double getResponseRatio()
    {
        return responseRatio;
    }
    
    public int getArrivalTime() {
        return arrivalTime;
    }

    public String getProcessID() {
        return processID;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public int getPriority() {
        return priority;
    }
    
    public int getFinishTime() {
        return finishTime;
    }
    
    //calculates turnaround time and sets it and returns it.
    public int getTurnTime() 
    {
        this.turnTime=(finishTime-arrivalTime);
        return turnTime;
    }
    
    //calculates normalized turnaround time and returns it / sets it. 
    public int getNormalTurnTime(){
        this.normalTurnTime=(turnTime/serviceTime);
        return normalTurnTime;
    }
    
    public int getTimeRemaining(){
        return timeRemaining;
    }
    
    public void setTimeRemaining(int timeRemaining){
        this.timeRemaining = timeRemaining;
    }
    
    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    

    public void setProcessID(String processID) {
        this.processID = processID;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    public void calculateResponseRatio(int curTime)
    {
        int waitTime = curTime - arrivalTime;
        this.responseRatio = (double)(waitTime + serviceTime)/(double)(serviceTime);
    }

    //This is used to display the p
    public String display(){
        return processID + " Priority: " + priority + ". Arrived at: " + arrivalTime;
        //return processID + " arrived at time: " + arrivalTime + " and will execute for: " + serviceTime + " time units. ";
    }
    
    // Compare Two Processes based on their priority
    /**
     * @param   other - The Employee to be compared.
     * @return  A negative integer, zero, or a positive integer as this employee
     *          is less than, equal to, or greater than the supplied employee object.
    */
    @Override
    public int compareTo(Process other) {
        int returnVal;
        if (this.priority < other.getPriority())
        {
            returnVal = -1;
        }
        else if (this.priority > other.getPriority())
        {
            returnVal = 1;
        }
        else
        {
            if (this.arrivalTime < other.getArrivalTime())
            {
                returnVal = -1;
            }
            else if (this.arrivalTime > other.getArrivalTime())
            {
                returnVal = 1;
            }
            else
            {
                returnVal = 0;
            }
        }
        return returnVal;
    }
}
