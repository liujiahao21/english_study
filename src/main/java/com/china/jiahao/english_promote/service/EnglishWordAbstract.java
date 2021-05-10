package com.china.jiahao.english_promote.service;

import com.china.jiahao.english_promote.entity.EnglishWord;
import com.china.jiahao.english_promote.util.FileUtil;
import com.china.jiahao.english_promote.util.JsonUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class EnglishWordAbstract {
    static String id = "C:\\id.txt";
    static String filePath = "C:\\test.txt";

    public static List<EnglishWord> findAll() {
        List<EnglishWord> list = new ArrayList<>();
        String str = FileUtil.readLogByStr(filePath);
        if (StringUtils.isNoneBlank(str)) {
            list = JsonUtil.parseObjectToJavaClassList(str, EnglishWord.class);
        }
        return list;
    }

    public static void wirteFrileStr(List<EnglishWord> list) {
        List<String> strings = JsonUtil.parseObjectToStrings(list);

        FileUtil.writeLog(strings, filePath);

    }

    public static void startGame() {
        boolean start = true;
        Scanner scanner = new Scanner(System.in);
        while (start) {
            System.out.println("********************************************************************************************************************");
            System.out.println("********************************************************************************************************************");
            System.out.println("********************************选择模式 【1】单词录入，【2】单词默写，【3】结束程序********************************");
            System.out.println("********************************************************************************************************************");
            System.out.println("********************************************************************************************************************");
            int type = scanner.nextInt();
            if (type == 1) {
                getUserInput();
            } else if (type == 2) {

                startTest(findAll());
            } else {
                System.out.println("************************************************************************");
                System.out.println("************************************************************************");
                System.out.println("********************************程序结束********************************");
                System.out.println("************************************************************************");
                System.out.println("************************************************************************");
                break;
            }
        }
    }


    public static void startTest(List<EnglishWord> list) {
        System.out.println("************************************************************************************************************");
        System.out.println("************************************************************************************************************");
        System.out.println("********************************单词测验开始，本轮共" + list.size() + "个单词********************************");
        System.out.println("************************************************************************************************************");
        System.out.println("************************************************************************************************************");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("*****************************************************************************************************************************");
            System.out.println("*****************************************************************************************************************************");
            System.out.println("******************************** 第" + (i + 1) + "个单词[" + list.get(i).getChineseValue() + "]********************************");
            System.out.println("*****************************************************************************************************************************");
            System.out.println("*****************************************************************************************************************************");
            Scanner scanner = new Scanner(System.in);
            String englishValue = scanner.next();
            System.out.println(list.get(i).toString());
            if (englishValue.equals(list.get(i).getEnglishtVlaue())) {
                System.out.println();
                System.out.println();
                System.out.println("********************************回答正确********************************");
                System.out.println();
                System.out.println();
            } else {
                System.out.println();
                System.out.println();
                System.out.println("********************************回答错误,抄写单词三次********************************");
                for (int x = 1; x < 4; x++) {
                    System.out.println();
                    System.out.println("********************************该次为第" + x + "次********************************");
                    System.out.println();
                    String error = scanner.next();
                }
            }
            if (i == list.size() - 1) {
                System.out.println("测验结束");
            }
        }
    }

    public static void getUserInput() {
        List<EnglishWord> englishWords = new ArrayList<>();
        Integer start = Integer.parseInt(FileUtil.readLogByStr2(id));
        boolean sign = true;
        while (sign) {
            System.out.println();
            System.out.println("********************************单词录入开始,请输入英语单词********************************");
            System.out.println();
            EnglishWord englishWord = new EnglishWord();
            englishWord.setId(start++);
            englishWord.setCorrect(0);
            englishWord.setError(0);
            englishWord.setFraction(0);
            Scanner scanner = new Scanner(System.in);
            String englishValue = scanner.next();
            System.out.println();
            System.out.println("**************************您输入的单词为[ " + englishValue + " ]********************************");
            System.out.println();
            System.out.println("*************************************请输入中文翻译*****************************************");
            System.out.println();
            String chineseValue = scanner.next();
            System.out.println();
            System.out.println();
            System.out.println("*************************您输入的中文翻译为[ " + chineseValue + " ]*****************************");
            System.out.println();
            System.out.println();
            System.out.println("**************************************请输入英语例句****************************************");
            System.out.println();
            System.out.println();
            scanner.useDelimiter("\n");
            String exampleSentence = scanner.next();
            System.out.println("**************您输入的英语例句为[ " + exampleSentence + " ]***********");
            englishWord.setEnglishtVlaue(englishValue);
            englishWord.setId(start);
            englishWord.setChineseValue(chineseValue);
            englishWord.setExampleSentence(exampleSentence);
            englishWords.add(englishWord);
            System.out.println(JsonUtil.parseObjectToString(englishWords));
            System.out.println();
            System.out.println();
            System.out.println("********单词 【" + englishValue + "】 录入结束,是否继续（Y/N）********");
            String confim = scanner.next();
            if (confim.equals("n") || confim.equals("N")) {
                sign = false;
                wirteFrileStr(englishWords);
                System.out.println("********************************单词录入结束，数据已被保存********************************");
                FileUtil.writeLog(start.toString(), id, false);
            }
        }
    }

    public abstract List<EnglishWord> findEnglishWord(int count);

    public static void main(String[] args) {
        // getUserInput();
        //startTest(findAll());
        startGame();
    }
}
