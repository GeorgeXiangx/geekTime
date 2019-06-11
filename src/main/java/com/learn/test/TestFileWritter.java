package com.learn.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by XJH on 2019/4/4.
 *
 * @Description:
 */
public class TestFileWritter {
    public static void main(String[] args) {

        try {

            String content = "This is the content to write into file";

            File file = new File("F:\\filename.txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.write("\n");
            bw.write(content);
            bw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//        try {
//            String data = " This content will append to the end of the file";
//
//            File file = new File("F:\\javaio-appendfile.txt");
//
//            //if file doesnt exists, then create it
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//
//            //true = append file
//            FileWriter fileWritter = new FileWriter(file.getName(), true);
//            fileWritter.write(data);
////            fileWritter.write("\n");
////            fileWritter.write(data);
//            fileWritter.close();
//
//            System.out.println("Done");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//}
}
