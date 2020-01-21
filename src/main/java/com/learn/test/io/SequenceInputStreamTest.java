package com.learn.test.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

/**
 * Created by XJH on 2019/12/17.
 *
 * @Description:
 */
public class SequenceInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fistream1 =
                new FileInputStream("/Users/aihe/Desktop/Songshu/code/java8source/src/main/resources/A.txt");  // first source
        FileInputStream fistream2 =
                new FileInputStream("/Users/aihe/Desktop/Songshu/code/java8source/src/main/resources/B.txt");  //second source

        // file
        SequenceInputStream sistream = new SequenceInputStream(fistream1, fistream2);
        FileOutputStream fostream = new FileOutputStream("C.txt");        // destination file

        int temp;
        while ((temp = sistream.read()) != -1) {
            System.out.print((char) temp); // to print at DOS prompt
            fostream.write(temp);   // to write to file
        }
        fostream.close();
        sistream.close();
        fistream1.close();
        fistream2.close();
        Thread.interrupted();
    }
}
