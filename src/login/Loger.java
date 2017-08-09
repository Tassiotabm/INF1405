package login;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import graphic.window1.InterfaceAirport;
import graphic.window2.InterfaceState;
import graphic.window3.InterfaceMeteorological;


@SuppressWarnings("serial")
public class Loger extends JFrame implements ActionListener{
	
	private String login;
	private String senha;
	public static JFrame loginframe = new JFrame();
	JButton logarButton = new JButton("Logar");
	JTextField loginField = new JTextField();
	JTextField passwordField = new JTextField();
	InterfaceAirport telaPrincipal;
	InterfaceState telaSecundaria;
	InterfaceMeteorological telaTercearia;
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == logarButton){
			
			login = loginField.getText();
			senha = passwordField.getText();
			
			try {
				if(Acesso.sendInfo(login,senha) == true){
					loginframe.setVisible(false);
					telaPrincipal = new InterfaceAirport();
					telaSecundaria = new InterfaceState();
					telaTercearia = new InterfaceMeteorological();
				}
				else
			        JOptionPane.showMessageDialog(null, "Senha Incorreta",
			        		"Acess denied", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Não foi possível conectar ao Banco, verificar o acesso.",
		        		"Error 404", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else
			System.exit(0);
	}
	
	public Loger(){
		// Configurar as specs da tela de login
		loginframe.setLayout(new GridLayout(3,1,0,0));
		loginframe.setLocation(512, 250);
		loginframe.setSize(100, 100);
		// Configurar os botoões
		logarButton.addActionListener(this);
		// Configurar o recebimento do login e senha

		// Setar as bordas dos textos e botoes e tamanhi

		loginField.setPreferredSize(new Dimension(50,50));
		passwordField.setPreferredSize(new Dimension(50,50));

		// Ordem dos "blocos" dentro da tela de login
		loginframe.add(loginField,BorderLayout.NORTH);
		loginframe.add(passwordField,BorderLayout.CENTER);
		loginframe.add(logarButton,BorderLayout.SOUTH);
		// Setar ele visivel
		loginframe.setResizable(false);
		loginframe.setLocationRelativeTo(null);
		loginframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
}
