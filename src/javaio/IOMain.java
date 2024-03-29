package javaio;

import map.treemap.AverageStudentGrade;
import map.treemap.SubjectGrade;
import map.treemap.TreeMapRunner;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.util.*;

public class IOMain {

    private static final String FILE_NAME = "GradeBook.txt";
    private static final String BINARY_NAME = "Students.bin";
    private static final String BUFFERED_FILE = "Buffered.txt";

    public static void main(String[] args) throws IOException {

        //создаем map (коллекция, состоящая из пар ключ-значение)
        SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades = TreeMapRunner.createGrades();

        Reader reader = new Reader();
        Writer writer = new Writer();
//
//        writer.writeFile(grades, FILE_NAME);
//        reader.readFile(FILE_NAME);

//        processGrads(grades, writer, BINARY_NAME);
//        outputObjects(reader, BINARY_NAME);

        FileUtils utils = new FileUtils();
//        utils.printIOFileDetails("./");
//        utils.printNioFileDetails(FILE_NAME);

//        reader.readFileInFull(FILE_NAME);
//        reader.nioReaderFileWithBuffer(FILE_NAME);
//        writer.nioWriteWitBuffer(BUFFERED_FILE);

        reader.nioReaderFileWithBuffer(FILE_NAME);
        writer.nioWriteWithStream(BUFFERED_FILE);

    }

    //создаем коллекцию студентов и записываем в файл
  private static void processGrads(SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades, Writer writer, String fileName ) {

        List<Student> students = new ArrayList<>();
        for (AverageStudentGrade grade: grades.keySet()) {
            students.add(new Student(grade.getName(), grade.getAverageGrade(), grades.get(grade)));
        } writer.writeObject(students, fileName);

  }


    private static void outputObjects(Reader reader, String fileName) {

        List<Student> students = reader.readObjects(fileName);

        for (Student student: students) {
            System.out.printf("%s, %.2f %n", student.getName(), student.getAverageGrade());
            System.out.println(student.getGrades());
        }

    }

}


