package com.mera.numbers.controller;

import com.mera.numbers.domain.Record;
import com.mera.numbers.service.RecordService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RecordController {

  private final RecordService recordService;

  @Autowired
  public RecordController(RecordService recordService) {
    this.recordService = recordService;
  }

  @GetMapping("/records")
  public String findAll(Model model) {
    List<Record> records = recordService.findAllRecords();
    model.addAttribute("recordList", records);
    return "record-list";
  }

  @GetMapping("/records/{idRecord}")
  public String findById(@PathVariable("idRecord") long id, Model model) {
    Record record = recordService.findRecordById(id);
    model.addAttribute("recordById", record);
    return "record-id";
  }

}
