package client;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chale
 */
public class DsLibraryClient {
    public static void main(String[] args) {     
        //*****Main form*****//
        DsLibraryMain mdi = new DsLibraryMain();
        mdi.setVisible(true);
        mdi.setExtendedState(mdi.getExtendedState() | DsLibraryMain.MAXIMIZED_BOTH);        
    }    
}
