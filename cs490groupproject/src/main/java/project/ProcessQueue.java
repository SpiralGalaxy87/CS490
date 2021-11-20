/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author Annaleise, Jake
 */
public class ProcessQueue {
   
    private PriorityQueue<Process> processes;
    private Comparator<Process> comp;

    public ProcessQueue() {
        this.processes = new PriorityQueue<Process>();
        this.comp = new Comparator<Process>() {
            @Override
            public int compare(Process left, Process right)
            {
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
    }
    
    //we use this to create a queue with a unique comparator to sort by different things.
    public ProcessQueue(Comparator comp) {
        this.processes = new PriorityQueue<Process>(comp);
        this.comp = comp;
    }

    /** Inserts the specified element at the tail of this queue. **/
    //This is synchronized to ensure that two CPUs do not pull the SAME process at the same time.
    public boolean enqueue(Process p)
    {
        return processes.add(p);
    }
    
    //Returns priority queue of processes
    public PriorityQueue<Process> getPriorityQueue(){
        
        return this.processes;
    }
    
    /**
     * Retrieves and removes the head of this queue, or returns null if this
     * queue is empty.
     * @return Process is the one removed.
     **/
    public synchronized Process dequeue()
    {
        return processes.poll();
    }
    
    /**
     * Retrieves, but does not remove, the head of this queue, or returns null
     * if this queue is empty.
     **/
    public Process peek()
    {
        return processes.peek();
    }
    
    /** Returns the number of elements in this queue. **/
    public int size()
    {
        return processes.size();
    }
    
    /** Returns a string representation of this collection. **/
    public String display()
    {
        PriorityQueue<Process> temp = new PriorityQueue(this.processes);
        
        String output = "";
        while(temp.size() != 0){
            output += temp.poll().display();
            output += "\n";
        }
        return output;
    }
}

