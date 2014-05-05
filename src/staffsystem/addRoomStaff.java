/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffsystem;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lewis
 */
public class addRoomStaff extends javax.swing.JFrame {

    Staff staff;
    StaffList staffList;
    Room room;
    RoomList roomList;
    DBConnection connect;
    private int staffIndex;
    private Object thisStaff;
    private String selectedStaff;
    private String[] staffInfo;
    private int roomIndex;
    private Object thisRoom;
    private String selectedRoom;
    private String[] roomInfo;
    int activeTab = 5;
    /**
     * Creates new form addRoomChildStaff
     */
    public addRoomStaff() throws SQLException, ClassNotFoundException {
        initComponents();
        getContentPane().setBackground(Color.white);
        this.setLocationRelativeTo(null);
        
        connect = new DBConnection();
        this.connect.dbConnect();
        
        setStaffList();
        setRoomList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelAddRoom = new javax.swing.JLabel();
        jLabelCancel = new javax.swing.JLabel();
        jLabelHeading = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListRoom = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListStaff = new javax.swing.JList();
        jLabelSearch = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jLabelStaff = new javax.swing.JLabel();
        jLabelRoom = new javax.swing.JLabel();
        jTextFieldStaff = new javax.swing.JTextField();
        jTextFieldRoom = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelAddRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addRoom_button.png"))); // NOI18N
        jLabelAddRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelAddRoomMousePressed(evt);
            }
        });

        jLabelCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel_button.png"))); // NOI18N
        jLabelCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelCancelMousePressed(evt);
            }
        });

        jLabelHeading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/newRoomHeading.png"))); // NOI18N

        jListRoom.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListRoomMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jListRoom);

        jListStaff.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListStaffMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jListStaff);

        jLabelSearch.setText("Search");

        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });

        jLabelStaff.setText("Staff");

        jLabelRoom.setText("Room");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelSearch)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jScrollPane1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelStaff)
                                    .addComponent(jLabelRoom))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldStaff, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                    .addComponent(jTextFieldRoom)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabelHeading)
                        .addGap(0, 341, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelCancel)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelAddRoom)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHeading)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSearch)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelStaff)
                            .addComponent(jTextFieldStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRoom)
                            .addComponent(jTextFieldRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelCancel)
                    .addComponent(jLabelAddRoom))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelCancelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCancelMousePressed
        homePage home = null;
        this.dispose();
        try {
            home = new homePage(activeTab);
        } catch (SQLException ex) {
            Logger.getLogger(addBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        home.setVisible(true);
    }//GEN-LAST:event_jLabelCancelMousePressed

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        try {
            searchStaffList();
        } catch (SQLException ex) {
            Logger.getLogger(addRoomStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void jListStaffMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListStaffMousePressed
        updateSelectedStaff();
    }//GEN-LAST:event_jListStaffMousePressed

    private void jListRoomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListRoomMousePressed
        updateSelectedRoom();
    }//GEN-LAST:event_jListRoomMousePressed

    private void jLabelAddRoomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddRoomMousePressed
        connect.addStaffRoom(staffInfo[0], roomInfo[0]);
        
        homePage home = null;
        this.dispose();
        try {
            home = new homePage(activeTab);
        } catch (SQLException ex) {
            Logger.getLogger(addBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        home.setVisible(true);
    }//GEN-LAST:event_jLabelAddRoomMousePressed

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
            java.util.logging.Logger.getLogger(addRoomStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addRoomStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addRoomStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addRoomStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new addRoomStaff().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(addRoomStaff.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(addRoomStaff.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void setStaffList() throws SQLException{
        this.staffList = this.connect.viewAllStaff();
        jListStaff.setListData(this.staffList.getAllStaff());
        jListStaff.setSelectedIndex(0);
        
        updateSelectedStaff();
    }
    
    public void searchStaffList() throws SQLException{
        this.staffList = this.connect.searchAllStaff(jTextFieldSearch.getText());
        jListStaff.setListData(this.staffList.getAllStaff());
        jListStaff.setSelectedIndex(0);
        
        updateSelectedStaff();
    }
    
    public void updateSelectedStaff(){
        try{
            staffIndex = jListStaff.getSelectedIndex();
            thisStaff = jListStaff.getModel().getElementAt(staffIndex);
            selectedStaff = thisStaff.toString();
            staffInfo = selectedStaff.split(": ");
            staff = this.staffList.getStaffAt(staffInfo[0]);

            jTextFieldStaff.setText(staff.getFirstName() + " " + staff.getSurname());
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("e");
        }
    }
    
    public void setRoomList() throws SQLException{
        this.roomList = this.connect.viewAllRooms();
        jListRoom.setListData(this.roomList.getAllRooms());
        jListRoom.setSelectedIndex(0);
        
        updateSelectedRoom();
    }
    
    public void updateSelectedRoom(){
        try{
            roomIndex = jListRoom.getSelectedIndex();
            thisRoom = jListRoom.getModel().getElementAt(roomIndex);
            selectedRoom = thisRoom.toString();
            roomInfo = selectedRoom.split(", ");
            room = this.roomList.getRoomAt(roomInfo[0]);

            jTextFieldRoom.setText(room.getRoomName());
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("e");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAddRoom;
    private javax.swing.JLabel jLabelCancel;
    private javax.swing.JLabel jLabelHeading;
    private javax.swing.JLabel jLabelRoom;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelStaff;
    private javax.swing.JList jListRoom;
    private javax.swing.JList jListStaff;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldRoom;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTextField jTextFieldStaff;
    // End of variables declaration//GEN-END:variables
}
