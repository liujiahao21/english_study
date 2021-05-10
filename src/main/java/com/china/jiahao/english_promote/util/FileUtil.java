package com.china.jiahao.english_promote.util;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtil {

    /**
     * 按行读取文件，以list<String>的形式返回
     * @return
     */
    public static List<String> readLogByList(String filePath) {
        List<String> lines = new ArrayList<String>();
        String tempstr = null;
        try {
            File file = new File(filePath);
            if(!file.exists()) {
                throw new FileNotFoundException();
            }
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, "utf-8"));
            while((tempstr = br.readLine()) != null) {
                lines.add(tempstr.toString());
            }
        } catch(IOException ex) {
            System.out.println(ex.getStackTrace());
        }
        return lines;
    }

    /**
     * 按行读取文件，String的形式返回
     * @return
     */
    public static String readLogByStr(String filePath) {
        StringBuilder lines = new StringBuilder();
        lines.append("[");
        String tempstr ;
        try {
            File file = new File(filePath);
            if(!file.exists()) {
                throw new FileNotFoundException();
            }
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, "utf-8"));
            while((tempstr = br.readLine()) != null) {
                lines.append(tempstr+",");
            }
        } catch(IOException ex) {
            System.out.println(ex.getStackTrace());
        }
        String returnStr=lines.toString();
         lines.replace(returnStr.length()-1,returnStr.length(),"]");
        return lines.toString();
    }
    /**
     * 按行读取文件，String的形式返回
     * @return
     */
    public static String readLogByStr2(String filePath) {
        StringBuilder lines = new StringBuilder();
        String tempstr ;
        try {
            File file = new File(filePath);
            if(!file.exists()) {
                throw new FileNotFoundException();
            }
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, "utf-8"));
            while((tempstr = br.readLine()) != null) {
                lines.append(tempstr);
            }
        } catch(IOException ex) {
            System.out.println(ex.getStackTrace());
        }
        String returnStr=lines.toString();
        return lines.toString();
    }

    /**
     * 写入文件,末尾自动添加\r\n
     * utf-8  追加
     * @param str
     */
    public static void writeLog( String str,String filePath,boolean type)
    {
        try
        {
            File file = new File(filePath);
            if(!file.exists())
                file.createNewFile();
            FileOutputStream out = new FileOutputStream(file,type); //true表示追加
            StringBuffer sb = new StringBuffer();
            sb.append(str + "\r\n");
            out.write(sb.toString().getBytes("utf-8"));//
            out.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getStackTrace());
        }
    }
    /**
     * 写入文件,末尾自动添加\r\n
     * utf-8  追加
     * @param str
     */
    public static void writeLog( List<String> str,String filePath)
    {
        try
        {
            File file = new File(filePath);
            if(!file.exists())
                file.createNewFile();
            FileOutputStream out = new FileOutputStream(file,true); //true表示追加
            for(String s:str){
                String value=s+ "\r\n";
                out.write(value.getBytes("utf-8"));
            }
            out.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getStackTrace());
        }
    }



}
