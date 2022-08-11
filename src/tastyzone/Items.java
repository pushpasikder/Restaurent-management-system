/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tastyzone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Items extends javax.swing.JFrame {

    /**
     * Creates new form Items
     */
    public Items() {
        initComponents();
        connect();
        Loadlist();
       
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
      num.setText(""); 
      name.setText("");
      price.setText("");
      

   }
    private void Loadlist() {
       try{
            pst=conn.prepareStatement("select * from producttbl");
            rst=pst.executeQuery();
            
            table_model=(DefaultTableModel)productlist.getModel();
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
 public void CreateTable() {
     table_model=(DefaultTableModel)productlist.getModel();
     table_model.getDataVector().removeAllElements();
     table_model.fireTableDataChanged();
     table_model.setRowCount(0);
 }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        num = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        productlist = new javax.swing.JTable();
        dltbtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        addbtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        updatebtn = new javax.swing.JButton();
        combobox = new javax.swing.JComboBox<>();
        Searchdata = new javax.swing.JTextField();
        Searchbtn2 = new javax.swing.JButton();
        Items = new javax.swing.JButton();
        selling = new javax.swing.JButton();
        ViewSells = new javax.swing.JButton();
        Logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel4.setBackground(new java.awt.Color(0, 153, 153));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Items Management");

        name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        price.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        num.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        productlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PNum", "PName", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productlistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productlist);

        dltbtn.setBackground(new java.awt.Color(255, 255, 255));
        dltbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dltbtn.setForeground(new java.awt.Color(0, 153, 153));
        dltbtn.setText("Delete");
        dltbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltbtnActionPerformed(evt);
            }
        });

        clearbtn.setBackground(new java.awt.Color(255, 255, 255));
        clearbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clearbtn.setForeground(new java.awt.Color(0, 153, 153));
        clearbtn.setText("Clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });

        addbtn.setBackground(new java.awt.Color(255, 255, 255));
        addbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addbtn.setForeground(new java.awt.Color(0, 153, 153));
        addbtn.setText("ADD");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Name");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Price");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Num");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        updatebtn.setBackground(new java.awt.Color(255, 255, 255));
        updatebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updatebtn.setForeground(new java.awt.Color(0, 153, 153));
        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });

        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PNum", "PName", "Price" }));
        combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxActionPerformed(evt);
            }
        });

        Searchdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchdataActionPerformed(evt);
            }
        });

        Searchbtn2.setText("Search");
        Searchbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Searchbtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(293, 293, 293))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dltbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Searchdata, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Searchbtn2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dltbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Searchdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Searchbtn2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );

        Items.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Items.setText("Items");
        Items.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemsActionPerformed(evt);
            }
        });

        selling.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        selling.setText("Selling");
        selling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellingActionPerformed(evt);
            }
        });

        ViewSells.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ViewSells.setText("View sells");
        ViewSells.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewSellsActionPerformed(evt);
            }
        });

        Logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Logout.setText("LogOut");
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
        });
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Items, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selling)
                    .addComponent(ViewSells)
                    .addComponent(Logout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(Items)
                .addGap(17, 17, 17)
                .addComponent(selling)
                .addGap(28, 28, 28)
                .addComponent(ViewSells)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Logout)
                .addGap(27, 27, 27))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
         try {
            String PNum= num.getText();
            String PName= name.getText();
            String Price = price.getText();
            System.out.println(PNum+" "+PName+" "+Price);
            pst=conn.prepareStatement("insert into producttbl values(?,?,?)");
            pst.setString(1, PNum);
            pst.setString(2, PName);
            pst.setString(3, Price );
       

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClearFrom();
        Loadlist();
        JOptionPane.showMessageDialog(this,"data added successfully");
    }//GEN-LAST:event_addbtnActionPerformed

    private void ItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemsActionPerformed
        Items p=new Items();
            p.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_ItemsActionPerformed

    private void sellingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellingActionPerformed
       selling p=new selling();
            p.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_sellingActionPerformed

    private void ViewSellsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewSellsActionPerformed
        ViewSells p=new ViewSells();
            p.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_ViewSellsActionPerformed

    private void dltbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltbtnActionPerformed
         try {
            String PNum= num.getText();
            String PName= name.getText();
            String Price = price.getText();
            pst=conn.prepareStatement("delete from producttbl where Price = ?");
            pst.setString(1, Price);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        }
        addbtn.setEnabled(true);
        ClearFrom();
        Loadlist();
        JOptionPane.showMessageDialog(this,"data deleted successfully");
    }//GEN-LAST:event_dltbtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
         addbtn.setEnabled(true);
        try {
             String PNum= num.getText();
            String PName= name.getText();
            String Price = price.getText();
            System.out.println(PNum+" "+PName+" "+Price);
            pst=conn.prepareStatement("update producttbl set PNum=?,PName=?,"+"Price=? where PNum =?");
           pst.setString(1, PNum);
            pst.setString(2, PName);
            pst.setString(3, Price );
             pst.setString(4, PNum);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClearFrom();
        Loadlist();
        //addbtn.setEnabled(true);
        JOptionPane.showMessageDialog(this,"data Update successfully");

    }//GEN-LAST:event_updatebtnActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        ClearFrom();
        addbtn.setEnabled(true);
        updatebtn.setEnabled(false);
        dltbtn.setEnabled(false);
    }//GEN-LAST:event_clearbtnActionPerformed

    private void productlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productlistMouseClicked
          table_model=(DefaultTableModel)productlist.getModel();
        int selectedIndex=productlist.getSelectedRow();
        num.setText(productlist.getValueAt(selectedIndex,0).toString());
        name.setText(productlist.getValueAt(selectedIndex,1).toString());
        price.setText(productlist.getValueAt(selectedIndex,2).toString());
        addbtn.setEnabled(false);
        updatebtn.setEnabled(true);
        dltbtn.setEnabled(true);
    }//GEN-LAST:event_productlistMouseClicked

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
         
    }//GEN-LAST:event_LogoutActionPerformed

    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
         Logout.setText("LOGOUT");
        Login m=new Login();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutMouseClicked

    private void comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxActionPerformed

    private void SearchdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchdataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchdataActionPerformed

    private void Searchbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Searchbtn2ActionPerformed
        updatebtn.setEnabled(false);
        dltbtn.setEnabled(false);
        //Searchdata.setText(" Search by id... ");
        //Searchdata.setForeground(Color.lightGray);
        String searchData =Searchdata.getText();
        System.out.println(searchData);
        String searchType=(String) combobox.getSelectedItem();
        try {

            pst=conn.prepareStatement("select * from producttbl where "+searchType+"=?");
            pst.setString(1,searchData );
            rst=pst.executeQuery();

            
            table_model=(DefaultTableModel)productlist.getModel();
            table_model.setRowCount(0);
             clearTable();
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
        //Searchdata.setText(" Search by id... ");
        //Searchdata.setForeground(Color.lightGray);
       // addbtn.setEnabled(true);
        //ClearFrom();
        //Loadlist();
        JOptionPane.showMessageDialog(this,"data search successfully");
        //Searchdata.setText(" Search by id... ");
       // Searchdata.setForeground(Color.lightGray);
    }//GEN-LAST:event_Searchbtn2ActionPerformed

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
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(new Runnable() {
          //  public void run() {
                new Items().setVisible(true);
            }
       // });
 //   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Items;
    private javax.swing.JButton Logout;
    private javax.swing.JButton Searchbtn2;
    private javax.swing.JTextField Searchdata;
    private javax.swing.JButton ViewSells;
    private javax.swing.JButton addbtn;
    private javax.swing.JButton clearbtn;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JButton dltbtn;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField num;
    private javax.swing.JTextField price;
    private javax.swing.JTable productlist;
    private javax.swing.JButton selling;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables

    private void clearTable() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
