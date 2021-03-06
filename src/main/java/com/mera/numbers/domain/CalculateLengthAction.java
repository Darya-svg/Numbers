package com.mera.numbers.domain;

import org.springframework.stereotype.Component;

@Component
public class CalculateLengthAction implements RecordAction {

  @Override
  public String action(Record record) {
    return "The length of fact's string: " + record.getText().length() + " symbols.";
  }
}
