package edu.javavt17.view;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.javavt17.model.CarBrand;
import edu.javavt17.model.CarModel;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelBuilder extends AbstractPOIExcelView {
    @Override
    protected XSSFWorkbook createWorkbook() {
        return new XSSFWorkbook();
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> model, XSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // get data model which is passed by the Spring container
        List<CarBrand> carBrands = (List<CarBrand>) model.get("carBrands");
        List<CarModel> carModels = (List<CarModel>) model.get("carModels");

        generateBrandSheet(workbook, carBrands);
        generateModelsSheet(workbook, carModels);
    }

    private void generateBrandSheet(XSSFWorkbook workbook, List<CarBrand> carBrands){

        // create a new Excel sheet
        Sheet sheet = workbook.createSheet("Brands");
        sheet.setColumnWidth(0,2000);
        sheet.setColumnWidth(1,5000);
        sheet.setColumnWidth(2,3000);
        sheet.setColumnWidth(3,10000);

        Font font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        font.setFontName("Helvetica");

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setFont(font);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        // create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("№");
        headerRow.getCell(0).setCellStyle(headerStyle);

        headerRow.createCell(1).setCellValue("Brand name");
        headerRow.getCell(1).setCellStyle(headerStyle);

        headerRow.createCell(2).setCellValue("Founded year");
        headerRow.getCell(2).setCellStyle(headerStyle);

        headerRow.createCell(3).setCellValue("Headquarter");
        headerRow.getCell(3).setCellStyle(headerStyle);

        CellStyle rowCellStyle = workbook.createCellStyle();
        rowCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        // create data rows
        int rowCount = 1;
        for (CarBrand carBrand : carBrands) {
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(rowCount-1);
            row.getCell(0).setCellStyle(rowCellStyle);

            row.createCell(1).setCellValue(carBrand.getName());
            row.getCell(1).setCellStyle(rowCellStyle);

            row.createCell(2).setCellValue(carBrand.getFoundedYear());
            row.getCell(2).setCellStyle(rowCellStyle);

            row.createCell(3).setCellValue(carBrand.getHeadquarter());
            row.getCell(3).setCellStyle(rowCellStyle);
        }
    }

    private void generateModelsSheet(XSSFWorkbook workbook, List<CarModel> carModels){

        // create a new Excel sheet
        Sheet sheet = workbook.createSheet("Models");
        sheet.setColumnWidth(0,2000);
        sheet.setColumnWidth(1,5000);
        sheet.setColumnWidth(2,5000);
        sheet.setColumnWidth(3,7000);
        sheet.setColumnWidth(4,2500);
        sheet.setColumnWidth(5,2000);
        sheet.setColumnWidth(6,2000);
        sheet.setColumnWidth(7,2500);

        Font font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        font.setFontName("Helvetica");

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setFont(font);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        // create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("№");
        headerRow.getCell(0).setCellStyle(headerStyle);

        headerRow.createCell(1).setCellValue("Brand");
        headerRow.getCell(1).setCellStyle(headerStyle);

        headerRow.createCell(2).setCellValue("Model");
        headerRow.getCell(2).setCellStyle(headerStyle);

        headerRow.createCell(3).setCellValue("Generation");
        headerRow.getCell(3).setCellStyle(headerStyle);

        headerRow.createCell(4).setCellValue("Prod year");
        headerRow.getCell(4).setCellStyle(headerStyle);

        headerRow.createCell(5).setCellValue("Doors");
        headerRow.getCell(5).setCellStyle(headerStyle);

        headerRow.createCell(6).setCellValue("Seats");
        headerRow.getCell(6).setCellStyle(headerStyle);

        headerRow.createCell(7).setCellValue("Max speed");
        headerRow.getCell(7).setCellStyle(headerStyle);

        CellStyle rowCellStyle = workbook.createCellStyle();
        rowCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        // create data rows
        int rowCount = 1;
        for (CarModel carModel : carModels) {
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(rowCount-1);
            row.getCell(0).setCellStyle(rowCellStyle);

            row.createCell(1).setCellValue(carModel.getCarBrand().getName());
            row.getCell(1).setCellStyle(rowCellStyle);

            row.createCell(2).setCellValue(carModel.getModelName());
            row.getCell(2).setCellStyle(rowCellStyle);

            row.createCell(3).setCellValue(carModel.getGeneration());
            row.getCell(3).setCellStyle(rowCellStyle);

            row.createCell(4).setCellValue(carModel.getProductionYear());
            row.getCell(4).setCellStyle(rowCellStyle);

            row.createCell(5).setCellValue(carModel.getDoors());
            row.getCell(5).setCellStyle(rowCellStyle);

            row.createCell(6).setCellValue(carModel.getSeats());
            row.getCell(6).setCellStyle(rowCellStyle);

            row.createCell(7).setCellValue(carModel.getMaximumSpeed());
            row.getCell(7).setCellStyle(rowCellStyle);
        }
    }

}