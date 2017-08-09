package graphic.window2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import data.AllPlanes;

public class InterfaceState extends JFrame{


	private static final long serialVersionUID = 1L;
	private static int numberOfClicks = 0;
	private static PlanePanel tempPlane;
	private static List<PlanePanel> subPainelsArrival = new ArrayList<PlanePanel>();
	private static List<PlanePanel> subPainelsRunway = new ArrayList<PlanePanel>();
	private static List<PlanePanel> subPainelsDeparture = new ArrayList<PlanePanel>();
	private static List<PlanePanel> subPainelsOverFlight = new ArrayList<PlanePanel>();
	private static JScrollPane scrollPane1;
	private static JScrollPane scrollPane2;
	private static JScrollPane scrollPane3;
	private static JScrollPane scrollPane4;
	private static JPanel panel1 = new JPanel();
	private static JPanel panel2 = new JPanel();
	private static JPanel panel3 = new JPanel();
	private static JPanel panel4 = new JPanel();

	@SuppressWarnings("unused")
	private static AllPlanes planes; 
	
	GridLayout layout = new GridLayout();
	private static JPanel arrivalP,runwayP,departureP,overflightP;
	
	public InterfaceState(){
		super("Controle de Pista de Aeroporto");
		
		planes = new AllPlanes();

		
		layout.setColumns(2);
		layout.setRows(2);
		layout.setHgap(10);
		layout.setVgap(10);
		
		setAllPanels();
				
		this.setLayout(layout);
		this.setBackground(Color.BLACK);
		this.setForeground(Color.BLACK);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}
	public void setAllPanels(){
		setArrivalP();
		setRunwayP();
		setDepartureP();
		setOverflightP();
	}
	public void setArrivalP(){
		arrivalP = new JPanel(null);
		arrivalP.setName("arrivalP");
        panel1.setLayout(new GridLayout(20,1));
        
        for (int i = 0; i< AllPlanes.getArrival().get(0).size(); i++) {
        	PlanePanel temp = new PlanePanel(panel1,i,Color.GREEN,subPainelsArrival);
        	temp.setJFrame(this);
        	temp.setPanelText("arrival", AllPlanes.getArrival().get(0).get(i),
        			AllPlanes.getArrival().get(1).get(i),
        			AllPlanes.getArrival().get(2).get(i),
        			AllPlanes.getArrival().get(3).get(i));
        	subPainelsArrival.add(temp);
            panel1.add(subPainelsArrival.get(i));
        }
        
		scrollPane1 = new JScrollPane(panel1);
		scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane1.setBounds(0, 0,450,373);
		scrollPane1.setBackground(Color.white);
		
		arrivalP.setPreferredSize(new Dimension(450,400));
		arrivalP.add(scrollPane1);
		this.add(arrivalP);
	}
	public void setRunwayP(){
		runwayP = new JPanel(null);
		runwayP.setName("runwayP");
        
        panel2.setLayout(new GridLayout(20,1));

        for (int i = 0; i< AllPlanes.getRunway().get(0).size(); i++) {
        	PlanePanel temp = new PlanePanel(panel2,i,Color.GRAY,subPainelsRunway);
        	temp.setJFrame(this);
        	temp.setPanelText("runway", AllPlanes.getRunway().get(0).get(i),
        			AllPlanes.getRunway().get(1).get(i), 
        			AllPlanes.getRunway().get(2).get(i),
        			AllPlanes.getRunway().get(3).get(i));
        	subPainelsRunway.add(temp);
            panel2.add(subPainelsRunway.get(i));
        }
        
        
		scrollPane2 = new JScrollPane(panel2);
		scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setBounds(0, 0,450,373);
		scrollPane2.setBackground(Color.white);
		
		runwayP.setPreferredSize(new Dimension(450,400));
		runwayP.add(scrollPane2);
		this.add(runwayP);
	}
	public void setDepartureP(){
		departureP = new JPanel(null);
		departureP.setName("departure");
		
		panel3.setLayout(new GridLayout(20,1));
        
		for (int i = 0; i <  AllPlanes.getDeparture().get(0).size() ; i++) {
        	PlanePanel temp = new PlanePanel(panel3,i,Color.BLUE,subPainelsDeparture);
        	temp.setPanelText("departure", AllPlanes.getDeparture().get(0).get(i),
        			AllPlanes.getDeparture().get(1).get(i),
        			AllPlanes.getDeparture().get(2).get(i),
        			AllPlanes.getDeparture().get(3).get(i));
        	temp.setJFrame(this);
        	subPainelsDeparture.add(temp);
        	panel3.add(subPainelsDeparture.get(i));
        }
                
		scrollPane3 = new JScrollPane(panel3);
		//scrollPane3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane3.setBounds(0, 0,450,373);
		scrollPane3.setBackground(Color.white);
		
		departureP.setPreferredSize(new Dimension(450,400));
		departureP.add(scrollPane3);

		this.add(departureP);
	}
	public void setOverflightP(){
		overflightP = new JPanel(null);		
		
		panel4.setLayout(new GridLayout(20,1));
        for (int i = 0; i < AllPlanes.getOverflight().get(0).size(); i++) {
        	PlanePanel temp = new PlanePanel(panel4,i,Color.darkGray,subPainelsOverFlight);
        	temp.setJFrame(this);
        	temp.setPanelText("overflight", AllPlanes.getOverflight().get(0).get(i),
        			 AllPlanes.getOverflight().get(1).get(i),
        			 AllPlanes.getOverflight().get(2).get(i),
        			 AllPlanes.getOverflight().get(3).get(i));
        	subPainelsOverFlight.add(temp);
            panel4.add(subPainelsOverFlight.get(i));
        }
                
		scrollPane4 = new JScrollPane(panel4);
		//scrollPane3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane4.setBounds(0, 0,450,373);
		scrollPane4.setBackground(Color.white);
		
		overflightP.setPreferredSize(new Dimension(450,400));
		overflightP.add(scrollPane4);
 		this.add(overflightP);
	}
	public void changePlanePanel(PlanePanel planeClicado, JPanel PainelLista,List<PlanePanel> listaDePlanes){
		if(numberOfClicks == 0){
			numberOfClicks++;
			tempPlane = planeClicado;
			System.out.println("Removendo: "+planeClicado.getNumber());
			PainelLista.remove(planeClicado.getNumber());	//Remover o PlanePanel clicado
			listaDePlanes.remove(planeClicado.getNumber());
			
			int a = 0;
			for(PlanePanel jst : listaDePlanes){
				jst.setNumber(a);
				a++;
			}
			
			revalidate();
			repaint();
		}
		else{
			System.out.println("Adicionando: "+planeClicado.getNumber());
			numberOfClicks = 0;
			tempPlane.setC(planeClicado.getC());
			tempPlane.setName(planeClicado.getName());
			PainelLista.add(tempPlane);
			tempPlane.setJPanelAtual(PainelLista);
			listaDePlanes.add(tempPlane);
			
			int a = 0;
			//System.out.println("Size da lista: "+j1.size());
			for(PlanePanel jst : listaDePlanes){
				jst.setNumber(a);
				//System.out.println("elementos: "+jst.getNumber());
				a++;
			}
			
			//System.out.println("Teste BD: ");
			//System.out.println("Stage enviado para o BD: "+t.getName());
			//System.out.println("Registro sendo enviado para o BD: "+tempPlane.getjTextArea4().getText());
			
			AllPlanes.sendToBD(planeClicado.getName(),tempPlane.getjTextArea4().getText());
			AllPlanes.refresh();
			
			tempPlane = null;
			
			revalidate();
			repaint();
		}
	}
}

