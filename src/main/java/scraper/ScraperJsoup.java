package scraper;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ScraperJsoup {

    public ScraperJsoup(String s) {
    }

    public ScraperJsoup() {

    }

    public static void busca(Document htmlJsoup, String s) {
        String nome;
        Elements tags = htmlJsoup.select(s);
        Element tag = tags.first();
        nome = tag.text();
        System.out.println(nome);
    }

    public static void busca2( Document htmlJsoup, String s) {
        String elements = htmlJsoup.select( s ).select( "img" ).attr( "src" ) ;
        System.out.println(elements);
    }

    public static boolean isProduct (Document htmlJsoup){
        return htmlJsoup.select("[class^=header-product__title]").size() > 0;
    }

    public List<String> getLinkJsoup(Document htmlJsoup){
        List<String> strings = new ArrayList<>();
        Elements elements = htmlJsoup.select("[href^=https://www.magazineluiza.com.br]");
        for (Element element : elements) {
            strings.add(element.attr("href"));
        }
        return strings;
    }


}
