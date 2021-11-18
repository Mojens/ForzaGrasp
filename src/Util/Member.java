package Util;

import Core.Status;

/**
 * @Author Malthe, Simon og Mohammad
 */
public class Member{
    private String name;
    private int age;
    private String ageGroup;
    private double balance;
    private String level;
    private String style;
    private double distance;
    private double time;
    private String place;
    private String location;
    private int date;

    public Member(String name, int age, Status status, String ageGroup, String level, double balance ){
    this.name = name;
    this.age = age;
    this.ageGroup = ageGroup;
    this.level = level;
    this.balance = balance;


    }
    public Member(String name, int age, Status status, String ageGroup, String level, String style ){
        this.name = name;
        this.age = age;
        this.ageGroup = ageGroup;
        this.level = level;
        this.style = style;


    }
}