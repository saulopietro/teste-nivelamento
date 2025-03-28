package com.web_scraping.data_transformation.services;

import com.web_scraping.data_transformation.interfaces.DataWriter;
import org.springframework.stereotype.Service;

import com.opencsv.CSVWriter;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class CsvWriterService implements DataWriter {


    @Override
    public void writeData(List<String[]> data, String outputPath) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputPath))) {
            writer.writeAll(data);
        }
    }
}
