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
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.nio.file.Files;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class ADDORDER extends javax.swing.JFrame {

    private String userRole; // Store the user's role
    private MANAGEORDER parentFrame; // Reference to the parent frame

    public ADDORDER(String role, MANAGEORDER parent) {
        initComponents();
        generateNextOrderId();
        this.userRole = role;
        this.parentFrame = parent;
        loadCartItems();
        createBackup();  // Create a backup when entering ADDORDER
        setCurrentDate();
        calculateTotalPrice();

        OrderTable.getTableHeader().setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        JTable[] tables = {OrderTable};

        for (JTable table : tables) {
            // Center cells
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            // Custom header renderer with background color and bold font
            JTableHeader header = table.getTableHeader();
            headerRenderer.setHorizontalAlignment(JLabel.CENTER);
            headerRenderer.setBackground(Color.decode("#325ea0")); // Your desired color
            headerRenderer.setForeground(Color.WHITE); // White text looks good on dark blue

            // Set font to Segoe UI, size 14, and bold for header only
            // Apply the custom header renderer to each column
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
            }

            header.repaint();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        AddItemBtn = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        PLaceOrderBtn = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        OrderTable = new javax.swing.JTable();
        jlabel3 = new javax.swing.JLabel();
        TotalPriceLabel2 = new javax.swing.JLabel();
        OrderIdLabel = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TotalPriceLabel = new javax.swing.JLabel();
        ClearBtn = new javax.swing.JButton();
        TotalPriceLabel4 = new javax.swing.JLabel();
        FINALBG = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ADD ORDER");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 92, 90, -1));

        AddItemBtn.setBackground(new java.awt.Color(217, 234, 253));
        AddItemBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        AddItemBtn.setForeground(new java.awt.Color(0, 0, 0));
        AddItemBtn.setText("ADD ITEM");
        AddItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemBtnActionPerformed(evt);
            }
        });
        getContentPane().add(AddItemBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, 170, 42));

        Cancel.setBackground(new java.awt.Color(217, 234, 253));
        Cancel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        Cancel.setForeground(new java.awt.Color(0, 0, 0));
        Cancel.setText("CANCEL");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        getContentPane().add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 530, 170, 42));

        PLaceOrderBtn.setBackground(new java.awt.Color(217, 234, 253));
        PLaceOrderBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        PLaceOrderBtn.setForeground(new java.awt.Color(0, 0, 0));
        PLaceOrderBtn.setText("PLACE NEW ORDER");
        PLaceOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PLaceOrderBtnActionPerformed(evt);
            }
        });
        getContentPane().add(PLaceOrderBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 170, 42));

        EditBtn.setBackground(new java.awt.Color(38, 67, 114));
        EditBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        EditBtn.setForeground(new java.awt.Color(255, 255, 255));
        EditBtn.setText("EDIT");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });
        getContentPane().add(EditBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 137, 130, 30));

        OrderTable.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        OrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Item Id", "Item Name", "Quantity", "Price per Item", "Price all Items"
            }
        ));
        OrderTable.setIntercellSpacing(new java.awt.Dimension(0, 5));
        OrderTable.setRowHeight(25);
        jScrollPane3.setViewportView(OrderTable);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 184, 906, 254));

        jlabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jlabel3.setForeground(new java.awt.Color(0, 0, 0));
        jlabel3.setText("Total Price:");
        getContentPane().add(jlabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 456, 90, -1));

        TotalPriceLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        TotalPriceLabel2.setForeground(new java.awt.Color(0, 0, 0));
        TotalPriceLabel2.setText("Date: ");
        getContentPane().add(TotalPriceLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 39, -1));

        OrderIdLabel.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        OrderIdLabel.setForeground(new java.awt.Color(0, 0, 0));
        OrderIdLabel.setText("OrderIdLabel");
        getContentPane().add(OrderIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 120, -1));

        DateLabel.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        DateLabel.setForeground(new java.awt.Color(0, 0, 0));
        DateLabel.setText("DateLabel");
        getContentPane().add(DateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 90, 20));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("STOCKHUB");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 10, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Order and Inventory System");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 40, -1, -1));

        TotalPriceLabel.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        TotalPriceLabel.setForeground(new java.awt.Color(0, 153, 0));
        TotalPriceLabel.setText("TotalPrice");
        getContentPane().add(TotalPriceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 456, 70, -1));

        ClearBtn.setBackground(new java.awt.Color(38, 67, 114));
        ClearBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        ClearBtn.setForeground(new java.awt.Color(255, 255, 255));
        ClearBtn.setText("CLEAR");
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });
        getContentPane().add(ClearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 137, 130, 30));

        TotalPriceLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        TotalPriceLabel4.setForeground(new java.awt.Color(0, 0, 0));
        TotalPriceLabel4.setText("Order Id:");
        getContentPane().add(TotalPriceLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 70, -1));

        FINALBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/ADDORDER BG FINAL.png"))); // NOI18N
        FINALBG.setText("jLabel2");
        getContentPane().add(FINALBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, -1));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        try (FileReader reader = new FileReader("src//Main//Cart.json")) {
            // Read the entire content of Cart.json
            char[] content = new char[1024];  // Buffer size, can adjust
            int length = reader.read(content);
            String cartContent = new String(content, 0, length).trim();

            // If Cart.json is not empty (contains items)
            if (!cartContent.equals("[]")) {
                int confirm = JOptionPane.showConfirmDialog(this,
                        "Are you sure you want to cancel placing the order?",
                        "Cancel Order",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                // If the user confirms to cancel
                if (confirm == JOptionPane.YES_OPTION) {
                    // Read the current items_backup.json to restore stock
                    File itemsBackupFile = new File("src//Main//items_backup.json");
                    JSONArray itemsBackupArray = new JSONArray();

                    if (itemsBackupFile.exists()) {
                        JSONParser parser = new JSONParser();
                        FileReader itemsReader = new FileReader(itemsBackupFile);
                        itemsBackupArray = (JSONArray) parser.parse(itemsReader);
                        itemsReader.close();
                    }

                    // Read the current Cart.json to get the items that need their stock restored
                    JSONArray cartArray = new JSONArray();
                    cartArray = (JSONArray) new JSONParser().parse(new FileReader("src//Main//Cart.json"));

                    // Loop through the cart and restore stock for each item in items_backup.json
                    for (int i = 0; i < cartArray.size(); i++) {
                        JSONObject cartItem = (JSONObject) cartArray.get(i);
                        String itemNumber = cartItem.get("itemNumber").toString();
                        int quantity = Integer.parseInt(cartItem.get("quantity").toString());

                        // Restore the stock in items_backup.json
                        for (int j = 0; j < itemsBackupArray.size(); j++) {
                            JSONObject item = (JSONObject) itemsBackupArray.get(j);
                            if (item.get("itemNumber").toString().equals(itemNumber)) {
                                int currentStock = Integer.parseInt(item.get("quantity").toString());
                                item.put("quantity", currentStock + quantity); // Increase the stock
                                break;
                            }
                        }
                    }

                    // Now save the updated items_backup.json
                    try (FileWriter backupWriter = new FileWriter(itemsBackupFile)) {
                        backupWriter.write(itemsBackupArray.toJSONString());
                        backupWriter.flush();
                    }

                    // Clear Cart.json by writing an empty array
                    try (FileWriter file = new FileWriter("src//Main//Cart.json")) {
                        file.write("[]");
                        file.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error clearing Cart.json!", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    // Notify the user that the order was cancelled
                    JOptionPane.showMessageDialog(this, "Order cancelled");

                    // Navigate back to manage orders
                    MANAGEORDER x = new MANAGEORDER(userRole); // Use userRole instead of hardcoded "Employee"
                    x.setVisible(true);
                    setVisible(false);
                }
            } else {
                // No need to confirm, just navigate back and restore stock from backup
                MANAGEORDER x = new MANAGEORDER(userRole); // Use userRole instead of hardcoded "Employee"
                x.setVisible(true);
                setVisible(false);
            }
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading Cart.json or items_backup.json!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CancelActionPerformed

    private void PLaceOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PLaceOrderBtnActionPerformed
        // TODO add your handling code here:
        saveOrder();
    }//GEN-LAST:event_PLaceOrderBtnActionPerformed

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        // TODO add your handling code here:
    int selectedRow = OrderTable.getSelectedRow();
    if (selectedRow != -1) {
        String itemNumber = OrderTable.getValueAt(selectedRow, 0).toString();
        String itemName = OrderTable.getValueAt(selectedRow, 1).toString();
        int quantity = Integer.parseInt(OrderTable.getValueAt(selectedRow, 2).toString());

        // FIX: Remove currency symbols before parsing
        String rawPrice = OrderTable.getValueAt(selectedRow, 3).toString().replaceAll("[^\\d.]", "");
        double pricePerItem = Double.parseDouble(rawPrice);

        new EDITCARTITEM(itemNumber, itemName, quantity, pricePerItem, this).setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Please select an item to edit.");
    }
    }//GEN-LAST:event_EditBtnActionPerformed

    private void AddItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemBtnActionPerformed
        // TODO add your handling code here:
        ADDCARTITEM addCartItemFrame = new ADDCARTITEM(this);
        addCartItemFrame.setVisible(true);
    }//GEN-LAST:event_AddItemBtnActionPerformed

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) OrderTable.getModel();
        model.setRowCount(0);  // Clear the table
        TotalPriceLabel.setText("0.00");  // Reset total price

        try {
            // Load Cart.json
            JSONArray cartArray = readJsonFile("src//Main//Cart.json");

            if (cartArray.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No items to be cleared.");
                return;
            }

            // Load original items from a permanent backup (items_original.json)
            JSONArray originalItems = readJsonFile("src//Main//items_backup.json");

            // Overwrite items_backup.json with original values
            writeJsonFile("src//Main//items_backup.json", originalItems);

            // Clear Cart.json
            writeJsonFile("src//Main//Cart.json", new JSONArray());

            JOptionPane.showMessageDialog(this, "Your cart has been cleared successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error clearing cart.");
        }
    }

