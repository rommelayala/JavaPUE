package leeconfig;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;

public class LeeConfig {

	String cad;
	ArrayList<String> DatosConfig = new ArrayList<>();

	public void leeArchivo() {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream("config.txt")));

			while ((cad = br.readLine()) != null)
				for (int i = 0; i < 2; i++) {

					DatosConfig.add(cad.split(" ")[i]);
				}
			br.close();
		} catch (IOException e) {
			System.out.println("Error E/S");
			e.printStackTrace();
		}
		// muestra elementos de la lista
		for (String n : DatosConfig) {
			System.out.println(n);
		}
	}
	
	public void calculaSemanas(String mes){
		//pasa de string a calendar
		
	}

}
