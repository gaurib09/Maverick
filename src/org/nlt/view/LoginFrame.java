package org.nlt.view;

import javax.swing.JOptionPane;
import org.nlt.model.Users;
import org.nlt.services.UserServices;

public class LoginFrame extends javax.swing.JFrame implements ParentInterface1
{
    int attempt=0;
    public LoginFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        emailTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordTextField2 = new javax.swing.JTextField();
        loginButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        sinupLabel3 = new javax.swing.JLabel();
        forgotpasswordLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(3, 2, 20, 20));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Enter Email:");
        jPanel1.add(jLabel1);

        emailTextField1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        emailTextField1.setText("gauribhamkar09@gmail.com");
        jPanel1.add(emailTextField1);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Enter Password:");
        jPanel1.add(jLabel2);

        passwordTextField2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        passwordTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(passwordTextField2);

        loginButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        loginButton1.setText("Login");
        loginButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(loginButton1);

        jPanel2.setLayout(new java.awt.GridLayout(1, 2, 20, 20));

        sinupLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        sinupLabel3.setText("Sign Up");
        sinupLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sinupLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sinupLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(sinupLabel3);

        forgotpasswordLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        forgotpasswordLabel4.setText("Forgot Password");
        forgotpasswordLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(forgotpasswordLabel4);

        jPanel1.add(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void passwordTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextField2ActionPerformed

    private void loginButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButton1ActionPerformed
      
        String email=emailTextField1.getText();
        String password=passwordTextField2.getText();
        
        Users localUserObject = userService.getUserByEmailAndPassword(email, password, ses);

        if (localUserObject==null)
        {
            attempt=++attempt;
            System.out.println(attempt);
            
            if (attempt==3) 
            {
                Users updateUsers = userService.getUserByEmail(email, ses);
                Users user = new Users();
                user.setStatus(2);
                userService.updateuserByEmail(email, ses);
                JOptionPane.showMessageDialog(this, "Too many attempts.... your account has been freezed", "Freezed Account", 0);
                emailTextField1.setText("");
                passwordTextField2.setText("");
            }
                    
            JOptionPane.showMessageDialog(this, "Invalid Username or Password! Please Try Again....", "New Account", 0);
        }
        else
        {
            loginUser.setEmail(localUserObject.getEmail());
            
            loginUser.setCreated(localUserObject.getCreated());
            
            loginUser.setModified(localUserObject.getModified());
            
            loginUser.setId(localUserObject.getId());
            
            loginUser.setName(localUserObject.getName());
            
            loginUser.setPassword("");
            
            loginUser.setStatus(localUserObject.getStatus());
            
            personsFrame.setVisible(true);
            personsFrame.setTitle("Login: "+loginUser.getName());
            this.dispose();
        }
    }//GEN-LAST:event_loginButton1ActionPerformed

    private void sinupLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sinupLabel3MouseClicked
        userFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_sinupLabel3MouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailTextField1;
    private javax.swing.JLabel forgotpasswordLabel4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginButton1;
    private javax.swing.JTextField passwordTextField2;
    private javax.swing.JLabel sinupLabel3;
    // End of variables declaration//GEN-END:variables

    
}
