package com.traceprice.takeoffer.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AliCrawlerService implements CrawlerService {
    @Override
    public List<List<String>> getSearchResults(String q) throws IOException {
        List<List<String>> results = new ArrayList<>();
        Random random = new Random();
        int randomTimeout = random.nextInt(5000 + 1) + 3000;
        String url = "https://ko.aliexpress.com/w/wholesale-" + q + ".html";
        Document d = Jsoup.connect(url)
                .timeout(randomTimeout)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36")
                .header("Accept-Language", "ko,ja;q=0.9,en;q=0.8,en-US;q=0.7")
                .get();
        Elements e = d.select(".multi--titleText--nXeOvyr");
//        e.forEach(element -> results.add(element.text()));
        return results;
    }
}
