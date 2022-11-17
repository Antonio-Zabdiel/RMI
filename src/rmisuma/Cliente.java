/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmisuma;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

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
                
            String ip = JOptionPane.showInputDialog("ingrese ip");
            
            JFrame frame = new JFrame("cliente");      
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
            frame.setSize(480, 360); 
            
            Registry reg= LocateRegistry.getRegistry(ip,1099);
            final InterfazRemota i=(InterfazRemota)reg.lookup("trans-formar");
            
            
            JPanel title=new JPanel();
            JLabel titleLabel = new JLabel("convertir temperatura");
            JButton transbtn=new JButton("convertir");
            title.add(titleLabel);
            title.add(transbtn);
            
            JPanel panelFrom = new JPanel();
            panelFrom.setLayout(new BoxLayout(panelFrom, BoxLayout.Y_AXIS));
            ButtonGroup Tfrom = new ButtonGroup();
            
            JRadioButton fromK=new JRadioButton("from K",true);
            JRadioButton fromC=new JRadioButton("from C",false);
            JRadioButton fromF=new JRadioButton("from F",false);
            JRadioButton fromR=new JRadioButton("from R",false);
            Tfrom.add(fromK);
            Tfrom.add(fromC);
            Tfrom.add(fromF);
            Tfrom.add(fromR);
            panelFrom.add(fromK);
            panelFrom.add(fromC);
            panelFrom.add(fromF);
            panelFrom.add(fromR);
            JTextArea fromTxt = new JTextArea(1, 10);
            panelFrom.add(fromTxt);
            
            frame.getContentPane().add(BorderLayout.WEST, panelFrom);
            frame.getContentPane().add(BorderLayout.CENTER, title);
            frame.setVisible(true);
        }catch (Exception e){}
    }
    
    
    public static void main(String[] args) {
        new Cliente();
    }
}
