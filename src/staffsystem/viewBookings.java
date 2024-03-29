/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffsystem;

import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Lewis
 */
public class viewBookings extends javax.swing.JFrame {

    Booking booking;
    BookingList bookingList;
    Child child;
    ChildList childList;
    DBConnection connect;
    
    ArrayList<BookingList> listOfBookings;
    
    int childID;
    private int bookingIndex;
    private Object thisBooking;
    private String selectedBooking;
    private String[] bookingInfo;
    private String stringID;
    int activeTab = 2;
    /**
     * Creates new form viewBookings
     */
    
    public viewBookings(String id) throws SQLException, ClassNotFoundException {
        initComponents();
        getContentPane().setBackground(Color.white);
        this.setLocationRelativeTo(null);
        
        connect = new DBConnection();
        this.connect.dbConnect();
        
        setBookingList(id);
        searchBookingList(id);
        this.childList = this.connect.viewAllChildren();
        child = childList.getChildAt(id);
    }
    
    public void setBookingList(String id) throws SQLException{
        childID = Integer.parseInt(id);
        this.childList = this.connect.viewAllChildren();
        child = childList.getChildAt(id);
        
        bookingList = connect.getChildBookings(id);
        try{
        jListBookings.setListData(this.bookingList.getAllBookings());
        jListBookings.setSelectedIndex(0);
        
        updateBookingList();
        } catch(ArrayIndexOutOfBoundsException e){
             
        }
    }
    
    public void searchBookingList(String id) throws SQLException{
        childID = Integer.parseInt(id);
        
        bookingList = connect.searchChildBookings(childID, jTextFieldSearch.getText());
        try{
        jListBookings.setListData(this.bookingList.getAllBookings());
        jListBookings.setSelectedIndex(0);
        
        updateBookingList();
        } catch(ArrayIndexOutOfBoundsException e){
             
        }
    }
    
