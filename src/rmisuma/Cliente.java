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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
            
            JFrame frame = new JFrame("server");      
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
            frame.setSize(480, 360); 
            
            Registry reg= LocateRegistry.getRegistry(ip,1099);
            final InterfazRemota i=(InterfazRemota)reg.lookup("trans-formar");
            
            
            JPanel panel=new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            JLabel xLabel = new JLabel("x : ");
            final JTextArea xText = new JTextArea(1, 20);
            xText.setLineWrap(true);
            xText.setWrapStyleWord(true);
            JLabel yLabel = new JLabel("y : ");
            final JTextArea yText = new JTextArea(1, 20);
            yText.setLineWrap(true);
            yText.setWrapStyleWord(true);
            
            // Se realiza la suma remota.
            JButton button=new JButton("lol");
            button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(xText.getText());
                int y = Integer.parseInt(yText.getText());

                try{
                    JOptionPane.showMessageDialog(null, i.suma(x,y));
                    JOptionPane.showMessageDialog(null, i.resta(x,y));
                    JOptionPane.showMessageDialog(null, i.multiplicacion(x,y));
                    JOptionPane.showMessageDialog(null, i.divicion(x,y));
                }catch(Exception ex){}
                }});
            
            panel.add(xLabel);
            panel.add(xText);
            panel.add(yLabel);
            panel.add(yText);
            panel.add(button);
            
            frame.getContentPane().add(BorderLayout.CENTER, panel);
            frame.setVisible(true);
        }catch (Exception e){}
    }
    
    
    public static void main(String[] args) {
        new Cliente();
    }
}
