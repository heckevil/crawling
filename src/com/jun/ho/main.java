package com.jun.ho;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class main {
    public static void main(String[] args) {
        Document doc = null;
        String selector = "ul.hdline_article_list";
        try {
           doc = Jsoup.connect("https://news.naver.com/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements headLine = doc.select(selector);
        System.out.println(headLine);
        for (Element el : headLine.select("a")){
            System.out.println(el.text());
        };




    }
}
