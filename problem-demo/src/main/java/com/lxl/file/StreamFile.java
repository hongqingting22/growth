package com.lxl.file;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class StreamFile {

    @Test
    public void test() throws Exception{
        Files.lines(Paths.get("C:\\Users\\lenovo\\Desktop\\newh5.txt")).filter(a ->{
            String[] s = a.split("    ");
            return
        }).forEach(System.out::println);
    }
}
