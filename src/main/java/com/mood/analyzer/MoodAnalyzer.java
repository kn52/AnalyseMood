package com.mood.analyzer;
import com.mood.exception.MoodAnalyzerException;
public class MoodAnalyzer {
    private String message;

    public MoodAnalyzer() {
    }

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String moodAnalyse() {
        try
        {
            if (message.isEmpty())
            {
                throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.EMPTY_STRING,"EMPTY_STRING");
            }
            if(message.contains("sad"))
                return "SAD";
            return "HAPPY";
        }
        catch(NullPointerException npe)
        {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NULL_STRING,"NULL_STRING");
        }
    }
}
