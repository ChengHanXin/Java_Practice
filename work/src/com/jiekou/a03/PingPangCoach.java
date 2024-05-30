package com.jiekou.a03;

public class PingPangCoach extends Coach implements SpeakEnglish{
    @Override
    public void teach() {
        System.out.println("乒乓球教练在教如何打乒乓球");
    }

    @Override
    public void speak() {
        System.out.println("乒乓球教练在说英语");
    }
}
