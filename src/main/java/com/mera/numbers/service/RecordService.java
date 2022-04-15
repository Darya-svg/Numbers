package com.mera.numbers.service;

import com.mera.numbers.domain.Record;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:value.properties")
public class RecordService {

  private RestTemplate restTemplate;

  @Value("${api.url}")
  private String API_URL;

  public RecordService() {
    this.restTemplate = new RestTemplate();
  }

  private Record getRecordFromApi() {
    return this.restTemplate.getForObject(API_URL, Record.class);
  }

  public void printRecord(Record record) {
    System.out.println(record.toString());
  }

  public void processRecord() {
    printRecord(getRecordFromApi());
  }
}
