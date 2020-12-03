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

    private static Document getPage(String url) throws IOException {
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

    public static void main(String[] args) throws IOException {

    }

    private Elements titles;
    private Elements posts;

    public void setElements(Elements titles) {
        this.titles = titles;
    }

    public void setElements(Elements titles, Elements posts) {
        this.titles = titles;
        this.posts = posts;
    }

    public String createString() throws IOException {
        Document page = getPage("https://toonily.com/");
        Element main = page.select("div[id=loop-content]").first();
        Elements titles = main.select("h3[class=h5]");
        setElements(titles);

        int number = 0;
        String testStr = "";
        for (Element title : titles) {
            testStr = testStr + "\n " + ((number++) + ". " + title.text());
        }
        return testStr;
    }

    public String[] linksArray() throws IOException {
        Document page = getPage("https://toonily.com/");
        Element main = page.select("div[id=loop-content]").first();

        int number = 0;
        String[] arr = new String[100];
        String tempTitle = "";
        char[] tempTitleLetters = new char[100];
        char[] titleLetters = new char[100];
        char tempChar = ' ';

        for (Element title : titles) {
            tempTitle = title.text();
            tempTitleLetters = new char[tempTitle.length()];
            titleLetters = new char[tempTitle.length()];

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

            arr[number] = "https://toonily.com/" + tempTitle;
            number++;
        }
        return arr;
    }

    public String getDvachParserString() throws Exception {
        int number = 0;
        int i = 0;
        String titleText = "";
        String[] postNumber = new String[100];
        String readyStr = "";
        char[] charArr = new char[100];

        Document page = getPage("https://2ch.hk/b/");
        Element main = page.select("div[class=cntnt]").first();
        Elements titles = main.select("article[class=post__message post__message_op]");
        Elements posts = main.select("div[class=thread]");
        setElements(titles, posts);

        for (Element post: posts) {
            postNumber[i] = getFromPostNumberFromString(post.text());
            i++;
        }
        i = 0;
        for (Element title: titles) {
            titleText = title.text();
            if (titleText.length() > charArr.length) {
                for (int k = 0; k < charArr.length; k++) {
                    charArr[k] = titleText.charAt(k);
                }
            } else {
                for (int k = 0; k < titleText.length(); k++) {
                    charArr[k] = titleText.charAt(k);
                }
            }
            titleText = new String(charArr);

            readyStr = readyStr + number + ". " + titleText + "\n";
            number++;
            i++;

        }
        return readyStr;
    }

    public String[] getDvachParserArrayLinks() throws Exception {
        int number = 0;
        int i = 0;
        String titleText = "";
        String[] postNumber = new String[100];
        String[] readyStr = new String[100];
        char[] charArr = new char[50];

        Document page = getPage("https://2ch.hk/b/");
        Element main = page.select("div[class=cntnt]").first();

        for (Element post: posts) {
            postNumber[i] = getFromPostNumberFromString(post.text());
            readyStr[i] = "https://2ch.hk/b/res/" + postNumber[i] + ".html";
            i++;
        }
        return readyStr;
    }

}
