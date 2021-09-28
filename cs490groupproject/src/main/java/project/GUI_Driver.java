package project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class GUI_Driver extends javax.swing.JFrame {

    public static OS os;
    public boolean isPaused = true;
    
    /**
     * Creates new form GUI_Driver
     */
    public GUI_Driver(OS os) {
        this.os = os;
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

        startPauseToggleButton = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        waitingProcessQueueTable = new javax.swing.JTable();
        waitingProcessQueueLabel = new javax.swing.JLabel();
        startPauseLabel = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        cpu1_Status = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        systemReportArea = new javax.swing.JTextArea();
        systemReportLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startPauseToggleButton.setText("Start/Pause");
        startPauseToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startPauseToggleButtonActionPerformed(evt);
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

        startPauseLabel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        startPauseLabel.setText("System Paused");
        startPauseLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startPauseLabelActionPerformed(evt);
            }
        });

        cpu1_Status.setColumns(20);
        cpu1_Status.setRows(5);
        cpu1_Status.setWrapStyleWord(true);
        cpu1_Status.setEnabled(false);
        jScrollPane2.setViewportView(cpu1_Status);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("1 Time Unit = 100 ms");
        jTextField1.setEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        systemReportArea.setColumns(20);
        systemReportArea.setRows(5);
        systemReportArea.setEnabled(false);
        jScrollPane3.setViewportView(systemReportArea);

        systemReportLabel.setText("System Report Stats");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(waitingProcessQueueLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(startPauseToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(startPauseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(systemReportLabel))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startPauseToggleButton)
                    .addComponent(startPauseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(waitingProcessQueueLabel)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
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

    private void startPauseLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startPauseLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startPauseLabelActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void startPauseToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startPauseToggleButtonActionPerformed
        // TODO add your handling code here:
        if (isPaused) startPauseLabel.setText("System Running");
        else startPauseLabel.setText("System Paused");
        isPaused = !isPaused;
        os.setIsPaused(isPaused);
    }//GEN-LAST:event_startPauseToggleButtonActionPerformed

    //Removed main function
    //All main functionality in Main class

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea cpu1_Status;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField startPauseLabel;
    private javax.swing.JToggleButton startPauseToggleButton;
    private javax.swing.JTextArea systemReportArea;
    private javax.swing.JLabel systemReportLabel;
    private javax.swing.JLabel waitingProcessQueueLabel;
    private javax.swing.JTable waitingProcessQueueTable;
    // End of variables declaration//GEN-END:variables
}
