package com.china.jiahao.english_promote.mapper;

import com.china.jiahao.english_promote.entity.KeyWord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface KeyWordMapper {
    void addKeyWordBatch(List<KeyWord> keyWords);

    void updateWordBatch(List<KeyWord> keyWords);

    List<KeyWord> finAllKeyWord();

}
