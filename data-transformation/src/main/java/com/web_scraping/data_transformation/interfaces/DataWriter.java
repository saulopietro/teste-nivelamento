package com.web_scraping.data_transformation.interfaces;

import java.io.IOException;
import java.util.List;

public interface DataWriter {

    void writeData(List<String[]> data, String outputPath) throws IOException;

}
