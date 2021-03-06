/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Booking;
import Model.Customer;
import Model.Room;
import Service.BookingService;
import Service.CustomerService;
import Service.IBookingService;
import Service.ICustomerService;
import Service.IRoomService;
import Service.RoomService;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class BookingPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    private IBookingService bookingService;
    private ICustomerService customerService;
    private IRoomService roomService;
    public BookingPanel() {
        initComponents();
        bookingService = new BookingService();
        customerService = new CustomerService();
        roomService = new RoomService();
        jPanelBooking.setVisible(false);
    }

    public void reset(){
        jComboBoxRoom.setSelectedIndex(0);
        jCustomers.setSelectedIndex(0);
        jCalendarCheckin.setDate( Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        jCalendarCheckout.setDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        jTextFieldAdultNo.setText("");
        jTextFieldChildNo.setText("");  
    }
    
     public void setRooms(){
//         ArrayList<String> ls = new ArrayList<String>();
//        ls.add("Select");
//        for(int i = 0 ; i < roomService.getRooms().size();i++ ){
//            ls.add(roomService.getRooms().get(i).getRoomNumber());
//        }
        jComboBoxRoom.setModel(new DefaultComboBoxModel(roomService.getRooms().toArray()));
    }
    
    public void setCustomers(){
        
//        ArrayList<String> ls = new ArrayList<String>();
//        ls.add("Select");
//        for(int i = 0 ; i < customerService.getCustomers().size();i++ ){
//            ls.add(customerService.getCustomers().get(i).getName());
//        }
        jCustomers.setModel(new DefaultComboBoxModel(customerService.getCustomers().toArray()));
    }
    
      public void setData(){
        while (((DefaultTableModel)jTable1.getModel()).getRowCount()>0)
          {
             ((DefaultTableModel)jTable1.getModel()).removeRow(0);
          }
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        Object rowData[]  = new Object[7];
        for(int i = 0 ;i < bookingService.getBookings().size();i++){
            
            rowData[0] = bookingService.getBookings().get(i).getId();
            rowData[1] = bookingService.getBookings().get(i).getCustomer().getName();
            rowData[2] = bookingService.getBookings().get(i).getRoom().getRoomNumber();
            rowData[3] = bookingService.getBookings().get(i).getCheckIn();
            rowData[4] = bookingService.getBookings().get(i).getCheckOut();
            rowData[5] = bookingService.getBookings().get(i).getAdultCount();
            rowData[6] = bookingService.getBookings().get(i).getChildrenCount();
            model.addRow(rowData);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jPanelBooking = new javax.swing.JPanel();
        jLabelCheckin = new javax.swing.JLabel();
        jLabelCheckout = new javax.swing.JLabel();
        jCalendarCheckout = new com.toedter.calendar.JCalendar();
        jCalendarCheckin = new com.toedter.calendar.JCalendar();
        jLabelRoom = new javax.swing.JLabel();
        jComboBoxRoom = new javax.swing.JComboBox<>();
        jLabelPayment = new javax.swing.JLabel();
        jComboBoxPayment = new javax.swing.JComboBox<>();
        jLabelAdultNumber = new javax.swing.JLabel();
        jTextFieldAdultNo = new javax.swing.JTextField();
        jLabelChildNumber = new javax.swing.JLabel();
        jTextFieldChildNo = new javax.swing.JTextField();
        jButtonAddRoom = new javax.swing.JButton();
        jCustomers = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Customer", "Room", "CheckIn", "CheckOut", "Adult", "Children"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

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

        jPanelBooking.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Booking Information:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabelCheckin.setText("Check-in Date:");

        jLabelCheckout.setText("Check-out Date:");

        jLabelRoom.setText("Room:");

        jComboBoxRoom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelPayment.setText("Payment:");

        jComboBoxPayment.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "By Card", "By Cash" }));
        jComboBoxPayment.setActionCommand("");

        jLabelAdultNumber.setText("Adult No:");

        jLabelChildNumber.setText("Child No:");

        jButtonAddRoom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonAddRoom.setText("Update");
        jButtonAddRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddRoomActionPerformed(evt);
            }
        });

        jLabel2.setText("Customers:");

        javax.swing.GroupLayout jPanelBookingLayout = new javax.swing.GroupLayout(jPanelBooking);
        jPanelBooking.setLayout(jPanelBookingLayout);
        jPanelBookingLayout.setHorizontalGroup(
            jPanelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBookingLayout.createSequentialGroup()
                .addGroup(jPanelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBookingLayout.createSequentialGroup()
                        .addComponent(jLabelAdultNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAdultNo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBookingLayout.createSequentialGroup()
                        .addGroup(jPanelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelChildNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCustomers, 0, 155, Short.MAX_VALUE)
                            .addComponent(jTextFieldChildNo)))
                    .addGroup(jPanelBookingLayout.createSequentialGroup()
                        .addGroup(jPanelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelPayment, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                .addComponent(jLabelRoom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabelCheckout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBoxRoom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxPayment, 0, 155, Short.MAX_VALUE))
                            .addComponent(jCalendarCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCalendarCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBookingLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonAddRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanelBookingLayout.setVerticalGroup(
            jPanelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBookingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBookingLayout.createSequentialGroup()
                        .addComponent(jCalendarCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCalendarCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBookingLayout.createSequentialGroup()
                        .addComponent(jLabelCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabelCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdultNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAdultNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelChildNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldChildNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jCustomers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAddRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
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
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanelBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        if(jTable1.getSelectedRow() >= 0){
        int id = Integer.parseInt(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),0).toString());
        bookingService.DeleteById(id);
        ((DefaultTableModel)jTable1.getModel()).removeRow(jTable1.getSelectedRow());
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
       if(jTable1.getSelectedRow() >= 0){
        int id = Integer.parseInt(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),0).toString());
        Booking booking =  bookingService.findById(id);
        setRooms();
        setCustomers();
        jCustomers.setSelectedItem(booking.getCustomer());
        jComboBoxRoom.setSelectedItem(booking.getRoom());
        jCalendarCheckin.setDate(Date.from(booking.getCheckIn().toInstant(ZoneOffset.UTC)));
        jCalendarCheckout.setDate(Date.from(booking.getCheckOut().toInstant(ZoneOffset.UTC)));
        jTextFieldAdultNo.setText(Integer.toString(booking.getAdultCount()));
        jTextFieldChildNo.setText(Integer.toString(booking.getChildrenCount()));  
        jPanelBooking.setVisible(true);
       }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonAddRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddRoomActionPerformed
//       Customer customer, Room room, LocalDateTime checkIn, LocalDateTime checkOut, 
//            int adultCount, int childrenCount,Boolean status
        Booking booking = new Booking();
        int id = Integer.parseInt(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),0).toString());
        booking.setCustomer((Customer)jCustomers.getSelectedItem());
        booking.setRoom((Room)jComboBoxRoom.getSelectedItem());
        booking.setId(id);
        booking.setCheckIn(LocalDateTime.ofInstant(jCalendarCheckin.getDate().toInstant(),ZoneId.systemDefault()));
        booking.setCheckOut(LocalDateTime.ofInstant(jCalendarCheckout.getDate().toInstant(),ZoneId.systemDefault()));
        booking.setChildrenCount(Integer.parseInt(jTextFieldChildNo.getText()));
        booking.setAdultCount(Integer.parseInt(jTextFieldAdultNo.getText()));
        booking.setStatus(true);
        bookingService.Update(booking);
        jPanelBooking.setVisible(false);
        setData();
    }//GEN-LAST:event_jButtonAddRoomActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddRoom;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonUpdate;
    private com.toedter.calendar.JCalendar jCalendarCheckin;
    private com.toedter.calendar.JCalendar jCalendarCheckout;
    private javax.swing.JComboBox<String> jComboBoxPayment;
    private javax.swing.JComboBox<Room> jComboBoxRoom;
    private javax.swing.JComboBox<Customer> jCustomers;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAdultNumber;
    private javax.swing.JLabel jLabelCheckin;
    private javax.swing.JLabel jLabelCheckout;
    private javax.swing.JLabel jLabelChildNumber;
    private javax.swing.JLabel jLabelPayment;
    private javax.swing.JLabel jLabelRoom;
    private javax.swing.JPanel jPanelBooking;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldAdultNo;
    private javax.swing.JTextField jTextFieldChildNo;
    // End of variables declaration//GEN-END:variables
}
