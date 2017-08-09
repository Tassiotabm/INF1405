package data;

import java.util.ArrayList;
import java.util.List;

import sql.Query;

public class AllPlanes {
	
	private static Query planeQuery = new Query();
	
	private static List<List<String>> Arrival = new ArrayList<List<String>>();
	private static List<List<String>> Departure = new ArrayList<List<String>>();
	private static List<List<String>> Overflight = new ArrayList<List<String>>();
	private static List<List<String>> Runway = new ArrayList<List<String>>();
	
	public AllPlanes(){
		generatePlanesArrival();
		generatePlanesDeparture();
		generatePlanesOverflight();
		generatePlanesRunway();
	}
	private static void generatePlanesArrival(){
		

		List<String> modelo = new ArrayList<String>();
		List<String> origem = new ArrayList<String>();
		List<String> destino = new ArrayList<String>();
		List<String> registroID = new ArrayList<String>();	
		
		planeQuery.getPlaneModelo("arrival",modelo);
		planeQuery.getPlaneDO("arrival",origem, destino);
		planeQuery.getPlaneRegistroID("arrival", registroID);
		
		Arrival.add(modelo);
		Arrival.add(origem);
		Arrival.add(destino);
		Arrival.add(registroID);
	}
	private static void generatePlanesDeparture(){
	
		List<String> modelo = new ArrayList<String>();
		List<String> origem = new ArrayList<String>();
		List<String> destino = new ArrayList<String>();
		List<String> registroID = new ArrayList<String>();	
	
		planeQuery.getPlaneModelo("departure",modelo);
		planeQuery.getPlaneDO("departure",origem, destino);
		planeQuery.getPlaneRegistroID("departure", registroID);

		Departure.add(modelo);
		Departure.add(origem);
		Departure.add(destino);
		Departure.add(registroID);
	}
	private static void generatePlanesOverflight(){
		
		List<String> modelo = new ArrayList<String>();
		List<String> origem = new ArrayList<String>();
		List<String> destino = new ArrayList<String>();
		List<String> registroID = new ArrayList<String>();	
	
		planeQuery.getPlaneModelo("overflight",modelo);
		planeQuery.getPlaneDO("overflight",origem, destino);
		planeQuery.getPlaneRegistroID("overflight",registroID);
		
		Overflight.add(modelo);
		Overflight.add(origem);
		Overflight.add(destino);
		Overflight.add(registroID);
	}
	private static void generatePlanesRunway(){
	
		List<String> modelo = new ArrayList<String>();
		List<String> origem = new ArrayList<String>();
		List<String> destino = new ArrayList<String>();
		List<String> registroID = new ArrayList<String>();	
	
		planeQuery.getPlaneModelo("runway",modelo);
		planeQuery.getPlaneDO("runway",origem, destino);
		planeQuery.getPlaneRegistroID("runway",registroID);
		
		Runway.add(modelo);
		Runway.add(origem);
		Runway.add(destino);
		Runway.add(registroID);
	}
	public static Query getPlaneQuery() {
		return planeQuery;
	}
	public static List<List<String>> getArrival() {
		return Arrival;
	}
	public static List<List<String>> getDeparture() {
		return Departure;
	}
	public static List<List<String>> getOverflight() {
		return Overflight;
	}
	public static List<List<String>> getRunway() {
		return Runway;
	}
	public static void sendToBD(String newPhase,String registroID){
		planeQuery.setPlanePhase(newPhase,registroID);
	}
	public static void refresh(){
		generatePlanesArrival();
		generatePlanesDeparture();
		generatePlanesOverflight();
		generatePlanesRunway();
	}
}