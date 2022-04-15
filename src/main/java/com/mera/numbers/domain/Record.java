package com.mera.numbers.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Record {

  private long number;
  private String text;

  @Override
  public String toString() {
    return number + ", " + text;
  }
}
