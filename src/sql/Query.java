package sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import sql.Connect;

public class Query {

	private static Connect con = new Connect();
	
	public Query(){
	}
	
	public boolean checkLogin(String log,String pass){
		PreparedStatement statement = con.getVetordeStatement().get(0);
		try {
			statement.setString(1, log);
			ResultSet result = statement.executeQuery();
			while(result.next()){
				if(result.getString(1).equals(pass))
					return true;
				else
					return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro tentando checkar o login");
			//e.printStackTrace();
		}
		return false;		
	}
	public void getPlaneModelo(String fase,List<String> listaDeInfo){
		
		PreparedStatement statement;

		if(fase.equals("arrival"))
			statement = con.getVetordeStatement().get(1);
		else if(fase.equals("runway"))
			statement = con.getVetordeStatement().get(2);
		else if(fase.equals("departure"))
			statement = con.getVetordeStatement().get(3);
		else
			statement = con.getVetordeStatement().get(4);
		
		try {
			ResultSet result = statement.executeQuery();
			while(result.next()){
				listaDeInfo.add(result.getString(1));
				//System.out.println(fase+result.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro tentando checkar o modelo de "+fase);
			//e.printStackTrace();
		}
	}
	public void getPlaneDO(String fase,List<String> listaDeInfo1,List<String> listaDeInfo2){
		
		PreparedStatement statement;
		if(fase.equals("arrival"))
			statement = con.getVetordeStatement().get(5);
		else if(fase.equals("runway"))
			statement = con.getVetordeStatement().get(6);
		else if(fase.equals("departure"))
			statement = con.getVetordeStatement().get(7);
		else
			statement = con.getVetordeStatement().get(8);
		
		try {
			ResultSet result = statement.executeQuery();
			while(result.next()){
				listaDeInfo1.add(result.getString(1));
				listaDeInfo2.add(result.getString(2));
				//System.out.println(fase+result.getString(1)+result.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro tentando checkar o modelo de "+fase);
			//e.printStackTrace();
		}
	}
	public void getPlaneRegistroID(String stage,List<String> listaDeInfo1){
		PreparedStatement statement = con.getVetordeStatement().get(9);
		try {
			statement.setString(1, stage);
			ResultSet result = statement.executeQuery();
			while(result.next()){
				//System.out.println("RegistroID "+stage+" result.getString(1)");
				listaDeInfo1.add(result.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro tentando checkar o RegistroID das Aeroaves");
			//e.printStackTrace();
		}
	}
	public void setPlanePhase(String newStage,String regID){
		PreparedStatement statement = con.getVetordeStatement().get(10);
		
		try {
			statement.setString(1, newStage);
			statement.setString(2, regID);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Erro na alteracao do Stage");
			e1.printStackTrace();
		}
		try{
			statement.executeUpdate();
			System.out.println("Update feito com sucesso");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public String getPista(){
		PreparedStatement statement = con.getVetordeStatement().get(11);
		String Stages = new String();
		try{
			ResultSet result = statement.executeQuery();
			while(result.next()){
				Stages = result.getString(1);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return Stages;
	}
	public void setPista(String newPista){
		PreparedStatement statement = con.getVetordeStatement().get(12);
		System.out.println("Teste do setPista: "+newPista);
		try {
			statement.setString(1, newPista);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Erro na alteracao do Stage");
			e1.printStackTrace();
		}
		try{
			statement.executeUpdate();
			System.out.println("Update da pista feito com sucesso");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}