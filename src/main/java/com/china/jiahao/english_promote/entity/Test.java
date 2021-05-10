package com.china.jiahao.english_promote.entity;

public class Test {
    public static void main(String[] args) {
        boolean bs = true;
        String str = "121";
        String str2 = "";
        for (int i = str.length() - 1; i > -1; i--) {
            str2 = str2 + str.charAt(i);
        }
        for (int j = 0; j < str.length(); j++) {
            char a = str2.charAt(j);
            char b = str.charAt(j);
            if (a != b) {
                bs = false;
            }

        }
        if (bs) {
            System.out.println(str + "是回文串");
        }
    }
}
