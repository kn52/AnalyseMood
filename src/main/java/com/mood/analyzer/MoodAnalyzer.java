package com.mood.analyzer;

public class MoodAnalyzer {
    public String moodAnalyse(String message) {
            if (message.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
    }
}
