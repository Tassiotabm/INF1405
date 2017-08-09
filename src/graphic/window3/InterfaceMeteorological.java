package graphic.window3;
import java.io.IOException;
import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import data.MeteorologicalData;


@SuppressWarnings("serial")
public class InterfaceMeteorological extends JFrame {

	private MeteorologicalData data;
	private String [] dataString;
	private InterfaceStruct skeleton;
	
	public InterfaceMeteorological(){
		
		try {
			data = new MeteorologicalData();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataString = data.getMeteoData();
	    skeleton = new InterfaceStruct(dataString);
        skeleton.setVisible(true);
    }
}
