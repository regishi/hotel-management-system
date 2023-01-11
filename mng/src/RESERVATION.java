
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSetMetaData;
import java.text.ParseException;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DOLPHIX ELECTRONICS
 */
public class RESERVATION extends javax.swing.JFrame {

    /**
     * Creates new form RESERVATION
     */
    public RESERVATION() {
        initComponents();
        Connect();
        autoID();
        RoomTypeL();
        RoomNo();
        BedType();
        Load_reservation();
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
            ResultSet rs = s.executeQuery("select MAX(reid) from reservation");
            rs.next();
            rs.getString("MAX(reid)");
            
            if(rs.getString("MAX(reid)")== null)
            {
                jLabel12.setText("RE0001");
            }
            else
            {
                long id = Long.parseLong(rs.getString("MAX(reid)").substring(2,rs.getString("MAX(reid)").length()));
                id++;
                 jLabel12.setText("RE0" + String.format("%03d", id));
                
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ROOM.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
     
     
     
     public void RoomTypeL()
    {
        try {
            pst = con.prepareStatement("select Distinct rtype from room");
             ResultSet rs = pst.executeQuery();
             txtrtype.removeAllItems();
             
             while(rs.next())
             {
                 txtrtype.addItem(rs.getString("rtype"));
             }
             
             
        } catch (SQLException ex) {
            Logger.getLogger(ROOM.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
     
    
     
     
     
     
     
       public void Load_reservation()
    {
        
        int c;
        
        try {
            pst = con.prepareStatement("select * from  reservation");
            ResultSet rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                
                for(int i =1; i<=c; i++)
                {
                    v2.add(rs.getString("reid"));
                    v2.add(rs.getString("name")); 
                    v2.add(rs.getString("mobile"));
                    v2.add(rs.getString("check_in"));
                    v2.add(rs.getString("check_out"));
                    v2.add(rs.getString("room_type"));
                    v2.add(rs.getString("room_no"));
                    //v2.add(rs.getString("bed_type"));
                    v2.add(rs.getString("amount"));
                    
                }
                
                d.addRow(v2);
                
               
            }
         
        } catch (SQLException ex) {
            Logger.getLogger(RESERVATION.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
       
       
       
       
       
      public void RoomNo()
    {
        try {
            pst = con.prepareStatement("select Distinct rid from room");
             ResultSet rs = pst.executeQuery();
             txtro.removeAllItems();
             
             while(rs.next())
             {
                 txtro.addItem(rs.getString("rid"));
             }
             
             
        } catch (SQLException ex) {
            Logger.getLogger(ROOM.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
     
      
      
      
       public void BedType()
    {
        try {
            pst = con.prepareStatement("select Distinct btype from room");
             ResultSet rs = pst.executeQuery();
             txtbtype.removeAllItems();
             
             while(rs.next())
             {
                 txtbtype.addItem(rs.getString("btype"));
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtname = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        txtmobile = new javax.swing.JTextField();
        txtcheckin = new com.toedter.calendar.JDateChooser();
        txtcheckout = new com.toedter.calendar.JDateChooser();
        txtrtype = new javax.swing.JComboBox<>();
        txtro = new javax.swing.JComboBox<>();
        txtbtype = new javax.swing.JComboBox<>();
        txtamount = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Harrington", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 51));
        jLabel2.setText("reservation");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 153, 0)));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 51));
        jLabel3.setText("reid");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 51));
        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 51));
        jLabel5.setText("address");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 51));
        jLabel6.setText("mobile");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 51));
        jLabel7.setText("check in");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 51));
        jLabel8.setText("check out");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 51));
        jLabel9.setText("room type");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 51));
        jLabel10.setText("room no");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 51));
        jLabel11.setText("bed type");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, -1, -1));

        jLabel12.setFont(new java.awt.Font("Pristina", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 255, 102));
        jLabel12.setText("jLabel12");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 51));
        jLabel13.setText("amount");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, -1, 20));

        jButton1.setText("save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, -1, -1));

        jButton3.setText("clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, -1, -1));

        jButton4.setText("delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, -1, -1));

        jButton5.setBackground(new java.awt.Color(102, 102, 102));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 102));
        jButton5.setText("close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, -1, 20));
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 200, -1));
        getContentPane().add(txtaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 200, -1));
        getContentPane().add(txtmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 200, -1));
        getContentPane().add(txtcheckin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 210, -1));
        getContentPane().add(txtcheckout, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 210, -1));

        getContentPane().add(txtrtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 190, -1));

        getContentPane().add(txtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 190, -1));

        getContentPane().add(txtbtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 190, -1));
        getContentPane().add(txtamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 190, -1));

        jTable1.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "reid", "Name", "mobile", "chech_in", "check_out", "room type", "room_no", "amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 0, 700, 600));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\DOLPHIX ELECTRONICS\\Pictures\\project photoes\\rese.gif")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        HOME_PAGE e=new HOME_PAGE();
                    e.setVisible(true);
                    setVisible(false);  
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
        
        String reno = jLabel12.getText();
        String name = txtname.getText();
        String address = txtaddress.getText();
        String mobile = txtmobile.getText();        
        SimpleDateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
        String StartDate = df1.format(txtcheckin.getDate());
        SimpleDateFormat df2=new SimpleDateFormat("yyyy-MM-dd");
        String EndDate = df1.format(txtcheckout.getDate());
        String rtype = txtrtype.getSelectedItem().toString();
        String roomno = txtro.getSelectedItem().toString();
        String bedtype = txtbtype.getSelectedItem().toString();
        String amount = txtamount.getText();

        
        try {
            pst = con.prepareStatement("insert into reservation(reid,name,address,mobile,check_in,check_out,room_type,room_no,bed_type,amount) values(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, reno);
            pst.setString(2, name);
            pst.setString(3, address);
            pst.setString(4, mobile);
            pst.setString(5, StartDate);
            pst.setString(6, EndDate);
            pst.setString(7, bedtype);
            pst.setString(8, roomno);
            pst.setString(9, rtype);
            pst.setString(10, amount);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Reservation  Adddeddddd");
            
            txtname.setText("");
            txtaddress.setText("");
            txtmobile.setText("");
            txtaddress.setText("");
            txtmobile.setText("");
            txtrtype.setSelectedIndex(-1);
            txtro.setSelectedIndex(-1);
            txtbtype.setSelectedIndex(-1);
            txtamount.setText("");
            
            autoID();
            Load_reservation();
            
        } catch (SQLException ex) {
            Logger.getLogger(RESERVATION.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        
        
         String revno = jLabel12.getText();
      
        
        try {
            pst = con.prepareStatement("delete from reservation where reid = ?");
          
            pst.setString(1, revno);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Reservation Deletedddddd");
            
            txtname.setText("");
            txtaddress.setText("");
            txtmobile.setText("");
            txtaddress.setText("");
            txtmobile.setText("");
            txtrtype.setSelectedIndex(-1);
            txtro.setSelectedIndex(-1);
            txtbtype.setSelectedIndex(-1);
            txtamount.setText("");
            autoID();
            Load_reservation();
            jButton1.setEnabled(false);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RESERVATION.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        
         d = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        
        jLabel12.setText(d.getValueAt(selectIndex, 0).toString());
        txtname.setText(d.getValueAt(selectIndex, 1).toString());
        txtaddress.setEnabled(true);
        txtmobile.setText(d.getValueAt(selectIndex, 2).toString());
        txtcheckin.setEnabled(true);
        txtcheckout.setEnabled(true);
        txtrtype.setSelectedItem(d.getValueAt(selectIndex, 5).toString());
        txtro.setSelectedItem(d.getValueAt(selectIndex, 6).toString());
        //txtrtype.setEnabled(false);   
        //txtro.setEnabled(false);
       // txtbtype.setEnabled(false);
        txtamount.setText(d.getValueAt(selectIndex, 7).toString());
        
        jButton1.setEnabled(false);
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        
        
        
          
            txtname.setText("");
            txtaddress.setText("");
            txtmobile.setText("");
           // txtcheckin.setDate(null);
           // txtcheckout.setDate(null);
            txtrtype.setSelectedIndex(-1);
            txtro.setSelectedIndex(-1);
            txtbtype.setSelectedIndex(-1);
            txtamount.setText("");
            autoID();
            Load_reservation();
            jButton1.setEnabled(true);
            txtcheckin.setEnabled(true);
            txtcheckout.setEnabled(true);
            txtaddress.setEnabled(true);
            txtbtype.setEnabled(true);
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(RESERVATION.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RESERVATION.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RESERVATION.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RESERVATION.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RESERVATION().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtamount;
    private javax.swing.JComboBox<String> txtbtype;
    private com.toedter.calendar.JDateChooser txtcheckin;
    private com.toedter.calendar.JDateChooser txtcheckout;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtname;
    private javax.swing.JComboBox<String> txtro;
    private javax.swing.JComboBox<String> txtrtype;
    // End of variables declaration//GEN-END:variables
}
