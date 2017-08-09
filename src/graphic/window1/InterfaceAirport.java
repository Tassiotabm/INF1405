package graphic.window1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import data.PistaData;
import graphic.window1.TiposSinais;

@SuppressWarnings("serial")
public class InterfaceAirport extends JFrame implements ActionListener,MouseListener,ItemListener {

	private static JPanel fs;
	private static JPanel menu;
	private static JPanel foot;
	private static Plane Av;
	private static PistaData data;
	public static Color temp = Color.RED;
	public static ArrayList<TiposSinais	> sinalPista;
	
	public InterfaceAirport(){
		/*******************************************/
		super("Controle de Pista de Aeroporto");
		this.setSize(1000, 800);
		//this.setLayout(new BorderLayout());
		/*******************************************/
		// Carregar o plane
		Av = new Plane();
		// Chamar função de criar os sinais da pista
		carregaLista();		
		//Deixar descomentado enquanto testo e vejo as posicoes dos sinais
		//addMouseListener(this);
		//Set components to Frame
		addPanels();
		/*******************************************/
		FlowLayout layout = new FlowLayout();
		layout.setHgap(0);
		layout.setVgap(0);
		this.setLayout(layout);
		this.setBackground(Color.BLACK);
		this.setForeground(Color.BLACK);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		/*******************************************/
	}
	public void addPanels(){ /*Adicionar conteiners ao JFrame(this)*/	
		//this.setLayout(new GridLayout(3,1,0,0));
		fs = new Pista(sinalPista,Av);
		menu = new JPanel();
		foot = new JPanel();
		// Configurar os JPanels
		configPista();
		configMenu();
		rodaPe();
		// Adicionar os JPanels
		this.add(fs);
		this.add(menu);
		this.add(foot);
	}
	public void configPista(){
		// Configuração da Label da pista
		//pista.setSize(800,600);
		fs.setBackground(Color.black);
		fs.setForeground(Color.black);
		//fs.setSize(500,500);
		fs.setPreferredSize(new Dimension(1000,600));
		fs.setMinimumSize(new Dimension(1000,600));
		
		
		//pista.setMinimumSize(new Dimension(800,600));
		/*********************************************************/
		// Aqui vamos tratar o "Background da imagem"
		//imageTemp = aeroportoImage(image.getImage(),Av.getPlane().getImage());
		//finalImage = new ImageIcon(image2);
		//label = new JLabel("", finalImage, JLabel.CENTER);
		/*********************************************************/
		//pista.add(label);
		//pista.setBackground(Color.BLACK);
	}
	public void configMenu(){
		menu.setForeground(Color.BLACK);
		menu.setLayout(new GridLayout(1,10));
		menu.setPreferredSize(new Dimension(1000,100));
		
		
		for( TiposSinais l1 : sinalPista){
			menu.add(l1.retButton());
			l1.retButton().addActionListener(this);
			l1.retButton().addMouseListener(this);
		}

		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.black);
		menu.setBorder(blackline);
		
