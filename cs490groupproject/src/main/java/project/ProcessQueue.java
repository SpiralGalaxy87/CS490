/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
//import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Annaleise, Jake
 */
public class ProcessQueue {
    private PriorityQueue<Process> processes;

    public ProcessQueue() {
        processes = new PriorityQueue<Process>();
    }

    /** Inserts the specified element at the tail of this queue. **/
    public boolean enqueue(Process p)
    {
        return processes.add(p);
    }
    
    /**
     * Retrieves and removes the head of this queue, or returns null if this
     * queue is empty.
     **/
    public Process dequeue()
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
    
    /**
     * Removes a single instance of the specified element from this queue, if it
     * is present.
     **/
    public boolean remove(Process p)
    {
        return processes.remove(p);
    }
    
    /** Returns a string representation of this collection. **/
    public String toString()
    {
        
        return "test";
        //return processes.toString();
    }
    
}

////////////////////////

//    /** Atomically removes all of the elements from this queue. **/
//    public void clear()
//    {
//        arrayDeque.clear();
//    }
//
//    /** Returns an iterator over the elements in this queue in proper sequence. **/
//    public Iterator<E> iterator()
//    {
//        return arrayDeque.iterator();
//    }
//
//    
//
//    /**
//     * Returns an array containing all of the elements in this queue, in proper
//     * sequence.
//     **/
//    public Object[] toArray()
//    {
//        return arrayDeque.toArray();
//    }
//
//    /**
//     * Returns an array containing all of the elements in this queue, in proper
//     * sequence; the runtime type of the returned array is that of the specified
//     * array.
//     **/
//    public <T> T[] toArray(T[] a)
//    {
//        return arrayDeque.toArray(a);
//    }
//
//
//    /** Inserts the specified element at the front of this deque. **/
//    public void addFirst(E e)
//    {
//        arrayDeque.addFirst(e);
//    }
//
//    /** Inserts the specified element at the end of this deque. **/
//    public void addLast(E e)
//    {
//        arrayDeque.addLast(e);
//    }
//
//    /** Retrieves, but does not remove, the first element of this deque. **/
//    public void getFirst()
//    {
//        arrayDeque.getFirst();
//    }
//
//    /** Retrieves, but does not remove, the last element of this deque. **/
//    public void getLast()
//    {
//        arrayDeque.getLast();
//    }
//
//    /** Inserts the specified element at the front of this deque. **/
//    public boolean offerFirst(E e)
//    {
//        return arrayDeque.offerFirst(e);
//    }
//
//    /** Inserts the specified element at the end of this deque. **/
//    public boolean offerLast(E e)
//    {
//        return arrayDeque.offerLast(e);
//    }
//
//    /**
//     * Retrieves, but does not remove, the first element of this deque, or
//     * returns null if this deque is empty.
//     **/
//    public E peekFirst()
//    {
//        return arrayDeque.peekFirst();
//    }
//
//    /**
//     * Retrieves, but does not remove, the last element of this deque, or
//     * returns null if this deque is empty.
//     **/
//    public E peekLast()
//    {
//        return arrayDeque.peekLast();
//    }