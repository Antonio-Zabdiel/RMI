/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmisuma;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author KIKA
 */

public interface InterfazRemota extends Remote {
    public int suma (int a, int b) throws RemoteException;
    public int resta (int a, int b) throws RemoteException;
    public int multiplicacion (int a, int b) throws RemoteException;
    public int divicion (int a, int b) throws RemoteException;
}

