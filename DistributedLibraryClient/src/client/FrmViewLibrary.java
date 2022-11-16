/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import common.DistributedLibraryInterface;
import java.awt.HeadlessException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

/**
 *
 * @author Chale
 */
public class FrmViewLibrary extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmViewLibrary
     */
    public FrmViewLibrary() {        
       initComponents();       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ppmViewLibrary = new javax.swing.JPopupMenu();
        ppmiViewDetail = new javax.swing.JMenuItem();
        ppmiLibrarayDelete = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblViewLibrary = new javax.swing.JTable();

        ppmiViewDetail.setText("Viewe Detail");
        ppmViewLibrary.add(ppmiViewDetail);

        ppmiLibrarayDelete.setText("Delete");
        ppmViewLibrary.add(ppmiLibrarayDelete);

        jMenuItem2.setText("jMenuItem2");
        ppmViewLibrary.add(jMenuItem2);

        jMenuItem3.setText("jMenuItem3");
        ppmViewLibrary.add(jMenuItem3);

        jMenuItem4.setText("jMenuItem4");
        ppmViewLibrary.add(jMenuItem4);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("ILS List of registered libraries");
        setToolTipText("");
        setAutoscrolls(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        tblViewLibrary.setAutoCreateRowSorter(true);
        tblViewLibrary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Name", "Address", "Phone", "Fax", "Email", "Web site", "Note"
            }
        ));
        jScrollPane1.setViewportView(tblViewLibrary);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        this.toFront();
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
       viewLibrary();
    }//GEN-LAST:event_formInternalFrameOpened
    private void viewLibrary() {
          try {
            Object[][] libInfo;
            ClientServerInfo lookup = new ClientServerInfo();
            DistributedLibraryInterface viewLib;
            viewLib = lookup.getLookup();
            if (viewLib == null) {
                throw new java.net.ConnectException();
            }
            libInfo = viewLib.viewLibrary();
            if (libInfo == null) {
                JOptionPane.showMessageDialog(this, "No record found.");
            } else {
                String[] str = new String[]{"Code", "Name", "Addres", "Phone", "Fax", "E-mail", "Web Site", "Note"};
                tblViewLibrary.setModel(new javax.swing.table.DefaultTableModel(libInfo, str));
            }
        } catch (java.net.ConnectException conex) {
            JOptionPane.showMessageDialog(this, "Connection refused to Server : " + ClientServerInfo.serverName + "\n Check your network connection or \n Contact your Network Administrator.", "Distributed Library System", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (HeadlessException | RemoteException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Distributed Library System", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void fillTable(Object data[][], int col) {
        String[] str = new String[]{"No.", "Name", "Addres", "Phone", "Fax", "E-mail", "Web Site", "Note"};
        tblViewLibrary.setModel(new javax.swing.table.DefaultTableModel(data, str));
    }             
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu ppmViewLibrary;
    private javax.swing.JMenuItem ppmiLibrarayDelete;
    private javax.swing.JMenuItem ppmiViewDetail;
    private javax.swing.JTable tblViewLibrary;
    // End of variables declaration//GEN-END:variables
}
