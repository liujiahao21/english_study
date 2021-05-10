package com.china.jiahao.english_promote.entity;

import java.util.List;

public class EnglishWord {
    private int id;
    private int correct;
    private Integer error;
    private double fraction;
    private int level;
    private int keyWordType;

    public EnglishWord(int id, int correct, Integer error, double fraction, int level, int keyWordType, String englishtVlaue, String chineseValue, String exampleSentence) {
        this.id = id;
        this.correct = correct;
        this.error = error;
        this.fraction = fraction;
        this.level = level;
        this.keyWordType = keyWordType;
        this.englishtVlaue = englishtVlaue;
        this.chineseValue = chineseValue;
        this.exampleSentence = exampleSentence;
    }

    private String englishtVlaue;
    private String chineseValue;
    private String exampleSentence;

    public EnglishWord() {
    }

    @Override
    public String toString() {
        return "EnglishWord{" +
                "id=" + id +
                ", correct=" + correct +
                ", error=" + error +
                ", fraction=" + fraction +
                ", level=" + level +
                ", keyWordType=" + keyWordType +
                ", englishtVlaue='" + englishtVlaue + '\'' +
                ", chineseValue='" + chineseValue + '\'' +
                ", exampleSentence='" + exampleSentence + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public double getFraction() {
        return fraction;
    }

    public void setFraction(double fraction) {
        this.fraction = fraction;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getKeyWordType() {
        return keyWordType;
    }

    public void setKeyWordType(int keyWordType) {
        this.keyWordType = keyWordType;
    }

    public String getEnglishtVlaue() {
        return englishtVlaue;
    }

    public void setEnglishtVlaue(String englishtVlaue) {
        this.englishtVlaue = englishtVlaue;
    }

    public String getChineseValue() {
        return chineseValue;
    }

    public void setChineseValue(String chineseValue) {
        this.chineseValue = chineseValue;
    }

    public String getExampleSentence() {
        return exampleSentence;
    }

    public void setExampleSentence(String exampleSentence) {
        this.exampleSentence = exampleSentence;
    }
}

