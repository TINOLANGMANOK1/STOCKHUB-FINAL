/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

/**
 *
 * @author Acer
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class EDITACC extends javax.swing.JFrame {

    private MANAGEEMPLOYEE manageEmployeeFrame;
    private JSONObject currentAccount;

    public EDITACC(MANAGEEMPLOYEE manageEmployeeFrame, String accountNumber, String username, String password, String role) {
        initComponents();
        this.manageEmployeeFrame = manageEmployeeFrame;

        IdLabel.setText(accountNumber);
        NameF.setText(username);
        PassF.setText(password);
        RoleComboBox.setSelectedItem(role);

        currentAccount = new JSONObject();
        currentAccount.put("accountNumber", accountNumber);
        currentAccount.put("username", username);
        currentAccount.put("password", password);
        currentAccount.put("role", role);
    }


    public EDITACC() {
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

        CancelBtn = new javax.swing.JButton();
        SaveChangesBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        NameF = new javax.swing.JTextField();
        IdLabel = new javax.swing.JLabel();
        RoleComboBox = new javax.swing.JComboBox<>();
        PassF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CancelBtn.setBackground(new java.awt.Color(217, 234, 253));
        CancelBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        CancelBtn.setForeground(new java.awt.Color(0, 0, 0));
        CancelBtn.setText("CANCEL");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });
        getContentPane().add(CancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 454, 170, 42));

        SaveChangesBtn.setBackground(new java.awt.Color(217, 234, 253));
        SaveChangesBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        SaveChangesBtn.setForeground(new java.awt.Color(0, 0, 0));
        SaveChangesBtn.setText("SAVE CHANGES");
        SaveChangesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveChangesBtnActionPerformed(evt);
            }
        });
        getContentPane().add(SaveChangesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 396, 170, 42));

        DeleteBtn.setBackground(new java.awt.Color(217, 234, 253));
        DeleteBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        DeleteBtn.setForeground(new java.awt.Color(204, 0, 51));
        DeleteBtn.setText("DELETE");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });
        getContentPane().add(DeleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 396, 170, 42));
        getContentPane().add(NameF, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 204, 264, 32));

        IdLabel.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        IdLabel.setForeground(new java.awt.Color(0, 0, 0));
        IdLabel.setText("IdLabel");
        getContentPane().add(IdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 160, 90, -1));

        RoleComboBox.setBackground(new java.awt.Color(217, 234, 253));
        RoleComboBox.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        RoleComboBox.setForeground(new java.awt.Color(0, 0, 0));
        RoleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employee", "Admin" }));
        RoleComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoleComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(RoleComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 306, 140, 32));
        getContentPane().add(PassF, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 254, 264, 32));

        jLabel10.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Role:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 308, 50, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Password:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 257, 74, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Name:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 208, 90, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Id:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 74, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("EDIT ACCOUNT");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 93, 110, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Order and Inventory System");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 40, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 1, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("STOCKHUB");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/EDIT ITEM BG FINAL.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this account?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(new FileReader("src//Main//employee.json"));
            JSONArray accounts = (JSONArray) root.get("employee");
            Iterator<?> iterator = accounts.iterator();
            while (iterator.hasNext()) {
                JSONObject obj = (JSONObject) iterator.next();
                if (obj.get("accountNumber").equals(currentAccount.get("accountNumber"))) {
                    iterator.remove();
                    break;
                }
            }

            FileWriter file = new FileWriter("src//Main//employee.json");
            file.write(root.toJSONString());
            file.flush();
            file.close();

            JOptionPane.showMessageDialog(this, "Account deleted successfully!");
            setVisible(false);
            if (manageEmployeeFrame != null) {
                manageEmployeeFrame.refreshTable();
            }
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error deleting account: " + e.getMessage());
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void SaveChangesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveChangesBtnActionPerformed
           
    String accountNumber = currentAccount.get("accountNumber").toString();
    String newUsername = NameF.getText().trim();
    String newPassword = PassF.getText().trim();
    String newRole = RoleComboBox.getSelectedItem().toString();

    // Check if no changes were made
    if (newUsername.equals(currentAccount.get("username").toString()) &&
        newPassword.equals(currentAccount.get("password").toString()) &&
        newRole.equals(currentAccount.get("role").toString())) {
        JOptionPane.showMessageDialog(this, "No changes were made.", "No Changes", JOptionPane.INFORMATION_MESSAGE);
        setVisible(false);
        return;
    }

    try {
        // Load employee JSON file
        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject) parser.parse(new FileReader("src//Main//employee.json"));
        JSONArray accounts = (JSONArray) root.get("employee");

        // Check if the username already exists (excluding the current account)
        for (Object obj : accounts) {
            JSONObject account = (JSONObject) obj;
            if (!account.get("accountNumber").equals(accountNumber) && account.get("username").equals(newUsername)) {
                JOptionPane.showMessageDialog(this, "Username already exists.", "Username Error", JOptionPane.WARNING_MESSAGE);
                // Do not dispose the JFrame
                return;
            }
        }

        // Ask for confirmation to save changes
        int confirmSave = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to save the changes? Please verify the details before proceeding.",
                "Confirm Save Changes", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirmSave == JOptionPane.NO_OPTION) {
            setVisible(false);
            return;
        }

        // Update the account details
        for (Object obj : accounts) {
            JSONObject account = (JSONObject) obj;
            if (account.get("accountNumber").equals(accountNumber)) {
                account.put("username", newUsername);
                account.put("password", newPassword);
                account.put("role", newRole);
                break;
            }
        }

        // Save the updated JSON file
        FileWriter file = new FileWriter("src//Main//employee.json");
        file.write(root.toJSONString());
        file.flush();
        file.close();

        JOptionPane.showMessageDialog(this, "Account updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        setVisible(false);

        // Refresh the table in the parent frame (if applicable)
        if (manageEmployeeFrame != null) {
            manageEmployeeFrame.refreshTable();
        }

        this.dispose();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error saving changes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        setVisible(false);
    }
    }//GEN-LAST:event_SaveChangesBtnActionPerformed

    private void RoleComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoleComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoleComboBoxActionPerformed

    public void loadAccount(JSONObject account) {
        this.currentAccount = account;
        NameF.setText((String) account.get("username"));
        PassF.setText((String) account.get("password"));
        RoleComboBox.setSelectedItem((String) account.get("role"));
    }


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
            java.util.logging.Logger.getLogger(EDITACC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EDITACC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EDITACC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EDITACC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EDITACC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JLabel IdLabel;
    private javax.swing.JTextField NameF;
    private javax.swing.JTextField PassF;
    private javax.swing.JComboBox<String> RoleComboBox;
    private javax.swing.JButton SaveChangesBtn;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
