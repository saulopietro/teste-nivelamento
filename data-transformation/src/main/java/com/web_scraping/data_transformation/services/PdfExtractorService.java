package com.web_scraping.data_transformation.services;

import com.web_scraping.data_transformation.interfaces.DataExtractor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class PdfExtractorService implements DataExtractor {

    @Override
    public List<String[]> extractData(String pdfPath) throws Exception {
        PDDocument document = PDDocument.load(new File(pdfPath));
        PDFTextStripper stripper = new PDFTextStripper();
        String pdfText = stripper.getText(document);
        document.close();

        List<String[]> data = new ArrayList<>();
        String[] lines = pdfText.split("\n");

        for (String line : lines) {
            if (line.contains("Rol de Procedimentos e Eventos em Saúde")) {
                String[] columns = line.split("\\s+");
                data.add(columns);
            }
        }

        return data;
    }
}
