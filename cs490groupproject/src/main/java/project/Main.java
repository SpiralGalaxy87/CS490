/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author jmpet
 */
public class Main {
    
    public static void main(String args[])
    {
        ProcessQueue pq1 = new ProcessQueue();
        CPU cpu1 = new CPU(pq1);  
    }
}
