package com.github.fttroy.prettyJson.service;

import com.github.fttroy.prettyJson.utils.Constants;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.github.fttroy.prettyJson.utils.Constants.PHRASES_FILE_PATH;
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
        headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        headers.setContentDisposition(ContentDisposition.attachment().filename(PHRASES_FILE_PATH).build());

        return ResponseEntity.ok()
                .headers(headers)
                .body(excelFile);
    }
}
