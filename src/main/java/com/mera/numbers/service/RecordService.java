package com.mera.numbers.service;


import com.mera.numbers.domain.Record;
import com.mera.numbers.repository.RecordRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:value.properties")
@Slf4j
public class RecordService {

  private RestTemplate restTemplate;
  private final RecordRepository recordRepository;

  @Value("${api.url}")
  private String API_URL;

  @Autowired
  public RecordService(RecordRepository recordRepository) {
    this.recordRepository = recordRepository;
    this.restTemplate = new RestTemplate();
  }

  private Record getRecordFromApi() {
    return this.restTemplate.getForObject(API_URL, Record.class);
  }

  public void printRecord(Record record) {
    log.info(
        "Processing a record - id=[{}] number=[{}] fact=[{}]", record.getId(), record.getNumber(),
        record.getText());
  }

  public void processRecord() {
    Record record = getRecordFromApi();
    printRecord(record);
    saveRecord(record);
  }

  public void saveRecord(Record record) {
    recordRepository.save(record);
  }

  public List<Record> findAllRecords() {
    return recordRepository.findAll();
  }

  public Record findRecordById(long id) {
    return recordRepository.getById(id);
  }
}
