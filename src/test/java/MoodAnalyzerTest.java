import com.mood.analyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    @Test
    public void givenSadMood_ShouldReturn_SAD() {
        MoodAnalyzer analyzer=new MoodAnalyzer();
        String mood = analyzer.moodAnalyse("This is sad message");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenHappyMood_ShouldReturn_HAPPY() {
        MoodAnalyzer analyzer = new MoodAnalyzer();
        String mood=analyzer.moodAnalyse("This is happy message");
        Assert.assertEquals("HAPPY",mood);
    }

}
