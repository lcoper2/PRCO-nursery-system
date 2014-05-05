/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffsystem;

import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lcooper2
 */
public class addChild extends javax.swing.JFrame {

    Child child;
    ChildList childList;
    DBConnection connect;
    int activeTab = 2;
    /**
     * Creates new form addChild
     */
    public addChild() throws SQLException, ClassNotFoundException {
        initComponents();
        getContentPane().setBackground(Color.white);
        this.setLocationRelativeTo(null);
        
        child = new Child();
        childList = new ChildList();
        connect = new DBConnection();
        this.connect.dbConnect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDOB = new javax.swing.JLabel();
        jLabelSex = new javax.swing.JLabel();
        jLabelDietaryNeeds = new javax.swing.JLabel();
        jLabelSurname = new javax.swing.JLabel();
        jLabelNotes = new javax.swing.JLabel();
        jTextFieldSurname = new javax.swing.JTextField();
        jTextFieldDietaryNeeds = new javax.swing.JTextField();
        jTextFieldFirstName = new javax.swing.JTextField();
        jTextFieldMedicalConditions = new javax.swing.JTextField();
        jTextFieldImmunisations = new javax.swing.JTextField();
        jLabelFirstName = new javax.swing.JLabel();
        jLabelKnownAs = new javax.swing.JLabel();
        jTextFieldSex = new javax.swing.JTextField();
        jTextFieldKnownAs = new javax.swing.JTextField();
        jLabelPosFamily = new javax.swing.JLabel();
        jTextFieldPosFamily = new javax.swing.JTextField();
        jLabelReligion = new javax.swing.JLabel();
        jTextFieldReligion = new javax.swing.JTextField();
        jLabelEthnicOrigin = new javax.swing.JLabel();
        jTextFieldEthnicOrigin = new javax.swing.JTextField();
        jLabelLanguages = new javax.swing.JLabel();
        jTextFieldLanguages = new javax.swing.JTextField();
        jLabelImmunisations = new javax.swing.JLabel();
        jLabelMedicalConditions = new javax.swing.JLabel();
        jScrollPaneNotesChild = new javax.swing.JScrollPane();
        jTextAreaNotes = new javax.swing.JTextArea();
        jLabelAddChild = new javax.swing.JLabel();
        jLabelHeading = new javax.swing.JLabel();
        jLabelCancel = new javax.swing.JLabel();
        jTextFieldDateOfBirth = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabelDOB.setText("Date Of Birth");

        jLabelSex.setText("Sex");

        jLabelDietaryNeeds.setText("Dietary Needs");

        jLabelSurname.setText("Surname");

        jLabelNotes.setText("Notes");

        jLabelFirstName.setText("First Name");

        jLabelKnownAs.setText("Known As");

        jLabelPosFamily.setText("Position In Family");

        jLabelReligion.setText("Religion");

        jLabelEthnicOrigin.setText("Ethnic Origin");

        jLabelLanguages.setText("Languages Spoken");

        jLabelImmunisations.setText("Immunisations");

        jLabelMedicalConditions.setText("Medical Conditions");

        jTextAreaNotes.setColumns(20);
        jTextAreaNotes.setRows(5);
        jScrollPaneNotesChild.setViewportView(jTextAreaNotes);

        jLabelAddChild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addChild_button.png"))); // NOI18N
        jLabelAddChild.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelAddChildMousePressed(evt);
            }
        });

        jLabelHeading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/newChildHeading.png"))); // NOI18N

        jLabelCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel_button.png"))); // NOI18N
        jLabelCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelCancelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNotes)
                                .addGap(280, 280, 280))
                            .addComponent(jScrollPaneNotesChild, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelCancel)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelAddChild))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFirstName)
                            .addComponent(jLabelSurname)
                            .addComponent(jLabelKnownAs)
                            .addComponent(jLabelPosFamily)
                            .addComponent(jLabelSex)
                            .addComponent(jLabelDOB))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldSurname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                .addComponent(jTextFieldSex, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(jTextFieldPosFamily, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldKnownAs))
                            .addComponent(jTextFieldDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelEthnicOrigin)
                                    .addComponent(jLabelReligion)
                                    .addComponent(jLabelLanguages))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldImmunisations)
                                    .addComponent(jTextFieldMedicalConditions, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldLanguages, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldDietaryNeeds, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldReligion)
                                    .addComponent(jTextFieldEthnicOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelMedicalConditions)
                            .addComponent(jLabelImmunisations)
                            .addComponent(jLabelDietaryNeeds))))
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(jLabelHeading)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHeading)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelReligion)
                            .addComponent(jTextFieldReligion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEthnicOrigin)
                            .addComponent(jTextFieldEthnicOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLanguages)
                            .addComponent(jTextFieldLanguages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMedicalConditions)
                            .addComponent(jTextFieldMedicalConditions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelImmunisations)
                            .addComponent(jTextFieldImmunisations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDietaryNeeds)
                            .addComponent(jTextFieldDietaryNeeds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelFirstName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSurname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldKnownAs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKnownAs))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDOB)
                            .addComponent(jTextFieldDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSex)
                            .addComponent(jTextFieldSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPosFamily)
                            .addComponent(jTextFieldPosFamily, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNotes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPaneNotesChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelAddChild)
                            .addComponent(jLabelCancel))))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelAddChildMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddChildMousePressed
        try {
            addChild();
        } catch (SQLException ex) {
            Logger.getLogger(addChild.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addChild.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(addChild.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelAddChildMousePressed

    private void jLabelCancelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCancelMousePressed
        homePage home = null;
        this.dispose();
        try {
            home = new homePage(activeTab);
        } catch (SQLException ex) {
            Logger.getLogger(addChild.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addChild.class.getName()).log(Level.SEVERE, null, ex);
        }
        home.setVisible(true);
    }//GEN-LAST:event_jLabelCancelMousePressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        homePage home = null;
        this.dispose();
        try {
            home = new homePage(activeTab);
        } catch (SQLException ex) {
            Logger.getLogger(addChild.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addChild.class.getName()).log(Level.SEVERE, null, ex);
        }
        home.setVisible(true);
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
            java.util.logging.Logger.getLogger(addChild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addChild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addChild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addChild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new addChild().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(addChild.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(addChild.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void addChild()throws SQLException, ClassNotFoundException, ParseException{
        connect.addChild(jTextFieldFirstName.getText(),
                jTextFieldSurname.getText(), jTextFieldKnownAs.getText(),
                jTextFieldSex.getText(), jTextFieldDateOfBirth.getText(),
                Integer.parseInt(jTextFieldPosFamily.getText()),
                jTextFieldReligion.getText(), jTextFieldEthnicOrigin.getText(),
                jTextFieldLanguages.getText(),
                jTextFieldMedicalConditions.getText(),
                jTextFieldImmunisations.getText(),
                jTextFieldDietaryNeeds.getText(),
                jTextAreaNotes.getText());
        
        homePage home = null;
        this.connect.closeConnection();
        this.dispose();
        
        home = new homePage(activeTab);
        home.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAddChild;
    private javax.swing.JLabel jLabelCancel;
    private javax.swing.JLabel jLabelDOB;
    private javax.swing.JLabel jLabelDietaryNeeds;
    private javax.swing.JLabel jLabelEthnicOrigin;
    private javax.swing.JLabel jLabelFirstName;
    private javax.swing.JLabel jLabelHeading;
    private javax.swing.JLabel jLabelImmunisations;
    private javax.swing.JLabel jLabelKnownAs;
    private javax.swing.JLabel jLabelLanguages;
    private javax.swing.JLabel jLabelMedicalConditions;
    private javax.swing.JLabel jLabelNotes;
    private javax.swing.JLabel jLabelPosFamily;
    private javax.swing.JLabel jLabelReligion;
    private javax.swing.JLabel jLabelSex;
    private javax.swing.JLabel jLabelSurname;
    private javax.swing.JScrollPane jScrollPaneNotesChild;
    private javax.swing.JTextArea jTextAreaNotes;
    private javax.swing.JTextField jTextFieldDateOfBirth;
    private javax.swing.JTextField jTextFieldDietaryNeeds;
    private javax.swing.JTextField jTextFieldEthnicOrigin;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldImmunisations;
    private javax.swing.JTextField jTextFieldKnownAs;
    private javax.swing.JTextField jTextFieldLanguages;
    private javax.swing.JTextField jTextFieldMedicalConditions;
    private javax.swing.JTextField jTextFieldPosFamily;
    private javax.swing.JTextField jTextFieldReligion;
    private javax.swing.JTextField jTextFieldSex;
    private javax.swing.JTextField jTextFieldSurname;
    // End of variables declaration//GEN-END:variables
}
