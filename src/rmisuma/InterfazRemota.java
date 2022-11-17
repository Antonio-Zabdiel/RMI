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
    
    public double CtoK (double c) throws RemoteException;
    public double FtoK (double f) throws RemoteException;
    public double RtoK (double r) throws RemoteException;
    public double KtoC (double k) throws RemoteException;
    public double KtoF (double k) throws RemoteException;
    public double KtoR (double k) throws RemoteException;
    public double KtoK (double k) throws RemoteException;
}

