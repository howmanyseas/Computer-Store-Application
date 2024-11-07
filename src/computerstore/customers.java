/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package computerstore;
import java.sql.PreparedStatement;

import java.sql.Connection;
 // Assuming you need DBCon class (adjust if needed)
import computerstore.dbcon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author sadir
 */
public class customers extends javax.swing.JFrame {

    /**
     * Creates new form customers
     */
      private final Connection con;
   
      private final dbcon dbConnector;
    public customers() {
        initComponents();
        dbConnector = new dbcon(); // Instantiate dbcon in the constructor
        con = dbConnector.connect(); // Initialize con using dbConnector

        if (con != null) {
            System.out.println("Database connection successful.");
            showCust(); // Call the method to display services
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
 public void showCust() {
       try {
            System.out.println("Fetching services...");
            PreparedStatement SQ = con.prepareStatement("SELECT * FROM CUSTOMER;");
            ResultSet rs = SQ.executeQuery();

            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.setRowCount(0);
//CUSTOMER_ID, CUS_USERNAME, CUS_PASSWORD, CUS_EMAIL, CUS_REG, CUS_DOB, ACCOUNT_STAT, CUS_FNAME, CUS_LNAME)
            while (rs.next()) {
                String CUSTOMER_ID = String.valueOf(rs.getInt("CUSTOMER_ID"));
                String CUS_USERNAME = rs.getString("CUS_USERNAME");
                String CUS_PASSWORD = rs.getString("CUS_PASSWORD");
                String CUS_EMAIL = rs.getString("CUS_EMAIL");
                String CUS_REG = rs.getString("CUS_REG");
                String CUS_DOB = rs.getString("CUS_DOB");
                String ACCOUNT_STAT_STR = rs.getString("ACCOUNT_STAT");
                boolean ACCOUNT_STAT = Boolean.parseBoolean(ACCOUNT_STAT_STR); // Convert to boolean
                String CUS_FNAME = rs.getString("CUS_FNAME");
                String CUS_LNAME = rs.getString("CUS_LNAME");
               
                String rowData[] = {CUSTOMER_ID, CUS_USERNAME, CUS_PASSWORD, CUS_EMAIL, CUS_REG, CUS_DOB, String.valueOf(ACCOUNT_STAT), CUS_FNAME, CUS_LNAME};
                tableModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            System.out.println("Error fetching services: " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching services.");
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        search_tt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(129, 135, 177));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CUS_ID", "CUS_USERNAME", "CUS_PASSWORD", "CUS_EMAIL", "CUS_REG", "CUS_DOB", "ACCOUNT_STAT", "CUS_FNAME", "CUS_LNAME"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        search_tt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_ttActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(59, 75, 125));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SHOW");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CUSTOMER LIST");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(search_tt, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_tt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

      
 if (search_tt.getText().isEmpty()) {
       showCust(); 
  
     // If the search field is empty, show all categories showAllCateg(); 
    } else {
        try {
            // Clear the existing table data
            DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
            table.setRowCount(0);
//CUSTOMER_ID, CUS_USERNAME, CUS_PASSWORD, CUS_EMAIL, CUS_REG, CUS_DOB, ACCOUNT_STAT, CUS_FNAME, CUS_LNAME)

            PreparedStatement search = 
                    con.prepareStatement("SELECT * FROM CATEGORY WHERE CUSTOMER_ID=? OR CUS_PASSWORD=? OR CUS_EMAIL=? OR CUS_REG=? OR CUS_DOB=? OR ACCOUNT_STAT=? OR CUS_FNAME=? OR CUS_LNAME=?;");
            search.setString(1, search_tt.getText());
            search.setString(2, search_tt.getText());
            search.setString(3, search_tt.getText());
            search.setString(4, search_tt.getText());
            search.setString(5, search_tt.getText());
            search.setBoolean(6, Boolean.parseBoolean(search_tt.getText()));
            search.setString(7, search_tt.getText());
            search.setString(8, search_tt.getText());
            search.setString(9, search_tt.getText());

            ResultSet res = search.executeQuery();

            while (res.next()) {
                String CUSTOMER_ID = String.valueOf(res.getInt("CUSTOMER_ID"));
                String CUS_USERNAME = res.getString("CUS_USERNAME");
                String CUS_PASSWORD = res.getString("CUS_PASSWORD");
                String CUS_EMAIL = res.getString("CUS_EMAIL");
                String CUS_REG = res.getString("CUS_REG");
                String CUS_DOB = res.getString("CUS_DOB");
                String ACCOUNT_STAT_STR = res.getString("ACCOUNT_STAT");
                boolean ACCOUNT_STAT = Boolean.parseBoolean(ACCOUNT_STAT_STR); // Convert to boolean
                String CUS_FNAME = res.getString("CUS_FNAME");
                String CUS_LNAME = res.getString("CUS_LNAME");
               
                String tableData[] = {CUSTOMER_ID, CUS_USERNAME, CUS_PASSWORD, CUS_EMAIL, CUS_REG, CUS_DOB, String.valueOf(ACCOUNT_STAT), CUS_FNAME, CUS_LNAME};
          
                table.addRow(tableData);
            }
        } catch (SQLException ex) {
            System.out.println("Could not search for the keyword due to DB problems!");
            JOptionPane.showMessageDialog(this, "Could not search for the keyword due to DB problems!");
        }
    }







        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void search_ttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_ttActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_ttActionPerformed

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
            java.util.logging.Logger.getLogger(customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField search_tt;
    // End of variables declaration//GEN-END:variables
}
