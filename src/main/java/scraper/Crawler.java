package scraper;

import org.jsoup.nodes.Document;
import request.Request_Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Crawler implements Runnable {


    private static List<String> pesquisas = new ArrayList<>();
    String homePage = "https://www.magazineluiza.com.br/";
    private static List<String> produtos = new ArrayList<>();
    private static List<String> linksConhecidos = new ArrayList<>();

    ScraperJsoup scraper = new ScraperJsoup();

    Request_Jsoup request_jsoup = new Request_Jsoup();

    public List<String> fistRequest() throws IOException {
        request_jsoup.setUSER_AGENT( "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:47.0) Gecko/20100101 Firefox/47.0" );
        Document htmlJsoup = Request_Jsoup.connect( homePage );
        List<String> linkNovos = scraper.getLinkJsoup( htmlJsoup );
        return linkNovos;
    }

    public void armazenandoLinksDeProdutos(String link) throws IOException {
        if (linksConhecidos.size() %2 == 0) {
            request_jsoup.setUSER_AGENT( "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:47.0) Gecko/20100101 Firefox/47.0" );
        }else{
            request_jsoup.setUSER_AGENT( "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_5) AppleWebKit/601.6.17 (KHTML, like Gecko) Version/9.1.1 Safari/601.6.17" );
        }
        Document html = Request_Jsoup.connect( link );
        List<String>links = scraper.getLinkJsoup( html );
        novosLinks( links );
        if (ScraperJsoup.isProduct( html ) && produtos.size() < 10000) {
            System.out.println( "Este link é de um produto, chamado pela thread: " + Thread.currentThread().getName() + " " + link );
            produtos.add( link );
        } else{
            linksConhecidos.add(link);
        }
    }


    public void novosLinks(List<String> links){
        for(String s : links){
            if(!linksConhecidos.contains( s ) && !pesquisas.contains( s )){
                pesquisas.add( s );
            }
        }
    }

    public void linksDeProdutos(){
        while (pesquisas.size() > 0 && produtos.size() < 10000) {
            String link = pesquisas.remove( 0 );
            try {
                armazenandoLinksDeProdutos( link );
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Finalizado com a lista de pesquisas de: " + pesquisas.size() + "produtos: "+ produtos + "e links visitados: " + linksConhecidos.size() + " " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        try {
            Thread.sleep( 500 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> links = null;
        try {
            links = fistRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }
        novosLinks( links );
        linksDeProdutos();
    }
}
