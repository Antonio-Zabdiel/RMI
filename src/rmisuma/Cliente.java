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
import java.text.DecimalFormat;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.ParseException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
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
    ButtonGroup Tfrom;
    ButtonGroup Tto;
    JTextArea fromTxt;
    JLabel resLabel;
    
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
            
            
            JPanel panelFrom = new JPanel();
            panelFrom.setLayout(new BoxLayout(panelFrom, BoxLayout.Y_AXIS));
            Tfrom = new ButtonGroup();
            
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
            
            JPanel panelTo = new JPanel();
            panelTo.setLayout(new BoxLayout(panelTo, BoxLayout.Y_AXIS));
            Tto = new ButtonGroup();
            
            JRadioButton toK=new JRadioButton("to K",true);
            JRadioButton toC=new JRadioButton("to C",false);
            JRadioButton toF=new JRadioButton("to F",false);
            JRadioButton toR=new JRadioButton("to R",false);
            Tto.add(toK);
            Tto.add(toC);
            Tto.add(toF);
            Tto.add(toR);
            panelTo.add(toK);
            panelTo.add(toC);
            panelTo.add(toF);
            panelTo.add(toR);
            
            
            
            JPanel title=new JPanel();
            title.setLayout(new BoxLayout(title, BoxLayout.Y_AXIS));
            JLabel titleLabel = new JLabel("convertir temperatura");
            final String resStr = "resultado : ";
            resLabel = new JLabel(resStr);
            final String inStr = "introduzca la temperatura :3 ";
            JLabel inLabel = new JLabel(inStr);
            JButton transbtn=new JButton("convertir");
            fromTxt = new JTextArea(1, 10);
            fromTxt.setLineWrap(true);
            fromTxt.setWrapStyleWord(true);
            
            title.add(titleLabel);
            title.add(transbtn);
            title.add(resLabel);
            title.add(inLabel);
            title.add(fromTxt);
            
            transbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String from = getRadio(Tfrom);
                    String to = getRadio(Tto);
                    DecimalFormat df = new DecimalFormat();
                    double f = 0;
                    try {
                        f = df.parse(fromTxt.getText()).doubleValue();
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null, "pls que sea numero");
                    }
                    double k=0;
                    double t=0;
                    switch(from){
                        case "from K":
                            k = i.KtoK(f);
                            break;
                        case "from C":
                            k = i.CtoK(f);
                            break;
                        case "from F":
                            k = i.FtoK(f);
                            break;
                        case "from R":
                            k = i.RtoK(f);
                            break;
                        default:
                            break;
                    }
                    switch(to){
                        case "to K":
                            t = i.KtoK(k);
                            break;
                        case "to C":
                            t = i.KtoC(k);
                            break;
                        case "to F":
                            t = i.KtoF(k);
                            break;
                        case "to R":
                            t = i.KtoR(k);
                            break;
                        default:
                            break;
                    }
                    resLabel.setText(resStr+t);
                } catch (RemoteException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE,null, ex);
                }
            }});
            
            
            frame.getContentPane().add(BorderLayout.EAST, panelTo);
            frame.getContentPane().add(BorderLayout.WEST, panelFrom);
            frame.getContentPane().add(BorderLayout.CENTER, title);
            frame.setVisible(true);
        }catch (Exception e){}
    }
    
    public String getRadio(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
    
    public static void main(String[] args) {
        new Cliente();
    }
}
