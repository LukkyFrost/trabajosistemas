package com.cosaproyectosistemas.LukkyFrost.cosa.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
/*
class cosatraduccion {
    public String traduccosa;
}
class parafarmalia {
    public cosatraduccion pepino;
}
@Service
public class Traduccion{

    @Autowired
    RestTemplate restTemplate;	 

public String gettraduccion(String cosa){
    String url = "https://api.mymemory.translated.net/get?q="+cosa+"&langpair=es|en";
    parafarmalia algo = restTemplate.getForObject(url, parafarmalia.class);
    System.out.println(algo);
    return algo.pepino.traduccosa;

    }
}
*/

class caca{
    public String translatedText;
}

class Response{
    public caca responseData;
    
}

@Service
public class TranslateService {

    @Autowired
    RestTemplate restTemplate;

    public String translate(String text) {
        String url = "https://api.mymemory.translated.net/get?q=" + text + "&langpair=es|en";
        Response json = restTemplate.getForObject(url, Response.class);   
        return json.responseData.translatedText;
    }

}