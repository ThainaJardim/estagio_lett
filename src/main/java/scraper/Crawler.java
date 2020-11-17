package scraper;

import org.jsoup.nodes.Document;
import request.Request_Jsoup;

import java.io.IOException;
import java.util.*;


public class Crawler implements Runnable {

    private static final int QUANTIDADE = 10000;
    public static List<String> pesquisas = new ArrayList<>();
    public static Set<String> produtos = new LinkedHashSet();
    public static Set<String> linksConhecidos = new HashSet<>();

    public Crawler(){
    }

    public Crawler(String url){
        this.pesquisas.add(url);
    }

    ScraperJsoup scraper = new ScraperJsoup();

    Request_Jsoup request_jsoup = new Request_Jsoup();

    public List<String> fistRequest(String url) throws IOException {
        request_jsoup.setUSER_AGENT( "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:47.0) Gecko/20100101 Firefox/47.0" );
        Document htmlJsoup = Request_Jsoup.connect( url );
        List<String> linkNovos = scraper.getLinkJsoup( htmlJsoup );
        return linkNovos;
    }

    public void armazenandoLinksDeProdutos(String link) throws IOException {
        if (produtos.size() %2 == 0) {
            request_jsoup.setUSER_AGENT( "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:47.0) Gecko/20100101 Firefox/47.0" );
        }else{
            request_jsoup.setUSER_AGENT( "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_5) AppleWebKit/601.6.17 (KHTML, like Gecko) Version/9.1.1 Safari/601.6.17" );
        }
          Document html = Request_Jsoup.connect( link );
//        List<String>links = scraper.getLinkJsoup( html );
//        novosLinks( links );
        if (ScraperJsoup.isProduct( html ) && produtos.size() < QUANTIDADE) {
            System.out.println( "Este link é de um produto: " + link );
            produtos.add( link );
        }
    }


    public void novosLinks(List<String> links){
        for(String s : links){
            if(linksConhecidos.add(s)){
                try {
                    armazenandoLinksDeProdutos( s );
                } catch (IOException e) {
                    e.printStackTrace();
                }
                pesquisas.add( s );
            }
        }
    }



    @Override
    public void run() {
        while (pesquisas.size() > 0 && produtos.size()<QUANTIDADE) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<String> links = null;
            try {
                links = fistRequest(pesquisas.remove(0));
            } catch (IOException e) {
                e.printStackTrace();
            }
            novosLinks(links);
        }
    }
}
