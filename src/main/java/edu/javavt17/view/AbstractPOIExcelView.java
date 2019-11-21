package edu.javavt17.view;

import org.apache.poi.POIXMLProperties;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public abstract class AbstractPOIExcelView extends AbstractView {
    private static final String CONTENT_TYPE_XLSX = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public AbstractPOIExcelView() {
        setContentType(CONTENT_TYPE_XLSX);
    }

    @Override
    protected boolean generatesDownloadContent() {
        return true;
    }

    @Override
    protected final void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        XSSFWorkbook workbook = createWorkbook();
        buildXlsxMetadata(workbook);
        buildExcelDocument(model, workbook, request, response);
        // Set the content type.
        response.setContentType(getContentType());
        // Flush byte array to servlet output stream.
        ServletOutputStream out = response.getOutputStream();
        out.flush();
        workbook.write(out);
        out.flush();
    }

    protected void buildXlsxMetadata(XSSFWorkbook workbook) {
        POIXMLProperties props = workbook.getProperties();
        POIXMLProperties.CoreProperties coreProp = props.getCoreProperties();
        coreProp.setCreator("laboratory@email.com");
        coreProp.setDescription("creating xlsx report using Apache POI / Java");
        coreProp.setKeywords("Apache POI, Java, Spring, XLSX ");
        coreProp.setTitle("Cars_report");
        coreProp.setCategory("Programming");
        POIXMLProperties.ExtendedProperties extProp = props.getExtendedProperties();
        extProp.getUnderlyingProperties().setCompany("knit-12-1");
        extProp.getUnderlyingProperties().setManager("mk_d");
    }

    protected abstract XSSFWorkbook createWorkbook();

    protected abstract void buildExcelDocument(Map<String, Object> model, XSSFWorkbook workbook,
                                               HttpServletRequest request, HttpServletResponse response) throws Exception;
}