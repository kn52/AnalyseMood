package com.mood.analyzer;

public class MoodAnalyzer {
    private String message;

    public MoodAnalyzer() {
    }

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String moodAnalyse() {
            if (message.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
    }
}
