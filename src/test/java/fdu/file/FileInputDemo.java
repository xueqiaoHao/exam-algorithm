package fdu.file;

import java.io.*;

/**
 * Description  TODO
 * Author hao
 * Date 2023/3/24 23:58
 */
public class FileInputDemo {
    public static void main(String[] args) throws Exception {
//        File file = new File("E:\\testFile\\test.txt");
        File file = new File("src/main/resources/test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s ;
        while ((s=bufferedReader.readLine())!=null){
            System.out.print(s+" ");
        }
    }
}
