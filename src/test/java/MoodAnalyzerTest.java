import com.mood.analyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    @Test
    public void givenSadMood_ShouldReturn_SAD() {
        MoodAnalyzer analyzer=new MoodAnalyzer("This is sad message");
        String mood = analyzer.moodAnalyse();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenHappyMood_ShouldReturn_HAPPY() {
        MoodAnalyzer analyzer = new MoodAnalyzer("This is happy message");
        String mood=analyzer.moodAnalyse();
        Assert.assertEquals("HAPPY",mood);
    }

}
