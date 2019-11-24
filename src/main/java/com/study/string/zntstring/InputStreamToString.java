package com.study.string.zntstring;

import org.apache.commons.io.IOUtils;
import java.io.*;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Collectors;

import static sun.plugin.ClassLoaderInfo.reset;

/**
 * @author  znt
 * @description  InputStreamToString方法比较
 * @Date 2019/11/24
 */

public class InputStreamToString {

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
        //测试数据：4,075,699 字节
        File filename = new File("D:/1553715388945.html");
        InputStream inputStream = new FileInputStream(filename);

        long startTime,endTime;

        Class cla = Class.forName("com.study.string.zntstring.InputStreamToString");
        for(String name : methods){
            try {
                Method method = cla.getMethod(name, InputStream.class);
                startTime = System.currentTimeMillis();
                method.invoke(cla, inputStream);
                endTime = System.currentTimeMillis();
                System.out.println("cost: " + (endTime - startTime) + "ms");
                System.out.println();
            }catch (Exception e){
                System.out.println("调用方法失败！");
            }

        }
    }

    public static String[] methods = {"iOUtils","scanner","streamApi","parallelStreamApi","readerAndBuilder",
            "writerAndCopy","outputAndInputStream","bufferReader","bufferedAndOutputStream","readAndBuilder"};


    public static String iOUtils(InputStream inputStream) throws IOException {
        System.out.println("使用IOUtils.toString (Apache Utils) ：");
        return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
    }

    public static String scanner(InputStream inputStream){
        System.out.println("Scanner");
        Scanner s = new Scanner(inputStream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    /**
     *  提醒: 这种方式会将不同的换行符 (比如\r\n) 都替换为 \n.
     */
    public static String  streamApi(InputStream inputStream){
        System.out.println("使用Stream Api和BufferReader (Java 8)");
       return new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));
    }

    /**
     *  提醒: 这种方式会将不同的换行符 (比如\r\n) 都替换为 \n.
     */
    public static String parallelStreamApi(InputStream inputStream){
        System.out.println("使用parallel Stream Api 和BufferReader (Java 8)");
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines().parallel().collect(Collectors.joining("\n"));
    }

    public static String readerAndBuilder(InputStream inputStream) throws IOException {
        System.out.println("使用InputStreamReader 和StringBuilder (JDK)");
        //为什么需要指定bufferSize？
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(inputStream, "UTF-8");
        while(true) {
            int rsz = in.read(buffer, 0, buffer.length);
            if (rsz < 0){break;}
            out.append(buffer, 0, rsz);
        }
        return out.toString();
    }

    public static String writerAndCopy(InputStream inputStream) throws IOException {
        System.out.println("使用StringWriter 和 IOUtils.copy (Apache Commons)");
        StringWriter writer = new StringWriter();
        IOUtils.copy(inputStream, writer, "UTF-8");
        return writer.toString();
    }

    public static String outputAndInputStream(InputStream inputStream) throws IOException {
        System.out.println("使用ByteArrayOutputStream 和 inputStream.read (JDK)");
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString("UTF-8");
    }

    /**
     * 提醒: 这种方式会将不同的换行符 (比如\r\n) 都替换为当前系统的换行符(例如, 在windows下是"\r\n").
     */
    public static String bufferReader(InputStream inputStream) throws IOException {
        System.out.println("使用BufferedReader和StringBuffer (JDK)");
        String newLine = System.getProperty("line.separator");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer result = new StringBuffer();
        String line; boolean flag = false;
        while ((line = reader.readLine()) != null) {
            result.append(flag? newLine: "").append(line);
            flag = true;
        }
        return result.toString();
    }

    public static String bufferedAndOutputStream(InputStream inputStream) throws IOException {
        System.out.println("使用BufferedInputStream 和 ByteArrayOutputStream (JDK)");
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int result = bis.read();
        while(result != -1) {
            buf.write((byte) result);
            result = bis.read();
        }
        return buf.toString();
    }

    /**
     * 提醒: 这种方式处理Unicode时存在问题, 例如俄文, 仅在非Unicode字符串下工作正常
     */
    public static String readAndBuilder(InputStream inputStream) throws IOException {
        System.out.println("使用 inputStream.read() 和 StringBuilder (JDK)");
        int ch;
        StringBuilder sb = new StringBuilder();
        while((ch = inputStream.read()) != -1){
            sb.append((char)ch);
        }
        reset();
        return sb.toString();
    }
}
