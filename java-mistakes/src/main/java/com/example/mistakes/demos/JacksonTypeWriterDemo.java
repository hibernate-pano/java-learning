package com.example.mistakes.demos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JacksonTypeWriterDemo
 * 测试待泛型的对象的序列化
 *
 * @author Panbo
 * @create_time 2023/6/4 12:18
 */
public class JacksonTypeWriterDemo {

    public static <T> String objectToJson(T obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    public static <T> T jsonToObject(String json, TypeReference<T> typeReference) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, typeReference);
    }

    public static void main(String[] args) throws IOException {
        JacksonTypeWriterDemo demo = new JacksonTypeWriterDemo();
        demo.test();
    }

    public void test() throws IOException {
        Result<List<String>> result = new Result<>();
        result.setCode(200);
        result.setMessage("success");
        List<String> data = new ArrayList<>();
        data.add("hello");
        data.add("world");
        result.setData(data);

        String s = objectToJson(result);

        System.out.println(s);
        Result<List<String>> result2 = jsonToObject(s, new TypeReference<>() {
        });
        System.out.println(result2.getCode());
        System.out.println(result2.getMessage());
        System.out.println(result2.getData());
    }

    @Data
    static class Result<T> {
        private int code;
        private String message;
        private T data;
    }

}