		menu.setBackground(Color.BLACK);
	}
	public void rodaPe(){
		//foot.setSize(1200,40);
		foot.setMaximumSize(new Dimension(1000,40));
		foot.setPreferredSize(new Dimension(1000,40));
		foot.setBackground(Color.black);
		foot.setForeground(Color.black);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		for(TiposSinais l1 : sinalPista){
			if(arg0.getSource() == l1.retButton()){
				temp = l1.listaSinais.get(0).retCor();
				//System.out.println("Mudando de cor");
				l1.changeColor(Color.GREEN);
				l1.changeButtonColor(Color.YELLOW);}
			//printer(this.getGraphics());
			repaint();
		}
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		for(TiposSinais l1 : sinalPista){
			if(arg0.getSource() == l1.retButton()){
				//System.out.println("Mudando de cor");
				l1.changeColor(l1.listaSinais.get(0).rettempCor()	);
				l1.changeButtonColor(Color.WHITE);}
		//printer(this.getGraphics());
		repaint();}
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		Point p = arg0.getPoint();
		System.out.println(p.toString());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		String retTest = "";
		for(TiposSinais l1 : sinalPista){
			if(e.getSource() == l1.retButton()){
				if(l1.listaSinais.get(0).rettempCor() == Color.RED){
					l1.changeColor(Color.YELLOW);
					l1.changetempColor(Color.YELLOW);
					l1.setState("ON");
				}
				else if(l1.listaSinais.get(0).rettempCor() == Color.YELLOW){
					l1.changeColor(Color.RED);
					l1.changetempColor(Color.RED);
					l1.setState("OFF");
				}
			}
			retTest = retTest+l1.getNome()+"-"+l1.getState()+"/";
			Av.movePlane();
		//printer(this.getGraphics());
		}
		data.setPistaInfo(retTest);
		System.out.println(retTest);
	}
	
	public void carregaLista(){
		int cont = 0;
		String tipo;
		//Criar a lista que contem todos os tipos de sinais
		sinalPista = new ArrayList<TiposSinais>();	
		//Criar o sinal que vamos adicionar aos tipos de sinais
		TiposSinais sinalLuz1 = new TiposSinais("luz1");
		TiposSinais sinalLuz2 = new TiposSinais("luz2");
		TiposSinais sinalLuz3 = new TiposSinais("luz3");
		TiposSinais sinalLuz4 = new TiposSinais("luz4");
		TiposSinais sinalLuz5 = new TiposSinais("luz5");
		TiposSinais sinalLuz6 = new TiposSinais("luz6");
		TiposSinais sinalLuz7 = new TiposSinais("luz7");
		TiposSinais sinalLuz8 = new TiposSinais("luz8");
		TiposSinais sinalLuz9 = new TiposSinais("luz9");
		TiposSinais sinalLuz10 = new TiposSinais("luz10");

		
		//Adicionar os sinais a lista do tipo de sinal associado
		for(cont = 0;cont<40;cont++)
			sinalLuz1.addSinal();
		for(cont = 0;cont<7;cont++)
			sinalLuz2.addSinal();
		for(cont = 0;cont<7;cont++)
			sinalLuz3.addSinal();
		for(cont = 0;cont<7;cont++)
			sinalLuz4.addSinal();
		for(cont = 0;cont<4;cont++)
			sinalLuz5.addSinal();
		for(cont = 0;cont<13;cont++)
			sinalLuz6.addSinal();
		for(cont = 0;cont<4;cont++)
			sinalLuz7.addSinal();
		for(cont = 0;cont<6;cont++)
			sinalLuz8.addSinal();
		for(cont = 0;cont<12;cont++)
			sinalLuz9.addSinal();
		for(cont = 0;cont<5;cont++)
			sinalLuz10.addSinal();
		
		// "Configurar a posicao x e y dos quadrados de sinais
		int x1,x2,x3,x4,x5,x6,x7,x8,x9,x10;
		int y1,y2,y3,y4,y5,y6,y7,y8,y9,y10;
		
		x1 = 100;y1 = 50;
		x2 = 180;y2 = 120;
		x3 = 420;y3 = 120;
		x4 = 650;y4 = 120;
		x5 = 20;y5 = 50;
		x6 = 360;y6 = 240;
		x7 = 860;y7 = 120;
		x8 = 170;y8 = 180;
		x9 = 370;y9 = 180;
		x10 = 700;y10 = 180;
		
		// Adicionar o tipo do sinal a lista de tipo de sinal
		sinalPista.add(sinalLuz1);
		sinalPista.add(sinalLuz2);
		sinalPista.add(sinalLuz3);
		sinalPista.add(sinalLuz4);
		sinalPista.add(sinalLuz5);
		sinalPista.add(sinalLuz6);
		sinalPista.add(sinalLuz7);
		sinalPista.add(sinalLuz8);
		sinalPista.add(sinalLuz9);
		sinalPista.add(sinalLuz10);
		cont = 0;
		
		// Setar as coordenadas dos sinais
		for( TiposSinais l1 : sinalPista){
			tipo = l1.retType(); 
			switch(tipo){
				case "luz1":
					cont = 0;
					for( Sinais l2 : l1.listaSinais ){
						l2.setCoord(x1+(cont*20),y1);
						cont++;}
					break;
				case "luz2":
					cont = 0;
					for( Sinais l2 : l1.listaSinais ){
						l2.setCoord(x2+(cont*20),y2);
						cont++;}
					break;
				case "luz3":	
					cont = 0;
					for( Sinais l2 : l1.listaSinais ){
						l2.setCoord(x3+(cont*20),y3);
						cont++;}
					break;
				case "luz4":
					cont = 0;
					for( Sinais l2 : l1.listaSinais ){
						l2.setCoord(x4+(cont*20),y4);
						cont++;}
					break;
				case "luz5":
					cont = 0;
					for( Sinais l2 : l1.listaSinais ){
						l2.setCoord(x5,y5+(cont*20));
						cont++;}
					break;
				case "luz6":
					cont = 0;
					for( Sinais l2 : l1.listaSinais ){
						l2.setCoord(x6+(cont*20),y6);
						cont++;}
					break;
				case "luz7":
					cont = 0;
					for( Sinais l2 : l1.listaSinais ){
						l2.setCoord(x7,y7+(cont*20));
						cont++;}
					break;
				case "luz8":
					cont = 0;
					for( Sinais l2 : l1.listaSinais ){
						l2.setCoord(x8+(cont*20),y8);
						cont++;}
					break;
				case "luz9":
					cont = 0;
					for( Sinais l2 : l1.listaSinais ){
						l2.setCoord(x9+(cont*20),y9);
						cont++;}
					break;
				case "luz10":
					cont = 0;
					for( Sinais l2 : l1.listaSinais ){
						l2.setCoord(x10+(cont*20),y10);
						cont++;}
					break;
			}
		}
		
		//Setar o boolean da pista FAZER O SQL AQUI!!
		//String stateON = "ON";
		
		data = new PistaData();
		String [] dataLista1 = data.parse();
		String [] dataLista2 = new String[dataLista1.length*2];
		int j=0;
		for(int i=0;i<dataLista1.length;i++){
			String [] temp = dataLista1[i].split("-");
			for(String s:temp){
				dataLista2[j] = s;
				j++;
			}
		}
		for(TiposSinais s:sinalPista){
			for(int i =0;i<dataLista2.length;i++){
				if(s.getNome().equals(dataLista2[i]))
					s.setState(dataLista2[i+1]);		
			}
		}
		
		//for(TiposSinais s:sinalPista)
			//System.out.println("Situacao das pistas: "+s.getState());
		

		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	@Override
	public void itemStateChanged(ItemEvent arg0) {}
	@Override
	public void mouseClicked(MouseEvent arg0) {}

}

