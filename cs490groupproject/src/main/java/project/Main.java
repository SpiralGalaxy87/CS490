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
    
    public OS os;
    public GUI_Driver gui;
    
    public static void main(String args[])
    {}
    
    public Main()
    {
        os = new OS(100);
        gui = new GUI_Driver(os);
    }
}
