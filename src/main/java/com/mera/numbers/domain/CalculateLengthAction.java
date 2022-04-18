package com.mera.numbers.domain;

import org.springframework.stereotype.Component;

@Component
public class CalculateLengthAction implements RecordAction {

  @Override
  public String action(String text) {
    return "The length of fact's string: " + text.length() + " symbols.";
  }
}
