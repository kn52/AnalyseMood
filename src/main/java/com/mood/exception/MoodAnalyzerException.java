package com.mood.exception;

public class MoodAnalyzerException extends RuntimeException{
    public enum ExceptionType{
        EMPTY_STRING,NULL_STRING,NO_ACCESS,NO_SUCH_FIELD,NO_SUCH_METHOD,NO_SUCH_CLASS,OBJECT_CREATION_ISSUE
    }
    public ExceptionType type;
    public MoodAnalyzerException(ExceptionType type,String message) {
        super(message);
        this.type=type;
    }

    public MoodAnalyzerException(ExceptionType type,Throwable cause) {
        super(cause);
        this.type = type;
    }

    public MoodAnalyzerException(ExceptionType type,String message, Throwable cause ) {
        super(message, cause);
        this.type = type;
    }
}
