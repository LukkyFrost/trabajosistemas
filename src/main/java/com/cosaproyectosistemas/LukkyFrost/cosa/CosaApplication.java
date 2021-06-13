package com.cosaproyectosistemas.LukkyFrost.cosa;
import java.util.ArrayList;

import com.cosaproyectosistemas.LukkyFrost.cosa.Services.TranslateService;
import com.cosaproyectosistemas.LukkyFrost.cosa.models.Paismodelo;
import com.cosaproyectosistemas.LukkyFrost.cosa.repositories.CosaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@SpringBootApplication
@RestController
public class CosaApplication {
	@Autowired 
	TranslateService translateService;
	ArrayList<String> datos;
	@Autowired
    private CosaRepository cosarepository;
	@RequestMapping("/contar/{palabra}")
	public String contar(@PathVariable String palabra) {
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
	@GetMapping("/listar")
		public ArrayList<Paismodelo> listar() {
			return (ArrayList<Paismodelo>) 	cosarepository.findAll();
	}
	@GetMapping("/guarda")
	public void datos(@RequestParam String Pais,@RequestParam String Capital) {
		Paismodelo paismodelo = new Paismodelo();
		paismodelo.setpais(Pais);
		paismodelo.setcapital(Capital);
        cosarepository.save(paismodelo);
		}
	
	@GetMapping("/{texto}")
	public String transformconsonantintos(@PathVariable String texto) {
		char [] equalslowercase = {'b','c','d','f','g','h','j','q','l','m','n','ñ','p','q','r','t','v','w','x','y','z'};
		char [] equalscapital = {'B','C','D','F','G','H','J','Q','L','M','N','Ñ','P','Q','R','T','V','W','X','Y','Z'};
	for (int i = 0; i < 21; i++) {
		texto=texto.replace(equalslowercase[i], 's');
		texto=texto.replace(equalscapital[i], 'S');
		}
		return texto;
	}
	/*@GetMapping("/traduce/{texto}")
	public String espaingles(@PathVariable String texto) {
	return traduccion.gettraduccion(texto);
	}*/
	@GetMapping("/traduce/{text}")
    public String traducirTexto(@PathVariable String text){
        return translateService.translate(text);
    }
}