// Helper method to read JSON file
    private JSONArray readJsonFile(String filePath) throws IOException, ParseException {
        File file = new File(filePath);
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                JSONParser parser = new JSONParser();
                return (JSONArray) parser.parse(reader);
            }
        }
        return new JSONArray();  // Return an empty array if the file doesn't exist
    }

// Helper method to write JSON to a file
    private void writeJsonFile(String filePath, JSONArray jsonArray) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(jsonArray.toJSONString());
            writer.flush();
        }

    }//GEN-LAST:event_ClearBtnActionPerformed

    public void loadCartItems() {
        try {
            FileReader reader = new FileReader("src//Main//Cart.json");
            JSONParser parser = new JSONParser();
            JSONArray cartArray = (JSONArray) parser.parse(reader);

            // Sorting the cartArray based on itemNumber in ascending order
            cartArray.sort((o1, o2) -> {
                String itemNumber1 = (String) ((JSONObject) o1).get("itemNumber");
                String itemNumber2 = (String) ((JSONObject) o2).get("itemNumber");
                return itemNumber1.compareTo(itemNumber2); // Ascending order
            });

            DefaultTableModel model = (DefaultTableModel) OrderTable.getModel();
            model.setRowCount(0); // Clear existing rows
            DecimalFormat df = new DecimalFormat("₱#,##0.00");

            for (Object obj : cartArray) {
                JSONObject item = (JSONObject) obj;

                String itemNumber = (String) item.get("itemNumber");
                String itemName = (String) item.get("itemName");
                long quantity = (Long) item.get("quantity");
                double price = (Double) item.get("price");

                double totalItemPrice = price * quantity;

                // Format price display only
                model.addRow(new Object[]{
                    itemNumber,
                    itemName,
                    quantity,
                    df.format(price), // Formatted "₱100.00"
                    df.format(totalItemPrice) // Formatted "₱300.00"
                });
            } // After loading items, calculate the total price
            calculateTotalPrice();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = sdf.format(new Date());
        DateLabel.setText(currentDate);
    }

    void calculateTotalPrice() {
        DefaultTableModel model = (DefaultTableModel) OrderTable.getModel();
        double total = 0;
        // Loop through all rows in the table to sum up the total price
        for (int i = 0; i < model.getRowCount(); i++) {
            // Extract the price for the current item in the row
            String totalPriceString = model.getValueAt(i, 4).toString().replace("₱", "").replace(",", "");
            double totalPrice = Double.parseDouble(totalPriceString);
            total += totalPrice;  // Accumulate the total price
        }
        // Format the total price and update the label
        DecimalFormat df = new DecimalFormat("₱#,##0.00");
        TotalPriceLabel.setText(df.format(total));  // Update TotalPriceLabel
    }

   private void saveOrder() {
    DefaultTableModel model = (DefaultTableModel) OrderTable.getModel();

    // Step 1: Check if there are no items in the order
    if (model.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "No items to place order.");
        return; // Exit if there are no items in the order
    }

    // Step 2: Show confirmation dialog before placing the order
    int confirmOrder = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to place this order?",
            "Confirm Order",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
    );

    if (confirmOrder != JOptionPane.YES_OPTION) {
        return; // User canceled the order
    }

    // Step 3: Continue with the order placement process
    String orderId = OrderIdLabel.getText();
    String date = DateLabel.getText();
    String filePath = "src//Main//Orders.json";

    // Parse the total price correctly without the currency symbol for saving
    String totalPriceString = TotalPriceLabel.getText();
    double totalPrice = 0.0;
    try {
        // Remove any non-numeric characters except for the decimal point
        totalPriceString = totalPriceString.replaceAll("[^0-9\\.]", "");
        totalPrice = Double.parseDouble(totalPriceString);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid total price format. Please check the price value.", "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
        return;
    }

    JSONArray orderItems = new JSONArray();

    // Step 4: Load Cart Items (Cart.json)
    JSONArray cartItems = new JSONArray();
    try {
        FileReader cartReader = new FileReader("src//Main//Cart.json");
        JSONParser cartParser = new JSONParser();
        cartItems = (JSONArray) cartParser.parse(cartReader);
        cartReader.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error reading Cart.json", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Step 5: Load Items (items.json)
    JSONArray itemsArray = new JSONArray();
    try {
        FileReader itemsReader = new FileReader("src//Main//items.json");
        JSONParser itemsParser = new JSONParser();
        itemsArray = (JSONArray) itemsParser.parse(itemsReader);
        itemsReader.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error reading items.json", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Step 6: Deduct Quantities in items.json based on Cart.json
    for (Object cartItemObj : cartItems) {
        JSONObject cartItem = (JSONObject) cartItemObj;
        String cartItemNumber = (String) cartItem.get("itemNumber");
        long cartItemQuantity = (Long) cartItem.get("quantity");

        // Find the corresponding item in items.json and deduct the quantity
        for (Object itemObj : itemsArray) {
            JSONObject item = (JSONObject) itemObj;
            String itemNumber = (String) item.get("itemNumber");
            long itemQuantity = (Long) item.get("quantity");

            if (cartItemNumber.equals(itemNumber)) {
                if (itemQuantity >= cartItemQuantity) {
                    item.put("quantity", itemQuantity - cartItemQuantity); // Deduct the quantity
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient stock for item: " + itemNumber, "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Exit if there's insufficient stock
                }
                break;
            }
        }
    }

    // Step 7: Save the updated items.json with the deducted quantities
    try {
        FileWriter itemsWriter = new FileWriter("src//Main//items.json");
        itemsWriter.write(itemsArray.toJSONString());
        itemsWriter.flush();
        itemsWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating items.json", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Continue with order placement (saving the order)
    for (int i = 0; i < model.getRowCount(); i++) {
        JSONObject item = new JSONObject();
        item.put("itemNumber", model.getValueAt(i, 0));
        item.put("itemName", model.getValueAt(i, 1));
        item.put("quantity", model.getValueAt(i, 2));

        // Ensure the price is stored as a numeric value (double), not a formatted string with currency symbol
        Object priceObj = model.getValueAt(i, 3); // Assuming the price is in the 4th column
        double price = 0.0;
        if (priceObj instanceof String) {
            // Parse the price if it is a string containing the currency symbol
            String priceString = ((String) priceObj).replaceAll("[^0-9\\.]", ""); // Remove non-numeric characters
            price = Double.parseDouble(priceString);
        } else if (priceObj instanceof Double) {
            price = (Double) priceObj; // If it's already a numeric value
        }
        item.put("price", price);
        orderItems.add(item);
    }

    JSONObject newOrder = new JSONObject();
    newOrder.put("orderId", orderId);
    newOrder.put("date", date);
    newOrder.put("status", "Pending");
    newOrder.put("totalPrice", totalPrice);  // Store the parsed numeric total price
    newOrder.put("items", orderItems);

    try {
        File file = new File(filePath);
        JSONArray ordersArray;

        if (file.exists() && file.length() > 0) {
            JSONParser parser = new JSONParser();
            ordersArray = (JSONArray) parser.parse(new FileReader(file));
        } else {
            ordersArray = new JSONArray();
        }

        ordersArray.add(newOrder);

        // Write the updated orders array to the file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(ordersArray.toJSONString());
        }

        // Clear the cart
        FileWriter cartClear = new FileWriter("src//Main//Cart.json");
        cartClear.write("[]");
        cartClear.close();

        // Notify user and refresh the MANAGEORDER table
        JOptionPane.showMessageDialog(this, "Order placed successfully!");

        MANAGEORDER x = new MANAGEORDER(userRole);
        x.setVisible(true);
        setVisible(false);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    private void generateNextOrderId() {
        String filePath = "src//Main//Orders.json";
        String prefix = "ORD";
        int maxIdNum = 0;
        try {
            File file = new File(filePath);
            if (file.exists() && file.length() > 0) {
                JSONParser parser = new JSONParser();
                JSONArray ordersArray = (JSONArray) parser.parse(new FileReader(filePath));

                for (Object obj : ordersArray) {
                    JSONObject order = (JSONObject) obj;
                    String id = (String) order.get("orderId");

                    if (id.startsWith(prefix)) {
                        try {
                            int idNum = Integer.parseInt(id.substring(prefix.length()));
                            if (idNum > maxIdNum) {
                                maxIdNum = idNum;
                            }
                        } catch (NumberFormatException e) {
                            // Skip non-numeric IDs
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int nextIdNum = maxIdNum + 1;
        String nextId = String.format("%s%03d", prefix, nextIdNum);
        OrderIdLabel.setText(nextId);
    }

    public void refreshTable() {
        loadCartItems(); // Reloads the JTable from Cart.json
    }

    private void createBackup() {
        try {
            File itemsFile = new File("src//Main//items.json");
            File backupFile = new File("src//Main//items_backup.json");

            if (itemsFile.exists() && !backupFile.exists()) {
                // Copy the content of items.json to items_backup.json
                Files.copy(itemsFile.toPath(), backupFile.toPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error creating backup file!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

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
            java.util.logging.Logger.getLogger(ADDORDER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADDORDER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADDORDER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADDORDER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADDORDER("role", null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddItemBtn;
    private javax.swing.JButton Cancel;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JButton EditBtn;
    private javax.swing.JLabel FINALBG;
    private javax.swing.JLabel OrderIdLabel;
    private javax.swing.JTable OrderTable;
    private javax.swing.JButton PLaceOrderBtn;
    private javax.swing.JLabel TotalPriceLabel;
    private javax.swing.JLabel TotalPriceLabel2;
    private javax.swing.JLabel TotalPriceLabel4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jlabel3;
    // End of variables declaration//GEN-END:variables
}
