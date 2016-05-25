/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pages;

import grid_node.Main;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Server.UserThread.writer;

/**
 *
 * @author Дом
 */
public class ProfilePage extends JFrame {
    public static EditProfilePage editProfilePage;
    public static CreateJobPage createJobPage;
    public static SubmitJobPage submitJobPage;
    public static Socket s;
    public static BufferedReader reader;
    public static PrintWriter writer;


    /**
     * Creates new form ProfilePage
     */
    public ProfilePage() {

        initComponents();
        initServerConnection();
    }
    private void initServerConnection(){
        try {
            s = new Socket("localhost",7009);
            writer = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println("Connected");
        } catch (IOException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        MenuPanel = new javax.swing.JPanel();
        EditProfileBtn = new javax.swing.JButton();
        RemoveJobBtn = new javax.swing.JButton();
        CreateJobBtn = new javax.swing.JButton();
        LogoutBtn = new javax.swing.JButton();
        PersonDataPanel = new javax.swing.JPanel();
        SubmitJobBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ResultTextPane = new javax.swing.JTextPane();
        StatusBtn = new javax.swing.JButton();
        JobName = new javax.swing.JTextField();
        ListOfJob = new javax.swing.JButton();
        textArea = new java.awt.TextArea();
        textArea.setVisible(false);
        textArea.setText("");
        ResultOfJobBtn = new javax.swing.JButton();
        TestJobBtn = new javax.swing.JButton();

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

        MenuPanel.setBackground(new java.awt.Color(204, 255, 255));

        EditProfileBtn.setBackground(new java.awt.Color(0, 204, 204));
        EditProfileBtn.setText("Edit Profile");
        EditProfileBtn.setActionCommand("Registration");
        EditProfileBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        EditProfileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditProfileBtnActionPerformed(evt);
            }
        });

        RemoveJobBtn.setBackground(new java.awt.Color(0, 204, 204));
        RemoveJobBtn.setText("Remove Job");
        RemoveJobBtn.setActionCommand("Registration");
        RemoveJobBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RemoveJobBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                try {
                    RemoveJobBtnActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        CreateJobBtn.setBackground(new java.awt.Color(0, 204, 204));
        CreateJobBtn.setText("Create Job");
        CreateJobBtn.setActionCommand("Registration");
        CreateJobBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CreateJobBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateJobBtnActionPerformed(evt);
            }
        });

        LogoutBtn.setBackground(new java.awt.Color(0, 204, 204));
        LogoutBtn.setText("Logout");
        LogoutBtn.setActionCommand("Registration");
        LogoutBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });

        PersonDataPanel.setBackground(new java.awt.Color(153, 255, 255));

        javax.swing.GroupLayout PersonDataPanelLayout = new javax.swing.GroupLayout(PersonDataPanel);
        PersonDataPanel.setLayout(PersonDataPanelLayout);
        PersonDataPanelLayout.setHorizontalGroup(
            PersonDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PersonDataPanelLayout.setVerticalGroup(
            PersonDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );

        SubmitJobBtn.setBackground(new java.awt.Color(0, 204, 204));
        SubmitJobBtn.setText("Submit Job");
        SubmitJobBtn.setActionCommand("Registration");
        SubmitJobBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SubmitJobBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    SubmitJobBtnActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        jScrollPane1.setViewportView(ResultTextPane);

        StatusBtn.setBackground(new java.awt.Color(0, 204, 204));
        StatusBtn.setText("Details of Job");
        StatusBtn.setActionCommand("Registration");
        StatusBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        StatusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    StatusBtnActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        JobName.setForeground(new java.awt.Color(153, 153, 153));
        JobName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JobName.setText("Enter your Job name");
        JobName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JobNameMouseClicked(evt);
            }
        });

        ListOfJob.setBackground(new java.awt.Color(0, 204, 204));
        ListOfJob.setText("List of Jobs");
        ListOfJob.setActionCommand("Registration");
        ListOfJob.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ListOfJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    ListOfJobActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        ResultOfJobBtn.setBackground(new java.awt.Color(0, 204, 204));
        ResultOfJobBtn.setText("Result of Job");
        ResultOfJobBtn.setActionCommand("Registration");
        ResultOfJobBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ResultOfJobBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    ResultOfJobBtnActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        TestJobBtn.setBackground(new java.awt.Color(0, 204, 204));
        TestJobBtn.setText("Test job");
        TestJobBtn.setActionCommand("Registration");
        TestJobBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TestJobBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TestJobBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MenuPanelLayout.createSequentialGroup()
                                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JobName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ListOfJob, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(PersonDataPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MenuPanelLayout.createSequentialGroup()
                                        .addComponent(EditProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(CreateJobBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(RemoveJobBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(StatusBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(ResultOfJobBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TestJobBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanelLayout.createSequentialGroup()
                                .addComponent(SubmitJobBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addComponent(textArea, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateJobBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubmitJobBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addComponent(PersonDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TestJobBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(ListOfJob, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JobName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(StatusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ResultOfJobBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RemoveJobBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textArea, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 243, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addComponent(TopLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TopLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(336, 336, 336))
        );



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EditProfileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditProfileBtnActionPerformed
        editProfilePage=new EditProfilePage();
        editProfilePage.setVisible(true);
        LoginPage.profilePage.setVisible(false);
    }//GEN-LAST:event_EditProfileBtnActionPerformed

    private void RemoveJobBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_RemoveJobBtnActionPerformed
        jobActions("KillJob");
    }//GEN-LAST:event_RemoveJobBtnActionPerformed

    private void CreateJobBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateJobBtnActionPerformed
        createJobPage=new CreateJobPage();
        createJobPage.setVisible(true);
        LoginPage.profilePage.setVisible(false);
    }//GEN-LAST:event_CreateJobBtnActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed

        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
        LoginPage.profilePage.setVisible(false);


    }//GEN-LAST:event_LogoutBtnActionPerformed

    private void SubmitJobBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException, ClassNotFoundException {//GEN-FIRST:event_SubmitJobBtnActionPerformed
        submitJobPage=new SubmitJobPage();
        submitJobPage.setVisible(true);
        LoginPage.profilePage.setVisible(false);
    }//GEN-LAST:event_SubmitJobBtnActionPerformed

    private void StatusBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_StatusBtnActionPerformed
        jobActions("StatusOfJob");

    }//GEN-LAST:event_StatusBtnActionPerformed

    private void ListOfJobActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_ListOfJobActionPerformed

        String command = "ListOfJobs";
        textArea.setText("");

            System.out.println("writing to server: list of jobs\n");
            writer.write(command+"\n");
            writer.flush();
            try {
                String result = reader.readLine();
                System.out.println("get result");
                // read the output from the command

                    textArea.append(result+ "\n");
                    System.out.println(result);

                // read any errors from the attempted command

                ResultTextPane.setText(textArea.getText());
            }
            catch (IOException e) {
                System.out.println("exception happened - here's what I know: ");
                e.printStackTrace();
            }

    }//GEN-LAST:event_ListOfJobActionPerformed

    private void JobNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobNameMouseClicked
      JobName.setText("");
    }//GEN-LAST:event_JobNameMouseClicked

    private void ResultOfJobBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_ResultOfJobBtnActionPerformed
        jobActions("ResultOfJob");

    }//GEN-LAST:event_ResultOfJobBtnActionPerformed

    private void TestJobBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TestJobBtnActionPerformed
String command = "TestJob";
        textArea.setText("");

            System.out.println("writing to server: list of jobs\n");
            writer.write(command+"\n");
            writer.flush();
            try {
                String result = reader.readLine();
                System.out.println("get result");
                // read the output from the command

                    textArea.append(result+ "\n");
                    System.out.println(result);

                // read any errors from the attempted command

                ResultTextPane.setText(textArea.getText());
            }
            catch (IOException e) {
                System.out.println("exception happened - here's what I know: ");
                e.printStackTrace();
            }        // TODO add your handling code here:
    }//GEN-LAST:event_TestJobBtnActionPerformed

    public void jobActions (String command) throws IOException {
        textArea.setText("");
        String jobName= JOptionPane.showInputDialog("Enter file name");
        if (jobName != null ) {

            JobName.setText(jobName);
            System.out.println("writing to server: "+jobName +"\n");
            writer.write(command+"\n");
            writer.write(jobName+"\n");
            writer.flush();
            try {
                String result = reader.readLine();
                // read the output from the command
                while (result!= null) {
                    textArea.append(result+ "\n");

                }
                // read any errors from the attempted command
                System.out.println("Here is the standard error of the command (if any):\n");
                while (result != null) {
                    textArea.append(result+ "\n");

                }
                ResultTextPane.setText(textArea.getText());
            }
            catch (IOException e) {
                System.out.println("exception happened - here's what I know: ");
                e.printStackTrace();
            }
        }else {
            JobName.setText("Please, enter job name");
        }

    }
public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateJobPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CreateJobPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CreateJobPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CreateJobPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfilePage().setVisible(true);
            }
        });
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton CreateJobBtn;
    public javax.swing.JButton EditProfileBtn;
    public javax.swing.JTextField JobName;
    public javax.swing.JButton ListOfJob;
    public javax.swing.JButton LogoutBtn;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JPanel PersonDataPanel;
    public javax.swing.JButton RemoveJobBtn;
    public javax.swing.JButton ResultOfJobBtn;
    public javax.swing.JTextPane ResultTextPane;
    public javax.swing.JButton StatusBtn;
    public javax.swing.JButton SubmitJobBtn;
    public javax.swing.JButton TestJobBtn;
    private javax.swing.JLabel TopLabel;
    public javax.swing.JPanel TopPanel;
    private javax.swing.JScrollPane jScrollPane1;
    public java.awt.TextArea textArea;
    // End of variables declaration//GEN-END:variables
    
}

