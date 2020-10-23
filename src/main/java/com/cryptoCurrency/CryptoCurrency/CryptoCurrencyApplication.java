package com.cryptoCurrency.CryptoCurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class CryptoCurrencyApplication {
	private static final Logger log = LoggerFactory.getLogger(CryptoCurrencyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CryptoCurrencyApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			reportCurrentTime();
		};
	}

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		RestTemplate template = new RestTemplate();
		ResponseEntity<MarketStamp[]> responseEntity = template.getForEntity("https://api.n.exchange/en/api/v1/price/BTCLTC/latest/?format=json&market_code=nex", MarketStamp[].class);
		log.info(Arrays.toString(responseEntity.getBody()));
	}


}
