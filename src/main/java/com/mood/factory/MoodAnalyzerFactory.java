package com.mood.factory;

import com.mood.analyzer.MoodAnalyzer;
import com.mood.exception.MoodAnalyzerException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyzerFactory {

    public static MoodAnalyzer createMoodAnalyzer() {

        try {
            return (MoodAnalyzer)Class.forName("com.mood.analyzer.MoodAnalyzer").getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MoodAnalyzer createMoodAnalyzer(String message) {

            try {
                return (MoodAnalyzer)Class.forName("com.mood.analyzer.MoodAnalyzer").getConstructor(String.class).newInstance(message);
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        return null;
    }

    public static Class<?> getClass(String name) {
        try {
            Class<?> className = Class.forName(name);
            return className;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS,e.getMessage());
        }
    }

    public static Constructor<?> getDefaultConstructor(Class<?> className) {
        try {
            Constructor<?> constructorName = className.getConstructor();
            return constructorName;
        }
        catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        }
    }

    public static Constructor<?> getParametizedConstructor(Class<?> className,Class<?> ... param) {
        try {
            Constructor<?> constructorName = className.getConstructor(param);
            return constructorName;
        }
        catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        }
    }

    public static Object getObject(Constructor<?> constructor, Object ... message) {
        try {
            return constructor.newInstance(message);
        } catch (InstantiationException | InvocationTargetException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.OBJECT_CREATION_ISSUE,e);
        } catch (IllegalAccessException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_ACCESS,e);
        }
    }

    public static Object invokeMethod(Object moodObject, String message) {
        try {
            return moodObject.getClass().getMethod(message).invoke(moodObject);
        } catch (IllegalAccessException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_ACCESS,"NO_ACCESS");
        } catch (InvocationTargetException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.OBJECT_CREATION_ISSUE,"OBJECT_CREATION_ISSUE");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD,"NO_SUCH_METHOD");
        }
    }

    public static Object getField(Constructor<?> constructor, String moodMethod, String messageString, String fieldString) {
        Field fieldName=null;
        Field field;
        try {
            Object obj=constructor.newInstance();
            Class cname=obj.getClass();
            fieldName=cname.getDeclaredField(fieldString);
            fieldName.setAccessible(true);
            //field=cname.getField(fieldString);
            fieldName.set(obj,messageString);
            Method method = cname.getDeclaredMethod(moodMethod);
            return method.invoke(obj);
        } catch (IllegalAccessException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_ACCESS,"NO_ACCESS");
        } catch (InstantiationException | InvocationTargetException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.OBJECT_CREATION_ISSUE,"OBJECT_CREATION_ISSUE");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD,"NO_SUCH_METHOD");
        } catch (NoSuchFieldException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_FIELD, "NO_SUCH_FIELD");
        }
    }

}
