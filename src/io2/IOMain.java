package io2;

import map.treemap.AverageStudentGrade;
import map.treemap.SubjectGrade;
import map.treemap.TreeMapRunner;

import java.io.*;
import java.util.*;

public class IOMain {

    private static final String FILE_NAME = "GradeBook2.txt";
    private static final String FILE_BYNARY = "Students.bin";
    private static final String BUFFERED_LINE = "Buffered.bin";

    public static void main(String[] args) throws IOException {
        SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades = TreeMapRunner.createGrades();


        Reader reader = new Reader();
        Writer writer = new Writer();
        writer.writeFile(grades, FILE_NAME);
//        reader.readFile(FILE_NAME);

        //Formatter - для записи в файл с определенным форматированием
//        writer.writerWithFormater();

//        processedGrades(grades, writer, FILE_BYNARY);
//        outputObjects(reader, FILE_BYNARY);

        FileUtils utils = new FileUtils();

//        utils.printIOFileDetails("./");
//        utils.printNioFileDitales(FILE_NAME);
//        reader.readFileInFull(FILE_NAME);
//        reader.nioReadFileWithBuffer(FILE_NAME);
//        writer.nioWriteWithBuffer(BUFFERED_LINE);
//        reader.nioReadFileWithBuffer(FILE_NAME);
//        writer.nioWriteWithStream(BUFFERED_LINE);
//        reader.nioReadWithChannel(FILE_NAME);
//        writer.nioWriteWithChannel(BUFFERED_LINE);
//        writer.writeWithRandomAccess(FILE_NAME);
        utils.processDir();

    }

    private static void processedGrades (SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades, Writer writer, String fileName) {

        List<Student> students = new ArrayList<>();
        for (AverageStudentGrade gradeKey: grades.keySet()) {
            students.add(new Student(gradeKey.getName(), gradeKey.getAverageGrade(), grades.get(gradeKey)));
        }

            writer.writeObject(students, fileName);

    }

    private static void outputObjects(Reader reader, String fileName) {
        List<Student> students = reader.readObject(fileName);
        for (Student student: students) {
            System.out.printf("%s, %.2f%n", student.getName(), student.getAverageGrade());
            System.out.println(student.getGrades());
        }

    }


}

