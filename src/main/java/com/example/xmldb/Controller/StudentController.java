package com.example.xmldb.Controller;

import com.example.xmldb.entity.Student;
import com.example.xmldb.repository.StudentRepository;

import jakarta.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/excel")
    public void downloadExcel(HttpServletResponse response) throws Exception {

        response.setContentType(
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
        );

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=students.xlsx"
        );

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Students");

        Row headerRow = sheet.createRow(0);

        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("School EMIS");
        headerRow.createCell(3).setCellValue("10th Mark");
        headerRow.createCell(4).setCellValue("12th Mark");
        headerRow.createCell(5).setCellValue("Cutoff");
        headerRow.createCell(6).setCellValue("Native Place");
        headerRow.createCell(7).setCellValue("First Graduate");
        headerRow.createCell(8).setCellValue("Email");

        List<Student> students = studentRepository.findAll();

        int rowNum = 1;

        for (Student student : students) {

            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(student.getId());
            row.createCell(1).setCellValue(student.getName());
            row.createCell(2).setCellValue(student.getSchoolEmisNumber());
            row.createCell(3).setCellValue(student.getTenthMark());
            row.createCell(4).setCellValue(student.getTwelfthMark());
            row.createCell(5).setCellValue(student.getCutoff());
            row.createCell(6).setCellValue(student.getNativePlace());
            row.createCell(7).setCellValue(student.isFirstGraduate());
            row.createCell(8).setCellValue(student.getEmail());
        }

        workbook.write(response.getOutputStream());

        workbook.close();
    }
}