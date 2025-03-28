package com.web_scraping.data_transformation.interfaces;

import java.io.IOException;

public interface FileCompressor {

    void compressFile(String filePath, String zipPath) throws IOException;
}
