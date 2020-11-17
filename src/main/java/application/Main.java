package application;

import request.Request_Jsoup;
import scraper.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) throws NumberFormatException {

        Crawler crawl1 = new Crawler("https://www.magazineluiza.com.br/complemento-alimentar-adulto/mercado/s/me/cmaa/");
        Thread t1 = new Thread(crawl1);

        Crawler crawl2 = new Crawler("https://www.magazineluiza.com.br/eletrodomesticos/l/ed/");
//        crawl2.setHomePage(  );
        Thread t2 = new Thread(crawl2);

        Crawler crawl3 = new Crawler("https://www.magazineluiza.com.br/decoracao/l/de/");
//        crawl3.setHomePage( "https://www.magazineluiza.com.br/decoracao/l/de/" );
        Thread t3 = new Thread(crawl3);

        Crawler crawl4 = new Crawler("https://www.magazineluiza.com.br/ar-e-ventilacao/l/ar/");
//        crawl4.setHomePage( "https://www.magazineluiza.com.br/ar-e-ventilacao/l/ar/" );
        Thread t4 = new Thread(crawl4);

        Crawler crawl5 = new Crawler("https://www.magazineluiza.com.br/games/l/ga/" );
//        crawl5.setHomePage( "https://www.magazineluiza.com.br/games/l/ga/" );
        Thread t5 = new Thread(crawl5);


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

//
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Finalizado com a lista de pesquisas de: " + Crawler.pesquisas.size()+ " produtos: "+ Crawler.produtos.size() + " e links visitados: " + Crawler.linksConhecidos.size() );

    }
}

//                Product product = new Product();
//
//                Scraper.pageOfProduct(html, product.setPageProduct( "pagetype: 'product'" ) );
//                Scraper.productIsAvailable( html, product.setAvailable( "'stockAvailability': true"));
//                Scraper.pattern(html, product.setTagName("<h1 class=\"header-product__title\">(.*?)</h1>"));
//                Scraper.pattern(html, product.setTagPrice("<span class=\"price-template__text\">(.*?)</span>"));
//                Scraper.pattern(html, product.setTagImage("(?:showcase-product__big-img.*?src=)\"(.+?)\""));
//
//                Product productJsoup = new Product( );
//                ScraperJsoup.busca( htmlJsoup, productJsoup.setTagName("body > div.wrapper__main > div.wrapper__content.js-wrapper-content > div.wrapper__control > div.header-product.js-header-product > h1") );
//                ScraperJsoup.busca( htmlJsoup, productJsoup.setTagPrice("body > div.wrapper__main > div.wrapper__content.js-wrapper-content > div.wrapper__control > div.wrapper-product__content.wrapper-product__box-prime > div.wrapper-product__informations.js-block-product > div.information-values__product-page > div > div > div > span.price-template__text") );
//                ScraperJsoup.busca2( htmlJsoup, productJsoup.setTagImage( "[class^=showcase-product__big]" ) );
//                ScraperJsoup.isProduct( htmlJsoup );
//
//
//        try {
//            FileOutputStream arq = new FileOutputStream("teste.txt");
//            ObjectOutputStream obj = new ObjectOutputStream(arq);
//            obj.writeObject(htmlJsoup);
//            System.out.println("Salvo em diretório com sucesso!");
//        } catch ( Exception e) {
//            System.out.println("Erro ao salvar a conteúdo da página");
//        }




