package com.github.fttroy.prettyJson.utils;

import com.github.fttroy.prettyJson.enums.Reason;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.github.fttroy.prettyJson.utils.Constants.*;

public class ExcelUtils {

    static Logger log = LoggerFactory.getLogger(ExcelUtils.class);

    public static void createExcel(String phrase, Reason reason) throws IOException {
        boolean isPhrasePresent = false;
        if (!phrase.isEmpty()) {
            Workbook workbook = initializeWorkbook();
            Sheet sheet = workbook.getSheet(reason.toString());
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (phrase.equals(cell.getStringCellValue())) {
                    isPhrasePresent = true;
                    break;
                }
            }
            if (!isPhrasePresent) {
                Row contentRow = sheet.createRow(sheet.getLastRowNum() + 1);
                contentRow.createCell(0).setCellValue(phrase);
                sheet.autoSizeColumn(0);
            }
            writeAndClose(workbook, true);
        }
    }

    public static Workbook initializeWorkbook() throws IOException {
        Workbook workbook;
        File file = new File(System.getProperty(USER_DIR).concat(PHRASES_FILE_PATH));
        if (file.exists() && file.length() > 0) {
            workbook = new XSSFWorkbook(new FileInputStream(file));
        } else {
            workbook = new XSSFWorkbook();
            for (Reason reason : Reason.values()) {
                Sheet sheet = workbook.createSheet(reason.toString());
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue(FOUND_PHRASES);
            }
            writeAndClose(workbook, false);
        }
        return workbook;
    }

    public static void writeAndClose(Workbook workbook, boolean close) {
        try (FileOutputStream fileOut = new FileOutputStream(System.getProperty(USER_DIR).concat(PHRASES_FILE_PATH))) {
            workbook.write(fileOut);
            if (close) workbook.close();
        } catch (IOException e) {
            log.info("ERROR - writing excel with exception: {}", e.getMessage());
        }
    }
}
