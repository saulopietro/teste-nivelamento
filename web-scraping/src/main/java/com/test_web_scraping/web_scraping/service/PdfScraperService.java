package com.test_web_scraping.web_scraping.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PdfScraperService {

    public List<String> scrapePdfLinks(String url) throws IOException {
        Document doc = Jsoup.connect(url).timeout(10000).get();
        Elements pdfLinks = doc.select("a[href*='Anexo'][href$='.pdf']");
        List<String> links = new ArrayList<>();
        for (Element link : pdfLinks) {
            links.add(link.absUrl("href"));
        }
        return links;
    }
}
