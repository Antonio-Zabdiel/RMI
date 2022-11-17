/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmisuma;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 *
 * @author KIKA
 */
public class Cliente {
    
    public Cliente(){
        try{
		// Lugar en el que está el objeto remoto.
		// Debe reemplazarse "localhost" por el nombre o ip donde
		// esté corriendo "rmiregistry".
		// Naming.lookup() obtiene el objeto remoto
            Registry reg= LocateRegistry.getRegistry("192.168.2.100",1099);
            InterfazRemota i=(InterfazRemota)reg.lookup("suma");
            // Se realiza la suma remota.
            while(true){
                int x = Integer.parseInt(JOptionPane.showInputDialog("ingresa numero 1"));
                int y = Integer.parseInt(JOptionPane.showInputDialog("ingresa numero 2"));

                JOptionPane.showMessageDialog(null, i.suma(x,y));
                JOptionPane.showMessageDialog(null, i.resta(x,y));
                JOptionPane.showMessageDialog(null, i.multiplicacion(x,y));
                JOptionPane.showMessageDialog(null, i.divicion(x,y));
            }
        }
        catch (Exception e)
        {
        }
    }
    
    
    public static void main(String[] args) {
        new Cliente();
    }
}
