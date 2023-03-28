package fdu.file;

import java.io.*;

/**
 * Description  TODO
 * Author hao
 * Date 2023/3/25 0:14
 */
public class FileOutputDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/test.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        outputStreamWriter.write("what 123");
        outputStreamWriter.close();
    }
}
