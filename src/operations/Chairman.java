package operations;
/**
 * @Author Mohammad og Malthe
 */

import util.Member;
import util.MemberList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Chairman extends Member {
    public final String competiviveFile = "CompetiviveList.csv";
    private final String allMembersFile = "AllMembers.csv";
    boolean done = true;
    boolean second = true;

    public void registerCasual() throws IOException {
        Scanner input = new Scanner(System.in);
        setToStringStatus(2);
        setMemberType("Casual");
        setStyle("None");

        System.out.println("Type name");
        setName(input.nextLine());

        while (done){
        System.out.println("Type age");
        int age = Integer.parseInt(input.nextLine());
        if (age<100){
            setAge(age);
            done = false;
        } else {
            System.out.println("Over 100?");
            done = true;
        }

        }

        while (second){
            System.out.println("Enter if the person is active or passive");
            String statusString = input.nextLine();

            if (statusString.startsWith("a")||statusString.startsWith("A")||statusString.contains("active")||statusString.contains("Active")) {
                setStatus("Active");
                second = false;
            } else if (statusString.startsWith("p")||statusString.startsWith("P")||statusString.contains("passive")||statusString.contains("Passive")) {
                setStatus("Passive");
                second = false;
            } else {
                System.out.println("Try again");
                second = true;
            }
        }


        if (getAge() < 18) {
            setAgeGroup("Junior");
        } else if (getAge() >= 18 && getAge() < 60) {
            setAgeGroup("Senior");
        } else if (getAge() >= 60 && getAge() < 101){
            setAgeGroup("Pensioner");
        }


        if (getAgeGroup().equalsIgnoreCase("Junior") && getStatus().equalsIgnoreCase("Active")) {
            setBalance(-1000);
        } else if (getAgeGroup().equalsIgnoreCase("Senior") && getStatus().equalsIgnoreCase("Active")) {
            setBalance(-1600);
        } else if (getAgeGroup().equalsIgnoreCase("Pensioner") && getStatus().equalsIgnoreCase("Active")) {
            setBalance(-1200);
        } else {
            setBalance(-500);
        }

        Member member = new Member(getName(), getAge(), getAgeGroup(), getMemberType(), getStyle(),getBalance(), getStatus(), getToStringStatus());
        MemberList.casualList.add(member);
        MemberList.allMembers.add(member);
        new Chairman().addToAllMembersFile(member);

        System.out.println(getName() + " is now added to the list");

    }

    public void registerCompetivive() throws IOException {
        setToStringStatus(2);
        setMemberType("Competitive");
        Scanner input = new Scanner(System.in);

        System.out.println("Enter name: ");
        setName(input.nextLine());

        while (done){
            System.out.println("Type age");
            int age = Integer.parseInt(input.nextLine());
            if (age<100){
                setAge(age);
                done = false;
            } else {
                System.out.println("Over 100?");
                done = true;
            }

        }

        System.out.println("Enter Style: ");
        setStyle(input.nextLine());

        while (second){
            System.out.println("Enter if the person is active or passive");
            String statusString = input.nextLine();

            if (statusString.startsWith("a")||statusString.startsWith("A")||statusString.contains("active")||statusString.contains("Active")) {
                setStatus("Active");
                second = false;
            } else if (statusString.startsWith("p")||statusString.startsWith("P")||statusString.contains("passive")||statusString.contains("Passive")) {
                setStatus("Passive");
                second = false;
            } else {
                System.out.println("Try again");
                second = true;
            }
        }


        if (getAge() < 18) {
            setAgeGroup("Junior");
        } else if (getAge() >= 18 && getAge() < 60) {
            setAgeGroup("Senior");
        } else if (getAge() >= 60 && getAge() < 100) {
            setAgeGroup("Senior");
        } else if (getAge() > 100){
            System.out.println("Error");
        }


        if (getAgeGroup().equalsIgnoreCase("Junior") && getStatus().equalsIgnoreCase("Active")) {
            setBalance(-1000);
        } else if (getAgeGroup().equalsIgnoreCase("Senior") && getStatus().equalsIgnoreCase("Active")) {
            setBalance(-1600);
        } else if (getAgeGroup().equalsIgnoreCase("Pensioner") && getStatus().equalsIgnoreCase("Active")) {
            setBalance(-1200);
        } else
            setBalance(-500);


        Member member = new Member(getName(), getAge(), getAgeGroup(),getMemberType(),getStyle(), getBalance(), getStatus(), getToStringStatus());
        MemberList.competitiveList.add(member);
        System.out.println(MemberList.competitiveList);
        MemberList.allMembers.add(member);

        new Chairman().addToCompetitiveFile(member);
        new Chairman().addToAllMembersFile(member);

        System.out.println(getName() + " is now added to the list");
    }

    public void showAllMembers(){
        int counter = 0 ;
        for (int i = 0; i < MemberList.allMembers.size(); i++){
            counter++;
            System.out.println("#"+counter+", " + MemberList.allMembers.get(i));
        }
    }

    public void addToCompetitiveFile(Member member) throws IOException {
        FileWriter fileWriter = new FileWriter(competiviveFile, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(member.toString());
        bufferedWriter.close();
        fileWriter.close();
    }

    public void addToAllMembersFile(Member member) throws IOException {
        FileWriter fileWriter = new FileWriter(allMembersFile, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(member.toString());
        bufferedWriter.close();
        fileWriter.close();
    }

    public void loadFromCompetiviveFileToAllMembersList() throws IOException {
        Scanner reader = new Scanner(new File(competiviveFile));
        while (reader.hasNext()) {
            String lines = reader.nextLine();
            Member member = new Member();
            member.setDataFromLine(lines);
            MemberList.allMembers.add(member);
        }
    }

    public void loadFromAllMemberfileToAllMembersList() throws IOException {
        Scanner reader = new Scanner(new File(allMembersFile));
        while (reader.hasNext()) {
            String lines = reader.nextLine();
            Member member = new Member();
            member.setDataFromLine(lines);

            MemberList.allMembers.add(member);
            //System.out.println(member);
            //allTestMembers.add(member);
        }
    }
}