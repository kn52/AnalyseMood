import com.mood.analyzer.MoodAnalyzer;
import com.mood.exception.MoodAnalyzerException;
import com.mood.factory.MoodAnalyzerFactory;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;

import static org.hamcrest.CoreMatchers.is;

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

    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturn_Object() {
        MoodAnalyzer analyzer = MoodAnalyzerFactory.createMoodAnalyzer("I am in happy mood");
        String mood=analyzer.moodAnalyse();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenMoodAnalyzerClass_DefaultConstructor_WhenProper_ShouldReturn_Object() {
        MoodAnalyzer analyzer = null;
        try {
            analyzer= MoodAnalyzerFactory.createMoodAnalyzer();
            Assert.assertEquals(new MoodAnalyzer(), analyzer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenClassName_WhenNotProper_ShouldReturnThrow_NO_SUCH_CLASS() {
        try{
            Class<?> className=MoodAnalyzerFactory.getClass("com.mood.analyzer.MoodAnalyzerNot");
        }catch(MoodAnalyzerException ex)
        {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS,ex.type);
        }
    }

    @Test
    public void givenClassDefaultConstructor_WhenNotProper_ShouldReturnThrow_NO_SUCH_METHOD()
    {
        try{
            Class<?> className=MoodAnalyzerFactory.getClass("com.mood.analyzer.MoodAnalyzer");
            Constructor<?> classConstructor=MoodAnalyzerFactory.getDefaultConstructor(className);
        }catch(MoodAnalyzerException ex)
        {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD,ex.type);
        }
    }

    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnObject() {
        MoodAnalyzer analyzer = null;
        try {
            analyzer= MoodAnalyzerFactory.createMoodAnalyzer("I am in happy Mood");
        }catch (Exception e){
            Assert.assertEquals(new MoodAnalyzer("I am in happy Mood"), analyzer);
        }
    }

    @Test
    public void givenClass_Name_WhenNotProper_ShouldReturnThrow_NO_SUCH_CLASS() {
        try{
            Class<?> className=MoodAnalyzerFactory.getClass("com.mood.analyzer.MoodAnalyzerNot");
        }catch(MoodAnalyzerException ex)
        {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS,ex.type);
        }
    }


    @Test
    public void givenClassParametizedConstructor_WhenNotProper_ShouldReturnThrow_NO_SUCH_METHOD()
    {
        try{
            Class<?> className=MoodAnalyzerFactory.getClass("com.mood.analyzer.MoodAnalyzer");
            Constructor<?> classConstructor=MoodAnalyzerFactory.getParametizedConstructor(className, Integer.class);
        }catch(MoodAnalyzerException ex)
        {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD,ex.type);
        }
    }



}





