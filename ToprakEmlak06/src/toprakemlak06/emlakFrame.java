/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package toprakemlak06;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ozkay
 */
public class emlakFrame extends javax.swing.JFrame {

   
    DefaultTableModel model;
    public emlakFrame() {
        initComponents();
        populateTable();


    }

    public void populateTable(){
    model = (DefaultTableModel)tblCities.getModel();
    model.setRowCount(0);
        try {
            ArrayList<City> cities = getCities();
            for(City city : cities){
                Object[] row = {city.getId(),
                    city.getFirstname(),
                    city.getLastname(),
                    city.getNumberphone(),
                    city.getIdentity(),
                    city.getAddress(),
                    city.getAda(),
                    city.getParsel(),
                    city.getNotlar()};
                model.addRow(row);
              
            }
        } catch (SQLException ex) {
        }
    }
    public ArrayList<City> getCities() throws SQLException{
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement=null;
        ResultSet resultSet;
        ArrayList<City> cities=null;
        
          try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM emlak;");
            cities = new ArrayList<City>();
            while(resultSet.next()){
                cities.add(new City(
                        resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("numberphone"),
                        resultSet.getString("identity"),
                        resultSet.getString("address"),
                        resultSet.getString("ada"),
                        resultSet.getString("parsel"),
                        resultSet.getString("notlar")));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        }finally{
            statement.close();
            connection.close();
        }
        
        return cities;
    
    }


   
    @SuppressWarnings("unchecked")
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
            java.util.logging.Logger.getLogger(emlakFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(emlakFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(emlakFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(emlakFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new emlakFrame().setVisible(true);
            }
        });
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCities = new javax.swing.JTable();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblAda = new javax.swing.JLabel();
        lblParsel = new javax.swing.JLabel();
        lblIdentity = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtIdentity = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtAda = new javax.swing.JTextField();
        txtParsel = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnUserAdd = new javax.swing.JButton();
        lblNotlar = new javax.swing.JLabel();
        txtNotlar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCities.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Ad", "Soyad", "Telefon", "Kimlik", "Adres", "Ada", "Parsel", "Notlar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCities);

        lblSearch.setText("Arama İfadesi :");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblName.setText("Ad :");

        lblLastName.setText("Soyad :");

        lblPhone.setText("Telefon :");

        lblAddress.setText("Adres :");

        lblAda.setText("Ada :");

        lblParsel.setText("Parsel :");

        lblIdentity.setText("T.C. Kimlik :");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });

        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        txtIdentity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentityActionPerformed(evt);
            }
        });

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        txtAda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdaActionPerformed(evt);
            }
        });

        txtParsel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtParselActionPerformed(evt);
            }
        });

        btnAdd.setText("EKLE");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("SİL");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("GÜNCELLE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnUserAdd.setText("KULLANICI EKLE");
        btnUserAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserAddActionPerformed(evt);
            }
        });

        lblNotlar.setText("Notlar : ");

        txtNotlar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNotlarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdentity, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                            .addComponent(lblAda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAda, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(txtIdentity)
                            .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNotlar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblParsel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtParsel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNotlar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUserAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName)
                    .addComponent(lblLastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress)
                    .addComponent(btnUpdate)
                    .addComponent(btnUserAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAda)
                    .addComponent(txtAda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtParsel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblParsel))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNotlar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNotlar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblIdentity)
                        .addComponent(txtIdentity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtIdentityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentityActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtAdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdaActionPerformed

    private void txtParselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtParselActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtParselActionPerformed

    private void btnUserAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserAddActionPerformed
                adminFrame frame = new adminFrame();
                frame.setVisible(true);   
                dispose();            
    }//GEN-LAST:event_btnUserAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int secilenSatir = Integer.parseInt(tblCities.getValueAt(tblCities.getSelectedRow(),
            0).toString());   
        Connection connection=null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        try {
            connection = dbHelper.getConnection();
            String sql = "delete from emlak where id = ?";
            //model.removeRow(tblCities.getSelectedRow());
          //  int secilenSatir = Integer.parseInt(tblCities.getValueAt(tblCities.getSelectedRow(), 0).toString());
            System.out.println(secilenSatir);
            statement = connection.prepareStatement(sql);
            statement.setInt(1,secilenSatir);

            int result = statement.executeUpdate();
            populateTable();

        }catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Connection connection=null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        try {
            connection = dbHelper.getConnection();
            String sql = "insert into emlak(firstname,lastname,numberphone,identity,address,ada,parsel,notlar) values(?,?,?,?,?,?,?,?);";
            statement = connection.prepareStatement(sql);
            statement.setString(1,txtName.getText());
            statement.setString(2,txtLastName.getText());
            statement.setString(3,txtPhone.getText());
            statement.setString(4,txtIdentity.getText());
            statement.setString(5,txtAddress.getText());
            statement.setString(6,txtAda.getText());
            statement.setString(7,txtParsel.getText()); //Integer olsaydı (7,Integer.valueOf(txtParsel.getText())); yazacaktık.
            statement.setString(8, txtNotlar.getText());
            int result = statement.executeUpdate();
            populateTable();
            txtName.setText(null);
            txtLastName.setText(null);
            txtPhone.setText(null);
            txtIdentity.setText(null);
            txtAddress.setText(null);
            txtAda.setText(null);
            txtParsel.setText(null);
            txtNotlar.setText(null);
                    
            
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        }finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
            }
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String searchKey = txtSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(model);
        tblCities.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int secilenSatir = Integer.parseInt(tblCities.getValueAt(tblCities.getSelectedRow(),
            0).toString());   
        Connection connection=null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        try {
            connection = dbHelper.getConnection();
            String sql = "update emlak set firstname = ?, lastname = ?, numberphone = ?, identity = ?, address = ?, ada = ?, parsel = ?, notlar = ? where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,txtName.getText());
            statement.setString(2,txtLastName.getText());
            statement.setString(3,txtPhone.getText());
            statement.setString(4,txtIdentity.getText());
            statement.setString(5,txtAddress.getText());
            statement.setString(6,txtAda.getText());
            statement.setString(7,txtParsel.getText());
            statement.setString(8,txtNotlar.getText());
            statement.setInt(9,secilenSatir);
            int result = statement.executeUpdate();
            statement = connection.prepareStatement(sql);
            populateTable();
            txtName.setText(null);
            txtLastName.setText(null);
            txtPhone.setText(null);
            txtIdentity.setText(null);
            txtAddress.setText(null);
            txtAda.setText(null);
            txtParsel.setText(null);
            txtNotlar.setText(null);
            
        }catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
            }
        }    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtNotlarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNotlarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNotlarActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUserAdd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAda;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblIdentity;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNotlar;
    private javax.swing.JLabel lblParsel;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTable tblCities;
    private javax.swing.JTextField txtAda;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtIdentity;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNotlar;
    private javax.swing.JTextField txtParsel;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}

