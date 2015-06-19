/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pages;

import grid_node.Main;
import services.SelectFile;
import services.Users;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Дом
 */
public class RegistrationPage extends javax.swing.JFrame {
public File userCertFile;
public File userKeyFile;
public static ProfilePage profilePage;
    /**
     * Creates new form RegistrationPage
     */
    public RegistrationPage() {
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
        CertKeyPanel = new javax.swing.JPanel();
        userCertBtn = new javax.swing.JButton();
        userCert = new javax.swing.JLabel();
        userKeyBtn = new javax.swing.JButton();
        userKey = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        firstNameLb = new javax.swing.JLabel();
        lastNameLb = new javax.swing.JLabel();
        BirthdayLb = new javax.swing.JLabel();
        emailLb = new javax.swing.JLabel();
        passLb = new javax.swing.JLabel();
        passConfLb = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        birthday = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        passConf = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        RegistrationBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();

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

        CertKeyPanel.setBackground(new java.awt.Color(204, 255, 255));

        userCertBtn.setBackground(new java.awt.Color(0, 204, 204));
        userCertBtn.setText("Choose your usercert.pem");
        userCertBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        userCertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userCertBtnActionPerformed(evt);
            }
        });

        userKeyBtn.setBackground(new java.awt.Color(0, 204, 204));
        userKeyBtn.setText("Choose your userkey.pem");
        userKeyBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        userKeyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userKeyBtnActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        firstNameLb.setText("First Name");

        lastNameLb.setText("Last Name");

        BirthdayLb.setText("Virtual Organization");

        emailLb.setText("Username");

        passLb.setText("Password");

        passConfLb.setText("Password Confirmation");

        RegistrationBtn.setBackground(new java.awt.Color(0, 204, 204));
        RegistrationBtn.setText("Registration");
        RegistrationBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RegistrationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    RegistrationBtnActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        CancelBtn.setBackground(new java.awt.Color(0, 204, 204));
        CancelBtn.setText("Cancel");
        CancelBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RegistrationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passConfLb, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passLb, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailLb, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BirthdayLb, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNameLb, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameLb, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passConf, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(firstNameLb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lastNameLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BirthdayLb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(birthday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passConfLb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passConf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegistrationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        errorLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout CertKeyPanelLayout = new javax.swing.GroupLayout(CertKeyPanel);
        CertKeyPanel.setLayout(CertKeyPanelLayout);
        CertKeyPanelLayout.setHorizontalGroup(
            CertKeyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CertKeyPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CertKeyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(CertKeyPanelLayout.createSequentialGroup()
                        .addGroup(CertKeyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(userKeyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userCertBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(CertKeyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userCert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userKey, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(78, 78, 78))
        );
        CertKeyPanelLayout.setVerticalGroup(
            CertKeyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CertKeyPanelLayout.createSequentialGroup()
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(CertKeyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userCert, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userCertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CertKeyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userKey, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userKeyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        userCert.getAccessibleContext().setAccessibleName("usercert");
        userCert.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CertKeyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(CertKeyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TopLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 578, Short.MAX_VALUE)
                .addContainerGap())
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TopLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userKeyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userKeyBtnActionPerformed
    
       JFileChooser fileChooser = new JFileChooser();
         int returnVal;
        returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            userKeyFile = fileChooser.getSelectedFile();
            userKey.setText(userKeyFile.getName());
           
            
        }
    }//GEN-LAST:event_userKeyBtnActionPerformed

    private void userCertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userCertBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
         int returnVal;
        returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            userCertFile = fileChooser.getSelectedFile();
            userCert.setText(userCertFile.getName());
           
            
        }
    }//GEN-LAST:event_userCertBtnActionPerformed

    private void RegistrationBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException, ClassNotFoundException {//GEN-FIRST:event_RegistrationBtnActionPerformed
        Socket socket = null;

        try {
            socket = new Socket("localhost", 9999);
        } catch (IOException ex) {
            Logger.getLogger(CreateJobPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        String _firstName = (String) firstName.getText();
	String _lastName = (String) lastName.getText();
	String _vo = (String) birthday.getText();
	String _email = (String) email.getText();
	String _pass = (String) pass.getText();
	String _passConf = (String) passConf.getText();
        String _userCert = userCertFile.getName();
        String _userKey = userKeyFile.getName();
	Users newUser = null;
	System.out.println("q");

	if (_firstName != null && _lastName != null
	&& _vo != null && _email != null && _pass != null && _passConf != null
                && _userCert != null && _userKey != null) {


                System.out.println("fields not empty");
                System.out.println("connection start");

                ArrayList<String> my = new ArrayList<String>();
                my.add(0, _firstName);
                my.add(1, _lastName);
                my.add(2, _vo);
                my.add(3, _email);
                my.add(4, _pass);
                my.add(5, _passConf);
                my.add(6, _userCert);
                my.add(7, _userKey);
                String login = "registr";

                System.out.println(login);
                PrintWriter toClient = new PrintWriter(socket.getOutputStream(), true);
                toClient.println(login);
                ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
                objectOutput.writeObject(my);
                SelectFile.SelectFile(userCertFile, errorLabel);
                SelectFile.SelectFile(userKeyFile, errorLabel);

                    titleList = new ArrayList<String>();
                    ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());
                    Object object = objectInput.readObject();
                    titleList = (ArrayList<String>) object;
                    String result = titleList.get(4);
                    errorLabel.setText(result);
                    if (result.equals("success")){

                    Main.loginPage.setVisible(true);
                        Main.loginPage.errorLabel.setText(result);
                    LoginPage.registrationPage.setVisible(false);
                        
                    }else{
                       errorLabel.setText("error"); 
                    }
                    


	
	} else {
	errorLabel.setText("Empty fields!");
	System.out.println("d");
	}
    }//GEN-LAST:event_RegistrationBtnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        
        Main.loginPage.setVisible(true);
        LoginPage.registrationPage.setVisible(false);
    }//GEN-LAST:event_CancelBtnActionPerformed
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
            Logger.getLogger(CreateJobPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CreateJobPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CreateJobPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CreateJobPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationPage().setVisible(true);
            }
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BirthdayLb;
    public javax.swing.JButton CancelBtn;
    private javax.swing.JPanel CertKeyPanel;
    private javax.swing.JPanel MainPanel;
    public javax.swing.JButton RegistrationBtn;
    private javax.swing.JLabel TopLabel;
    public javax.swing.JPanel TopPanel;
    public javax.swing.JTextField birthday;
    public javax.swing.JTextField email;
    private javax.swing.JLabel emailLb;
    public javax.swing.JLabel errorLabel;
    public javax.swing.JTextField firstName;
    private javax.swing.JLabel firstNameLb;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField lastName;
    private javax.swing.JLabel lastNameLb;
    public javax.swing.JTextField pass;
    public javax.swing.JTextField passConf;
    private javax.swing.JLabel passConfLb;
    private javax.swing.JLabel passLb;
    public javax.swing.JLabel userCert;
    public javax.swing.JButton userCertBtn;
    public javax.swing.JLabel userKey;
    public javax.swing.JButton userKeyBtn;
    // End of variables declaration//GEN-END:variables
public static ArrayList<String> titleList;
}
