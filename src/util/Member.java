package util;
import java.util.Scanner;

/**
 * @Author Malthe,simon og Mohammad
 */

public class Member{
    private String name;
    private int age;
    private String ageGroup;
    private double balance;
    private String style;
    private double distance;
    private double time;
    private int place;
    private String location;
    private int date;
    private String status;
    private int toStringStatus;
    private int medlemsID;
    private String memberType;


    @Override
    public String toString() {
        if(getToStringStatus() == 1) {
            return
                name + ", "
                    + age + ", "
                    + ageGroup + ", "
                    + balance + ", "
                    + status+" \n";

        }else if(getToStringStatus() == 2) {
            return
                name + ", "
                    + age + ", "
                    + ageGroup + ", "
                    + memberType + ", "
                    + style + ", "
                    + balance + ", "
                    + status + " \n";

        }else if (getToStringStatus() == 3) {
            return name + ", " + age + ", "
                    + ageGroup + ", " + memberType + ", "
                    + style + ", "
                    + balance + ", " + status + "\n";
        }else if (getToStringStatus() == 4){
            return medlemsID + ", "
                    +ageGroup + ", "
                    + style + ", "
                    + date + ", "
                    + time;
        } else if(getToStringStatus() == 5){
            return medlemsID + ", "
                    + place + ", "
                    +ageGroup + ", "
                    + style + ", "
                    + time + ", "
                    + location + ", "
                    + date;
        }
        else
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

    public void setPlace(int place) {
        this.place = place;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getMemberType() {
        return memberType;
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

    public int getPlace() {
        return place;
    }

    public String getStyle() {
        return style;
    }
    public String setStyle() {
        return style;
    }

    public String getStatus() {
        return status;
    }

    public int getMedlemsID() {
        return medlemsID;
    }

    public double getTime() {
        return time;
    }

    public void setMedlemsID(int medlemsID) {
        this.medlemsID = medlemsID;
    }



    public Member(){

    }


    public void setDataFromLine(String line){
        Scanner sc = new Scanner(line).useDelimiter(", ");

        this.name = sc.next();
        this.age = sc.nextInt();
        this.ageGroup = sc.next();
        this.memberType = sc.next();
        this.style = sc.next();
        this.balance = Double.parseDouble(sc.next());
        this.status = sc.next();
        this.toStringStatus = 2;

    }

    public void setDataFromLinePrac(String line){
        Scanner sc = new Scanner(line).useDelimiter(", ");

        this.medlemsID = sc.nextInt();
        this.style = sc.next();
        this.ageGroup = sc.next();
        this.time = Integer.parseInt(sc.next());
        this.date = Integer.parseInt(sc.next());
        this.toStringStatus = 4;

    }

    public void setDataFromLineComp(String line){
        Scanner sc = new Scanner(line).useDelimiter(", ");

        this.medlemsID = sc.nextInt();
        this.place = Integer.parseInt(sc.next());
        this.style = sc.next();
        this.ageGroup = sc.next();
        this.time = Integer.parseInt(sc.next());
        this.location = sc.next();
        this.date = Integer.parseInt(sc.next());
        this.toStringStatus = 5;

    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Member){
            if (time<((Member) o).time){//Laveste tid først
                return -1;
            }else if (time>((Member) o).time){//Den største tid til sidst
                return 1;
            }
        }
        return 0;
    }

    public Member(String name, int age, String ageGroup, String memberType, String style, double balance, String status, int toStringStatus){
        this.name = name;
        this.age = age;
        this.ageGroup = ageGroup;
        this.memberType = memberType;
        this.style = style;
        this.balance = balance;
        this.status = status;
        this.toStringStatus = toStringStatus;

    }
    // practice Times
    public Member(int medlemsID,String ageGroup, String style, double time, int date, int toStringStatus){
        this.medlemsID = medlemsID;
        this.style = style;
        this.ageGroup = ageGroup;
        this.time = time;
        this.date = date;
        this.toStringStatus = toStringStatus;
    }
        //Comptetition info and times
    public Member(int medlemsID, int place, String ageGroup, String style, double time, String location, int date, int toStringStatus){
        this.medlemsID = medlemsID;
        this.place = place;
        this.style = style;
        this.ageGroup = ageGroup;
        this.time = time;
        this.location = location;
        this.date = date;
        this.toStringStatus = toStringStatus;
    }

}
