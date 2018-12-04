package prac;

import java.rmi.Remote; 
import java.rmi.RemoteException; 

public interface Hello extends Remote { 
    String sayHello(int timeOfDay) throws RemoteException; 
}

