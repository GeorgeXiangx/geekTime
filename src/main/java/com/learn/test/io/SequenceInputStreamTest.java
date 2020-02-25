package com.learn.test.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

/**
 * Created by XJH on 2019/12/17.
 *
 * @Description:
 * SequenceInputStream 表示其他输入流的逻辑"串联"。
 * 它从输入流的有序集合开始，并从第一个输入流开始读取，直到到达文件末尾；
 * 接着从第二个输入流读取，依次类推，直到到达包含的最后一个输入流的文件末尾为止。
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
