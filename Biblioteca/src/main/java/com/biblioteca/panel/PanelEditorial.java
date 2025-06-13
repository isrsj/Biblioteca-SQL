
package com.biblioteca.panel;

import com.biblioteca.entities.Editorial;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import java.util.function.Consumer;

public class PanelEditorial extends javax.swing.JPanel {

    private EntityManagerFactory factory;
    
    private Editorial editorial = new Editorial();
    
    public PanelEditorial( EntityManagerFactory factory ) {
        this.factory = factory;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textFieldName = new javax.swing.JTextField();
        insertButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        textFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNameActionPerformed(evt);
            }
        });

        insertButton.setText("insert");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(textFieldName)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(insertButton)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(insertButton)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 300));
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNameActionPerformed
    }//GEN-LAST:event_textFieldNameActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        String name = textFieldName.getText();
        
        inSession( factory, entityManager -> { 
            
            editorial.setNombre(name);
            
            entityManager.persist(editorial);
        });
        
    }//GEN-LAST:event_insertButtonActionPerformed

    
    public static void inSession ( EntityManagerFactory factory, Consumer<EntityManager> work ) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        
        try {
            transaction.begin();
            work.accept(manager);
            transaction.commit();
        }
        catch ( Exception e ) {
            if ( transaction.isActive() ) transaction.rollback();
            throw e;
        }
        finally {
            manager.close();
        }
        
    } 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton insertButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textFieldName;
    // End of variables declaration//GEN-END:variables
}
