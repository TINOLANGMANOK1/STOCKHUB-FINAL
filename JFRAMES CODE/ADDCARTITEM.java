/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

/**
 *
 * @author Acer
 */
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ADDCARTITEM extends javax.swing.JFrame {

    private DefaultTableModel model;
    private ADDORDER addOrderFrame; // Reference to parent

    public ADDCARTITEM(ADDORDER addOrderFrame) {
        initComponents();
        this.addOrderFrame = addOrderFrame;
        loadItems();

        ItemTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                QuantityLabel.setText("0");
                PriceallLabel.setText("₱0.00");
            }
        });
        SearchF.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                loadItems();
            }

            public void removeUpdate(DocumentEvent e) {
                loadItems();
            }

            public void changedUpdate(DocumentEvent e) {
                loadItems();
            }
        });
        
        ItemTable.getTableHeader().setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        JTable[] tables = {ItemTable};

        for (JTable table : tables) {
            // Center cells
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            // Custom header renderer with background color and bold font
            JTableHeader header = table.getTableHeader();
            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
            headerRenderer.setHorizontalAlignment(JLabel.CENTER);
            headerRenderer.setBackground(Color.decode("#325ea0")); // Your desired color
            headerRenderer.setForeground(Color.WHITE); // White text looks good on dark blue

            // Set font to Segoe UI, size 14, and bold for header only
            headerRenderer.setFont(new Font("Segoe UI", Font.BOLD, 14));  // Ensure it's bold

            // Apply the custom header renderer to each column
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
            }

            // Repaint to apply the changes
            header.repaint();  // Ensure the header is repainted after changes
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SearchF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ItemTable = new javax.swing.JTable();
        IncreaseBtn = new javax.swing.JButton();
        AddCartBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PriceallLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();
        QuantityLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        DecreaseBtn = new javax.swing.JButton();
        FINALBG = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(SearchF, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 320, 32));

        ItemTable.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        ItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item Id", "Item Name", "Price", "Quantity"
            }
        ));
        ItemTable.setIntercellSpacing(new java.awt.Dimension(0, 5));
        ItemTable.setRowHeight(25);
        jScrollPane2.setViewportView(ItemTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 188, 457, 190));

        IncreaseBtn.setBackground(new java.awt.Color(217, 234, 253));
        IncreaseBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        IncreaseBtn.setForeground(new java.awt.Color(0, 0, 0));
        IncreaseBtn.setText("+");
        IncreaseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IncreaseBtnActionPerformed(evt);
            }
        });
        getContentPane().add(IncreaseBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 388, 40, 35));

        AddCartBtn.setBackground(new java.awt.Color(217, 234, 253));
        AddCartBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        AddCartBtn.setForeground(new java.awt.Color(0, 0, 0));
        AddCartBtn.setText("ADD TO CART");
        AddCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCartBtnActionPerformed(evt);
            }
        });
        getContentPane().add(AddCartBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 454, 170, 42));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 37, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Quantity:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 395, 90, -1));

        PriceallLabel.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        PriceallLabel.setForeground(new java.awt.Color(0, 153, 0));
        PriceallLabel.setText("₱0.00");
        getContentPane().add(PriceallLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 395, 90, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Order and Inventory System");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 40, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 1, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("STOCKHUB");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Total Price:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 395, 90, 20));

        BackBtn.setBackground(new java.awt.Color(217, 234, 253));
        BackBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BackBtn.setForeground(new java.awt.Color(0, 0, 0));
        BackBtn.setText("BACK");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });
        getContentPane().add(BackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 454, 170, 42));

        QuantityLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        QuantityLabel.setForeground(new java.awt.Color(0, 0, 0));
        QuantityLabel.setText("0");
        getContentPane().add(QuantityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 395, 20, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Search Item:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 145, 110, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ADD CART ITEM");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 93, 110, -1));

        DecreaseBtn.setBackground(new java.awt.Color(217, 234, 253));
        DecreaseBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        DecreaseBtn.setForeground(new java.awt.Color(0, 0, 0));
        DecreaseBtn.setText("-");
        DecreaseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecreaseBtnActionPerformed(evt);
            }
        });
        getContentPane().add(DecreaseBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 388, 40, 35));

        FINALBG.setForeground(new java.awt.Color(0, 0, 0));
        FINALBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/ADDCARTITEM BG FINAL.png"))); // NOI18N
        FINALBG.setText("jLabel6");
        getContentPane().add(FINALBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 529));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void IncreaseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IncreaseBtnActionPerformed
       int selectedRow = ItemTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an item first.");
            return;
        }

        int currentQuantity = Integer.parseInt(QuantityLabel.getText());
        int maxQuantity = Integer.parseInt(ItemTable.getValueAt(selectedRow, 3).toString());
        String itemNumber = ItemTable.getValueAt(selectedRow, 0).toString();

        // Get quantity already in cart
        int cartQuantity = 0;
        try {
            File file = new File("src//Main//Cart.json");
            if (file.exists()) {
                JSONParser parser = new JSONParser();
                FileReader reader = new FileReader(file);
                JSONArray cartArray = (JSONArray) parser.parse(reader);
                reader.close();

                for (Object obj : cartArray) {
                    JSONObject cartItem = (JSONObject) obj;
                    if (cartItem.get("itemNumber").toString().equals(itemNumber)) {
                        cartQuantity = Integer.parseInt(cartItem.get("quantity").toString());
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Allow increase only if it won't exceed available stock
        if (currentQuantity + cartQuantity < maxQuantity) {
            QuantityLabel.setText(String.valueOf(currentQuantity + 1));
            updateTotalPrice();
        } else {
            JOptionPane.showMessageDialog(this, "You've reached the stock limit.");
        }
    }//GEN-LAST:event_IncreaseBtnActionPerformed

    private void AddCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCartBtnActionPerformed
        // TODO add your handling code here:
        addCartItem();
    }//GEN-LAST:event_AddCartBtnActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_BackBtnActionPerformed

    private void DecreaseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecreaseBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = ItemTable.getSelectedRow();

        if (selectedRow == -1) {
            // Show a message if no item is selected
            JOptionPane.showMessageDialog(this, "Please select an item first.");
            return; // Exit the method without changing the quantity
        }

        // Get the current quantity from the label
        int currentQuantity = Integer.parseInt(QuantityLabel.getText());

        // If current quantity is greater than 0, decrease it
        if (currentQuantity > 0) {
            QuantityLabel.setText(String.valueOf(currentQuantity - 1));
            updateTotalPrice();  // Update the total price in real-time after changing the quantity
        } else {
            JOptionPane.showMessageDialog(this, "Quantity cannot be less than 0.");
        }
    }//GEN-LAST:event_DecreaseBtnActionPerformed

    private void loadItems() {
        model = (DefaultTableModel) ItemTable.getModel();
        model.setRowCount(0); // Reset the table

        String searchText = SearchF.getText().trim().toLowerCase();

        try {
            File backupFile = new File("src//Main//items_backup.json");

            if (!backupFile.exists()) {
                JOptionPane.showMessageDialog(this, "Backup items file not found.");
                return;
            }

            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader(backupFile);
            JSONArray itemsArray = (JSONArray) parser.parse(reader);
            reader.close();

            // Sort the itemsArray based on itemNumber in ascending order
            itemsArray.sort((o1, o2) -> {
                String itemNumber1 = (String) ((JSONObject) o1).get("itemNumber");
                String itemNumber2 = (String) ((JSONObject) o2).get("itemNumber");
                return itemNumber1.compareTo(itemNumber2); // Ascending order
            });

            for (Object obj : itemsArray) {
                JSONObject item = (JSONObject) obj;
                String itemNumber = (String) item.get("itemNumber");
                String name = (String) item.get("name");
                double price = Double.parseDouble(item.get("price").toString());
                int quantity = Integer.parseInt(item.get("quantity").toString());

                // Check if itemNumber or name matches search input
                if (itemNumber.toLowerCase().contains(searchText) || name.toLowerCase().contains(searchText)) {
                    String formattedPrice = String.format("₱%.2f", price);
                    model.addRow(new Object[]{itemNumber, name, formattedPrice, quantity});
                }
            }

            // Hide quantity column
            ItemTable.getColumnModel().getColumn(3).setMinWidth(0);
            ItemTable.getColumnModel().getColumn(3).setMaxWidth(0);
            ItemTable.getColumnModel().getColumn(3).setWidth(0);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading items.");
        }
    }


     private void addCartItem() {
        int selectedRow = ItemTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an item to add.");
            return;
        }

        int enteredQuantity;
        try {
            enteredQuantity = Integer.parseInt(QuantityLabel.getText());
            if (enteredQuantity <= 0) {
                JOptionPane.showMessageDialog(this, "Please select a quantity greater than 0.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid quantity input.");
            return;
        }

        String itemNumber = ItemTable.getValueAt(selectedRow, 0).toString();
        String name = ItemTable.getValueAt(selectedRow, 1).toString();
        String priceStr = ItemTable.getValueAt(selectedRow, 2).toString().replaceAll("[^0-9.-]", "");
        double price;

        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid price format.");
            return;
        }

        int availableQuantity = Integer.parseInt(ItemTable.getValueAt(selectedRow, 3).toString());

        File file = new File("src//Main//Cart.json");
        JSONArray cartArray = new JSONArray();

        try {
            if (file.exists()) {
                JSONParser parser = new JSONParser();
                FileReader reader = new FileReader(file);
                cartArray = (JSONArray) parser.parse(reader);
                reader.close();
            }

            boolean itemExists = false;
            for (Object obj : cartArray) {
                JSONObject cartItem = (JSONObject) obj;
                if (cartItem.get("itemNumber").toString().equals(itemNumber)) {
                    int currentQty = Integer.parseInt(cartItem.get("quantity").toString());
                    int newQty = currentQty + enteredQuantity;

                    if (newQty > availableQuantity) {
                        JOptionPane.showMessageDialog(this, "Total quantity exceeds available stock.");
                        return;
                    }

                    cartItem.put("quantity", newQty);
                    itemExists = true;
                    break;
                }
            }

            if (!itemExists) {
                if (enteredQuantity > availableQuantity) {
                    JOptionPane.showMessageDialog(this, "Not enough stock available.");
                    return;
                }

                JSONObject newItem = new JSONObject();
                newItem.put("itemNumber", itemNumber);
                newItem.put("itemName", name);
                newItem.put("quantity", enteredQuantity);
                newItem.put("price", price);
                cartArray.add(newItem);
            }

            FileWriter writer = new FileWriter(file);
            writer.write(cartArray.toJSONString());
            writer.flush();
            writer.close();

            JOptionPane.showMessageDialog(this, "Item added to cart.");

            if (addOrderFrame != null) {
                addOrderFrame.refreshTable();
            }

            this.dispose();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding item to cart.");
        }
    }


    private void updateTotalPrice() {
        int selectedRow = ItemTable.getSelectedRow();
        if (selectedRow != -1) {
            try {
                // Get the current quantity from the label
                int quantity = Integer.parseInt(QuantityLabel.getText());
                if (quantity >= 0) {
                    // Get the price from the selected row (column 2)
                    String priceStr = ItemTable.getValueAt(selectedRow, 2).toString().replace("₱", "").trim();
                    double price = Double.parseDouble(priceStr);
                    // Calculate total price
                    double total = quantity * price;
                    // Update the total price label
                    PriceallLabel.setText("₱" + String.format("%.2f", total));
                } else {
                    PriceallLabel.setText("₱0.00");
                }
            } catch (NumberFormatException ex) {
                PriceallLabel.setText("₱0.00");
            }
        } else {
            PriceallLabel.setText("₱0.00");
        }
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
            java.util.logging.Logger.getLogger(ADDCARTITEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADDCARTITEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADDCARTITEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADDCARTITEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCartBtn;
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton DecreaseBtn;
    private javax.swing.JLabel FINALBG;
    private javax.swing.JButton IncreaseBtn;
    private javax.swing.JTable ItemTable;
    private javax.swing.JLabel PriceallLabel;
    private javax.swing.JLabel QuantityLabel;
    private javax.swing.JTextField SearchF;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
