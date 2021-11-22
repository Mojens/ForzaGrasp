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
    ArrayList<Member> allTestMembers = MemberList.allMembers;
    //Det virker ikke at gøre det sådan her, nu er det kun din computer der kan tilføje noget til de filer.
    //Den tilføjer ikke filerne inde i Package files


    public void registerCasual() throws IOException {
        setToStringStatus(1);
        setStyle("None");
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


        if (getAge() < 18) {
            setAgeGroup("Junior");
        } else if (getAge() >= 18 && getAge() < 60) {
            setAgeGroup("Senior");
        } else {
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

        Member member = new Member(getName(), getAge(), getAgeGroup(), getStyle(),getBalance(), getStatus(), getToStringStatus());
        MemberList.casualList.add(member);
        MemberList.allMembers.add(member);
        new Chairman().addToAllMembersFile(member);

        System.out.println(getName() + "is now added to the Casuallist");

    }

    public void registerCompetivive() throws IOException {
        setToStringStatus(2);
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


        Member member = new Member(getName(), getAge(), getAgeGroup(),getStyle(), getBalance(), getStatus(), getToStringStatus());
        MemberList.competitiveList.add(member);
        System.out.println(MemberList.competitiveList);
        MemberList.allMembers.add(member);
        allTestMembers.add(member);
        new Chairman().addToCompetitiveFile(member);
        new Chairman().addToAllMembersFile(member);

        System.out.println(getName() + " is now added to the list");
    }

    public void showAllMembers() {
        System.out.println(allTestMembers);
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
            System.out.println(member);
            allTestMembers.add(member);
        }
    }
}