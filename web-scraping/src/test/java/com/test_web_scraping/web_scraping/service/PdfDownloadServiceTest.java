package com.test_web_scraping.web_scraping.service;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PdfDownloadServiceTest {

    private PdfDownloadService pdfDownloadService;

    @BeforeEach
    void setUp() {
        pdfDownloadService = new PdfDownloadService();
    }

    @Test
    void TheFilesShouldBeDownloaded() throws IOException {

        //Arrange
        String downloadDir = "C:\\Users\\saulo\\Desktop\\teste1";
        List<String> fileUrls = new ArrayList<>();
        List<String> filePaths = new ArrayList<>();

        fileUrls.add("https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos/Anexo_I_Rol_2021RN_465.2021_RN627L.2024.pdf");
        fileUrls.add("https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos/Anexo_II_DUT_2021_RN_465.2021_RN628.2025_RN629.2025.pdf");
        //Act
        for (String fileUrl : fileUrls) {
            URL url = new URL(fileUrl);

            String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);

            File file = new File(downloadDir + "/" + fileName);
            FileUtils.copyURLToFile(url, file);

            System.out.println("Downloaded files: " + file.getAbsolutePath());
            filePaths.add(file.getAbsolutePath());
        }

        //Assert
        assertFalse(filePaths.isEmpty());
    }
}