package test;

import util.PropertiesFileRW;

public class Test {

    public static void main(String args[]){
        PropertiesFileRW rw = new PropertiesFileRW();
        System.out.println(rw.setFileName("testData").getKey("fruit1"));
        System.out.println(rw.setFileName("testData2").getKey("fruit1"));
        System.out.println(rw.setFileName("testData3").getKey("fruit1"));
    }

}
