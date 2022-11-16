/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import common.DistributedLibraryInterface;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Chale
 */
public class FrmCheckOut extends javax.swing.JDialog {

    String[] libNameList;
    String[] libIdList;
    int size = 0;
    String ruleId,period;
    /**
     * Creates new form FrmCheckOut
     * @param parent
     * @param modal
     */
    public FrmCheckOut(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getRootPane().setDefaultButton(btnPatronSearch);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtCardNumber = new javax.swing.JTextField();
        btnPatronSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCheckedOut = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtAllowed = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtQuantity = new javax.swing.JTextField();
        txtAvailable = new javax.swing.JTextField();
        txtTitle = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnBookSearch = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbAccessionNumber = new javax.swing.JComboBox();
        dchReturnDate = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        btnCheckOut = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cmbLibrary = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Check Out");
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnCancel.setForeground(new java.awt.Color(51, 51, 255));
        btnCancel.setText("Cancel");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patron Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        btnPatronSearch.setForeground(new java.awt.Color(51, 102, 255));
        btnPatronSearch.setText("Search");
        btnPatronSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatronSearchActionPerformed(evt);
            }
        });

        jLabel2.setText("Full Name : ");

        txtFullName.setEditable(false);
        txtFullName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel1.setText("Card Number :");

        jLabel8.setText("Checked Out :");

        txtCheckedOut.setEditable(false);
        txtCheckedOut.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel9.setText("Max. allowed :");

        txtAllowed.setEditable(false);
        txtAllowed.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPatronSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCheckedOut, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAllowed, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPatronSearch))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAllowed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCheckedOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Book Inforamation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N

        txtQuantity.setEditable(false);
        txtQuantity.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        txtAvailable.setEditable(false);
        txtAvailable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        txtTitle.setEditable(false);
        txtTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        txtAuthor.setEditable(false);
        txtAuthor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel3.setText("ISBN :");

        jLabel4.setText("Title :");

        jLabel5.setText("Author :");

        btnBookSearch.setForeground(new java.awt.Color(51, 102, 255));
        btnBookSearch.setText("Search");
        btnBookSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookSearchActionPerformed(evt);
            }
        });

        jLabel7.setText("Available :");

        jLabel6.setText("Quantity :");

        jLabel10.setText("Acc. Number :");

        cmbAccessionNumber.setEditable(true);

        dchReturnDate.setDateFormatString("dd-MM-yyyy");

        jLabel12.setText("Return date :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnBookSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtTitle)
                        .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQuantity)
                        .addComponent(txtAvailable))
                    .addComponent(cmbAccessionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dchReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBookSearch))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(txtAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbAccessionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dchReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCheckOut.setForeground(new java.awt.Color(51, 51, 255));
        btnCheckOut.setText("Check Out");
        btnCheckOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        jLabel11.setText("Library :");

        cmbLibrary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLibraryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(cmbLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCheckOut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancel, btnCheckOut});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCheckOut)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancel, btnCheckOut});

        setSize(new java.awt.Dimension(547, 579));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnPatronSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatronSearchActionPerformed
        if (!"".equals(this.txtCardNumber.getText())) {
            patronsearch(this.txtCardNumber.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Please enter card number to search", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPatronSearchActionPerformed

    private void btnBookSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookSearchActionPerformed
        if(!"".equals(this.txtISBN.getText())) {
            searchByISBN(this.txtISBN.getText());            
        }
        else {
            JOptionPane.showMessageDialog(this, "Please enter ISBN to search", "Error", JOptionPane.INFORMATION_MESSAGE);
            this.txtISBN.requestFocus();
        }
    }//GEN-LAST:event_btnBookSearchActionPerformed

    private void cmbLibraryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLibraryActionPerformed
        //getShelfList();
    }//GEN-LAST:event_cmbLibraryActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        dateFormat.format(date);
        this.dchReturnDate.setDate(date);
        this.btnCheckOut.setVisible(false);
        getLibraryList();
        if(!"".equals(ClientClass.patronId)) {
            this.txtCardNumber.setText(ClientClass.patronId);
            patronsearch(ClientClass.patronId);
            ClientClass.patronId="";
        }
        if(!"".equals(ClientClass.isbn)) {
            this.txtISBN.setText(ClientClass.isbn);
            searchByISBN(ClientClass.isbn);
            ClientClass.isbn="";
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
         String[] checkOutInfo = new String[6];                
        if (!"".equals(this.txtISBN.getText()) && !"".equals(this.txtCardNumber.getText())) {
            checkOutInfo[0] = this.cmbAccessionNumber.getSelectedItem().toString();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date();                        
            checkOutInfo[1] = dateFormat.format(date);
            checkOutInfo[2] =dateFormat.format(this.dchReturnDate.getDate());
            checkOutInfo[3] = "1";
            checkOutInfo[4] = this.txtCardNumber.getText();
            checkOutInfo[5] = ruleId;
            boolean saved;      
            ClientServerInfo lookup = new ClientServerInfo();
            DistributedLibraryInterface addChechOut;     
            try {
                addChechOut = lookup.getLookup();
                if (addChechOut == null) {
                    throw new java.net.ConnectException();
                }
                saved = addChechOut.checkOut(checkOutInfo);
                if (saved) {
                    JOptionPane.showMessageDialog(this,"Check out successfully completed to : "+ this.txtFullName.getText()+"\nItem Accession number : "+this.cmbAccessionNumber.getSelectedItem().toString(), "Notification", JOptionPane.INFORMATION_MESSAGE);
                    this.txtFullName.setText("");
                    this.txtAllowed.setText("");
                    this.txtCheckedOut.setText("");
                    this.txtISBN.setText("");
                    this.txtTitle.setText("");
                    this.txtAvailable.setText("");
                    this.txtQuantity.setText("");
                    this.cmbAccessionNumber.removeAllItems();
                    this.txtAuthor.setText("");
                    this.txtCardNumber.requestFocus();
                    this.btnCheckOut.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Oops! Patron check out faild.");
                    // this.dispose();
                }
            } catch (java.net.ConnectException conex) {
                JOptionPane.showMessageDialog(this, "Connection refused to Server : " + ClientServerInfo.serverName + "\n Check your network connection or \n Contact your Network Administrator.", "ILS Server refused", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please complete the required information", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCheckOutActionPerformed

    //////////////////////******************************************************************///////////////////////////////////
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
            JOptionPane.showMessageDialog(this, "Connection refused to Server : " + ClientServerInfo.serverName + "\n Check your network connection or \n Contact your Network Administrator.", "ILS Server refused", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void patronsearch(String cNum) {              
        try {
            Object[][] getPat;
            ClientServerInfo lookup = new ClientServerInfo();
            DistributedLibraryInterface viewPatron;
            viewPatron = lookup.getLookup();
            if (viewPatron == null) {
                throw new java.net.ConnectException();
            }
            getPat = viewPatron.getPatron(cNum);            
            if (getPat.length == 0) {
                JOptionPane.showMessageDialog(this, "No record found with card number : " + this.txtCardNumber.getText());
                this.txtCardNumber.requestFocus();
            } else {
                this.txtFullName.setText(getPat[0][1].toString()+" "+ getPat[0][2].toString());     
                viewRules();
            }
        } catch (java.net.ConnectException conex) {
            JOptionPane.showMessageDialog(this, "Connection refused to Server : " + ClientServerInfo.serverName + "\n Check your network connection or \n Contact your Network Administrator.", "ILS Server refused", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void searchByISBN(String isbn) {
          try {
            int id =  Integer.parseInt(libIdList[this.cmbLibrary.getSelectedIndex()]);
            Object[][] biblioInfo;
            ClientServerInfo lookup = new ClientServerInfo();
            DistributedLibraryInterface search;
            search = lookup.getLookup();
            if (search == null) {
                throw new java.net.ConnectException();
            }
            biblioInfo = search.searchRecordByISBN(id, isbn);
            if (biblioInfo.length == 0) {
                JOptionPane.showMessageDialog(this, "No record found with ISBN : "+this.txtISBN.getText());
                this.txtISBN.setText("");
                this.txtISBN.requestFocus();
            } else {
                size = biblioInfo.length;                
                for(int i=0; i<size;i++) {
                    this.txtTitle.setText(biblioInfo[i][1].toString());
                    this.txtAuthor.setText(biblioInfo[i][2].toString());
                    this.txtQuantity.setText(biblioInfo[i][8].toString());
                    this.txtAvailable.setText(biblioInfo[i][9].toString());
                }
                searchItem(isbn);
                this.btnCheckOut.setVisible(true);
            }
        } catch (java.net.ConnectException conex) {
            JOptionPane.showMessageDialog(this, "Connection refused to Server : " + ClientServerInfo.serverName + "\n Check your network connection or \n Contact your Network Administrator.", "ILS Server refused", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void searchItem(String isbn) {
        String[] accList;
        String [] avail;
        int accSize;
          try {           
            Object[][] biblioInfo;
            ClientServerInfo lookup = new ClientServerInfo();
            DistributedLibraryInterface viewItem;
            viewItem = lookup.getLookup();
            if (viewItem == null) {
                throw new java.net.ConnectException();
            }
            biblioInfo = viewItem.getItemList(isbn);
            if (biblioInfo.length ==0) {
                JOptionPane.showMessageDialog(this, "No item found with ISBN : "+isbn);
            } else {
                  accSize = biblioInfo.length;
                  accList = new String[accSize];
                  avail = new String[accSize];
                  this.cmbAccessionNumber.removeAllItems();//remove previous items
                  for (int i = 0; i < accSize; i++) {
                      accList[i] = biblioInfo[i][0].toString();
                      avail[i] = biblioInfo[i][2].toString();
                      if ( avail[i].equals("Available")) {
                          this.cmbAccessionNumber.addItem((Object) accList[i]);
                      }
                  }
              }
        } catch (java.net.ConnectException conex) {
            JOptionPane.showMessageDialog(this, "Connection refused to Server : " + ClientServerInfo.serverName + "\n Check your network connection or \n Contact your Network Administrator.", "ILS Server refused", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void viewRules() {        
        int ruleSize;
        String checked;        
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date fullDate = new Date();
        dateFormat.format(fullDate);           
        int date = fullDate.getDate();
        
        try {
            int id = Integer.parseInt(libIdList[this.cmbLibrary.getSelectedIndex()]);
            Object[][] ruleInfo;
            ClientServerInfo lookup = new ClientServerInfo();
            DistributedLibraryInterface viewRule;
            viewRule = lookup.getLookup();
            if (viewRule == null) {
                throw new java.net.ConnectException();
            }
            ruleInfo = viewRule.viewRules(id);
            ruleSize = ruleInfo.length;            
            if (ruleInfo.length == 0) {
                JOptionPane.showMessageDialog(this, "No record found in " + this.cmbLibrary.getSelectedItem());
            } else {
                for (int i = 0; i < ruleSize; i++) {
                    if (ruleInfo[i][1].toString().equals("All") && ruleInfo[i][2].toString().equals("All")) {
                        ruleId = ruleInfo[i][0].toString();
                        this.txtAllowed.setText(ruleInfo[i][3].toString());
                        period = ruleInfo[i][4].toString();
                        int rd = new Integer(period) + date;
                        fullDate.setDate(rd);
                        this.dchReturnDate.setDate(fullDate);
                    }
                    checked = viewRule.getCheckedOutCount(this.txtCardNumber.getText());
                    if(checked==null)
                        this.txtCheckedOut.setText("0");
                    else
                        this.txtCheckedOut.setText(checked);
                }
            }
        } catch (java.net.ConnectException conex) {
            JOptionPane.showMessageDialog(this, "Connection refused to Server : " + ClientServerInfo.serverName + "\n Check your network connection or \n Contact your Network Administrator.", "ILS Server refused", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                FrmCheckOut dialog = new FrmCheckOut(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookSearch;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnPatronSearch;
    private javax.swing.JComboBox cmbAccessionNumber;
    private javax.swing.JComboBox cmbLibrary;
    private com.toedter.calendar.JDateChooser dchReturnDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtAllowed;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtAvailable;
    private javax.swing.JTextField txtCardNumber;
    private javax.swing.JTextField txtCheckedOut;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
