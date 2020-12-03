import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DvachParser {

    private static Document getPage() throws IOException {
        String url = "https://2ch.hk/b/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    private static Pattern pattern = Pattern.compile("\\d{9}");

    private static String getFromPostNumberFromString(String str) throws Exception {
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()) {
            return matcher.group();
        }
        throw new Exception("Cant extract data from string");
    }

    public static void main(String[] args) throws Exception {
        int number = 0;
        int i = 0;
        String titleText;
        String[] postNumber = new String[100];

        Document page = getPage();
        Element main = page.select("div[class=cntnt]").first();
        Elements titles = main.select("article[class=post__message post__message_op]");
        Elements posts = main.select("div[class=thread]");

        for (Element post: posts) {
            postNumber[i] = getFromPostNumberFromString(post.text());
            i++;
        }
        i = 0;
        for (Element title: titles) {
            titleText = title.text();
            number++;
            System.out.println(number + ". " + titleText +
                    " https://2ch.hk/b/res/" + postNumber[i] +
                    ".html");
            i++;
        }
    }

    public static String getDvachParserString() throws Exception {
        int number = 0;
        int i = 0;
        String titleText = "";
        String[] postNumber = new String[100];

        Document page = getPage();
        Element main = page.select("div[class=cntnt]").first();
        Elements titles = main.select("article[class=post__message post__message_op]");
        Elements posts = main.select("div[class=thread]");

        for (Element post: posts) {
            postNumber[i] = getFromPostNumberFromString(post.text());
            i++;
        }
        i = 0;
        for (Element title: titles) {
            titleText = title.text();
            number++;
            titleText = number + ". " + titleText +
                    " https://2ch.hk/b/res/" + postNumber[i] +
                    ".html";
            i++;
        }
        return titleText;
    }
}