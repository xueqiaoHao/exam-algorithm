package fdu.file;

import java.io.*;

/**
 * Description  TODO
 * Author hao
 * Date 2023/3/25 9:03
 */
public class FileInputAndOutputTest {
    public static void main(String[] args) {
        File input = new File("src/main/resources/test.txt");
        File output = new File("src/main/resources/res.txt");
        try{
            FileInputStream fileInputStream = new FileInputStream(input);
            FileOutputStream fileOutputStream = new FileOutputStream(output);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedReader br = new BufferedReader(inputStreamReader);
            String tmp;
            while ((tmp=br.readLine())!=null){
                outputStreamWriter.write(tmp);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
