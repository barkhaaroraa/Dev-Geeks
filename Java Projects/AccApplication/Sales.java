/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccApplication;

import static AccApplication.DBConnection.con;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Asus
 */
public class Sales extends javax.swing.JFrame {

    /**
     * Creates new form Purchase
     */
    Vector Sprice;
    Vector ID; 
    Vector Customer;
    Vector City;
    ResultSet rs,rs1;
    String da;
    String a;
    String b;
    int c;
    String x;
    int y;
    public void pitm()
    {
        
         try{
           Statement stm = con1.createStatement();
           rs = stm.executeQuery("select * from item");
           ID = new Vector();
           Sprice = new Vector();
           
           while(rs.next())
           {
               ID.addElement(rs.getInt(1));
               item.addItem(rs.getString(2));
               Sprice.addElement(rs.getInt(4));
           }
        }catch(Exception ee)
        {
            System.out.println(ee +"pi");
        }
    }
    public void Company()
    {
        try{
           Statement stm = con1.createStatement();
           rs = stm.executeQuery("select * from customer");
           Customer = new Vector();
           City = new Vector();
           
           while(rs.next())
           {
               customer.addItem(rs.getString(2));
               Customer.addElement(rs.getString(2));
               City.addElement(rs.getString(3));
           }
        }catch(Exception ee)
        {
            System.out.println(ee+"c");
        }
    }
        Connection con1;
        
    public Sales() {
        initComponents();
        con1=DBConnection.getConn();
        pitm();
        Company();
        invoiceid();
    }
public void invoiceid()
    {
        try {
          
            Statement s = con1.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(InvoiceNo) FROM sales");
            rs.next();
            rs.getString("MAX(InvoiceNo)");
            if (rs.getString("MAX(InvoiceNo)") == null) {
               invno.setText("S-0000001");    
            } else {
                long id = Long.parseLong(rs.getString("MAX(InvoiceNo)").substring(2,rs.getString("MAX(InvoiceNo)").length()));
                id++;
                invno.setText("S-" + String.format("%07d", id));
            }
        } catch (Exception ex) {
            System.out.println(ex+"id");
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

        jLabel1 = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        customer = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        item = new javax.swing.JComboBox<>();
        invno = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tamt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ppr = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        pdate = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 48)); // NOI18N
        jLabel1.setText("Sales Form");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, 69));

        home.setText("HOME");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        getContentPane().add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));

        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, 150, 72));

        jPanel1.setBackground(new java.awt.Color(0, 10, 30,80));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        customer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                customerItemStateChanged(evt);
            }
        });

        jLabel4.setText("Customer Name");

        item.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                itemItemStateChanged(evt);
            }
        });

        jLabel6.setText("Quantity");

        jLabel2.setBackground(new java.awt.Color(210, 50, 0));
        jLabel2.setText("Invoice No.");

        jLabel3.setText("Item");

        tamt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamtActionPerformed(evt);
            }
        });

        jLabel9.setText("Total amount");

        ppr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pprActionPerformed(evt);
            }
        });

        jLabel7.setText("Sales Price");

        jLabel5.setText("City");

        city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityActionPerformed(evt);
            }
        });

        pdate.setDateFormatString("yyyy-MM-dd");

        jLabel8.setText("Sales Date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(21, 21, 21)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tamt, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(customer, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(invno, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pdate, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ppr, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(invno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ppr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tamt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 790, 320));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AccApplication/Sales5.jpg"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
      this.setVisible(false);
      AccSystem.main(new String[2]);
    }//GEN-LAST:event_homeActionPerformed

    private void itemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_itemItemStateChanged
        // TODO add your handling code here:
        try{
           int x = item.getSelectedIndex();
           ppr.setText(Sprice.get(x)+"");
        }catch(Exception ee)
        {}
    }//GEN-LAST:event_itemItemStateChanged

    private void tamtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamtActionPerformed
      
    }//GEN-LAST:event_tamtActionPerformed

    private void customerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_customerItemStateChanged
        // TODO add your handling code here:
        try{
           int x = customer.getSelectedIndex();
           city.setText(City.get(x)+"");
        }catch(Exception ee)
        {}
    }//GEN-LAST:event_customerItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         String id =invno.getText();
         try{
  //        STOCK
         int count = 0 , n = 0;
         Statement s = con1.createStatement();
         ResultSet rs1 = s.executeQuery("SELECT * from stock");
         while(rs1.next())
         {
             if(rs1.getString(2).equals(x)){
                  y = rs1.getInt(3);
                 if(y >= Integer.parseInt(a)){
                 y -= Integer.parseInt(a);
                 int z = rs1.getInt(1);
                 PreparedStatement p = con1.prepareStatement("Update stock set Qty = ? where ID = ?");
                 p.setInt(1,y);
                 p.setInt(2,z);
                 p.executeUpdate();
                 count = 1;
                 p.close();
             }else{
                     showMessageDialog(this,"NOT SUFFICIENT QUANTITY");
                     n=1;
                 }
             }
         }
         if(count == 0 && n == 0 )
         {
            showMessageDialog(this,"ITEM NOT PRESENT");
    
         }
          if(y >= Integer.parseInt(a)){   
         PreparedStatement ps = con1.prepareStatement
         ("insert into sales(InvoiceNo,item,CName,ccity,Qty,Sprice,Sdate,Totalamt) values (?,?,?,?,?,?,?,?)");
         ps.setString(1,id);
         ps.setString(2, (String) item.getSelectedItem());
         String x = (String) item.getSelectedItem();
         ps.setString(3, (String) customer.getSelectedItem());
         ps.setString(4,city.getText());
         ps.setInt(5,Integer.parseInt(qty.getText()));
         ps.setInt(6,Integer.parseInt(ppr.getText()));
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         String theDate = dateFormat.format(pdate.getDate());
         ps.setString(7,theDate);
         a = qty.getText();
         b = ppr.getText();
         c = Integer.parseInt(a)*Integer.parseInt(b);
         tamt.setText(c+""); 
         ps.setInt(8,Integer.parseInt(tamt.getText()));
         ps.executeUpdate();
         ps.close();
         invoiceid();
          }
         qty.setText("");
         city.setText("");
         ppr.setText("");
         
     }catch(Exception ee){
     }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pprActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pprActionPerformed

    private void cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
      this.setVisible(false);
      new AccSystem().setVisible(true);
    }//GEN-LAST:event_formWindowClosing
    
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
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField city;
    private javax.swing.JComboBox<String> customer;
    private javax.swing.JButton home;
    private javax.swing.JTextField invno;
    private javax.swing.JComboBox<String> item;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser pdate;
    private javax.swing.JTextField ppr;
    private javax.swing.JTextField qty;
    private javax.swing.JTextField tamt;
    // End of variables declaration//GEN-END:variables
}