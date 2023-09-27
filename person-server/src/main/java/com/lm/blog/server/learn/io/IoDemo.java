package com.lm.blog.server.learn.io;

import java.io.*;
import java.net.URL;

/**
 * @author yond
 * @date 2023/8/21
 * @description
 */
public class IoDemo {


    public void readTxt() throws FileNotFoundException {
        try {
            File txtFile = new File("C:\\Users\\yond\\Desktop\\my.txt");
            FileInputStream fileInputStream = new FileInputStream(txtFile);
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\yond\\Desktop\\copy.txt");
            byte[] buffer = new byte[1024];
            while (fileInputStream.read(buffer, 0, buffer.length - 1) != -1) {
                fileOutputStream.write(buffer);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {

        }
    }

    public void showText() {
        try {
            FileReader txtFile = new FileReader("C:\\Users\\yond\\Desktop\\my.txt");
            BufferedReader bufferedReader = new BufferedReader(txtFile);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        IoDemo ioDemo = new IoDemo();
        try {
            ioDemo.showText();

            URL url = new URL("http://www.baidu.com");

            /* 字节流 */
            InputStream is = url.openStream();

            /* 字符流 */
            InputStreamReader isr = new InputStreamReader(is, "utf-8");

            /* 提供缓存功能 */
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
