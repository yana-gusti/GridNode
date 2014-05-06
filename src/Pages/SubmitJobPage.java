/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pages;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import sun.misc.IOUtils;

/**
 *
 * @author Дом
 */
public class SubmitJobPage extends javax.swing.JFrame {
    public File XRSLFile;
    public Reader reader_ = null;
    private String s;

    /**
     * Creates new form SubmitJobPage
     */
    public SubmitJobPage() {
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

        TopPanel = new javax.swing.JPanel();
        TopLabel = new javax.swing.JLabel();
        MainPanel = new javax.swing.JPanel();
        VONameLb = new javax.swing.JLabel();
        VOName = new javax.swing.JTextField();
        CancelBtn = new javax.swing.JButton();
        SubmitJobBtn = new javax.swing.JButton();
        selectXRSLFileBtn1 = new javax.swing.JButton();
        textArea = new java.awt.TextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TopPanel.setBackground(new java.awt.Color(153, 255, 255));
        TopPanel.setForeground(new java.awt.Color(0, 0, 153));
        TopPanel.setToolTipText("Grid Node");
        TopPanel.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N

        TopLabel.setFont(new java.awt.Font("Verdana", 3, 36)); // NOI18N
        TopLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TopLabel.setText("Grid Node");
        TopLabel.setToolTipText("");

        MainPanel.setBackground(new java.awt.Color(204, 255, 255));

        VONameLb.setText("Enter name of VO");
        VONameLb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        CancelBtn.setBackground(new java.awt.Color(0, 204, 204));
        CancelBtn.setText("Cancel");
        CancelBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        SubmitJobBtn.setBackground(new java.awt.Color(0, 204, 204));
        SubmitJobBtn.setText("Submit Job");
        SubmitJobBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SubmitJobBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitJobBtnActionPerformed(evt);
            }
        });

        selectXRSLFileBtn1.setBackground(new java.awt.Color(0, 204, 204));
        selectXRSLFileBtn1.setText("Select your XRSL file");
        selectXRSLFileBtn1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        selectXRSLFileBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectXRSLFileBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(CancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VOName)
                        .addComponent(SubmitJobBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(selectXRSLFileBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(VONameLb)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textArea, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(selectXRSLFileBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(VONameLb, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VOName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(SubmitJobBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TopLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TopLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
       
        LoginPage.profilePage.setVisible(true);
        CreateJobPage.submitJobPage.setVisible(false);
  
        
    }//GEN-LAST:event_CancelBtnActionPerformed

 public SubmitJobPage(final TextArea _textArea) {
       textArea = _textArea;
    }
    private void SubmitJobBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitJobBtnActionPerformed
      textArea.setText("");
        try {
            
            ProcessBuilder builder = new ProcessBuilder("/bin/bash","-c","xterm -e arcproxy && arcproxy -I");
            builder.redirectErrorStream(true); // so we can ignore the error stream
            
            Process process = builder.start();
            Thread.sleep(2000);
             BufferedReader stdInput = new BufferedReader(new 
                    InputStreamReader(process.getInputStream()));

            BufferedReader stdError = new BufferedReader(new 
                    InputStreamReader(process.getErrorStream()));

            String s = null;
            while ((s = stdInput.readLine()) != null) {
                textArea.append(s+"\n");
            }

            while ((s = stdError.readLine()) != null) {
               textArea.append(s+"\n");
            }
   
          } catch (InterruptedException ex) {
            Logger.getLogger(SubmitJobPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SubmitJobPage.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_SubmitJobBtnActionPerformed

    private void selectXRSLFileBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectXRSLFileBtn1ActionPerformed
         JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            XRSLFile = fileChooser.getSelectedFile();
             try {           
                 String text = new Scanner(XRSLFile).useDelimiter("\\A").next();
                 textArea.setText(text);
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(SubmitJobPage.class.getName()).log(Level.SEVERE, null, ex);
             }
            

        } else {
            System.out.println("File access cancelled by user.");

        }
    }//GEN-LAST:event_selectXRSLFileBtn1ActionPerformed

  public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateJobPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateJobPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateJobPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateJobPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubmitJobPage().setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton CancelBtn;
    private javax.swing.JPanel MainPanel;
    public javax.swing.JButton SubmitJobBtn;
    private javax.swing.JLabel TopLabel;
    public javax.swing.JPanel TopPanel;
    public javax.swing.JTextField VOName;
    public javax.swing.JLabel VONameLb;
    public javax.swing.JButton selectXRSLFileBtn1;
    public java.awt.TextArea textArea;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param p
     * @return
     */
    public static boolean isAlive(Process p) {
    try {
      p.exitValue();
      return false;
    }
    catch (IllegalThreadStateException e) {
      return true;
    }
  }
}


