package com.example.lamda.file;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author pano
 * @date 2022/10/26
 **/
@FunctionalInterface
public interface BufferedReadProcessor {

    /**
     * lambda 文件读取func接口
     *
     * @param br BufferedReader
     * @return 读取的内容信息
     * @throws IOException IOException
     */
    String process(BufferedReader br) throws IOException;
}
