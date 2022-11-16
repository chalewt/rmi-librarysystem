package client;


import common.DistributedLibraryInterface;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chale
 */
public class ClientServerInfo {
    public static String serverName = "localhost";
    public static int portNumber = 2123;  
    private static Registry registry;
    public DistributedLibraryInterface getLookup() throws RemoteException
    {
        DistributedLibraryInterface ilsLookup = null;
        try {
            registry = LocateRegistry.getRegistry(ClientServerInfo.serverName, ClientServerInfo.portNumber);
            ilsLookup = (DistributedLibraryInterface) registry.lookup("DistributedLibrary");            
        }
        catch (NotBoundException | RemoteException ex) {
            System.err.println(ex.getMessage());
        }
        return ilsLookup;
    }
}
