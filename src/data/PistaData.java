package data;

import sql.Query;

public class PistaData {
	
	private static Query pistaQuery = new Query();
	private String pistaInfo = new String();
	
	public PistaData(){
		this.pistaInfo = pistaQuery.getPista();
	}
	public String getPistaInfo(){
		return this.pistaInfo;
	}
	public void setPistaInfo(String s){
		this.pistaInfo = s;
		pistaQuery.setPista(s);
	}
	public String[] parse(){
		String [] lista = this.pistaInfo.split("/");
		return lista;
	}
}
