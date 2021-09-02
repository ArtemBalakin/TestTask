package com.company;
import Entity.PeopleEntity;
import Fonts.FontNames;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author Artem Balakin (03.09.2021)
 * Данный класс представляет собой .xls документ, который можно заполнить и экспортировать
 */
class XlsDocument {
    private final HSSFWorkbook workbook;
    private String fileName;
    private List<PeopleEntity> data;
    private String[] header;

    /**
     * @param fileName-Имя для сохранения документа
     * @param data-        данные которые нужно записать в таблицу
     * @param header-      заголовок таблицы
     */
    public XlsDocument(String fileName, List<PeopleEntity> data, String[] header) {
        workbook = new HSSFWorkbook();
        this.fileName = fileName;
        this.data = data;
        this.header = header;
        this.fileName = fileName;
        createDocument();
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setData(List<PeopleEntity> data) {
        this.data = data;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    /**
     * Данный метод позволяет изменить шрифт заголовка
     *
     * @param name- Название шрифта который вы хотите применить для заголовка
     */
    public void decorateHeader(FontNames name) {
        HSSFSheet sheet = workbook.getSheetAt(0);
        HSSFFont font = workbook.createFont();
        font.setFontName(name.getFontName());
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        Row row = sheet.getRow(0);
        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            row.getCell(i).setCellStyle(style);
        }
        saveFile();
        System.out.println("Файл успешно обновлен!");
    }

    /**
     * Сохранение(Экспорт) документа
     */
    private void saveFile() {
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Файл сохранен!");
    }

    /**
     * Создание документа
     */
    private void createDocument() {
        workbook.createSheet("Sheet1");
        createHeader();
        writeDataToDocument();
        saveFile();
        System.out.println("Документ успешно создан и заполнен");
    }

    /**
     * Создание и заполнение заголовка таблицы
     */
    private void createHeader() {
        int rowNum = 0;
        HSSFSheet sheet = this.workbook.getSheet("Sheet1");
        Row row = sheet.createRow(rowNum);
        for (int columnIndex = 0; columnIndex < this.header.length; columnIndex++) {
            row.createCell(columnIndex).setCellValue(this.header[columnIndex]);
        }
    }

    /**
     * Заполнение документа
     */
    private void writeDataToDocument() {
        int rowIndex = 1;
        HSSFSheet sheet = this.workbook.getSheet("Sheet1");
        for (PeopleEntity data : data) {
            Row row = sheet.createRow(rowIndex);
            row.createCell(0).setCellValue(data.getName());
            row.createCell(1).setCellValue(data.getSurname());
            row.createCell(2).setCellValue(data.getCity());
            rowIndex++;
        }
    }
}
