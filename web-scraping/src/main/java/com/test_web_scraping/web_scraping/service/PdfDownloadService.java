package com.test_web_scraping.web_scraping.service;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class PdfDownloadService {

    public List<String> downloadFiles(List<String> fileUrls, String downloadDir) throws IOException {

        List<String> filePaths = new ArrayList<>();

        for (String fileUrl : fileUrls) {
            URL url = new URL(fileUrl);

            String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);


            File file = new File(downloadDir + "/" + fileName);
            FileUtils.copyURLToFile(url, file);

            System.out.println("Downloaded files: " + file.getAbsolutePath());
            filePaths.add(file.getAbsolutePath());
        }
        return filePaths;
    }
}
