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
                throw new MoodAnalyzerException("Empty Mood");
            }
            if(message.contains("sad"))
                return "SAD";
            return "HAPPY";
        }
        catch(NullPointerException npe)
        {
            throw new MoodAnalyzerException("Not Proper Mood");
        }
    }
}
