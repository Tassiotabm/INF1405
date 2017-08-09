package graphic.window1;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;

public class TiposSinais {
	public ArrayList<Sinais> listaSinais;
	private String type;
	private String state;
	private JButton Button;
	
	public void setState(String newState){
		this.state = newState;
		if(state.equals("ON")){
			this.changeColor(Color.YELLOW);
			this.changetempColor(Color.YELLOW);
		}
		else if(state.equals("OFF")){
			this.changeColor(Color.red);
			this.changetempColor(Color.red);
		}
		else
			this.changeColor(Color.GREEN);
	}
	public String getState(){
		return this.state;
	}
	public String getNome(){
		return type;
	}
	public TiposSinais(String tipo){
		listaSinais = new ArrayList<Sinais>();
		this.type = tipo;
		this.addSinal();
		createButton();
	}
	private void createButton(){
		Button = new JButton();
		Button.setPreferredSize(new Dimension(100,100));
		Button.setBackground(Color.white);
		Button.setText(this.type);
	}
	public JButton retButton(){
		return this.Button;
	}
	public String retType(){
		return this.type;
	}
	public void addSinal(){
		Sinais novo = new Sinais();
		listaSinais.add(novo);
	}
	public void setNameButton(String txt){
		this.Button.setText(txt);
	}
	public void changeColor(Color cor){
		for(Sinais l1 : listaSinais){
			l1.setCor(cor);
		}
	}
	public void changetempColor(Color cor){
		for(Sinais l1 : listaSinais){
			l1.settempCor(cor);
		}
	}
	public void changeButtonColor(Color cor){
		this.Button.setBackground(cor);
	}
}
