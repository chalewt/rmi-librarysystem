package server;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chalew Tesfaye
 */
import common.DistributedLibraryInterface;
import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;

public class DistributedLibraryImpl extends UnicastRemoteObject implements DistributedLibraryInterface {
    // variables    
    String connUrl = "jdbc:mysql://"+ FrmServerConfig.dbServerName +"/"+ FrmServerConfig.dbName;
    Connection conn;
    Statement stmt;
    ResultSet set;

    public DistributedLibraryImpl()throws RemoteException 
    {
        
    }
    
    /**
     *
     * @throws RemoteException
     */
    @Override
    public void dbConnection() throws RemoteException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connUrl, FrmServerConfig.userName, FrmServerConfig.password);
            stmt = conn.createStatement();
        }
        catch (ClassNotFoundException | SQLException ex ) {
            System.err.println(ex.getMessage());
        }
    }
    
    @Override
    public boolean createUser(String userName, String password, int type, String patronId) throws RemoteException{
        boolean created = false;
        String cmd  = "Insert into Account values('"+userName+"','"+ password +"',"+ type +",'"+ patronId +"')";
        try {
            dbConnection();            
            int rows = stmt.executeUpdate(cmd);
            created = rows != 0;
            stmt.close();
            conn.close();
        }
        catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
        return created;
    }
    
    public boolean login(String userName,String password)throws RemoteException {
        boolean found = false;
        try {
            dbConnection();
            String cmd = "select * from Account where UserName='"+ userName +"'&& password ='"+ password +"'";
            stmt.execute(cmd);
            set = stmt.getResultSet();          
            if(set.first())
            {
                found = true;
            }
            else
                found = false;
            stmt.close();
            conn.close();
        } 
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return found;
    }
    
    @Override
    public boolean addLibray(String[] libInfo) throws RemoteException {
        boolean added = false;
        String cmd  = "insert into Library(Library_Name, Library_Address, Library_Phone, Library_Fax, Library_Email, Library_Site, Library_Note)"
                + " values('"+libInfo[0]+"','"+ libInfo[1] +"','"+ libInfo[2] +"','"+ libInfo[3] +"','"+ libInfo[4] +"','"+ libInfo[5] +"','"+ libInfo[6]+"')";
        try {
            dbConnection();
            int rows = stmt.executeUpdate(cmd);
            if(rows != 0)
                added = true;
            else
                added = false;
        }
        catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
        return added;
    }

    public Object[][] viewLibrary() throws RemoteException {
         Object[][] libInfoList;         
         try {
             dbConnection();
             String cmd = "select * from Library";
             stmt.executeQuery(cmd);
             set = stmt.getResultSet();
             ResultSetMetaData meta = set.getMetaData();
             int col = meta.getColumnCount();
             set.last();
             int row = set.getRow();             
             libInfoList = new String[row][col];
             set.first();
             for (int r = 0; r < row; r++) {                
                for (int c = 0; c < col; c++) {
                    libInfoList[r][c] = set.getString(meta.getColumnName(c+1)); 
                }
//                 libInfoList[r][0] = new Integer(set.getInt("Library_Id")).toString();
//                 libInfoList[r][1] = set.getString("Library_Name");
//                 libInfoList[r][2] = set.getString("Library_Address");
//                 libInfoList[r][3] = set.getString("Library_Phone");
//                 libInfoList[r][4] = set.getString("Library_Fax");
//                 libInfoList[r][5] = set.getString("Library_Email");
//                 libInfoList[r][6] = set.getString("Library_Site");
//                 libInfoList[r][7] = set.getString("Library_Note");
//                
                set.next();
            }
         } catch (Exception ex) {
             System.err.println(ex);
             libInfoList = null;
         }
         return libInfoList;
     }
     
    @Override
     public String[][] getLibrary() throws RemoteException {
         String [][] library;
          try {
             dbConnection();
             String cmd = "select Library_Id, Library_Name from Library";
             stmt.executeQuery(cmd);
             set = stmt.getResultSet();
             ResultSetMetaData meta = set.getMetaData();
             int col = meta.getColumnCount();
             set.last();
             int row = set.getRow();             
             library = new String[row][col];
             set.first();
             for (int r = 0; r < row; r++) {                
                for (int c = 0; c < col; c++) {
                    library[r][c] = set.getString(meta.getColumnName(c+1)); 
                }               
                set.next();
            }
         } catch (Exception ex) {
             System.err.println(ex);
             library = null;
         }
         return library;
     }
     
     public boolean addRule(String[] ruleList) throws RemoteException {
         boolean saved = false;
         String cmd = "insert into rule(Library_id, patron_catagory, item_type, Check_out_allowed, loan_period, renewal_allowed, fine_amount, fine_charge_interval)"
                 + " values(" + Integer.parseInt(ruleList[0]) + ",'" + ruleList[1] + "','" + ruleList[2] + "'," + Integer.parseInt(ruleList[3]) + "," + Integer.parseInt(ruleList[4]) + "," + Integer.parseInt(ruleList[5]) + "," + Double.parseDouble(ruleList[6]) + "," + Integer.parseInt(ruleList[7]) + ")";
         try {
             dbConnection();
             int rows = stmt.executeUpdate(cmd);
             if (rows != 0) {
                 saved = true;
             } else {
                 saved = false;
             }
         } catch (Exception ex) {
             System.err.println(ex.getMessage());
         }
         return saved;
     }
     
    @Override
     public Object[][] viewRules(int libId) throws RemoteException {
          Object[][] ruleInfoList;         
         try {
             dbConnection();
             String cmd = "select rule_id, patron_catagory, item_type, Check_out_allowed, loan_period, renewal_allowed, fine_amount, fine_charge_interval from rule where Library_id =" + libId;
             stmt.executeQuery(cmd);
             set = stmt.getResultSet();
             ResultSetMetaData meta = set.getMetaData();
             int col = meta.getColumnCount();
             set.last();
             int row = set.getRow();             
             ruleInfoList = new String[row][col];
             set.first();
             for (int r = 0; r < row; r++) {                
                for (int c = 0; c < col; c++) {
                    ruleInfoList[r][c] = set.getString(meta.getColumnName(c+1)); 
                }                
                set.next();
            }
         } catch (Exception ex) {
             System.err.println(ex);
             ruleInfoList = null;
         }
         return ruleInfoList;
     }
     
    @Override
     public boolean addShelf(String[] shelfList) throws RemoteException {
         boolean saved = false;
         String cmd = "insert into shelf(shelf_id, shelf_Name, library_id)"
                 + " values('" + shelfList[0] + "','" + shelfList[1]+"'," + Integer.parseInt(shelfList[2]) +")";
         try {
             dbConnection();
             int rows = stmt.executeUpdate(cmd);
             if (rows != 0) {
                 saved = true;
             } else {
                 saved = false;
             }
         } catch (Exception ex) {
             System.err.println(ex.getMessage());
         }
         return saved;
     }
     
    @Override
     public boolean addPatrons(String[] patronList) throws RemoteException {
        boolean saved = false;
         String cmd = "insert into patron(patron_id, patron_name, patron_father_name, patron_gandfather_name,patron_gender, patron_catagory, patron_faculty, patron_department,Patron_year, patron_phone, patron_email, patron_card_number, patron_registration_date, library_Id)"
                 + " values('" + patronList[0] + "','" + patronList[1] + "','" + patronList[2] + "','" + patronList[3] + "','" + patronList[4] + "','" + patronList[5] + "','" + patronList[6] + "','" + patronList[7] +"','" + patronList[8] +"','" + patronList[9] +"','" + patronList[10] +"','"+ patronList[11] +"','"+ patronList[12] +"'," + Integer.parseInt(patronList[13]) + ")";
         try {
             dbConnection();
             int rows = stmt.executeUpdate(cmd);
             if (rows != 0) {
                 saved = true;
             } else {
                 saved = false;
             }
         } catch (RemoteException | SQLException ex) {
             System.err.println(ex.getMessage());
         }
         return saved; 
     }
     
    @Override
     public Object[][] viewPatron(int id, String catagory) throws RemoteException {
         Object[][] patronList;         
         try {
             dbConnection();
             String cmd = "select patron_id, patron_name, patron_father_name, patron_gandfather_name,patron_gender, patron_faculty, patron_department,Patron_year, patron_phone, patron_email, patron_card_number, patron_registration_date from patron where library_Id="+ id +"&&  patron_catagory ='"+ catagory +"'";
             stmt.executeQuery(cmd);
             set = stmt.getResultSet();
             ResultSetMetaData meta = set.getMetaData();
             int col = meta.getColumnCount();
             set.last();
             int row = set.getRow();             
             patronList = new String[row][col];
             set.first();
             for (int r = 0; r < row; r++) {                
                for (int c = 0; c < col; c++) {
                    patronList[r][c] = set.getString(meta.getColumnName(c+1)); 
                }                
                set.next();
            }
         } catch (RemoteException | SQLException ex) {
             System.err.println(ex);
             patronList = null;
         }
         return patronList;
     }
     
    @Override
     public Object[][] getPatron(String id) throws RemoteException {
          Object[][] patronList;         
         try {
             dbConnection();
             String cmd = "select patron_id, patron_name, patron_father_name, patron_gandfather_name,patron_gender, patron_faculty, patron_department,Patron_year, patron_phone, patron_email, patron_card_number, patron_registration_date from patron where patron_card_number="+ id;
             stmt.executeQuery(cmd);
             set = stmt.getResultSet();
             ResultSetMetaData meta = set.getMetaData();
             int col = meta.getColumnCount();
             set.last();
             int row = set.getRow();             
             patronList = new String[row][col];
             set.first();
             for (int r = 0; r < row; r++) {                
                for (int c = 0; c < col; c++) {
                    patronList[r][c] = set.getString(meta.getColumnName(c+1)); 
                }                
                set.next();
            }
         } catch (Exception ex) {
             System.err.println(ex);
             patronList = null;
         }
         return patronList;
     }
     
    @Override
     public String[][] getShelfList(int libId) throws RemoteException {
         String [][] shelf;
          try {
             dbConnection();
             String cmd = "select shelf_id, shelf_Name from shelf where library_id=" + libId;
             stmt.executeQuery(cmd);
             set = stmt.getResultSet();
             ResultSetMetaData meta = set.getMetaData();
             int col = meta.getColumnCount();
             set.last();
             int row = set.getRow();             
             shelf = new String[row][col];
             set.first();
             for (int r = 0; r < row; r++) {                
                for (int c = 0; c < col; c++) {
                    shelf[r][c] = set.getString(meta.getColumnName(c+1)); 
                }               
                set.next();
            }
         } catch (Exception ex) {
             System.err.println(ex);
             shelf = null;
         }
         return shelf;
     }
     
    @Override
     public boolean addBiblioRecored(String[] biblioInfo) throws RemoteException {
         boolean saved = false;
         String cmd = "insert into biblio_record(biblio_isbn, biblio_title, biblio_author, biblio_Date,biblio_edition, biblio_publisher, biblio_Place, biblio_Quantity,biblio_UnitPrice, biblio_catagory, library_id)"
                 + " values('" + biblioInfo[0] + "','" + biblioInfo[1] + "','" + biblioInfo[2] + "',"+Integer.parseInt(biblioInfo[3]) + ",'" + biblioInfo[4] + "','" + biblioInfo[5] + "','" + biblioInfo[6] + "'," + Integer.parseInt(biblioInfo[7]) + "," + Double.parseDouble(biblioInfo[8]) + ",'" + biblioInfo[9] + "'," + Integer.parseInt(biblioInfo[10])+")";
         try {
             dbConnection();
             int rows = stmt.executeUpdate(cmd);
             if (rows != 0) {
                 saved = true;
             } else {
                 saved = false;
             }
         } catch (Exception ex) {
             System.err.println(ex.getMessage());
         }
         return saved;
     }
     
    @Override
     public boolean addItem(String[] itemInfo) throws RemoteException {
          boolean saved = false;
         String cmd = "insert into item(accession_number, biblio_isbn, shelf_id, item_status)"
                 + " values('" + itemInfo[0] + "','" + itemInfo[1] + "','" + itemInfo[2] + "'," + Integer.parseInt(itemInfo[3]) + ")";
         try {
             dbConnection();
             int rows = stmt.executeUpdate(cmd);
             if (rows != 0) {
                 saved = true;
             } else {
                 saved = false;
             }
         } catch (Exception ex) {
             System.err.println(ex.getMessage());
         }
         return saved;
      }
     
    @Override
     public Object[][] searchBiblioRecord(int libId) throws RemoteException {
         Object[][] biblioList;         
         try {
             dbConnection();
             String cmd = "select biblio_record.biblio_isbn,biblio_record.biblio_title,biblio_record.biblio_author,biblio_record.biblio_publisher, biblio_record.biblio_Place, biblio_record.biblio_Date, biblio_record.biblio_edition,"+
                     " biblio_record.biblio_UnitPrice, biblio_record.biblio_Quantity, count(*) from biblio_record, item Where biblio_record.biblio_isbn = item.biblio_isbn AND item.item_status = 0 AND library_id="+ libId +" GROUP BY biblio_record.biblio_isbn";
             stmt.executeQuery(cmd);
             set = stmt.getResultSet();
             ResultSetMetaData meta = set.getMetaData();
             int col = meta.getColumnCount();
             set.last();
             int row = set.getRow();             
             biblioList = new String[row][col];
             set.first();
             for (int r = 0; r < row; r++) {                
                for (int c = 0; c < col; c++) {
                    biblioList[r][c] = set.getString(meta.getColumnName(c+1)); 
                }                
                set.next();
            }
         } catch (Exception ex) {
             System.err.println(ex);
             biblioList = null;
         }
         return biblioList;
     }
     
    @Override
     public Object[][] searchRecordByISBN(int libId, String isbn) throws RemoteException {
          Object[][] biblioList;         
         try {
             dbConnection();
             String cmd = "select biblio_record.biblio_isbn,biblio_record.biblio_title,biblio_record.biblio_author,biblio_record.biblio_publisher, biblio_record.biblio_Place, biblio_record.biblio_Date, biblio_record.biblio_edition,"+
                     " biblio_record.biblio_UnitPrice, biblio_record.biblio_Quantity, count(*) from biblio_record, item Where biblio_record.biblio_isbn ="+ isbn +" AND biblio_record.biblio_isbn = item.biblio_isbn AND item.item_status = 0 AND library_id="+ libId +" GROUP BY biblio_record.biblio_isbn";
             stmt.executeQuery(cmd);
             set = stmt.getResultSet();
             ResultSetMetaData meta = set.getMetaData();
             int col = meta.getColumnCount();
             set.last();
             int row = set.getRow();             
             biblioList = new String[row][col];
             set.first();
             for (int r = 0; r < row; r++) {                
                for (int c = 0; c < col; c++) {
                    biblioList[r][c] = set.getString(meta.getColumnName(c+1)); 
                }                
                set.next();
            }
         } catch (Exception ex) {
             System.err.println(ex);
             biblioList = null;
         }
         return biblioList;
     }
     
    @Override
     public Object[][] getItemList(String isbn)throws RemoteException {
          String [][] itemList;
          try {
             dbConnection();
             String cmd = "select item.accession_number, shelf.shelf_name, item.item_status from item, shelf where item.biblio_isbn=" + isbn +" AND item.shelf_id=shelf.shelf_id";
             stmt.executeQuery(cmd);
             set = stmt.getResultSet();
             ResultSetMetaData meta = set.getMetaData();
             int col = meta.getColumnCount();
             set.last();
             int row = set.getRow();             
             itemList = new String[row][col];
             set.first();
             for (int r = 0; r < row; r++) {                
                for (int c = 0; c < col; c++) {
                    if (c+1==3 && set.getInt(meta.getColumnName(c+1))==0)
                        itemList[r][c]="Available";
                    else if(c+1==3 && set.getInt(meta.getColumnName(c+1))==1)
                        itemList[r][c]="Checked Out";
                    else 
                        itemList[r][c] = set.getString(meta.getColumnName(c+1)); 
                }               
                set.next();
            }
         } catch (Exception ex) {
             System.err.println(ex);
             itemList = null;
         }
         return itemList;
      }
      
    @Override
     public boolean updateQuantity(int quantity, String isbn) throws RemoteException {
          boolean saved = false;
         String cmd = "update biblio_record SET biblio_Quantity="+ quantity +" where biblio_isbn ='"+isbn+"'";              
         try {
             dbConnection();
             int rows = stmt.executeUpdate(cmd);
             saved = rows != 0;
         } catch (RemoteException | SQLException ex) {
             System.err.println(ex.getMessage());
         }
         return saved;
      }
      
    @Override
     public String getCheckedOutCount(String cNum) throws RemoteException {
          String checkOut;
          try {
              dbConnection();
              String cmd = "select count(check_out.patron_card_number) from check_out where  check_out.patron_card_number="+ cNum +" AND check_out.check_status=1 GROUP BY check_out.patron_card_number";
              stmt.executeQuery(cmd);
              set = stmt.getResultSet();
              if (set.first()) {
                  checkOut = set.getString(1);
              } else {
                  checkOut = null;
              }
          } catch (Exception ex) {
              System.err.println(ex);
              checkOut = null;
          }
          return checkOut;
      }
      
    @Override
     public boolean checkOut(String[] checkOutInfo) throws RemoteException {
           boolean saved = false;
           String incmd = "INSERT INTO check_out(accession_number, check_out_date, check_in_date, check_status, patron_card_number, rule_id)"+
                   " VALUES ('"+ checkOutInfo[0] +"','"+ checkOutInfo[1] +"','"+ checkOutInfo[2] +"',"+ Integer.parseInt(checkOutInfo[3]) +",'"+ checkOutInfo[4] +"',"+ Integer.parseInt(checkOutInfo[5]) +")";
           String cmd = "UPDATE item SET item_status=1 WHERE accession_number='"+checkOutInfo[0]+"'";
           try {
               dbConnection();
               int rows2 = stmt.executeUpdate(incmd);
               int rows = stmt.executeUpdate(cmd);               
               if (rows != 0 && rows2 !=0) {
                   saved = true;
               } else {
                   saved = false;//rollback but how? wait....
               }
           } catch (Exception ex) {
               System.err.println(ex.getMessage());
           }
           return saved;
       }
     
    @Override
     public Object[][] getCheckOutDetail(String cNum) throws RemoteException {
         Object[][] checkDetail;
         try {
             dbConnection();
             String cmd = "Select item.biblio_isbn,biblio_record.biblio_title,biblio_record.biblio_author, check_out.accession_number, check_out.check_out_date,check_out.check_in_date "+ 
                            "from item, biblio_record, check_out where check_out.accession_number=item.accession_number AND item.biblio_isbn=biblio_record.biblio_isbn AND check_out.patron_card_number='"+ cNum +"' AND check_out.check_status=1";
             stmt.executeQuery(cmd);
             set = stmt.getResultSet();
             ResultSetMetaData meta = set.getMetaData();
             int col = meta.getColumnCount();
             set.last();
             int row = set.getRow();
             checkDetail = new String[row][col];
             set.first();
             for (int r = 0; r < row; r++) {
                 for (int c = 0; c < col; c++) {
                    checkDetail[r][c] = set.getString(meta.getColumnName(c+1));
                 }
                 set.next();
             }
         } catch (Exception ex) {
             System.err.println(ex);
             checkDetail = null;
         }
         return checkDetail;
     }
     
    @Override
     public boolean checkIn(String[] checkInInfo) throws RemoteException {
          boolean saved = false;
           String upcmd = "UPDATE check_out SET check_status=0, check_returned_date='"+ checkInInfo[0] +"' where patron_card_number='"+ checkInInfo[1] +"'AND accession_number='"+ checkInInfo[2] +"'";
                  
           String cmd = "UPDATE item SET item_status=0 WHERE accession_number='"+checkInInfo[2]+"'";
           try {
               dbConnection();
               int rows2 = stmt.executeUpdate(upcmd);
               int rows = stmt.executeUpdate(cmd);               
               if (rows != 0 && rows2 !=0) {
                   saved = true;
               } else {
                   saved = false;//rollback but how? wait....
               }
           } catch (Exception ex) {
               System.err.println(ex.getMessage());
           }
           return saved;
     }
     
    @Override
     public Object[][] advancedSearch(int libid, String title, String author) throws RemoteException {
         Object[][] biblioList;  
         String cmd="";
         try {
             dbConnection();
             if(!"".equals(title) && !"".equals(author)) {
                cmd = "select biblio_record.biblio_isbn,biblio_record.biblio_title,biblio_record.biblio_author,biblio_record.biblio_publisher, biblio_record.biblio_Place, biblio_record.biblio_Date, biblio_record.biblio_edition,"+
                     " biblio_record.biblio_UnitPrice, biblio_record.biblio_Quantity, count(*) from biblio_record, item Where biblio_record.biblio_title LIKE '%"+ title +"%' AND biblio_record.biblio_author LIKE '%"+ author +"%' AND biblio_record.biblio_isbn = item.biblio_isbn AND item.item_status = 0 AND library_id="+ libid +" GROUP BY biblio_record.biblio_isbn";
             }
             else if(!"".equals(title) && "".equals(author)) {
                cmd = "select biblio_record.biblio_isbn,biblio_record.biblio_title,biblio_record.biblio_author,biblio_record.biblio_publisher, biblio_record.biblio_Place, biblio_record.biblio_Date, biblio_record.biblio_edition,"+
                     " biblio_record.biblio_UnitPrice, biblio_record.biblio_Quantity, count(*) from biblio_record, item Where biblio_record.biblio_title LIKE '%"+ title +"%' AND biblio_record.biblio_isbn = item.biblio_isbn AND item.item_status = 0 AND library_id="+ libid +" GROUP BY biblio_record.biblio_isbn";
             }
             else if("".equals(title) && !"".equals(author)) {
                cmd = "select biblio_record.biblio_isbn,biblio_record.biblio_title,biblio_record.biblio_author,biblio_record.biblio_publisher, biblio_record.biblio_Place, biblio_record.biblio_Date, biblio_record.biblio_edition,"+
                     " biblio_record.biblio_UnitPrice, biblio_record.biblio_Quantity, count(*) from biblio_record, item Where biblio_record.biblio_author LIKE '%"+ author +"%' AND biblio_record.biblio_isbn = item.biblio_isbn AND item.item_status = 0 AND library_id="+ libid +" GROUP BY biblio_record.biblio_isbn";
             }
             stmt.executeQuery(cmd);
             set = stmt.getResultSet();
             ResultSetMetaData meta = set.getMetaData();
             int col = meta.getColumnCount();
             set.last();
             int row = set.getRow();             
             biblioList = new String[row][col];
             set.first();
             for (int r = 0; r < row; r++) {                
                for (int c = 0; c < col; c++) {
                    biblioList[r][c] = set.getString(meta.getColumnName(c+1)); 
                }                
                set.next();
            }
         } catch (Exception ex) {
             System.err.println(ex);
             biblioList = null;
         }
         return biblioList;
     }
}
