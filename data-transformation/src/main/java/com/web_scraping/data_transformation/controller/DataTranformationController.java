package com.web_scraping.data_transformation.controller;

import com.web_scraping.data_transformation.services.CsvCompressorService;
import com.web_scraping.data_transformation.services.CsvWriterService;
import com.web_scraping.data_transformation.services.PdfDataTranformerService;
import com.web_scraping.data_transformation.services.PdfExtractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DataTranformationController {

    @Autowired
    private PdfDataTranformerService pdfDataTranformerService;
    @Autowired
    private CsvCompressorService csvCompressorService;
    @Autowired
    private PdfExtractorService pdfExtractorService;
    @Autowired
    private CsvWriterService csvWriterService;

    String urlPdf = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos/Anexo_I_Rol_2021RN_465.2021_RN627L.2024.pdf";

    public void processPdf(String pdfPath, String csvPath, String zipPath) throws Exception {
        List<String[]> extractedData = pdfExtractorService.extractData(pdfPath);

        for (int i = 0; i < extractedData.size(); i++) {
            extractedData.set(i, pdfDataTranformerService.transformData(extractedData.get(i)));
        }

        csvWriterService.writeData(extractedData, csvPath);

        csvCompressorService.compressFile(csvPath, zipPath);
    }
}
