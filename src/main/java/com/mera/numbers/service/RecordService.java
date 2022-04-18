package com.mera.numbers.service;


import com.mera.numbers.domain.Record;
import com.mera.numbers.domain.CalculateLengthAction;
import com.mera.numbers.domain.ReverseStringAction;
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
  private final CalculateLengthAction stringLength;
  private final ReverseStringAction stringReverse;

  @Value("${api.url}")
  private String API_URL;

  @Autowired
  public RecordService(RecordRepository recordRepository,
      CalculateLengthAction stringLength, ReverseStringAction stringReverse) {
    this.recordRepository = recordRepository;
    this.stringLength = stringLength;
    this.stringReverse = stringReverse;
    this.restTemplate = new RestTemplate();
  }

  private Record getRecordFromApi() {
    return this.restTemplate.getForObject(API_URL, Record.class);
  }

  public void printRecord(Record record) {
    log.info(
        "Saved record - id=[{}] number=[{}] fact=[{}]", record.getId(), record.getNumber(),
        record.getText());
  }

  public void processRecord() {
    Record record = getRecordFromApi();
    saveRecord(record);
    printRecord(record);
    reverseAndLog(record.getText());
    calculateLengthAndLog(record.getText());
  }

  public void reverseAndLog(String text) {
    log.info("Reversed string: " + stringReverse.action(text));
  }

  public void calculateLengthAndLog(String text) {
    log.info(stringLength.action(text));
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
