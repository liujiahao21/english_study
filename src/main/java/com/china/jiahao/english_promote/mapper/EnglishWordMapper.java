package com.china.jiahao.english_promote.mapper;

import com.china.jiahao.english_promote.entity.EnglishWord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EnglishWordMapper {
    void addEnglishWordBatch(List<EnglishWord> englishWords);

    void updateEnglishWordBatch(List<EnglishWord> englishWords);

    List<EnglishWord> findRandEnglishWord(@Param("count") int count);

    List<EnglishWord> findAllEnglishWord();
}
