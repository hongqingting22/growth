package com.lxl.file;

import java.io.*;

public class NewH5 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\lenovo\\Desktop\\newH5.txt");
        readFile1(file);
    }
    private static void readFile1(File fin) {
        try {
            FileInputStream fis = new FileInputStream(fin);

            //Construct BufferedReader from InputStreamReader
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            //Construct BufferedReader from InputStreamReader
            String line = null;
            int num = 0;
            while ((line = br.readLine()) != null) {
                num++;
                if(line != ""&& line != null){
                    String substring = line.substring(line.indexOf(")")+2);
                    if(num%2 == 0){
                        System.out.println(substring);
                    }else{
                        System.out.print(substring + "    ");
                    }
                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
