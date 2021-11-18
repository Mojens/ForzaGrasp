package Operations;

import Core.Status;
import Util.Member;
import Util.MemberList;

import java.util.ArrayList;
import java.util.Scanner;

public class Chairman extends Member {
    public static int counter = 1;

    MemberList competitiveList = new MemberList();
    MemberList casualList = new MemberList();
    MemberList allMembers = new MemberList();

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Chairman.counter = counter;
    }


    public void registerCasual() {
        Scanner input = new Scanner(System.in);
        System.out.println("Type name");
        setName(input.nextLine());

        System.out.println("Type age");
        setAge(Integer.parseInt(input.nextLine()));

        System.out.println("Type if active or passive");
        String statusString = input.nextLine();

        setStyle("None");

        if (statusString.equalsIgnoreCase("Active")) {
            setStatus(statusString);
        } else {
            setStatus(statusString);
        }


        if (getAge() < 18) {
            setAgeGroup("Junior");
        } else if (getAge() >= 18 && getAge() < 60) {
            setAgeGroup("Senior");
        } else
            setAgeGroup("Pensioner");

        if (getAgeGroup().equalsIgnoreCase("Junior") && getStatus().equalsIgnoreCase("Active")) {
            setBalance(-1000);
        } else if (getAgeGroup().equalsIgnoreCase("Senior") && getStatus().equalsIgnoreCase("Active")) {
            setBalance(-1600);
        } else if (getAgeGroup().equalsIgnoreCase("Pensioner") && getStatus().equalsIgnoreCase("Active")) {
            setBalance(-1200);
        } else
            setBalance(-500);

        Member member = new Member(getName(), getAge(), getAgeGroup(), getStyle(), getBalance(), getStatus());
        casualList.getCasualList().add(member);
        allMembers.getAllMembers().add(member);

        for (Member cleaned : casualList.getCasualList()){

            System.out.println(cleaned.toString());
        }

    }

    public void registerCompetivive() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter name: ");
        setName(input.nextLine());

        System.out.println("Enter age: ");
        setAge(Integer.parseInt(input.nextLine()));

        System.out.println("Enter Style: ");
        setStyle(input.nextLine());

        System.out.println("Enter if the person is active or passive");
        setStatus(input.nextLine());

        if (getAge() < 18) {
            setAgeGroup("Junior");
        } else if (getAge() >= 18 && getAge() < 60) {
            setAgeGroup("Senior");
        } else if (getAge() >= 60) {
            setAgeGroup("Pensioner");
        }

        if (getAgeGroup().equalsIgnoreCase("Junior") && getStatus().equalsIgnoreCase("Active")) {
            setBalance(-1000);
        } else if (getAgeGroup().equalsIgnoreCase("Senior") && getStatus().equalsIgnoreCase("Active")) {
            setBalance(-1600);
        } else if (getAgeGroup().equalsIgnoreCase("Pensioner") && getStatus().equalsIgnoreCase("Active")) {
            setBalance(-1200);
        } else
            setBalance(-500);


        Member member = new Member(getName(), getAge(), getAgeGroup(), getStyle(), getBalance(),getStatus());
        competitiveList.getCompetitiveList().add(member);
        allMembers.getAllMembers().add(member);
        System.out.println(competitiveList.getCompetitiveList()); //Denne er kun for at tjekke om Medlemmen blev tilføjet i
        //ArrayListen
    }

    public void showAllMembers(){
    for (Member cleaned: allMembers.getAllMembers() ){
        System.out.println(cleaned.toString());
        }
    }
    }




