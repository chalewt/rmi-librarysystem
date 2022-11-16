package common;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chalew Tesfaye
 */
import java.rmi.*;

public interface DistributedLibraryInterface extends Remote{
    public void dbConnection() throws RemoteException;
    public boolean createUser(String userName, String password, int type, String patronId) throws RemoteException;
    public boolean login(String userName,String password)throws RemoteException;
    public boolean addLibray(String[] libInfo) throws RemoteException;
    public Object[][] viewLibrary() throws RemoteException;
    public String[][] getLibrary() throws RemoteException;
    public boolean addRule(String[] ruleList) throws RemoteException;
    public Object[][] viewRules(int libId) throws RemoteException;
    public boolean addShelf(String[] shelfList) throws RemoteException;
    public boolean addPatrons(String[] patronList) throws RemoteException;
    public Object[][] viewPatron(int id, String catagory) throws RemoteException;//all patron list
    public Object[][] getPatron(String id) throws RemoteException;
    public String[][] getShelfList(int libId) throws RemoteException;
    public boolean addBiblioRecored(String[] biblioInfo) throws RemoteException;
    public boolean addItem(String[] itemInfo) throws RemoteException;
    public Object[][] searchBiblioRecord(int libId) throws RemoteException;
    public Object[][] searchRecordByISBN(int id, String isbn) throws RemoteException;
    public Object[][] getItemList(String isbn)throws RemoteException;
    public boolean updateQuantity(int quantity, String isbn) throws RemoteException;
    public String getCheckedOutCount(String cNum) throws RemoteException;
    public boolean checkOut(String[] checkOutInfo) throws RemoteException;
    public Object[][] getCheckOutDetail(String cNum) throws RemoteException;
    public boolean checkIn(String[] checkInInfo) throws RemoteException;
    public Object[][] advancedSearch(int id, String title, String author) throws RemoteException;    
    
}
