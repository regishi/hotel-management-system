
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DOLPHIX ELECTRONICS
 */
public class ROOM extends javax.swing.JFrame {

    /**
     * Creates new form ROOM
     */
    public ROOM() {
        initComponents();
        Connect();
        autoID();
    }
    Connection con;
    PreparedStatement pst;
    DefaultTableModel d;
    
     public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/hoteldb", "root", "");     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ROOM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ROOM.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void autoID()
    {
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select MAX(rid) from room");
            rs.next();
            rs.getString("MAX(rid)");
            
            if(rs.getString("MAX(rid)")== null)
            {
                jLabel4.setText("R0001");
            }
            else
            {
                long id = Long.parseLong(rs.getString("MAX(rid)").substring(2,rs.getString("MAX(rid)").length()));
                id++;
                 jLabel4.setText("R0" + String.format("%03d", id));
                
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ROOM.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void Load_room()
    {
        
        int c;
        
        try {
            pst = con.prepareStatement("select * from room");
            ResultSet rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            d= (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                
                for(int i =1; i<=c; i++)
                {
                    v2.add(rs.getString("rid"));
                    v2.add(rs.getString("rtype"));
                    v2.add(rs.getString("btype"));
                    v2.add(rs.getString("amount"));
                    
                }
                
                d.addRow(v2);   
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ROOM.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtrtype = new javax.swing.JComboBox<>();
        txtbtype = new javax.swing.JComboBox<>();
        txtamount = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,0));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ROOM No");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 10, 110, 22);

        jLabel4.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 0));
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(180, 10, 80, 22);

        jLabel5.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ROOM TYPE");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 50, 100, 22);

        jLabel6.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("BED TYPE");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 150, 90, 22);

        jLabel7.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("AMOUNT");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 280, 100, 22);

        txtrtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VIP", "MIDLE CLASS", "ECONOMIC" }));
        txtrtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrtypeActionPerformed(evt);
            }
        });
        jPanel1.add(txtrtype);
        txtrtype.setBounds(160, 40, 130, 22);

        txtbtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KING SIZE", "QUENN SIZE", "SINGLE", "DOUBLE" }));
        jPanel1.add(txtbtype);
        txtbtype.setBounds(150, 150, 130, 22);
        jPanel1.add(txtamount);
        txtamount.setBounds(130, 270, 160, 30);

        jButton1.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 153, 0));
        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(60, 340, 110, 30);

        jButton2.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 153, 0));
        jButton2.setText("EDIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(330, 340, 70, 28);

        jButton3.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 153, 0));
        jButton3.setText("CLEAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(200, 340, 90, 30);

        jButton4.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 153, 0));
        jButton4.setText("DELETE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(200, 410, 90, 30);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 430, 500));

        jLabel2.setFont(new java.awt.Font("Segoe Script", 3, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 51));
        jLabel2.setText("ROOM PAGE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 360, -1));

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setBackground(new java.awt.Color(0, 0, 0,100));
        jTable1.setForeground(new java.awt.Color(255, 102, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ROOM No", "ROOM TYPE", "BED TYPE", "AMOUNT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 600, 490));

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 51, 51));
        jButton5.setText("CLOSE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 80, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\DOLPHIX ELECTRONICS\\Documents\\project source code\\3.gif")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 20, 1350, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
            txtrtype.setSelectedIndex(-1);
            txtbtype.setSelectedIndex(-1);
            txtamount.setText("");
            autoID();
            Load_room();
            jButton1.setEnabled(true);
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //CLOSE BUTTON 
        HOME_PAGE e=new HOME_PAGE();
                    e.setVisible(true);
                    setVisible(false);  
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //adding a data in room table in database hoteldb
           
        String roomno = jLabel4.getText();
        String roomtype = txtrtype.getSelectedItem().toString();
        String bedtype = txtbtype.getSelectedItem().toString();
        String amount = txtamount.getText();
        
        try {
            pst = con.prepareStatement("insert into room(rid,rtype,btype,amount) values(?,?,?,?)");
            pst.setString(1, roomno);
            pst.setString(2, roomtype);
            pst.setString(3, bedtype);
            pst.setString(4, amount);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Room Adddeddddd");
            
            txtrtype.setSelectedIndex(-1);
            txtbtype.setSelectedIndex(-1);
            txtamount.setText("");
            autoID();
            Load_room();
            
        } catch (SQLException ex) {
            Logger.getLogger(ROOM.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //deleting data from room table in database hoteldb
          String roomno = jLabel4.getText();
      
        
        try {
            pst = con.prepareStatement("delete from room where rid = ?");
          
            pst.setString(1, roomno);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Room Deletedddddd");
            
            txtrtype.setSelectedIndex(-1);
            txtbtype.setSelectedIndex(-1);
            txtamount.setText("");
            autoID();
            Load_room();
            jButton1.setEnabled(true);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ROOM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtrtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrtypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrtypeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //editing and updating data from room table in database hoteldb
        
        String roomno = jLabel4.getText();
        String roomtype = txtrtype.getSelectedItem().toString();
        String bedtype = txtbtype.getSelectedItem().toString();
        String amount = txtamount.getText();
        
        try {
            pst = con.prepareStatement("update room set rtype = ?, btype = ? , amount = ? where rid = ?");
            pst.setString(1, roomtype);
            pst.setString(2, bedtype);
            pst.setString(3, amount);
            pst.setString(4, roomno);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Room Editeddddd");
            
            txtrtype.setSelectedIndex(-1);
            txtbtype.setSelectedIndex(-1);
            txtamount.setText("");
            autoID();
            Load_room();
            jButton1.setEnabled(true);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ROOM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        // displaying information from database into UI table
                
        d = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        
        
        jLabel4.setText(d.getValueAt(selectIndex, 0).toString());
        txtrtype.setSelectedItem(d.getValueAt(selectIndex, 1).toString());
        txtbtype.setSelectedItem(d.getValueAt(selectIndex, 2).toString());
        txtamount.setText(d.getValueAt(selectIndex, 3).toString());
        
        jButton1.setEnabled(false);
        

    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(ROOM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ROOM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ROOM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ROOM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ROOM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtamount;
    private javax.swing.JComboBox<String> txtbtype;
    private javax.swing.JComboBox<String> txtrtype;
    // End of variables declaration//GEN-END:variables
}