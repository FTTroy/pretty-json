package com.github.fttroy.prettyJson.controller;


import com.github.fttroy.prettyJson.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/excel-controller")
public class ExcelController {

    @Autowired
    private ExcelService service;

    @GetMapping("/download-excel")
    public ResponseEntity<byte[]> downloadExcel() throws IOException {
        return service.downloadExcel();
    }
}
