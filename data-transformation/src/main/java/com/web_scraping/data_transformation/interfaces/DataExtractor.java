package com.web_scraping.data_transformation.interfaces;

import java.util.List;

public interface DataExtractor {
    List<String[]> extractData(String pdfPath) throws  Exception;

}
