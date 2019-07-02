package io2;

import map.treemap.AverageStudentGrade;
import map.treemap.SubjectGrade;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import static java.nio.file.StandardOpenOption.*;

public class Writer {

    public void writerWithFormater() throws FileNotFoundException {
        Formatter formatter = new Formatter("BankAccounts.txt");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter ClientId, ClientName, ClientSurname, AccountBalance");

        int i = 0;

        while (i < 3) {
            try {
                formatter.format("%d, %s, %s, %.2f%n", scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextFloat());
                i++;
            } catch (InputMismatchException e) {

                System.out.println("Input is incorrect. Please try again");
                e.printStackTrace();
            }
        }
        formatter.close();
    }


    public void writeFile(SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades, String fileName) throws IOException {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (AverageStudentGrade gradeKey: grades.keySet()) {
                writer.write("==========================================\n");
                writer.write("Student: " + gradeKey.getName() + " Average grade: " + gradeKey.getAverageGrade() + "\n");
                for (SubjectGrade grade: grades.get(gradeKey)) {

                    writer.write("Subject: " + grade.getSubject() + " Grade: " + grade.getGrade() + "\n");
                }
            }
        }
    }

    public void writeObject(List<Student> students, String fileName) {

        try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {

            for (Student student: students) {
                out.writeObject(student);
            }
            out.writeObject(new Student("", -1, null));
        } catch (IOException e) {

            System.out.println("File cannot be opened. Program terminates");
            e.printStackTrace();
        }

    }

    public void nioWriteWithBuffer(String fileName) throws IOException {

        Path path = Paths.get(fileName);

        Charset charset = Charset.forName("UTF-8");
        try(BufferedWriter writer = Files.newBufferedWriter(path, charset)) {

            writer.write(fileName, 0, fileName.length());

        }
    }


    public void nioWriteWithStream(String fileName) throws IOException {

        Path path = Paths.get(fileName);

        String str = "File cannot be opened. Program terminates";
        byte[] bytes = str.getBytes();
        try(OutputStream out = Files.newOutputStream(path, CREATE, APPEND)) {

            out.write(bytes, 0, bytes.length);

        }
    }

    public void nioWriteWithChannel(String fileName) throws IOException {

        String str = "The best way to find out your CEFR level is to take a well-designed standardized test. " +
                "In English, the EF SET is the best choice because it is freely available online " +
                "and the first test aligned to the CEFR. You will need to set aside 50 minutes to complete " +
                "the test and find out your CEFR level. To find out your CEFR level in other European languages, " +
                "the most common assessment tests are all aligned with the CEFR. ";

        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
        FileChannel channel = file.getChannel();

        byte[] bytes = str.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        channel.write(buffer);
        channel.close();


    }

    public void writeWithRandomAccess(String fileName) throws IOException {

        ByteBuffer mark = ByteBuffer.wrap(" MARKED AREA ".getBytes());

        ByteBuffer buffer = ByteBuffer.allocate(10);

        Path path = Paths.get(fileName);

        try(FileChannel openedFile = FileChannel.open(path, READ, WRITE)) {

            int numBytes = 0;
            while (buffer.hasRemaining() && numBytes != -1) {
                numBytes = openedFile.read(buffer);
            }
            openedFile.position(0);
            openedFile.write(mark);
            long size = openedFile.size();
            openedFile.position(size/2);
            mark.rewind();
            openedFile.write(mark);
            openedFile.position(size - 1);
            mark.rewind();
            openedFile.write(mark);
            buffer.rewind();
            openedFile.write(buffer);

        }
    }
}
