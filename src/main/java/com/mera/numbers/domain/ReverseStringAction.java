package com.mera.numbers.domain;

import org.springframework.stereotype.Component;

@Component
public class ReverseStringAction implements RecordAction {

  @Override
  public String action(Record record) {
    return new StringBuilder(record.getText()).reverse().toString();
  }
}
