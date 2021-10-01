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

    public Process(int arrivalTime, String processID, int serviceTime, int priority) {
        this.arrivalTime = arrivalTime;
        this.processID = processID;
        this.serviceTime = serviceTime;
        this.priority = priority;
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
