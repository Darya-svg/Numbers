package com.mera.numbers.service;

import com.mera.numbers.domain.Record;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:value.properties")
public class RecordService {

  @Value("${api.url}")
  private String API_URL;

  private Record getRecordFromApi() {
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(API_URL, Record.class);
  }

  public void printRecord() {
    System.out.println(getRecordFromApi().toString());
  }
}
