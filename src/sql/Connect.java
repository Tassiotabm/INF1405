package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class Connect {

	private static Connection con;
	private static Vector <PreparedStatement> vetordeStatement = new Vector<PreparedStatement>();
	
	public Connect(){
		  
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airport_control","controlador","inf1405");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Problema na conection do servidor");
			return;
			//e1.printStackTrace();
		}
		try {
			Generate_Statements(con);
		} catch (SQLException e) {
			System.out.println("Erro na criação dos Statements.");
			return;
			//e.printStackTrace();
		}
	}
	private void Generate_Statements(Connection connection)throws SQLException{
		  vetordeStatement.add(connection.prepareStatement("SELECT senha FROM controlador WHERE login=?"));	 	//0	  
		  vetordeStatement.add(connection.prepareStatement("SELECT * FROM MODELO_ARRIVAL"));	//1
		  vetordeStatement.add(connection.prepareStatement("SELECT * FROM MODELO_RUNWAY"));		//2
		  vetordeStatement.add(connection.prepareStatement("SELECT * FROM MODELO_DEPARTURE"));	//3
		  vetordeStatement.add(connection.prepareStatement("SELECT * FROM MODELO_OVERFLIGHT")); //4
		  vetordeStatement.add(connection.prepareStatement("SELECT * FROM ARRIVAL_DO"));		//5
		  vetordeStatement.add(connection.prepareStatement("SELECT * FROM RUNWAY_DO"));			//6
		  vetordeStatement.add(connection.prepareStatement("SELECT * FROM DEPARTURE_DO"));		//7
		  vetordeStatement.add(connection.prepareStatement("SELECT * FROM OVERFLIGHT_DO"));		//8
		  vetordeStatement.add(connection.prepareStatement("SELECT ID FROM REGISTRO WHERE ID IN "
		  		+ "(SELECT REGISTRO_ID FROM STAGE WHERE STAGE_AERONAVE=?)"));					//9
		  vetordeStatement.add(connection.prepareStatement("UPDATE stage SET Stage_Aeronave = ?"
		  		+ " WHERE REGISTRO_ID = ?")); //10
		  vetordeStatement.add(connection.prepareStatement("SELECT MODE FROM PISTA WHERE ID='1000'"));		//11
		  vetordeStatement.add(connection.prepareStatement("UPDATE pista set mode = ? WHERE ID='1000'"));	//12

	}
	public static Connection getCon() {
		return con;
	}
	public Vector<PreparedStatement> getVetordeStatement() {
		return vetordeStatement;
	}
	
}
