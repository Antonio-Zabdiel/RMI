/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmisuma;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author KIKA
 */
public class Servidor {
    
    /** Crea nueva instancia de Servidor rmi */
    public Servidor() {
        try 
        {
            
        Registry reg=LocateRegistry.createRegistry(1099);
        Objetoremoto lp=new Objetoremoto();
        reg.rebind("suma",lp);
        System.out.println("Servidor escuchando");
                       
        }
        catch (Exception e)
        {
            System.out.println("error");
        }
    }
    
   public static void main(String[] args) {
        new Servidor();
        System.out.println("Servidor escuchando...");
    }
}
