package tests.DZ_10;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FileParsingTest {
    private final ClassLoader cl = FileParsingTest.class.getClassLoader();

    @Test
    void zipPdfTest() throws Exception {
        try (InputStream is2 = cl.getResourceAsStream("filetest/test.zip");
             ZipInputStream zs = new ZipInputStream(is2)) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {
                String fileName = entry.getName();
                if (fileName.endsWith(".pdf")) {
                    PDF pdf = new PDF(zs);
                    assertEquals(180, pdf.numberOfPages);
                    assertEquals(337969, pdf.text.length());
                    assertEquals("Stefan Bechtold, Sam Brannen, Johannes Link, Matthias Merdes, Marc Philipp, Juliette de Rancourt, Christian Stein",
                            pdf.author);
                    return;

                }
            }
        }
    }
    @Test
    void zipCsvTest() throws Exception {
        try (InputStream is2 = cl.getResourceAsStream("filetest/test.zip");
             ZipInputStream zs = new ZipInputStream(is2)) {
            ZipEntry entry = zs.getNextEntry();;
            while (entry != null) {
                String fileName = entry.getName();
                if (fileName.endsWith(".csv")) {
                    InputStreamReader isr = new InputStreamReader(zs);
                    CSVReader csvReader = new CSVReader(isr);
                    List<String[]> content = csvReader.readAll();
                    assertEquals(4, content.size());
                    Assertions.assertArrayEquals(new String[] {"Тучс", "JUnit5"}, content.get(1));
                    return;
                }
                entry = zs.getNextEntry();
            }
            fail("No CSV file found in zip archive");
        }
    }
    @Test
    void zipXlsTest() throws Exception {
        try (InputStream is2 = cl.getResourceAsStream("filetest/test.zip");
             ZipInputStream zs = new ZipInputStream(is2)) {
            ZipEntry entry = zs.getNextEntry();;
            while (entry != null) {
                String fileName = entry.getName();
                if (fileName.endsWith(".xls")) {
                    XLS xls = new XLS(zs);
                    Assertions.assertTrue(
                            xls.excel.getSheetAt(0).getRow(3).getCell(2).getStringCellValue()
                                    .startsWith("1. Суммарное количество часов планируемое на штатную по всем разделам плана")
                    );
                    return;
                }
                entry = zs.getNextEntry();
            }
            fail("No XLS file found in zip archive");
        }
    }

    @Test
    void zipAllTest() throws Exception {
        try (InputStream is2 = cl.getResourceAsStream("filetest/test.zip");
             ZipInputStream zs = new ZipInputStream(is2)) {
            ZipEntry entry = zs.getNextEntry();;
            while (entry != null) {
                String fileName = entry.getName();
                if (fileName.endsWith(".xls")) {
                    XLS xls = new XLS(zs);
                    Assertions.assertTrue(
                            xls.excel.getSheetAt(0).getRow(3).getCell(2).getStringCellValue()
                                    .startsWith("1. Суммарное количество часов планируемое на штатную по всем разделам плана")
                    );
                    return;
                }
                else if (fileName.endsWith(".csv")) {
                    InputStreamReader isr = new InputStreamReader(zs);
                    CSVReader csvReader = new CSVReader(isr);
                    List<String[]> content = csvReader.readAll();
                    assertEquals(4, content.size());
                    Assertions.assertArrayEquals(new String[] {"Тучс", "JUnit5"}, content.get(1));
                    return;
                }
                else { fileName.endsWith(".pdf");
                    PDF pdf = new PDF(zs);
                    assertEquals(180, pdf.numberOfPages);
                    assertEquals(337969, pdf.text.length());
                    assertEquals("Stefan Bechtold, Sam Brannen, Johannes Link, Matthias Merdes, Marc Philipp, Juliette de Rancourt, Christian Stein",
                            pdf.author);
                    return;
                }
            }
        }
    }
}
