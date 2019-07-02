package io2;

import com.sun.source.tree.WhileLoopTree;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public  void readFile(String fileName) throws IOException {
        //FileReader читает побайтово и возвращает int. чтобы чтение имело нормальный вид его следует обернуть в BufferedReader, который читает и возвращает строку
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String c;
        while ((c = reader.readLine()) != null)
        {
            System.out.println(c);
        }
    }

    public List<Student> readObject(String fileName) {

        List<Student> students = new ArrayList<>();

        try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {

           boolean keepReading = true;
            while (keepReading) {

                Student student = (Student) in.readObject();
                if (!"".equals(student.getName())) {

                    students.add(student);
                } else {
                    keepReading = false;
                }

            }

        } catch (IOException e) {
            System.out.println("Unable to open file " + fileName + " program terminates");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Invalid object type");
            e.printStackTrace();
        }
        return students;
    }

    public void readFileInFull(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);
        for (String l: lines) {
            System.out.println(l);
        }
    }

    public void nioReadFileWithBuffer(String fileName) throws IOException {
        Path path = Paths.get(fileName);

        try(BufferedReader reader = Files.newBufferedReader(path)) {

            Charset charset = Charset.forName("UTF-8");
            String s;
            while ((s = reader.readLine()) !=null) {
                System.out.println(s);
            }
        }
    }

    public void nioReaderWithStream(String fileName) throws IOException {
        Path path = Paths.get(fileName);

        try(InputStream in = Files.newInputStream(path)) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String s;

            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        }
    }

    public void nioReadWithChannel(String fileName) throws IOException {

        //file - переменная, которая может использоваться для чтения и записи файла с именем fileName
        RandomAccessFile file = new RandomAccessFile(fileName, "rw");

        //из переменной file получаем дуступ к getChannel(). рузультат записываем в channel
        FileChannel channel = file.getChannel();

        //определяем размер буфера
        ByteBuffer buffer = ByteBuffer.allocate(100);

        //определяем сколько частей получится, если побуфферно читать channel
        int bytesNumber = channel.read(buffer);


        while (bytesNumber > 0) {
            buffer.flip();
            while (buffer.hasRemaining()) {

                System.out.print((char)buffer.get());
            }
            buffer.clear();
            bytesNumber = channel.read(buffer);
        }
        channel.close();
    }

}