    public void updateBookingList() throws SQLException{
            bookingIndex = jListBookings.getSelectedIndex();
            thisBooking = jListBookings.getModel().getElementAt(bookingIndex);
            selectedBooking = thisBooking.toString();
            bookingInfo = selectedBooking.split(":|\\ ");
            booking = this.bookingList.getBookingAt(bookingInfo[0]);

            this.bookingList = this.connect.getChildBookings(bookingInfo[4]);

            //set text boxes equal to booking selected
            jTextFieldChild.setText(child.getFirstName() + " " + child.getSurname());
            jTextFieldDate.setText(booking.getDate());
            jTextFieldSession.setText(booking.getSession());
            jTextAreaNotes.setText(booking.getNotes());
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
        jListBookings = new javax.swing.JList();
        jTextFieldSearch = new javax.swing.JTextField();
        jLabelAddBooking = new javax.swing.JLabel();
        jLabelEditBooking = new javax.swing.JLabel();
        jLabelDeleteBooking = new javax.swing.JLabel();
        jLabelChild = new javax.swing.JLabel();
        jLabelSession = new javax.swing.JLabel();
        jTextFieldSession = new javax.swing.JTextField();
        jLabelNotes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaNotes = new javax.swing.JTextArea();
        jTextFieldChild = new javax.swing.JTextField();
        jLabelHeading = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jTextFieldDate = new javax.swing.JTextField();
        jLabelCancel = new javax.swing.JLabel();
        jLabelSearch = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jListBookings.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListBookings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListBookingsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jListBookings);

        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });

        jLabelAddBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addNew_button.png"))); // NOI18N
        jLabelAddBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelAddBookingMousePressed(evt);
            }
        });

        jLabelEditBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_button.png"))); // NOI18N
        jLabelEditBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelEditBookingMousePressed(evt);
            }
        });

        jLabelDeleteBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_button.png"))); // NOI18N
        jLabelDeleteBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelDeleteBookingMousePressed(evt);
            }
        });

        jLabelChild.setText("Child");

        jLabelSession.setText("Session");

        jLabelNotes.setText("Notes");

        jTextAreaNotes.setColumns(20);
        jTextAreaNotes.setRows(5);
        jScrollPane2.setViewportView(jTextAreaNotes);

        jLabelHeading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/viewBookingsHeading.png"))); // NOI18N

        jLabelDate.setText("Date");

        jLabelCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel_button.png"))); // NOI18N
        jLabelCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelCancelMousePressed(evt);
            }
        });

        jLabelSearch.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelSearch)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCancel)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDeleteBooking)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelEditBooking)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelAddBooking))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelChild)
                            .addComponent(jLabelSession)
                            .addComponent(jLabelNotes)
                            .addComponent(jLabelDate))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldChild, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldDate, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldSession, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabelHeading)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelHeading)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelChild)
                            .addComponent(jTextFieldChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDate)
                            .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSession)
                            .addComponent(jTextFieldSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNotes)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelAddBooking)
                                .addComponent(jLabelEditBooking)
                                .addComponent(jLabelDeleteBooking))
                            .addComponent(jLabelCancel, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabelSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//        JOptionPane.showConfirmDialog(frame, 
//            "Are you sure to close this window?", "Really Closing?", 
//            JOptionPane.YES_NO_OPTION,
//            JOptionPane.QUESTION_MESSAGE);
//        
//        if (JOptionPane.QUESTION_MESSAGE == JOptionPane.YES_OPTION){
//            this.dispose();
//        } else if (
//            JOptionPane.QUESTION_MESSAGE == JOptionPane.NO_OPTION) {
            
            //frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            
            
//        }
        
//            homePage home = null;
//        this.dispose();
//        try {
//            home = new homePage();
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(viewBookings.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        home.setVisible(true);
//        }
        
    }//GEN-LAST:event_formWindowClosing

    private void jLabelAddBookingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddBookingMousePressed
        addBooking addBooking = null;
        this.dispose();
        try {
            addBooking = new addBooking();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(viewBookings.class.getName()).log(Level.SEVERE, null, ex);
        }
        addBooking.setVisible(true);
    }//GEN-LAST:event_jLabelAddBookingMousePressed

    private void jLabelCancelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCancelMousePressed
        homePage home = null;
        this.dispose();
        try {
            home = new homePage(activeTab);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(viewBookings.class.getName()).log(Level.SEVERE, null, ex);
        }
        home.setVisible(true); 
    }//GEN-LAST:event_jLabelCancelMousePressed

    private void jLabelDeleteBookingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteBookingMousePressed
        try {
            connect.deleteBooking(bookingInfo[0]);
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stringID = childID + "";
            setBookingList(stringID);
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelDeleteBookingMousePressed

    private void jListBookingsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListBookingsMousePressed
        try {
            updateBookingList();
        } catch (SQLException ex) {
            Logger.getLogger(viewBookings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListBookingsMousePressed

    private void jLabelEditBookingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditBookingMousePressed
        connect.editBooking(bookingInfo[0], jTextFieldDate.getText(),
                jTextFieldSession.getText(), jTextAreaNotes.getText());
        try {
            stringID = childID + "";
            setBookingList(stringID);
        } catch (SQLException ex) {
            Logger.getLogger(viewBookings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelEditBookingMousePressed

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        try {
            String searchID = childID + "";
            searchBookingList(searchID);
        } catch (SQLException ex) {
            Logger.getLogger(viewBookings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldSearchKeyReleased

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
            java.util.logging.Logger.getLogger(viewBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(String id) {
                try {
                    new viewBookings(id).setVisible(true);
                } catch (        SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(viewBookings.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAddBooking;
    private javax.swing.JLabel jLabelCancel;
    private javax.swing.JLabel jLabelChild;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelDeleteBooking;
    private javax.swing.JLabel jLabelEditBooking;
    private javax.swing.JLabel jLabelHeading;
    private javax.swing.JLabel jLabelNotes;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelSession;
    private javax.swing.JList jListBookings;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaNotes;
    private javax.swing.JTextField jTextFieldChild;
    private javax.swing.JTextField jTextFieldDate;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTextField jTextFieldSession;
    // End of variables declaration//GEN-END:variables
}
