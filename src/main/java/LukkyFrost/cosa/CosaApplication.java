package LukkyFrost.cosa;
import java.util.ArrayList;
import models.Paismodelo;
import repositories.CosaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class CosaApplication {
	ArrayList<String> datos;
	@Autowired
    private CosaRepository cosarepository;
	@RequestMapping("/contar/{palabra}")
	public String contar() {
		String palabra = "";
		char[] letras = palabra.toCharArray();
		int [] resultvocalconso = {0,0};
		for (int i = 0; i< palabra.length(); i++){
			if(letras[i]=='a'||letras[i]=='e'||letras[i]=='i'||letras[i]=='o'||letras[i]=='u'){
				resultvocalconso[0]++;
			}
			else{resultvocalconso[1]++;}
		}
		return "la palabra tiene: "+ resultvocalconso[0]+" vocales y "+resultvocalconso[1]+" consonantes";
	}
	@RequestMapping("/listar")
		public ArrayList<Paismodelo> listar() {
			return (ArrayList<Paismodelo>) 	cosarepository.findAll();
	}
	@RequestMapping("/guarda")
	public void datos(@RequestParam String cosa) {
		cosa.split("&");
		for(int i=0; i<cosa.length(); i++ ){
			String [] informacion = cosa.split("=");
			Paismodelo paismodelo = new Paismodelo();
		paismodelo.setPais(informacion[0]);
		paismodelo.setCapital(informacion[1]);
        cosarepository.save(paismodelo);
		}
		
    }
	@RequestMapping("/{texto}")
	public String transformconsonantintos(String texto) {
		char [] equalslowercase = {'b','c','d','f','g','h','j','q','l','m','n','ñ','p','q','r','t','v','w','x','y','z'};
		char [] equalscapital = {'B','C','D','F','G','H','J','Q','L','M','N','Ñ','P','Q','R','T','V','W','X','Y','Z'};
	for (int i = 0; i < 21; i++) {
		texto=texto.replace(equalslowercase[i], 'S');
		texto=texto.replace(equalscapital[i], 's');
		}
		return texto;
	}
	@RequestMapping("/traduce/{texto}")
	public void espaingles(String texto) {
	System.out.println(Services.traduccion.gettraduccion(texto));
	}
}