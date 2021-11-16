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
    private int timeUnitLength;
    private Thread guiUpdateThread;
    
    /**
     * Creates new form GUI_Driver
     */
    public GUI_Driver(OS os) {
        this.os = os;
        //this.timeUnitLength = os.getTimeUnitLength();
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
        waitingProcessQueueLabelHRRN = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cpu1_StatusRR = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_reportHRRN = new javax.swing.JTextArea();
        lbl_timeUnit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        var_time = new javax.swing.JFormattedTextField();
        lbl_pause_play = new javax.swing.JLabel();
        button_timeunit = new javax.swing.JButton();
        lbl_cpuRR = new javax.swing.JLabel();
        lbl_cpu2HRRN = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        cpu2_StatusHRRN = new javax.swing.JTextArea();
        lbl_processNameHRRN = new javax.swing.JLabel();
        lbl_serviceTimeHRRN = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_readyQueueHRRN = new javax.swing.JTextArea();
        lbl_report_nameHRRN = new javax.swing.JLabel();
        lbl_report_arriveHRRN = new javax.swing.JLabel();
        lbl_report_serviceHRRN = new javax.swing.JLabel();
        lbl_report_TATHRRN = new javax.swing.JLabel();
        lbl_report_finishHRRN = new javax.swing.JLabel();
        lbl_report_nTATHRRN = new javax.swing.JLabel();
        average_nTATHRRN = new javax.swing.JLabel();
        lbl_timeUnit1 = new javax.swing.JLabel();
        var_curTime = new javax.swing.JLabel();
        averagenTATFormulaHRRN = new javax.swing.JLabel();
        averagenTATHRRN = new javax.swing.JLabel();
        lbl_report_arriveRR = new javax.swing.JLabel();
        lbl_report_serviceRR = new javax.swing.JLabel();
        lbl_report_TATRR = new javax.swing.JLabel();
        lbl_report_finishRR = new javax.swing.JLabel();
        lbl_report_nTATRR = new javax.swing.JLabel();
        average_nTATRR = new javax.swing.JLabel();
        averagenTATFormulaRR = new javax.swing.JLabel();
        averagenTATRR = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_reportRR = new javax.swing.JTextArea();
        lbl_report_nameRR = new javax.swing.JLabel();
        lbl_processNameRR = new javax.swing.JLabel();
        lbl_serviceTimeRR = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        table_readyQueueRR = new javax.swing.JTextArea();
        waitingProcessQueueLabelRR = new javax.swing.JLabel();
        lbl_cpuRR1 = new javax.swing.JLabel();
        var_timeSliceRR = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(126, 153, 221));
        setResizable(false);

        button_startPause.setText("Start/Pause");
        button_startPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_startPauseActionPerformed(evt);
            }
        });

        waitingProcessQueueLabelHRRN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        waitingProcessQueueLabelHRRN.setText("OS Ready Queue");

        cpu1_StatusRR.setEditable(false);
        cpu1_StatusRR.setColumns(20);
        cpu1_StatusRR.setLineWrap(true);
        cpu1_StatusRR.setRows(5);
        cpu1_StatusRR.setWrapStyleWord(true);
        cpu1_StatusRR.setAutoscrolls(false);
        cpu1_StatusRR.setBorder(null);
        //cpu1_Status.setEnabled(false);
        jScrollPane2.setViewportView(cpu1_StatusRR);

        table_reportHRRN.setEditable(false);
        table_reportHRRN.setColumns(20);
        table_reportHRRN.setRows(5);
        jScrollPane3.setViewportView(table_reportHRRN);

        lbl_timeUnit.setText("1 Time Unit =");

        jLabel1.setText("ms");

        var_time.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        var_time.setValue(os.getTimeUnitLength());

        lbl_pause_play.setText("System Paused");

        button_timeunit.setText("Update");
        button_timeunit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_timeunitActionPerformed(evt);
            }
        });

        lbl_cpuRR.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_cpuRR.setText("CPU2");

        lbl_cpu2HRRN.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_cpu2HRRN.setText("CPU1");

        cpu2_StatusHRRN.setEditable(false);
        cpu2_StatusHRRN.setColumns(20);
        cpu2_StatusHRRN.setLineWrap(true);
        cpu2_StatusHRRN.setRows(5);
        cpu2_StatusHRRN.setWrapStyleWord(true);
        cpu2_StatusHRRN.setAutoscrolls(false);
        cpu2_StatusHRRN.setBorder(null);
        jScrollPane5.setViewportView(cpu2_StatusHRRN);

        lbl_processNameHRRN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_processNameHRRN.setText("Process Name");

        lbl_serviceTimeHRRN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_serviceTimeHRRN.setText("Service Time");
        lbl_serviceTimeHRRN.setMaximumSize(new java.awt.Dimension(70, 14));
        lbl_serviceTimeHRRN.setMinimumSize(new java.awt.Dimension(70, 14));

        jScrollPane4.setPreferredSize(new java.awt.Dimension(205, 76));

        table_readyQueueHRRN.setEditable(false);
        table_readyQueueHRRN.setColumns(20);
        table_readyQueueHRRN.setLineWrap(true);
        table_readyQueueHRRN.setRows(5);
        table_readyQueueHRRN.setAutoscrolls(false);
        table_readyQueueHRRN.setBorder(null);
        table_readyQueueHRRN.setRequestFocusEnabled(false);
        jScrollPane4.setViewportView(table_readyQueueHRRN);

        lbl_report_nameHRRN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_report_nameHRRN.setText("Process Name");

        lbl_report_arriveHRRN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_report_arriveHRRN.setText("Arrive Time");
        lbl_report_arriveHRRN.setMaximumSize(new java.awt.Dimension(70, 14));
        lbl_report_arriveHRRN.setMinimumSize(new java.awt.Dimension(70, 14));

        lbl_report_serviceHRRN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_report_serviceHRRN.setText("Service Time");
        lbl_report_serviceHRRN.setMaximumSize(new java.awt.Dimension(70, 14));
        lbl_report_serviceHRRN.setMinimumSize(new java.awt.Dimension(70, 14));

        lbl_report_TATHRRN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_report_TATHRRN.setText("TAT");
        lbl_report_TATHRRN.setMaximumSize(new java.awt.Dimension(70, 14));
        lbl_report_TATHRRN.setMinimumSize(new java.awt.Dimension(70, 14));

        lbl_report_finishHRRN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_report_finishHRRN.setText("Finish Time");
        lbl_report_finishHRRN.setMaximumSize(new java.awt.Dimension(70, 14));
        lbl_report_finishHRRN.setMinimumSize(new java.awt.Dimension(70, 14));

        lbl_report_nTATHRRN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_report_nTATHRRN.setText("nTAT");
        lbl_report_nTATHRRN.setMaximumSize(new java.awt.Dimension(70, 14));
        lbl_report_nTATHRRN.setMinimumSize(new java.awt.Dimension(70, 14));

        average_nTATHRRN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        average_nTATHRRN.setText("Average nTAT");

        lbl_timeUnit1.setText("Current Time:");

        var_curTime.setText("0");

        averagenTATFormulaHRRN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        averagenTATFormulaHRRN.setText("( TAT / Service Time ) /  Completed Processes");

        averagenTATHRRN.setText("0.00");

        lbl_report_arriveRR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_report_arriveRR.setText("Arrive Time");
        lbl_report_arriveRR.setMaximumSize(new java.awt.Dimension(70, 14));
        lbl_report_arriveRR.setMinimumSize(new java.awt.Dimension(70, 14));

        lbl_report_serviceRR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_report_serviceRR.setText("Service Time");
        lbl_report_serviceRR.setMaximumSize(new java.awt.Dimension(70, 14));
        lbl_report_serviceRR.setMinimumSize(new java.awt.Dimension(70, 14));

        lbl_report_TATRR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_report_TATRR.setText("TAT");
        lbl_report_TATRR.setMaximumSize(new java.awt.Dimension(70, 14));
        lbl_report_TATRR.setMinimumSize(new java.awt.Dimension(70, 14));

        lbl_report_finishRR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_report_finishRR.setText("Finish Time");
        lbl_report_finishRR.setMaximumSize(new java.awt.Dimension(70, 14));
        lbl_report_finishRR.setMinimumSize(new java.awt.Dimension(70, 14));

        lbl_report_nTATRR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_report_nTATRR.setText("nTAT");
        lbl_report_nTATRR.setMaximumSize(new java.awt.Dimension(70, 14));
        lbl_report_nTATRR.setMinimumSize(new java.awt.Dimension(70, 14));

        average_nTATRR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        average_nTATRR.setText("Average nTAT");

        averagenTATFormulaRR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        averagenTATFormulaRR.setText("( TAT / Service Time ) /  Completed Processes");

        averagenTATRR.setText("0.00");

        table_reportRR.setEditable(false);
        table_reportRR.setColumns(20);
        table_reportRR.setRows(5);
        jScrollPane6.setViewportView(table_reportRR);

        lbl_report_nameRR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_report_nameRR.setText("Process Name");

        lbl_processNameRR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_processNameRR.setText("Process Name");

        lbl_serviceTimeRR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_serviceTimeRR.setText("Service Time");
        lbl_serviceTimeRR.setMaximumSize(new java.awt.Dimension(70, 14));
        lbl_serviceTimeRR.setMinimumSize(new java.awt.Dimension(70, 14));

        jScrollPane7.setPreferredSize(new java.awt.Dimension(205, 76));

        table_readyQueueRR.setEditable(false);
        table_readyQueueRR.setColumns(20);
        table_readyQueueRR.setLineWrap(true);
        table_readyQueueRR.setRows(5);
        table_readyQueueRR.setAutoscrolls(false);
        table_readyQueueRR.setBorder(null);
        table_readyQueueRR.setRequestFocusEnabled(false);
        jScrollPane7.setViewportView(table_readyQueueRR);

        waitingProcessQueueLabelRR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        waitingProcessQueueLabelRR.setText("OS Ready Queue");

        lbl_cpuRR1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_cpuRR1.setText("Round Robin Time Slice Length");

        var_timeSliceRR.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        var_time.setValue(os.getTimeUnitLength());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(waitingProcessQueueLabelHRRN)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lbl_processNameHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_serviceTimeHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(101, 101, 101)
                                        .addComponent(lbl_cpu2HRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(317, 317, 317)
                                        .addComponent(waitingProcessQueueLabelRR))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                                    .addComponent(button_startPause, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbl_pause_play))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lbl_report_nameHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbl_report_arriveHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbl_report_serviceHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbl_report_finishHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbl_report_TATHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbl_report_nTATHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(average_nTATHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(averagenTATHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(50, 50, 50)
                                            .addComponent(averagenTATFormulaHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(215, 215, 215)
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lbl_report_nameRR, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbl_report_arriveRR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbl_report_serviceRR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbl_report_finishRR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbl_report_TATRR, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbl_report_nTATRR, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(average_nTATRR, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(averagenTATRR, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(50, 50, 50)
                                            .addComponent(averagenTATFormulaRR, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lbl_processNameRR, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbl_serviceTimeRR, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(106, 106, 106)
                                            .addComponent(lbl_cpuRR, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(var_timeSliceRR, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbl_cpuRR1)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(lbl_timeUnit1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(var_curTime, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_timeUnit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(var_time, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_timeunit)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_startPause)
                    .addComponent(lbl_pause_play))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_timeUnit1)
                            .addComponent(var_curTime)
                            .addComponent(lbl_timeUnit)
                            .addComponent(jLabel1)
                            .addComponent(var_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_timeunit))
                        .addGap(22, 22, 22)
                        .addComponent(waitingProcessQueueLabelHRRN)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_processNameHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_serviceTimeHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_cpu2HRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_report_nameHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_report_arriveHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_report_serviceHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_report_finishHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_report_TATHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_report_nTATHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(average_nTATHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(averagenTATFormulaHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(averagenTATHRRN)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(waitingProcessQueueLabelRR)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_processNameRR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_serviceTimeRR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_cpuRR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_cpuRR1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(var_timeSliceRR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_report_nameRR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_report_arriveRR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_report_serviceRR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_report_finishRR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_report_TATRR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_report_nTATRR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(average_nTATRR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(averagenTATFormulaRR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(averagenTATRR))))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_startPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_startPauseActionPerformed
        // TODO add your handling code here:
        if (os.getPaused()) lbl_pause_play.setText("System Running");
        else lbl_pause_play.setText("System Paused");
        os.setPaused(!os.getPaused());
        if(os.getPaused()){
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
    }//GEN-LAST:event_button_timeunitActionPerformed

    
    /**
    * Starts thread for GUI Updates when the system starts playing.
    */
    public void startGUIUpdater()
    {
        Thread t = new Thread(this);    // add start thread for gui updates
        this.guiUpdateThread = t;
        t.start();
        System.out.println("Started the GUI Updater thread");
    }

    /**
    * Interrupt GUI Updater Thread when the system pauses;
    */
    public void stopGUIUpdater()
    {
        this.guiUpdateThread.interrupt();
    }   
    
    
    //Removed main function
    //All main functionality in Main class

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel average_nTATHRRN;
    private javax.swing.JLabel average_nTATRR;
    private javax.swing.JLabel averagenTATFormulaHRRN;
    private javax.swing.JLabel averagenTATFormulaRR;
    private javax.swing.JLabel averagenTATHRRN;
    private javax.swing.JLabel averagenTATRR;
    private javax.swing.JToggleButton button_startPause;
    private javax.swing.JButton button_timeunit;
    private javax.swing.JTextArea cpu1_StatusRR;
    private javax.swing.JTextArea cpu2_StatusHRRN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lbl_cpu2HRRN;
    private javax.swing.JLabel lbl_cpuRR;
    private javax.swing.JLabel lbl_cpuRR1;
    private javax.swing.JLabel lbl_pause_play;
    private javax.swing.JLabel lbl_processNameHRRN;
    private javax.swing.JLabel lbl_processNameRR;
    private javax.swing.JLabel lbl_report_TATHRRN;
    private javax.swing.JLabel lbl_report_TATRR;
    private javax.swing.JLabel lbl_report_arriveHRRN;
    private javax.swing.JLabel lbl_report_arriveRR;
    private javax.swing.JLabel lbl_report_finishHRRN;
    private javax.swing.JLabel lbl_report_finishRR;
    private javax.swing.JLabel lbl_report_nTATHRRN;
    private javax.swing.JLabel lbl_report_nTATRR;
    private javax.swing.JLabel lbl_report_nameHRRN;
    private javax.swing.JLabel lbl_report_nameRR;
    private javax.swing.JLabel lbl_report_serviceHRRN;
    private javax.swing.JLabel lbl_report_serviceRR;
    private javax.swing.JLabel lbl_serviceTimeHRRN;
    private javax.swing.JLabel lbl_serviceTimeRR;
    private javax.swing.JLabel lbl_timeUnit;
    private javax.swing.JLabel lbl_timeUnit1;
    private javax.swing.JTextArea table_readyQueueHRRN;
    private javax.swing.JTextArea table_readyQueueRR;
    private javax.swing.JTextArea table_reportHRRN;
    private javax.swing.JTextArea table_reportRR;
    private javax.swing.JLabel var_curTime;
    private javax.swing.JFormattedTextField var_time;
    private javax.swing.JFormattedTextField var_timeSliceRR;
    private javax.swing.JLabel waitingProcessQueueLabelHRRN;
    private javax.swing.JLabel waitingProcessQueueLabelRR;
    // End of variables declaration//GEN-END:variables


    /**
    * Actions that need to be performed at each time step, including updating all info displays.  
    */ 
    private void timeStep(){
        
        var_curTime.setText(Integer.toString(os.getCurTime()));
        //check time, if anything in future queue has this time, move it to the readyQueue
        while(os.getFutureQueue().size() > 0 && os.getFutureQueue().peek().getArrivalTime()==os.getCurTime()) {
            for (CPU cpu : os.getCPUList()) {
                cpu.getReadyQueue().enqueue(os.getFutureQueue().peek());
            }
            os.getFutureQueue().dequeue();
        }        
            
        cpu1_StatusRR.setText(this.os.getCPUList().get(1).displayStatus());
        cpu2_StatusHRRN.setText(this.os.getCPUList().get(0).displayStatus());
        cpu1_StatusRR.setText(this.os.getCPUList().get(1).displayStatus());
        table_readyQueueRR.setText(this.os.getCPUList().get(1).displayQueueState());
        table_readyQueueHRRN.setText(this.os.getCPUList().get(0).displayQueueState());
        table_reportHRRN.setText(this.os.getCPUList().get(0).displayFinished());
        table_reportRR.setText(this.os.getCPUList().get(1).displayFinished());
        averagenTATHRRN.setText(String.format("%.2f",(float)this.os.getCPUList().get(0).getFinishedQueue().size() / this.os.getCurTime()));
        averagenTATRR.setText(String.format("%.2f",(float)this.os.getCPUList().get(1).getFinishedQueue().size() / this.os.getCurTime()));
        
    }
     
    /**
    * Run timeStep updates once every time step.
    */
    public void run(){
        System.out.println("  ...  GUI updater thread starting ");

        while(true){
            this.timeStep();
            try {
                Thread.sleep((long)(os.getTimeUnitLength()));
                os.incrementCurTime();
            } 
            catch (InterruptedException ex) {
            // TBD catch and deal with exception ere
                System.out.println("GUI Driver Exception caught: " + ex);
                //this.timeStep();
                return;
            }
        }
    }
}   
