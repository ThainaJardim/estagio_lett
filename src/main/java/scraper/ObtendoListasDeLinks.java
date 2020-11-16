package scraper;

import org.jsoup.nodes.Document;
import request.Request_Jsoup;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ObtendoListasDeLinks {

    Set<String> pesquisas = new LinkedHashSet<>();
    String URL = "https://www.magazineluiza.com.br/";

    ScraperJsoup scraper = new ScraperJsoup();
    public Set<String> obtendoLinks(Set<String> pesquisas, String URL) throws IOException {

        Document htmlJsoup = Request_Jsoup.connect( URL );
        List<String> linkNovos = scraper.getLinkJsoup( htmlJsoup );
        pesquisas.addAll( linkNovos );

        return pesquisas;
    }




}



