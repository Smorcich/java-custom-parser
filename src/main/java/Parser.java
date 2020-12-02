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
        if (matcher.find()) {
            return matcher.group();
        }
        throw new Exception("Cant extract data from string");
    }

    public static void main(String[] args) throws IOException {
    }

    public static String createString() throws IOException {
        Document page = getPage();
        Element main = page.select("div[id=loop-content]").first();
        Elements titles = main.select("h3[class=h5]");

        int number = 0;
        String testStr = "";
        for (Element title : titles) {
            testStr = testStr + "\n " + ((++number) + ". " + title.text());
        }
        return testStr;
    }

    public static String[] linksArray() throws IOException {
        Document page = getPage();
        Element main = page.select("div[id=loop-content]").first();
        Elements titles = main.select("h3[class=h5]");

        int number = 0;
        String[] arr = new String[100];
        String tempTitle = "";
        char[] tempTitleLetters = new char[100];
        char[] titleLetters = new char[100];
        char tempChar = ' ';

        for (Element title : titles) {
            tempTitle = title.text();
            tempTitleLetters = new char[100];
            titleLetters = new char[100];

            for(int i = 0; i < tempTitle.length(); i++){
                tempTitleLetters[i] = tempTitle.charAt(i);
            }

            for (int i = 0; i < tempTitle.length(); i++) {
                tempChar = tempTitleLetters[i];
                if (tempChar == ' ') {
                    tempTitleLetters[i] = '-';
                }
            }
            int k = 0;
            for (int i = 0; i < tempTitle.length(); i++) {
                tempChar = tempTitleLetters[i];
                if (tempChar == '’') {
                } else {
                    titleLetters[k] = tempTitleLetters[i];
                    k++;
                }
            }

            tempTitle = new String(titleLetters);

            arr[number] = "https://toonily.com/"
                    + tempTitle;
            System.out.println(arr[number]);
        }
        return arr;
    }

}
