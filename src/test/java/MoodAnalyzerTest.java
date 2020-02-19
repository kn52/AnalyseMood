import com.mood.analyzer.MoodAnalyzer;
import com.mood.exception.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    String mood = null;

    @Test
    public void givenHappyMood_ShouldReturnHappy() {
        try {
            MoodAnalyzer analyzer = new MoodAnalyzer("This is happy message");
            mood = analyzer.moodAnalyse();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenSadMood_ShouldReturnSAD() {
        try {
            MoodAnalyzer analyzer = new MoodAnalyzer("This is sad message");
            mood = analyzer.moodAnalyse();
            Assert.assertEquals("SAD", mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenNullMood_ShouldReturnHAPPY() {
        try {
            MoodAnalyzer analyzer = new MoodAnalyzer();
            mood = analyzer.moodAnalyse();
        } catch (MoodAnalyzerException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NULL_STRING, e.type);
        }

    }

    @Test
    public void givenEmptyMood_ShouldReturnHAPPY() {
        try {
            MoodAnalyzer analyzer = new MoodAnalyzer("");
            mood = analyzer.moodAnalyse();
        } catch (MoodAnalyzerException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.EMPTY_STRING, e.type);
        }
    }

}


