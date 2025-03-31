package com.test_web_scraping.web_scraping.controler;

import com.test_web_scraping.web_scraping.service.PdfCompressionService;
import com.test_web_scraping.web_scraping.service.PdfDownloadService;
import com.test_web_scraping.web_scraping.service.PdfScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

@Controller
public class WebScrapingController {

    @Autowired
    private PdfScraperService pdfScraperService ;

    @Autowired
    private PdfDownloadService pdfDownloadService;

    @Autowired
    private PdfCompressionService pdfCompressionService;

    public void processPdfFiles(String url) throws IOException {
        List<String> urlLinks = pdfScraperService.scrapePdfLinks(url);
        List<String> filePaths = pdfDownloadService.downloadFiles(urlLinks, "C:\\projetos\\teste_nivelamento\\web-scraping\\src\\main\\resources\\output");
        pdfCompressionService.compressFile(filePaths, "C:\\projetos\\teste_nivelamento\\web-scraping\\src\\main\\resources\\output\\Anexos.zip");
    }


}
