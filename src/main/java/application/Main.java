package application;

import request.Request_Jsoup;
import scraper.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) throws NumberFormatException {

        Thread crawl1 = new Thread( new Crawler() );
        Thread crawl2 = new Thread( new Crawler() );

        crawl1.start();
        crawl2.start();
//



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




