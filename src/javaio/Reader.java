package javaio;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public void readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String c;

        while ((c = reader.readLine()) != null) {
            System.out.println(c);
        }
    }

    public List<Student> readObjects(String fileName) {

        List<Student> students = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {

            boolean keepReading = true;
            while (keepReading) {


                Student student = (Student) in.readObject();
                if ("".equals(student.getName())) {
                    students.add(student);
                } else {
                    keepReading = false;
                }

            }

        } catch (IOException e) {
            System.out.println("Unable to open file " + fileName + " Program terminates");
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

   public void nioReaderFileWithBuffer(String fileName) throws IOException {
        Path path = Paths.get(fileName);

       Charset charset = Charset.forName("UTF-8");
        try(BufferedReader reader = Files.newBufferedReader(path, charset)) {

            String s;
            while ((s = reader.readLine()) != null) {

                System.out.println(s);
            }
        }
   }

   public void nioReadWithStream(String fileName) throws IOException {
        Path path = Paths.get(fileName);

        try(InputStream in = Files.newInputStream(path)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String s;

            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        }
   }

}
