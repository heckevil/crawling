package com.jun.ho;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Document doc = null;
        String[] kinds = {"위스키"};
        String url = "https://ko.wikipedia.org/wiki/" + kinds[0];
        Elements name = null;
        Elements contents = null;
        String img = null;
        Elements kindsName = null;
        Elements kindsContent = null;
        StringBuilder sb = new StringBuilder();
        List<Element> elemList = new ArrayList<>();
        try {
            doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109").get();
            name = doc.select("#firstHeading");
            img = doc.select("img[alt=Glass of whisky.jpg]").attr("src");

//            for(int i=0; i<5;i++) {
//                content1 = doc.select("p").get(i);
//                sb.append(content1.text());
//            }
            contents = doc.select("p");
            for (Element content : contents) {
                elemList.add(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String content = sb.toString();
        if (elemList.size() > 5) {
            int maxCount = 5;
            for (int i = 0; i < maxCount; i++) {
                System.out.println(elemList.get(i).text());
            }
        } else {
            for (int i = 0; i < elemList.size(); i++) {
                System.out.println(elemList.get(i).text());
            }
        }

    }
}
