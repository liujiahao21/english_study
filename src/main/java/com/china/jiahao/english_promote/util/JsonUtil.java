package com.china.jiahao.english_promote.util;

import com.alibaba.fastjson.JSON;
import com.china.jiahao.english_promote.entity.EnglishWord;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class JsonUtil {
    /**
     * 单java对象转字符串
     *
     * @param object
     * @return
     */
    public static String parseObjectToString(Object object) {
        return JSON.toJSON(object).toString();
    }

    /**
     * list 对象转listString
     * @param englishWords
     * @return
     */
    public static List<String> parseObjectToStrings(List<EnglishWord> englishWords){
        List<String> returnList=new ArrayList<>();
        for(EnglishWord e:englishWords){
            returnList.add(parseObjectToString(e));
        }
        return returnList;
    }
    /**
     * json 解析为java对象
     *
     * @param str
     * @param objectClass
     * @return
     */
    public static Object parseObjectToJavaClass(String str, Class objectClass) {

        Object o = JSON.parseObject(str, objectClass);
        return o;
    }

    /**
     * json 解析为java list
     *
     * @param str
     * @param objectClass
     * @return
     */
    public static List<EnglishWord> parseObjectToJavaClassList(String str, Class objectClass) {

        List<EnglishWord> o = JSON.parseArray(str, objectClass);
        return o;
    }

    public static void main(String[] args) {
        //模拟3个停车位
        Semaphore semaphore = new Semaphore(3);
        //模拟6部汽车
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    //抢到资源
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t抢到车位");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t 停3秒离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放资源
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }

}
