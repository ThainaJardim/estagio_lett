package scraper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Scraper {


    public static boolean  pageOfProduct (String html, String pageProduct) {
        if (html.contains(pageProduct)) {
                System.out.println("Esta pagína é de um produto");

        } else {
            System.out.println("Esta página não é de um produto");
        } return true;

    }

    public static boolean productIsAvailable (String html, String available) {
        if (html.contains( available )) {
            System.out.println( "Este produto está disponível para compra" );

        } else {
        } return false;
    }

    public static void pattern (String html, String s) {
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}


