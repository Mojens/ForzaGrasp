package Operations;

import Core.Status;
import Util.Member;
import Util.MemberList;

import java.util.Scanner;

public class Chairman extends Member {
    static int competitiveCounter = 1;
    static int casualCounter = 1;

    MemberList competitiveList = new MemberList();
    MemberList casualList = new MemberList();

    public static int getCasualCounter() {
        return casualCounter;
    }

    public static int getCompetitiveCounter() {
        return competitiveCounter;

    }

    public static void setCasualCounter(int casualCounter) {
        Chairman.casualCounter = casualCounter;
    }

    public static void setCompetitiveCounter(int competitiveCounter) {
        Chairman.competitiveCounter = competitiveCounter;
    }

    public void registerCasual() {
        Scanner input = new Scanner(System.in);
        System.out.println("Type name");
        setName(input.nextLine());

        System.out.println("Type age");
        setAge(Integer.parseInt(input.nextLine()));

        System.out.println("Type if active or passive");
        String statusString = input.nextLine();

        if (statusString.equalsIgnoreCase("Active")) {
            setStatus(statusString);
        } else {
            setStatus(statusString);
        }

        System.out.println("Type if Junior, Senior or Pensioner");

        if (getAge() <= 18) {
            setAgeGroup("Junior");
        } else if (getAge() > 18 || getAge() < 60) {
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

        Member member = new Member(getName(), getAge(), getStatus(), getAgeGroup(), getBalance());
        casualList.getCasualList().add(member);
        System.out.println(casualList.getCasualList());
    }

    public void registerCompetivive() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter name: ");
        setName(input.nextLine());

        System.out.println("Enter age: ");
        setAge(Integer.parseInt(input.nextLine()));

        System.out.println("Enter if the person is active or passive");
        setStatus(input.nextLine());

        if (getAge() < 18) {
            setAgeGroup("Junior");
        } else if (getAge() >= 18) {
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

        Member member = new Member(getName(), getAge(), getStatus(), getAgeGroup(), getBalance());
        competitiveList.getCompetitiveList().add(member);
        System.out.println(competitiveList.getCompetitiveList()); //Denne er kun for at tjekke om Medlemmen blev tilføjet i
        //ArrayListen
    }
}



