package com.web_scraping.data_transformation.services;

import com.web_scraping.data_transformation.interfaces.FileCompressor;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CsvCompressorService implements FileCompressor {
    @Override
    public void compressFile(String filePath, String zipPath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(zipPath);
             ZipArchiveOutputStream zipOut = new ZipArchiveOutputStream(fos)) {
            File fileToZip = new File(filePath);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipArchiveEntry zipEntry = new ZipArchiveEntry(fileToZip.getName());
            zipOut.putArchiveEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) >= 0) {
                zipOut.write(buffer, 0, length);
            }

            zipOut.closeArchiveEntry();
            fis.close();
            zipOut.finish();
        }
    }
    }

