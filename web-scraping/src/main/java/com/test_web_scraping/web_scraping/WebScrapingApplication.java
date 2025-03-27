package com.test_web_scraping.web_scraping;

import com.test_web_scraping.web_scraping.controler.WebScrapingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebScrapingApplication implements CommandLineRunner {

	private final WebScrapingController webScrapingController;

	@Autowired
	public WebScrapingApplication(WebScrapingController webScrapingController) {
		this.webScrapingController = webScrapingController;
	}

	@Override
	public void run(String... args) throws Exception {
		webScrapingController.processPdfFiles("https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos");
	}

	public static void main(String[] args) {
		SpringApplication.run(WebScrapingApplication.class, args);
	}

}
