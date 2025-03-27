package com.test_web_scraping.web_scraping.service;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class PdfCompressionService {

    public void compressFile(List<String> filePaths, String zipFilePath) throws IOException {

        try (FileOutputStream fos = new FileOutputStream(zipFilePath);
             ZipArchiveOutputStream zipOut = new ZipArchiveOutputStream(fos)) {

            for (String filePath : filePaths) {
                File file = new File(filePath);
                if (file.exists()) {
                    try (FileInputStream fis = new FileInputStream(file)) {
                        ZipArchiveEntry zipEntry = new ZipArchiveEntry(file.getName());
                        zipOut.putArchiveEntry(zipEntry);

                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = fis.read(buffer)) >= 0) {
                            zipOut.write(buffer, 0, length);
                        }

                        zipOut.closeArchiveEntry();
                    }
                }
            }
            System.out.println("Compressed files: " + zipFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
