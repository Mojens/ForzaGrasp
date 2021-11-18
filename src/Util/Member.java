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
    private String status;
    private int counterCasual = 1;

    @Override
    public String toString() {
        return "ID: "+ counterCasual + "Name: "+ name + ", "
            + "Age: " + age + ", "
            + "Age Group: " + ageGroup + ", "
            + "Balance: " + balance + ", "
            + "Status: " + status;
    }

    public String toString(String coach) {
        return "Member{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", ageGroup='" + ageGroup + '\'' +
            ", balance=" + balance +
            ", style='" + style + '\'' +
            ", distance=" + distance +
            ", time=" + time +
            ", place='" + place + '\'' +
            ", location='" + location + '\'' +
            ", date=" + date +
            ", status=" + status +
            '}';
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }


    public void setLocation(String location) {
        this.location = location;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }

    public int getAge() {
        return age;
    }

    public int getDate() {
        return date;
    }

    public String getAgeGroup() {
        return ageGroup;
    }


    public String getLocation() {
        return location;
    }

    public String getPlace() {
        return place;
    }

    public String getStyle() {
        return style;
    }

    public String getStatus() {
        return status;
    }

    public Member(){

    }

    public Member(String name, int age, String status, String ageGroup, double balance ){
        this.name = name;
        this.age = age;
        this.ageGroup = ageGroup;
        this.balance = balance;
        this.status = status;
    }

    public Member(String name, int age, String status, String ageGroup, String style, double balance){
        this.name = name;
        this.age = age;
        this.ageGroup = ageGroup;
        this.level = level;
        this.style = style;


    }
}
