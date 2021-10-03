package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class GUI_Driver extends javax.swing.JFrame implements Runnable {

    public static OS os;
    public boolean isPaused = true;
    private int timeUnitLength;
    private Thread guiUpdateThread;
    
    /**
     * Creates new form GUI_Driver
     */
    public GUI_Driver(OS os, int length) {
        this.os = os;
        this.timeUnitLength = length;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_startPause = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        waitingProcessQueueTable = new javax.swing.JTable();
        waitingProcessQueueLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cpu1_Status = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        systemReportArea = new javax.swing.JTextArea();
        systemReportLabel = new javax.swing.JLabel();
        lbl_timeUnit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        var_time = new javax.swing.JFormattedTextField();
        lbl_pause_play = new javax.swing.JLabel();
        button_timeunit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        button_startPause.setText("Start/Pause");
        button_startPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_startPauseActionPerformed(evt);
            }
        });

        waitingProcessQueueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Process Name", "Service Time"
            }
        ));
        waitingProcessQueueTable.getTableHeader().setReorderingAllowed(false);
        waitingProcessQueueTable.setEnabled(false);
        jScrollPane1.setViewportView(waitingProcessQueueTable);

        waitingProcessQueueLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        waitingProcessQueueLabel.setText("Waiting Process Queue");

        cpu1_Status.setColumns(20);
        cpu1_Status.setRows(5);
        cpu1_Status.setWrapStyleWord(true);
        cpu1_Status.setEnabled(false);
        jScrollPane2.setViewportView(cpu1_Status);

        systemReportArea.setColumns(20);
        systemReportArea.setRows(5);
        systemReportArea.setEnabled(false);
        jScrollPane3.setViewportView(systemReportArea);

        systemReportLabel.setText("System Report Stats");

        lbl_timeUnit.setText("1 Time Unit = ");

        jLabel1.setText("ms");

        var_time.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        lbl_pause_play.setText("System Paused");

        button_timeunit.setText("Update");
        button_timeunit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_timeunitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(systemReportLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(waitingProcessQueueLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_startPause, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_timeUnit)
                                        .addGap(3, 3, 3)
                                        .addComponent(var_time, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1)
                                        .addGap(6, 6, 6)
                                        .addComponent(button_timeunit))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(lbl_pause_play))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_startPause)
                    .addComponent(lbl_pause_play))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(waitingProcessQueueLabel)
                    .addComponent(lbl_timeUnit)
                    .addComponent(jLabel1)
                    .addComponent(var_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_timeunit))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(systemReportLabel)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_startPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_startPauseActionPerformed
        // TODO add your handling code here:
        if (isPaused) lbl_pause_play.setText("System Running");
        else lbl_pause_play.setText("System Paused");
        isPaused = !isPaused;
        os.setIsPaused(isPaused);
        if(isPaused){
            os.stopCPUs();
            this.stopGUIUpdater();
        }
        else {
            os.startCPUs();
            this.startGUIUpdater();
        }
    }//GEN-LAST:event_button_startPauseActionPerformed

    private void button_timeunitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_timeunitActionPerformed
        int num = ((Number)(var_time.getValue())).intValue();
        os.setTimeUnitLength(num);
        this.timeUnitLength = num;
    }//GEN-LAST:event_button_timeunitActionPerformed

    //Removed main function
    //All main functionality in Main class

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton button_startPause;
    private javax.swing.JButton button_timeunit;
    private javax.swing.JTextArea cpu1_Status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_pause_play;
    private javax.swing.JLabel lbl_timeUnit;
    private javax.swing.JTextArea systemReportArea;
    private javax.swing.JLabel systemReportLabel;
    private javax.swing.JFormattedTextField var_time;
    private javax.swing.JLabel waitingProcessQueueLabel;
    private javax.swing.JTable waitingProcessQueueTable;
    // End of variables declaration//GEN-END:variables

    private void timeStep(){
        cpu1_Status.setText(this.os.getCPUList().get(0).displayStatus());
    }

    public void startGUIUpdater()
    {
        Thread t = new Thread(this);    // add start thread for gui updates
        this.guiUpdateThread = t;
        t.start();
        System.out.println("Started the GUI Updater thread");
    }

    public void stopGUIUpdater()
    {
        this.guiUpdateThread.interrupt();
    }   

    public void run(){
        System.out.println("  ...  GIU updater thread starting ");

        while(true){
            this.timeStep();
            try {
                Thread.sleep((long)(this.timeUnitLength));
            } 
            catch (InterruptedException ex) {
            // TBD catch and deal with exception ere
                System.out.println("GUI Driver Exception caught: " + ex);
                this.timeStep();
                return;
            }
        }
    }
}   
