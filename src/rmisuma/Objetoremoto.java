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
    
    public double CtoK(double c){
        double k = c + 273.15;
        return k;
    }
    public double FtoK(double f){
        double k = f - 32;
        k = k * 5/9;
        k += 273.15;
        return k;
    }
    public double RtoK(double r){
        double k = r * 5/9;
        return k;
    }
    public double KtoC(double k){
        double c = k - 273.15;
        return c;
    }
    public double KtoF(double k){
        double f = k - 273.15;
        f = k * 9/5;
        f += 32;
        return f;
    }
    public double KtoR(double k){
        double r = k * 9/5;
        return r;
    }
    public double KtoK(double k){
        return k;
    }
}
