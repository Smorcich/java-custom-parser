import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class Parser {

    private static Document getPage() throws IOException {
        String url = "https://toonily.com/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    private static Pattern pattern = Pattern.compile("\\d{9}");

    private static String getLink(String str) throws Exception {
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()) {
            return matcher.group();
        }
        throw new Exception("Cant extract data from string");
    }
    public static void main(String[] args) throws IOException {
        Document page = getPage();
        Element main = page.select("div[id=loop-content]").first();
        Elements titles = main.select("h3[class=h5]");
        /*for (Element title : titles) {
            try {
                String postName = getLink(title.text());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         */
        int number = 0;
        for (Element title : titles) {
            System.out.println((++number) + ". " + title.text()
                    + " (" + "https://toonily.com/"
                    + title.text() +  ".html" + ")");
        }
    }

}
