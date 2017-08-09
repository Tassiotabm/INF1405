package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sql.Query;

final class Acesso{
	private static boolean acess;
	private static Query q;
	
	private Acesso(){
	}
	public static boolean sendInfo(String login,String senha)throws Exception{
		//Receber o password e login
		try{
			q = new Query();
		}
		catch(Exception e){
			return false;
		}
		//if(login.equals(""))
			//return true;
		//System.out.println("Recebendo pass");
		acess = q.checkLogin(login,senha);
		return acess;
	}
	public static boolean checkAcess(String login,String senha) throws SQLException{
		//Checar se o acesso é permitido com SQL em um futuro proximo
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airport_control"
				,"controlador","inf1405");
		
		PreparedStatement statement = con.prepareStatement("SELECT senha FROM controlador WHERE login=?");
		statement.setString(1, login);
		ResultSet result = statement.executeQuery();
		while(result.next()){
			if(result.getString(1).equals(senha))
				return true;
			else
				return false;
		}
		return false;
	}
	
}
