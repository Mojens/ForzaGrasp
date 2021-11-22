package util;
import java.util.Scanner;

/**
 * @Author Malthe og Mohammad
 */

public class Member{
    private String name;
    private int age;
    private String ageGroup;
    private double balance;
    private String style;
    private double distance;
    private double time;
    private String place;
    private String location;
    private int date;
    private String status;
    private int toStringStatus;
    private String medlemsID;
    private int practiseTime;

    @Override
    public String toString() {
        if(getToStringStatus() == 1) {
            return
                name + ", "
                    + age + ", "
                    + ageGroup + ", "
                    + balance + ", "
                    + status+"\n";

        }else if(getToStringStatus() == 2) {
            return
                name + ", "
                    + age + ", "
                    + ageGroup + ", "
                    + style + ", "
                    + balance + ", "
                    + status + "\n";

        }else if (getToStringStatus() == 3) {
            return name + ", " + age + ", "
                    + ageGroup + ", " + style + ", "
                    + balance + ", " + status + "\n";
        }else if (getToStringStatus() == 4){
            return medlemsID + ", "
                    + practiseTime;
        }else
            return null;

    }


    public void setToStringStatus(int toStringStatus) {
        this.toStringStatus = toStringStatus;
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

    public int getToStringStatus() {
        return toStringStatus;
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

    public String getMedlemsID() {
        return medlemsID;
    }

    public int getPractiseTime() {
        return practiseTime;
    }

    public void setMedlemsID(String medlemsID) {
        this.medlemsID = medlemsID;
    }

    public void setPractiseTime(int practiseTime) {
        this.practiseTime = practiseTime;
    }

    public void setDataFromLine(String line){
        Scanner sc = new Scanner(line).useDelimiter(", ");

        this.name = sc.next();
        this.age = sc.nextInt();
        this.ageGroup = sc.next();
        this.style = sc.next();
        this.balance = Double.parseDouble(sc.next());
        this.status = sc.next();
        this.toStringStatus = 2;

    }

    public Member(String name, int age, String ageGroup,String style, double balance, String status, int toStringStatus){
        this.name = name;
        this.age = age;
        this.ageGroup = ageGroup;
        this.style = style;
        this.balance = balance;
        this.status = status;
        this.toStringStatus = toStringStatus;

    }
    public Member(String medlemsID, int practiseTime){
        this.medlemsID = medlemsID;
        this.practiseTime = practiseTime;
    }


}
