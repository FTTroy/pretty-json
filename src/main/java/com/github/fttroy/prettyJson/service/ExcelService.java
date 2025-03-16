package com.github.fttroy.prettyJson.service;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.github.fttroy.prettyJson.utils.ExcelUtils.initializeWorkbook;

@Service
public class ExcelService {

    public ResponseEntity<byte[]> downloadExcel() throws IOException {
        Workbook workbook = initializeWorkbook();
        // Salvo il workbook in un ByteArrayOutputStream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        workbook.close();
        // Crea il byte array del file Excel
        byte[] excelFile = baos.toByteArray();
        // Imposto headers della risposta per ritornare excel
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=phrases.xlsx");
        // Restituisce la risposta con il file Excel come byte array
        return ResponseEntity.ok()
                .headers(headers)
                .body(excelFile);
    }
}
