package com.china.jiahao.english_promote.service;

import com.china.jiahao.english_promote.entity.EnglishWord;

import java.util.*;
import java.util.stream.Collectors;

public class ErrorEnglishWordAbstractImpl extends EnglishWordAbstract {
    @Override
    public List<EnglishWord> findEnglishWord(int count) {
        List<EnglishWord> allEnglishWord = findAll();

        Collections.sort(allEnglishWord ,new Comparator<EnglishWord>(){
            public int compare(EnglishWord arg0, EnglishWord arg1) {
                return arg0.getError().compareTo(arg1.getError());
            }
        });

        List<EnglishWord> returnList =allEnglishWord.subList(0,count);
        return returnList;
    }
}
