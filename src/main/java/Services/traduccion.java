package Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

class cosatraduccion {
    public String cosa;
    public String traduccosa;
}

@Service
public class traduccion {

    @Autowired
    static
    RestTemplate restTemplate;	 

public static String gettraduccion(String cosa){
    String url = "https://api.mymemory.translated.net/get?q=Hola&langpair=es|en";
    cosatraduccion algo = restTemplate.getForObject(url, cosatraduccion.class);
    System.out.println(algo.cosa);
    return algo.traduccosa;
    }
}
