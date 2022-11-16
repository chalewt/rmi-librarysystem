/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import common.DistributedLibraryInterface;
import java.awt.HeadlessException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

/**
 *
 * @author Chale
 */
public class FrmSearch extends javax.swing.JInternalFrame {

    String[] libNameList;
    String[] libIdList;
    int size = 0;
    /**
     * Creates new form FrmSearch
     */
    public FrmSearch() {
        initComponents();
        getRootPane().setDefaultButton(btnQuickSearch);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ppmBookSearch = new javax.swing.JPopupMenu();
        ppmiBookCheckOut = new javax.swing.JMenuItem();
        ppmiUpdateQuantity = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItemList = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSearch = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtISBN = new javax.swing.JTextField();
        btnQuickSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cmbLibrary = new javax.swing.JComboBox();
        btnRefresh = new javax.swing.JButton();

        ppmiBookCheckOut.setText("Check Out");
        ppmiBookCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppmiBookCheckOutActionPerformed(evt);
            }
        });
        ppmBookSearch.add(ppmiBookCheckOut);

        ppmiUpdateQuantity.setText("Update quantity");
        ppmiUpdateQuantity.setToolTipText("");
        ppmiUpdateQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppmiUpdateQuantityActionPerformed(evt);
            }
        });
        ppmBookSearch.add(ppmiUpdateQuantity);

        setBackground(new java.awt.Color(153, 153, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("ILS Search Item");
        setComponentPopupMenu(ppmBookSearch);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
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

        tblItemList.setAutoCreateRowSorter(true);
        tblItemList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Accession number", "Location", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItemList.setGridColor(new java.awt.Color(102, 255, 102));
        jScrollPane2.setViewportView(tblItemList);

        tblSearch.setAutoCreateRowSorter(true);
        tblSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Title", "Author", "Publisher", "Place", "Year", "Edition", "Unit price", "Qauntity", "Available"
            }
        ));
        tblSearch.setComponentPopupMenu(ppmBookSearch);
        tblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSearchMouseClicked(evt);
            }
        });
        tblSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tblSearchFocusGained(evt);
            }
        });
        jScrollPane3.setViewportView(tblSearch);

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quick Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), java.awt.Color.blue)); // NOI18N

        btnQuickSearch.setForeground(new java.awt.Color(0, 0, 255));
        btnQuickSearch.setText("Search");
        btnQuickSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuickSearch.setMaximumSize(new java.awt.Dimension(71, 23));
        btnQuickSearch.setMinimumSize(new java.awt.Dimension(71, 23));
        btnQuickSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuickSearchActionPerformed(evt);
            }
        });

        jLabel1.setText("ISBN :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuickSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnQuickSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Advanced Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), java.awt.Color.blue)); // NOI18N

        jLabel2.setText("Title :");

        jLabel3.setText("Author :");

        btnSearch.setForeground(new java.awt.Color(0, 51, 255));
        btnSearch.setText("Search");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2)
                .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3)
                .addComponent(btnSearch))
        );

        jLabel11.setText("Library :");

        cmbLibrary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLibraryActionPerformed(evt);
            }
        });

        btnRefresh.setForeground(new java.awt.Color(0, 0, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ppmiBookCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppmiBookCheckOutActionPerformed
       
        if (UserLogin.loggedin) {      
            int row = this.tblSearch.getSelectedRow();
            ClientClass.isbn = (String) this.tblSearch.getValueAt(row, 0);
            FrmCheckOut chk = new FrmCheckOut(null, true);
            chk.setVisible(true);
        }
        else 
            this.ppmiBookCheckOut.setVisible(false);
    }//GEN-LAST:event_ppmiBookCheckOutActionPerformed

    private void cmbLibraryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLibraryActionPerformed
       
    }//GEN-LAST:event_cmbLibraryActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        if (UserLogin.loggedin) {
            this.ppmiBookCheckOut.setVisible(true);
        } 
        else {
            this.ppmiBookCheckOut.setVisible(false);
        }
        getLibraryList();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnQuickSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuickSearchActionPerformed
        if(!"".equals(this.txtISBN.getText())) {
            searchByISBN(this.txtISBN.getText());            
        }
        else {
            JOptionPane.showMessageDialog(this, "Please enter ISBN to search", "Distributed Library System", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnQuickSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String title="";
        String author ="";
        if ("".equals(this.txtAuthor.getText()) && "".equals(this.txtTitle.getText())) {
            JOptionPane.showMessageDialog(this, "Please enter either title, author or both to search.");
        } else {
            if (!"".equals(this.txtAuthor.getText()) && !"".equals(this.txtTitle.getText())) {

                title = this.txtTitle.getText();
                author = this.txtAuthor.getText();
            }
            else if ("".equals(this.txtAuthor.getText()) && !"".equals(this.txtTitle.getText())) {
                title = this.txtTitle.getText();
            }
            else if (!"".equals(this.txtAuthor.getText()) && "".equals(this.txtTitle.getText())) {
                author = this.txtAuthor.getText();
            }
        
            advanceSearch(title, author);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSearchMouseClicked
        int row = this.tblSearch.getSelectedRow();
        Object str = this.tblSearch.getValueAt(row, 0);
        searchItem((String) str);
    }//GEN-LAST:event_tblSearchMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        searchBiblio();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tblSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblSearchFocusGained
        int row = this.tblSearch.getSelectedRow();
        Object str = this.tblSearch.getValueAt(row, 0);
        searchItem((String) str);
    }//GEN-LAST:event_tblSearchFocusGained

    private void ppmiUpdateQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppmiUpdateQuantityActionPerformed
        int row = this.tblSearch.getSelectedRow();
        ClientClass.isbn = (String) this.tblSearch.getValueAt(row, 0);
        FrmQuantity quan = new FrmQuantity(null, true);
        quan.setVisible(true);
    }//GEN-LAST:event_ppmiUpdateQuantityActionPerformed

      //***********************************************************************************////
    private void getLibraryList() {
        try {
            String[][] libList;
            ClientServerInfo lookup = new ClientServerInfo();
            DistributedLibraryInterface listLib;
            listLib = lookup.getLookup();
            if (listLib == null) {
                throw new java.net.ConnectException();
            }
            libList = listLib.getLibrary();
            size =  libList.length;
            libNameList = new String[size];  
            libIdList = new String[size]; 
            for(int i=0; i<size; i++) {
                libIdList[i] = libList[i][0];//library id
                libNameList[i] = libList[i][1];   //library name             
                this.cmbLibrary.addItem((Object)libNameList[i]);
            }         
        } catch (java.net.ConnectException conex) {
            JOptionPane.showMessageDialog(this, "Connection refused to Server : " + ClientServerInfo.serverName + "\n Check your network connection or \n Contact your Network Administrator.", "Distributed Library System", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Distributed Library System", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void searchBiblio() {        
          try {
             
            int id =  Integer.parseInt(libIdList[this.cmbLibrary.getSelectedIndex()]);
            Object[][] biblioInfo;
            ClientServerInfo lookup = new ClientServerInfo();
            DistributedLibraryInterface viewPatron;
            viewPatron = lookup.getLookup();
            if (viewPatron == null) {
                throw new java.net.ConnectException();
            }
            biblioInfo = viewPatron.searchBiblioRecord(id);
            if (biblioInfo == null) {
                JOptionPane.showMessageDialog(this, "No record found in "+this.cmbLibrary.getSelectedItem());
            } 
            String[] str = new String[]{"ISBN", "Title", "Author", "Publisher", "Place", "Year","Edition","Unit price","Quantity","Available"};
            this.tblSearch.setModel(new javax.swing.table.DefaultTableModel(biblioInfo, str));
            Object [][] itemInfo=null;
            String[] col = new String[]{"Accessin Number", "Shelving Location", "Status"};
            this.tblItemList.setModel(new javax.swing.table.DefaultTableModel(itemInfo, col));  
             TableColumn column;
              for (int i = 0; i < 10; i++) {
                  column = this.tblSearch.getColumnModel().getColumn(i);
                  if (i == 0) {
                      column.setPreferredWidth(50); //third column is bigger
                  } else if(i == 1) {
                      column.setPreferredWidth(130);
                  }else if(i == 2) {
                      column.setPreferredWidth(80);
                  }else {
                      column.setPreferredWidth(30);
                  }
              }
        } catch (java.net.ConnectException conex) {
            JOptionPane.showMessageDialog(this, "Connection refused to Server : " + ClientServerInfo.serverName + "\n Check your network connection or \n Contact your Network Administrator.", "Distributed Library System", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (HeadlessException | NumberFormatException | RemoteException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Distributed Library System", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void searchByISBN(String isbn) {
          try {
            int id =  Integer.parseInt(libIdList[this.cmbLibrary.getSelectedIndex()]);
            Object[][] biblioInfo;
            ClientServerInfo lookup = new ClientServerInfo();
            DistributedLibraryInterface viewPatron;
            viewPatron = lookup.getLookup();
            if (viewPatron == null) {
                throw new java.net.ConnectException();
            }
            biblioInfo = viewPatron.searchRecordByISBN(id, isbn);
             if (biblioInfo.length == 0) {
                JOptionPane.showMessageDialog(this, "No record found with ISBN : "+this.txtISBN.getText());
                //this.txtISBN.setText("");
                this.txtISBN.requestFocus();
                Object [][] itemInfo=null;
                String[] col = new String[]{"Accessin Number", "Shelving Location", "Status"};
                this.tblItemList.setModel(new javax.swing.table.DefaultTableModel(itemInfo, col));
            } else {
                 searchItem(this.txtISBN.getText());
             }
            String[] str = new String[]{"ISBN", "Title", "Author", "Publisher", "Place", "Year", "Edition", "Unit price", "Quantity", "Available"};
            this.tblSearch.setModel(new javax.swing.table.DefaultTableModel(biblioInfo, str));     
            TableColumn column;
              for (int i = 0; i < 10; i++) {
                  column = this.tblSearch.getColumnModel().getColumn(i);
                  if (i == 0) {
                      column.setPreferredWidth(50); //third column is bigger
                  } else if(i == 1) {
                      column.setPreferredWidth(130);
                  }else if(i == 2) {
                      column.setPreferredWidth(80);
                  }else {
                      column.setPreferredWidth(30);
                  }
              }
            
        } catch (java.net.ConnectException conex) {
            JOptionPane.showMessageDialog(this, "Connection refused to Server : " + ClientServerInfo.serverName + "\n Check your network connection or \n Contact your Network Administrator.", "Distributed Library System", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (HeadlessException | NumberFormatException | RemoteException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Distributed Library System", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void searchItem(String isbn) {
       try {           
            Object[][] biblioInfo;
            ClientServerInfo lookup = new ClientServerInfo();
            DistributedLibraryInterface viewPatron;
            viewPatron = lookup.getLookup();
            if (viewPatron == null) {
                throw new java.net.ConnectException();
            }
            biblioInfo = viewPatron.getItemList(isbn);
            if (biblioInfo.length==0) {
                JOptionPane.showMessageDialog(this, "No item found with ISBN : "+isbn);
            }
            String[] str = new String[]{"Accessin Number", "Shelving Location", "Status"};
            this.tblItemList.setModel(new javax.swing.table.DefaultTableModel(biblioInfo, str));            
        } catch (java.net.ConnectException conex) {
            JOptionPane.showMessageDialog(this, "Connection refused to Server : " + ClientServerInfo.serverName + "\n Check your network connection or \n Contact your Network Administrator.", "Distributed Library System", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (HeadlessException | RemoteException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Distributed Library System", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void advanceSearch(String title, String author) {
          try {
            int id =  Integer.parseInt(libIdList[this.cmbLibrary.getSelectedIndex()]);
            Object[][] biblioInfo;
            ClientServerInfo lookup = new ClientServerInfo();
            DistributedLibraryInterface viewRec;
            viewRec = lookup.getLookup();
            if (viewRec == null) {
                throw new java.net.ConnectException();
            }
            biblioInfo = viewRec.advancedSearch(id, title, author);
             if (biblioInfo.length == 0) {
                JOptionPane.showMessageDialog(this, "No result found matching the search ");
                //this.txtISBN.setText("");
                this.txtISBN.requestFocus();
                Object [][] itemInfo=null;
                String[] col = new String[]{"Accessin Number", "Shelving Location", "Status"};
                this.tblItemList.setModel(new javax.swing.table.DefaultTableModel(itemInfo, col));
            } 
            String[] str = new String[]{"ISBN", "Title", "Author", "Publisher", "Place", "Year", "Edition", "Unit price", "Quantity", "Available"};
            this.tblSearch.setModel(new javax.swing.table.DefaultTableModel(biblioInfo, str));     
            TableColumn column;
              for (int i = 0; i < 10; i++) {
                  column = this.tblSearch.getColumnModel().getColumn(i);
                  if (i == 0) {
                      column.setPreferredWidth(50); //third column is bigger
                  } else if(i == 1) {
                      column.setPreferredWidth(130);
                  }else if(i == 2) {
                      column.setPreferredWidth(80);
                  }else {
                      column.setPreferredWidth(30);
                  }
              }
            
        } catch (java.net.ConnectException conex) {
            JOptionPane.showMessageDialog(this, "Connection refused to Server : " + ClientServerInfo.serverName + "\n Check your network connection or \n Contact your Network Administrator.", "Distributed Library System", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Distributed Library System", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuickSearch;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cmbLibrary;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu ppmBookSearch;
    private javax.swing.JMenuItem ppmiBookCheckOut;
    private javax.swing.JMenuItem ppmiUpdateQuantity;
    private javax.swing.JTable tblItemList;
    private javax.swing.JTable tblSearch;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
