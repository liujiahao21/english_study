package com.china.jiahao.english_promote.service;

import com.china.jiahao.english_promote.entity.EnglishWord;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomEnglishWordAbstractImpl extends EnglishWordAbstract {


    @Override
    public List<EnglishWord> findEnglishWord(int count) {
        List<EnglishWord> allEnglishWord=findAll();
        List<EnglishWord> returnList=new ArrayList<>(count);
        Random random=new Random();
        for(int i=0;i<count;i++){
            returnList.add(allEnglishWord.get(random.nextInt(allEnglishWord.size())));
        }
        return returnList;
    }


}
