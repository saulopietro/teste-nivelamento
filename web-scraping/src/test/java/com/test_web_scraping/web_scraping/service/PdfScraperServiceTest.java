package com.test_web_scraping.web_scraping.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PdfScraperServiceTest {

    @Test
    void scrapePdfLinks() throws IOException {
        PdfScraperService pdfScraperService = new PdfScraperService();

        List<String> links = pdfScraperService.scrapePdfLinks("https://www.gov.br/ans/pt-br/acesso-a-informacao/informacoes-classificadas-e-desclassificadas");

        assertNotNull(links);
        assertTrue(links.size() > 0);
        assertTrue(links.get(0).contains("pdf"));
        assertTrue(links.get(0).contains("Anexo"));

    }


}