package com.learn.test.io.copyfile;


import java.io.*;
import java.nio.channels.FileChannel;

/**
 * Created by XJH on 2020/2/26.
 *
 * @Description:
 */
public class CopyFile {
    public static void copyFileByStream(File source, File dest) {
        try (FileInputStream is = new FileInputStream(source);
             FileOutputStream os = new FileOutputStream(dest)) {
//            BufferedInputStream
            byte[] buffer = new byte[1024];
            int length;

            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFileByChannel(File source, File dest){
        try (FileChannel sourceChannel = new FileInputStream(source).getChannel();
             FileChannel targetChannel = new FileOutputStream(dest).getChannel()) {

            for (long count = sourceChannel.size(); count > 0 ; ) {
                long transferred = sourceChannel.transferTo(sourceChannel.position(), count, targetChannel);
                sourceChannel.position(sourceChannel.position() + transferred);
                count -= transferred;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
