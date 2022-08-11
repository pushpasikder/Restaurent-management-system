
package tastyzone;

import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public final class selling extends javax.swing.JFrame {

    
    public selling() {
        initComponents();
          connect();
          Loadlist();
          Loadlist2();
          //Loadlist3();
          BillTable();
          
    }
Connection conn;
 PreparedStatement pst;
 ResultSet rst;
 DefaultTableModel table_model;
 
 
  private void connect() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn= DriverManager.getConnection("jdbc:mysql://localhost:3307/restaurant", "root","");
        System.out.println("connected");
    }   catch (ClassNotFoundException | SQLException ex) {
         Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public void ClearFrom(){
      Table.setText(""); 
      name1.setText("");
      price1.setText("");
      quantity1.setText("");
     // billtbl.setModel(table_model );
      

   }
 
   private void Loadlist() {
       try{
            pst=conn.prepareStatement("select * from producttbl");
            rst=pst.executeQuery();
            
            table_model=(DefaultTableModel)itemlist.getModel();
            table_model.setRowCount(0);
             
            while(rst.next()){
                Vector v = new Vector();
                
                v.add(rst.getString("PNum"));
                v.add(rst.getString("PName"));
                v.add(rst.getString("Price"));
                System.out.println(v);
                table_model.addRow(v);
            }
            
       } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    private void Loadlist2() {
       try{
            pst=conn.prepareStatement("select * from billtbl");
            rst=pst.executeQuery();
            
            table_model=(DefaultTableModel)Billtbl.getModel();
            table_model.setRowCount(0);
             
            while(rst.next()){
                Vector v = new Vector();
                
                v.add(rst.getString("TableNo"));
                v.add(rst.getString("Name"));
                v.add(rst.getString("Price"));
                v.add(rst.getString("Quantity"));
                v.add(rst.getString("Total"));
               
                
                System.out.println(v);
                table_model.addRow(v);
            }
            
       } catch (SQLException ex) {
            Logger.getLogger(selling.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
     public void BillTable()
    {
        try{
            pst=conn.prepareStatement("delete from billtbl");
            
                pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(selling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int doesFoodExists(String TableNo){
        int x=0;
        System.out.println(TableNo);
        try{
           pst=conn.prepareStatement("select exists(select * from billtbl where TableNo=?");
           pst.setString(1, TableNo);
              pst.setString(1, TableNo);
            rst=pst.executeQuery();
            while(rst.next()){
                System.out.println(Integer.parseInt(rst.getString(1)));
                x=Integer.parseInt(rst.getString(1));
            
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(selling.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return x;
        
        
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        price1 = new javax.swing.JTextField();
        quantity1 = new javax.swing.JTextField();
        Table = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Billtbl = new javax.swing.JTable();
        Print = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        name1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemlist = new javax.swing.JTable();
        Addbtn = new javax.swing.JButton();
        totalLbl = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Items = new javax.swing.JLabel();
        selling = new javax.swing.JLabel();
        Logout = new javax.swing.JLabel();
        ViewSells = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel4.setBackground(new java.awt.Color(0, 153, 153));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sell products");

        price1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        quantity1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        Table.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        Billtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Table No", "Name", "Price", "Quantity", "Total"
            }
        ));
        jScrollPane1.setViewportView(Billtbl);
        if (Billtbl.getColumnModel().getColumnCount() > 0) {
            Billtbl.getColumnModel().getColumn(2).setResizable(false);
            Billtbl.getColumnModel().getColumn(3).setResizable(false);
        }

        Print.setBackground(new java.awt.Color(255, 255, 255));
        Print.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Print.setForeground(new java.awt.Color(0, 153, 153));
        Print.setText("print");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Price");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantity");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Name");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Table No");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        name1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        itemlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num", "Name", "Price"
            }
        ));
        itemlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemlistMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(itemlist);

        Addbtn.setBackground(new java.awt.Color(255, 255, 255));
        Addbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Addbtn.setForeground(new java.awt.Color(0, 153, 153));
        Addbtn.setText("Add To Bill");
        Addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbtnActionPerformed(evt);
            }
        });

        totalLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalLbl.setForeground(new java.awt.Color(255, 255, 255));
        totalLbl.setToolTipText("");
        totalLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jLabel11.setBackground(new java.awt.Color(0, 153, 153));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("your bill");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Table, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(name1)
                            .addComponent(price1)
                            .addComponent(quantity1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(Addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(33, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(151, 151, 151))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(totalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Print, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Table, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantity1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(Print, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Items.setBackground(new java.awt.Color(0, 153, 153));
        Items.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Items.setText("Items");
        Items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ItemsMouseClicked(evt);
            }
        });

        selling.setBackground(new java.awt.Color(0, 153, 153));
        selling.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        selling.setText("Selling");
        selling.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sellingMouseClicked(evt);
            }
        });

        Logout.setBackground(new java.awt.Color(0, 153, 153));
        Logout.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Logout.setText("logout");
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
        });

        ViewSells.setBackground(new java.awt.Color(0, 153, 153));
        ViewSells.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ViewSells.setText("View Sells");
        ViewSells.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewSellsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Items, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selling, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ViewSells, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(Items, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selling, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ViewSells, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemsMouseClicked
         Items p=new Items();
            p.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_ItemsMouseClicked

    private void sellingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sellingMouseClicked
       selling p=new selling();
            p.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_sellingMouseClicked

    private void ViewSellsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewSellsMouseClicked
        ViewSells p=new ViewSells();
            p.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_ViewSellsMouseClicked

    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
          Logout.setText("LOGOUT");
        Login m=new Login();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutMouseClicked
int GrdTot = 0;
    private void AddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbtnActionPerformed
          //int Totall = Integer.valueOf(price1.getText())*Integer.valueOf(quantity1.getText());

        try {
            String TableNo= Table.getText();
            String Name= name1.getText();
            String Price = price1.getText();
            String Quantity = quantity1.getText();
            int Total = Integer.valueOf(price1.getText())*Integer.valueOf(quantity1.getText());
            GrdTot = GrdTot + Total;
            totalLbl.setText("BDT "+GrdTot);
            System.out.println(TableNo+" "+Name+" "+Price+" "+Quantity);
            pst=conn.prepareStatement("insert into billtbl values(?,?,?,?,?)");
            pst.setString(1, TableNo);
            pst.setString(2, Name);
           pst.setString(3, Price );
           pst.setString(4, Quantity );
            pst.setInt(5, Total );
       

            pst.executeUpdate();
            
            //int Total = Integer.valueOf(price1.getText())*Integer.valueOf(quantity1.getText());

       } catch (SQLException ex) {
           Logger.getLogger(selling.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClearFrom();
        Loadlist2();
        JOptionPane.showMessageDialog(this,"data added successfully");
    
    }//GEN-LAST:event_AddbtnActionPerformed

    private void itemlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemlistMouseClicked
        table_model=(DefaultTableModel)itemlist.getModel();
        int selectedIndex=itemlist.getSelectedRow();
       // Table.setText(itemlist.getValueAt(selectedIndex,0).toString());
        name1.setText(itemlist.getValueAt(selectedIndex,1).toString());
        price1.setText(itemlist.getValueAt(selectedIndex,2).toString());
       // quantity1.setText(itemlist.getValueAt(selectedIndex,2).toString());
        //updatebtn.setEnabled(true);
        //dltbtn.setEnabled(true);
    }//GEN-LAST:event_itemlistMouseClicked

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        try{
           Billtbl.print();
           //Loadlist3();
           //insertbill();
        }catch(PrinterException e){
            
        }
    }//GEN-LAST:event_PrintActionPerformed

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
            java.util.logging.Logger.getLogger(selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       // java.awt.EventQueue.invokeLater(() -> {
        //   new selling().setVisible(true);
        //});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbtn;
    private javax.swing.JTable Billtbl;
    private javax.swing.JLabel Items;
    private javax.swing.JLabel Logout;
    private javax.swing.JButton Print;
    private javax.swing.JTextField Table;
    private javax.swing.JLabel ViewSells;
    private javax.swing.JTable itemlist;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField name1;
    private javax.swing.JTextField price1;
    private javax.swing.JTextField quantity1;
    private javax.swing.JLabel selling;
    private javax.swing.JLabel totalLbl;
    // End of variables declaration//GEN-END:variables

   

   
}
