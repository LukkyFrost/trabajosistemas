package LukkyFrost.cosa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class CosaApplication {
	@RequestMapping("/contar/{palabra}")
	public String contar() {
		String palabra;
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
		public ArrayList<datostabla> listar() {
			return (ArrayList<datostabla>) cosarepository.findAll();
	}
	@RequestMapping("/contar/{Pais}")
	public Paismodelo guardarpais(Paismodelo Pais) {
        return cosarepository.save(Pais);
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
	@RequestMapping("/traduce/{cosa}}")
	public String traducir(String cosa){
    @Autowired
    RestTemplate restTemplate;	 
		return gettraduccion(cosa);
	}
    public String gettraduccion(String cosa) {
        
		String [] cosacortada = cosa.trim();
		for(int i = 0; i< cosacortada.length; i++){
		String url = "https://api.mymemory.translated.net/get?q={"+cosacortada[i]+"}&langpair=es|en";
        traduccion json = restTemplate.getForObject(url);
	}
        System.out.println(json.age);
        return json.traduccion;
    }
}
}

