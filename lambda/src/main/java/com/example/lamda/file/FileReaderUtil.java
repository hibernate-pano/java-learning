package com.example.lamda.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 文件读取工具类
 *
 * @author pano
 * @date 2022/10/26
 **/
public class FileReaderUtil {

    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/pano/Downloads/a.txt"))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferedReadProcessor processor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/pano/Downloads/a.txt"))) {
            return processor.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(FileReaderUtil.processFile());
        System.out.println(FileReaderUtil.processFile(BufferedReader::readLine));
        System.out.println(FileReaderUtil.processFile((BufferedReader br) -> br.readLine() + br.readLine() + br.readLine()));
    }
}
