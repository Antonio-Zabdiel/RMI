/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmisuma;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author KIKA
 */
public class Objetoremoto extends UnicastRemoteObject implements InterfazRemota{
    
    /**
     * Construye una instancia de ObjetoRemoto
     * @throws RemoteException
     */
    public Objetoremoto () throws RemoteException{
        super();
    }

    
    
    public int suma(int a, int b) 
    {
	    System.out.println ("Sumando " + a + " + " + b +"...");
        return a+b;
    }
    
    public int resta(int a, int b) 
    {
	    System.out.println ("restado " + a + " - " + b +"...");
        return a-b;
    }
    
    public int multiplicacion(int a, int b) 
    {
	    System.out.println ("multiplicado " + a + " * " + b +"...");
        return a*b;
    }
    
    public int divicion(int a, int b) 
    {
	    System.out.println ("divicion " + a + " / " + b +"...");
        return a/b;
    }
}
