/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmisuma;

import java.awt.BorderLayout;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author KIKA
 */
public class Servidor {
    
    /** Crea nueva instancia de Servidor rmi */
    public Servidor() {
        try 
        {
            JFrame frame = new JFrame("server");      
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
            frame.setSize(480, 360); 
            
            JPanel panel=new JPanel();
            String ipString="ip : "+InetAddress.getLocalHost().getHostAddress();
            JLabel ipLabel = new JLabel(ipString);
            panel.add(ipLabel);
            
            Registry reg=LocateRegistry.createRegistry(1099);
            Objetoremoto lp=new Objetoremoto();
            reg.rebind("suma",lp);
            System.out.println("Servidor escuchando");
                       
            frame.getContentPane().add(BorderLayout.NORTH, panel);
            frame.setVisible(true); 
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
