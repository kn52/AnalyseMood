package com.mood.exception;

public class MoodAnalyzerException extends RuntimeException{
    public enum ExceptionType{
        EMPTY_STRING,NULL_STRING
    }
    ExceptionType type;
    public MoodAnalyzerException(ExceptionType type,String message) {
        super(message);
        this.type=type;
    }
}
