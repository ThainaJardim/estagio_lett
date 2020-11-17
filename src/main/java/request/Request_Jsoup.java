package request;

import java.io.IOException;
import java.net.Authenticator;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Request_Jsoup extends Authenticator {

    private static String USER_AGENT;

    public static String getUSER_AGENT() {
        return USER_AGENT;
    }

    public void setUSER_AGENT(String USER_AGENT) {
        this.USER_AGENT = USER_AGENT;
    }



    public static Document connect(String link) {
        System.setProperty( "http.proxyhost", "haproxy.lett.global" );
        System.setProperty( "http.proxyport", "3130" );
        System.out.println("Chamando requisição: " + Thread.currentThread().getName() + " " + link);
        try {
            Document document = Jsoup.connect( link )

                    .userAgent( getUSER_AGENT() )
                    .referrer( "http://www.google.com" )
                    .ignoreHttpErrors( true )
//                  .followRedirects( true )
                    .ignoreContentType(true)

                    .get();
            System.out.println("deu tudo ok " + link);
            return document;

        } catch (Exception e){
            System.out.println("Deu erro na url " + link);
            e.printStackTrace();
        }

      return new Document( link );
    }

}

