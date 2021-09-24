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
public class Process {
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
}
