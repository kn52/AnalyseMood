package com.mood.analyzer;
import com.mood.exception.MoodAnalyzerException;
public class MoodAnalyzer {
    private String message;

    public MoodAnalyzer() {
        message="lue";
    }

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String moodAnalyse(String message) {
        this.message = message;
        return moodAnalyse();
    }

    public String moodAnalyse() {
        if (message.length() == 0)
        {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.EMPTY_STRING,"This is not proper method");
        }
        try
        {
            if(message.contains("sad"))
                return "SAD";
            return "HAPPY";
        }
        catch(NullPointerException npe)
        {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NULL_STRING,"This is not proper method");
        }
    }

    public boolean equals(Object another){
        if (this.message.equals(((MoodAnalyzer)another).message))
            return true;
        return false;
    }

}
