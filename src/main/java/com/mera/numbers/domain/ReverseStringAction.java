package com.mera.numbers.domain;

import org.springframework.stereotype.Component;

@Component
public class ReverseStringAction implements RecordAction {

  @Override
  public String action(String text) {
    return new StringBuilder(text).reverse().toString();
  }
}
