/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Service.CustomerService;
import Service.ICustomerService;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class CustomerPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    private ICustomerService customerService;
    public CustomerPanel() {
        initComponents();
        customerService = new CustomerService();
         jPanelCustomer.setVisible(false);
    }
    
     public void setData(){
        while (((DefaultTableModel)jTable1.getModel()).getRowCount()>0)
          {
             ((DefaultTableModel)jTable1.getModel()).removeRow(0);
          }
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        Object rowData[]  = new Object[8];
        for(int i = 0 ;i < customerService.getCustomers().size();i++){
            rowData[0] = customerService.getCustomers().get(i).getId();
            rowData[1] = customerService.getCustomers().get(i).getName(); 
            rowData[2] = customerService.getCustomers().get(i).getSurname();
            rowData[3] = customerService.getCustomers().get(i).getEmail();
            rowData[4] = customerService.getCustomers().get(i).getAddress();
            rowData[5] = customerService.getCustomers().get(i).getPhoneNumber();
            rowData[6] = customerService.getCustomers().get(i).getDate_of_birth();
            rowData[7] = customerService.getCustomers().get(i).getNationality();
            model.addRow(rowData);
        }        
    }
     
     
    public void reset(){
        jTextFieldSecondName.setText("");
        jTextFieldFirstName3.setText("");
        //jRadioButtonFemale.setSelected(!worker.getGender());
        //jRadioButtonMale.setSelected(worker.getGender());
        jCalendar1.setDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        jTextFieldEmail.setText("");
        jTextFieldAddress1.setText("");
        jTextFieldNumber.setText("");
        jNationality.setName("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanelCustomer = new javax.swing.JPanel();
        jLabelFirstName = new javax.swing.JLabel();
        jLabelSecondName = new javax.swing.JLabel();
        jLabelDatOfBirth = new javax.swing.JLabel();
        jLabelNationality = new javax.swing.JLabel();
        jLabelGender = new javax.swing.JLabel();
        jLabelNumber = new javax.swing.JLabel();
        jLabelAddress = new javax.swing.JLabel();
        jTextFieldSecondName = new javax.swing.JTextField();
        jTextFieldNumber = new javax.swing.JTextField();
        jTextFieldFirstName3 = new javax.swing.JTextField();
        jTextFieldAddress1 = new javax.swing.JTextField();
        jNationality = new com.toedter.components.JLocaleChooser();
        jRadioButtonFemale = new javax.swing.JRadioButton();
        jRadioButtonMale = new javax.swing.JRadioButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jButtonAddCustomer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();

        jButtonUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Surname", "Email", "Address", "PhoneNumber", "BirhtDate", "Nationality"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanelCustomer.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Customer Information:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanelCustomer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelFirstName.setText("First Name:");

        jLabelSecondName.setText("Last Name:");

        jLabelDatOfBirth.setText("Date Of Birth:");

        jLabelNationality.setText("Nationality:");

        jLabelGender.setText("Gender:");

        jLabelNumber.setText("Number:");

        jLabelAddress.setText("Address:");

        jTextFieldAddress1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAddress1ActionPerformed(evt);
            }
        });

        jNationality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNationalityActionPerformed(evt);
            }
        });

        jRadioButtonFemale.setText("Female");

        jRadioButtonMale.setText("Male");

        jButtonAddCustomer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonAddCustomer.setText("Update");
        jButtonAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCustomerActionPerformed(evt);
            }
        });

        jLabel1.setText("Email:");

        javax.swing.GroupLayout jPanelCustomerLayout = new javax.swing.GroupLayout(jPanelCustomer);
        jPanelCustomer.setLayout(jPanelCustomerLayout);
        jPanelCustomerLayout.setHorizontalGroup(
            jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCustomerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(jPanelCustomerLayout.createSequentialGroup()
                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCustomerLayout.createSequentialGroup()
                        .addComponent(jLabelNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCustomerLayout.createSequentialGroup()
                        .addComponent(jLabelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCustomerLayout.createSequentialGroup()
                        .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCustomerLayout.createSequentialGroup()
                                .addComponent(jLabelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanelCustomerLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(129, 129, 129)))
                        .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(jTextFieldEmail))))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPanelCustomerLayout.createSequentialGroup()
                    .addComponent(jLabelSecondName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jTextFieldSecondName, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelCustomerLayout.createSequentialGroup()
                    .addComponent(jLabelFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jTextFieldFirstName3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelCustomerLayout.createSequentialGroup()
                    .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelDatOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelGender, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelCustomerLayout.createSequentialGroup()
                            .addComponent(jRadioButtonMale, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                            .addComponent(jRadioButtonFemale))
                        .addGroup(jPanelCustomerLayout.createSequentialGroup()
                            .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addContainerGap()))))
        );
        jPanelCustomerLayout.setVerticalGroup(
            jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFirstName3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSecondName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSecondName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDatOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGender, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonMale)
                    .addComponent(jRadioButtonFemale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jPanelCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
       if(jTable1.getSelectedRow() >= 0){
        int id = Integer.parseInt(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),0).toString());
        customerService.DeleteById(id);
        ((DefaultTableModel)jTable1.getModel()).removeRow(jTable1.getSelectedRow());
       }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTextFieldAddress1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAddress1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAddress1ActionPerformed

    private void jNationalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNationalityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNationalityActionPerformed

    private void jButtonAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCustomerActionPerformed
       
        Customer customer = new Customer(jTextFieldSecondName.getText(),jTextFieldFirstName3.getText(), jRadioButtonMale.isSelected(),
            LocalDateTime.ofInstant(jCalendar1.getDate().toInstant(),ZoneId.systemDefault()) , jTextFieldEmail.getText(),
            jTextFieldAddress1.getText(),jTextFieldNumber.getText(),jNationality.getName());
        int id = Integer.parseInt(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),0).toString());
        customer.setId(id);
        customerService.Update(customer);
        jPanelCustomer.setVisible(false);
        setData();
    }//GEN-LAST:event_jButtonAddCustomerActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
         if(jTable1.getSelectedRow() >= 0){
        int id = Integer.parseInt(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),0).toString());
        Customer customer =  customerService.findById(id);
        jTextFieldSecondName.setText(customer.getSurname());
        jTextFieldFirstName3.setText(customer.getName());
        //jRadioButtonFemale.setSelected(!worker.getGender());
        //jRadioButtonMale.setSelected(worker.getGender());
        jCalendar1.setDate(Date.from(customer.getDate_of_birth().toInstant(ZoneOffset.UTC)));
        jTextFieldEmail.setText(customer.getEmail());
        jTextFieldAddress1.setText(customer.getAddress());
        jTextFieldNumber.setText(customer.getPhoneNumber());
        jNationality.setName(customer.getNationality());
        jPanelCustomer.setVisible(true);
       }
    }//GEN-LAST:event_jButtonUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddCustomer;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonUpdate;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelDatOfBirth;
    private javax.swing.JLabel jLabelFirstName;
    private javax.swing.JLabel jLabelGender;
    private javax.swing.JLabel jLabelNationality;
    private javax.swing.JLabel jLabelNumber;
    private javax.swing.JLabel jLabelSecondName;
    private com.toedter.components.JLocaleChooser jNationality;
    private javax.swing.JPanel jPanelCustomer;
    private javax.swing.JRadioButton jRadioButtonFemale;
    private javax.swing.JRadioButton jRadioButtonMale;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldAddress1;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFirstName3;
    private javax.swing.JTextField jTextFieldNumber;
    private javax.swing.JTextField jTextFieldSecondName;
    // End of variables declaration//GEN-END:variables
}