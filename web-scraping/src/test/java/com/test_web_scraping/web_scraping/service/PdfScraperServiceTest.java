package com.test_web_scraping.web_scraping.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PdfScraperServiceTest {

    @Autowired
    private PdfScraperService pdfScraperService;

    @Test
    void ShouldFindPdfLink() throws IOException {

        //Arrange
        String url = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";
        List<String> links = new ArrayList<>();
        //Act
        Document doc = Jsoup.connect(url).timeout(10000).get();
        Elements pdfLinks = doc.select("a[href$='.pdf']");
        for(Element link: pdfLinks) {
            links.add(link.absUrl("href"));
        }
        //Assert
        assertFalse(links.isEmpty());
    }

    @Test
    void ShouldFindTwoPdfWithNameAnexo() throws IOException {
        //Arrange
        String url = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";
        List<String> links = new ArrayList<>();
        //Act
        Document doc = Jsoup.connect(url).timeout(10000).get();
        Elements pdfLinks = doc.select("a[href*='Anexo'][href$='.pdf']");
        for(Element link: pdfLinks) {
            links.add(link.absUrl("href"));
        }
        //Assert
        assertEquals(2, links.size());
    }
}
