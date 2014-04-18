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
 * @author lcooper2
 */
public class addBooking extends javax.swing.JFrame {
    
    Child child;
    ChildList childList;
    DBConnection connect;
    private int childIndex;
    private Object thisChild;
    private String selectedChild;
    private String[] childInfo;

    /**
     * Creates new form addBooking
     */
    public addBooking() throws SQLException, ClassNotFoundException {
        initComponents();
        getContentPane().setBackground(Color.white);
        this.setLocationRelativeTo(null);
        
        connect = new DBConnection();
        this.connect.dbConnect();
        
        setChildList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelHeading = new javax.swing.JLabel();
        jLabelAddBooking = new javax.swing.JLabel();
        jLabelCancel = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListChildren = new javax.swing.JList();
        jTextFieldChild = new javax.swing.JTextField();
        jTextFieldRoom = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaNotes = new javax.swing.JTextArea();
        jLabelChild = new javax.swing.JLabel();
        jLabelRoom = new javax.swing.JLabel();
        jLabelSession = new javax.swing.JLabel();
        jLabelNotes = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jTextFieldDate = new javax.swing.JTextField();
        jTextFieldSession = new javax.swing.JTextField();
        jLabelSearch = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabelHeading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/newBookingHeading.png"))); // NOI18N

        jLabelAddBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addBooking_button.png"))); // NOI18N
        jLabelAddBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelAddBookingMousePressed(evt);
            }
        });

        jLabelCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel_button.png"))); // NOI18N
        jLabelCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelCancelMousePressed(evt);
            }
        });

        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });

        jListChildren.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListChildren.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListChildrenMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jListChildren);

        jTextAreaNotes.setColumns(20);
        jTextAreaNotes.setRows(5);
        jScrollPane2.setViewportView(jTextAreaNotes);

        jLabelChild.setText("Child");

        jLabelRoom.setText("Room");

        jLabelSession.setText("Session Required");

        jLabelNotes.setText("Notes");

        jLabelDate.setText("Date");

        jLabelSearch.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabelHeading))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabelSearch)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldSearch)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelChild)
                                    .addComponent(jLabelRoom)
                                    .addComponent(jLabelDate))
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 110, Short.MAX_VALUE))
                                    .addComponent(jTextFieldRoom)
                                    .addComponent(jTextFieldChild)))
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelSession)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldSession, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabelNotes))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addComponent(jLabelCancel)
                .addGap(18, 18, 18)
                .addComponent(jLabelAddBooking)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHeading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCancel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelAddBooking, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelChild))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRoom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDate)
                            .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSession)
                            .addComponent(jTextFieldSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNotes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelAddBookingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddBookingMousePressed
        connect.addBooking(childInfo[0], jTextFieldRoom.getText(), jTextFieldDate.getText(), jTextFieldSession.getText(), jTextAreaNotes.getText());
        
        homePage home = null;
        this.dispose();
        try {
            home = new homePage();
        } catch (SQLException ex) {
            Logger.getLogger(addBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        home.setVisible(true);
    }//GEN-LAST:event_jLabelAddBookingMousePressed

    private void jLabelCancelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCancelMousePressed
        homePage home = null;
        this.dispose();
        try {
            home = new homePage();
        } catch (SQLException ex) {
            Logger.getLogger(addBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        home.setVisible(true);
    }//GEN-LAST:event_jLabelCancelMousePressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        homePage home = null;
        this.dispose();
        try {
            home = new homePage();
        } catch (SQLException ex) {
            Logger.getLogger(addBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        home.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jListChildrenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListChildrenMousePressed
        updateSelectedChild();
    }//GEN-LAST:event_jListChildrenMousePressed

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        try {
            searchChildList();
        } catch (SQLException ex) {
            Logger.getLogger(addBooking.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(addBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new addBooking().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(addBooking.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(addBooking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void setChildList() throws SQLException{
        this.childList = this.connect.viewAllChildren();
        jListChildren.setListData(this.childList.getAllChildren());
        jListChildren.setSelectedIndex(0);
        
        updateSelectedChild();
    }
    
    public void searchChildList() throws SQLException{
        this.childList = this.connect.searchAllChildren(jTextFieldSearch.getText());
        jListChildren.setListData(this.childList.getAllChildren());
        jListChildren.setSelectedIndex(0);
        
        updateSelectedChild();
    }
    
    public void updateSelectedChild(){
        try{
            childIndex = jListChildren.getSelectedIndex();
            thisChild = jListChildren.getModel().getElementAt(childIndex);
            selectedChild = thisChild.toString();
            childInfo = selectedChild.split(": ");
            child = this.childList.getChildAt(childInfo[0]);

            jTextFieldChild.setText(child.getFirstName() + " " + child.getSurname());
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("e");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAddBooking;
    private javax.swing.JLabel jLabelCancel;
    private javax.swing.JLabel jLabelChild;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelHeading;
    private javax.swing.JLabel jLabelNotes;
    private javax.swing.JLabel jLabelRoom;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelSession;
    private javax.swing.JList jListChildren;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaNotes;
    private javax.swing.JTextField jTextFieldChild;
    private javax.swing.JTextField jTextFieldDate;
    private javax.swing.JTextField jTextFieldRoom;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTextField jTextFieldSession;
    // End of variables declaration//GEN-END:variables
}