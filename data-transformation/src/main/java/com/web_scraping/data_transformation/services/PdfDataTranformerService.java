package com.web_scraping.data_transformation.services;

import org.springframework.stereotype.Service;

@Service
public class PdfDataTranformerService {

    public String[] transformData(String[] columns) {
        for (int i = 0; i < columns.length; i++) {
            if ("OD".equals(columns[i])) {
                columns[i] = "Outros Descritos";
            }
            if ("AMB".equals(columns[i])) {
                columns[i] = "Ambulatorial";
            }
        }
        return columns;
    }
}
