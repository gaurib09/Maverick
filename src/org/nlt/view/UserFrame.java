package org.nlt.view;

import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.nlt.model.Users;
import org.nlt.services.Mailer;
import org.nlt.services.UserServices;

//import org.mailer.Mailer;
public class UserFrame extends javax.swing.JFrame implements ParentInterface1
{

    
    public UserFrame() 
    {
        initComponents();
    }

       @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        nameLabel1 = new javax.swing.JLabel();
        nameTextField1 = new javax.swing.JTextField();
        emailLabel2 = new javax.swing.JLabel();
        emailTextField2 = new javax.swing.JTextField();
        createUserButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setLayout(new java.awt.GridLayout(3, 2, 20, 20));

        nameLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        nameLabel1.setText("Enter Name");
        jPanel2.add(nameLabel1);

        nameTextField1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        nameTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(nameTextField1);

        emailLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        emailLabel2.setText("Enter Email");
        jPanel2.add(emailLabel2);

        emailTextField2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        emailTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextField2ActionPerformed(evt);
            }
        });
        jPanel2.add(emailTextField2);

        createUserButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        createUserButton1.setText("Create User");
        createUserButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(createUserButton1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void emailTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextField2ActionPerformed

    private void nameTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextField1ActionPerformed

    private void createUserButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserButton1ActionPerformed
        String name =nameTextField1.getText();
        String email =emailTextField2.getText();
        
        if (name.isEmpty()||email.isEmpty()) 
        {
            JOptionPane.showMessageDialog(this,"Invalid");
        } 
        else 
        {
            SessionFactory sf=new Configuration().configure().buildSessionFactory();

            Session ses=sf.openSession();
            
            ses.beginTransaction();
            
            Users user=new Users();
            
            user.setName(name);
            
            user.setCreated(new Date());
            user.setModified(new Date());
            
            user.setEmail(email);
            user.setPassword(new Random().nextInt(1000000)+"");
            user.setStatus(1);
            
            boolean result=userService.addUser(user,ses);
            
            if (result)
            {
                String subject = "Login Authentication";
                String password = null;
                String message = "Your Login Username: "+email+"\nPassword: "+ password;
                Mailer.send("gauribhamkar09@gmail.com", "dcpemyapmxoekdgy", email, subject, message);
                JOptionPane.showMessageDialog(this, "Account Created Successfully", "New Account", 1);
                this.dispose();
                loginFrame.setVisible(true);
            }
            else 
            {
                JOptionPane.showMessageDialog(this, "Can not Create Account! Check if it is already Resitered", "New Account", 0);
            }
            ses.save(user);
            ses.getTransaction().commit();
            ses.close();
            sf.close();
            
            //JOptionPane.showMessageDialog(this, "Done! User Created");
        }
    }//GEN-LAST:event_createUserButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createUserButton1;
    private javax.swing.JLabel emailLabel2;
    private javax.swing.JTextField emailTextField2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JTextField nameTextField1;
    // End of variables declaration//GEN-END:variables
}
