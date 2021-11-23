package operations;

import util.Member;
import util.MemberList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Mohammad og Malthe
 */
public class Cashier extends Member{
Chairman chairman = new Chairman();
private final String allMembersFile = "AllMembers.csv";

  public void forecastRev(){
    double sum = 0;
    for (Member member : MemberList.allMembers) {
      if (member.getAgeGroup().equalsIgnoreCase("Junior") && member.getStatus().equalsIgnoreCase("Active")) {
        sum = sum + 1000;
      }else if (member.getAgeGroup().equalsIgnoreCase("Senior") && member.getStatus().equalsIgnoreCase("Active")){
        sum = sum + 1600;
      }else if (member.getAgeGroup().equalsIgnoreCase("Pensioner") && member.getStatus().equalsIgnoreCase("Active")){
        sum = sum + 1600/1.25;
      }else{
        sum = sum + 500;
      }
    }
    System.out.println("\033[0;1m" + "Forecast Revenue for this year: " + "\033[0;0m" + sum + "kr.\n");

  }

  public void checkDebt(){
    System.out.println("the members that are in debt: \n");
    int counter = 0;
    for(Member member : MemberList.allMembers){
      counter++;
      if (member.getBalance()<0){
        System.out.println("\033[0;1m" + "#"+counter+ "\033[0;0m"+" "+member);
      }
    }
    double sum = 0;
    for (Member member : MemberList.allMembers) {
      if (member.getBalance()<0)
        sum = sum + member.getBalance();
    }
    System.out.println("\033[0;1m" + "Amount of total debt: " + "\033[0;0m" + sum + "kr.\n");

  }


  public void makePayment() throws IOException {
    Scanner input = new Scanner(System.in);
    boolean done = true;

    while (done){
      System.out.println("Pick name. Type 'done' when you are finished");
      String name = input.nextLine();

      for (Member edit: MemberList.allMembers){

        if (name.equalsIgnoreCase(edit.getName())){
          System.out.println("Edit balance");
          double changeBalance = Double.parseDouble(input.nextLine());
          edit.setBalance(changeBalance);
          System.out.println(edit);
          if (MemberList.allMembers.contains(edit)){
            addToAllMembersFile();
          }
        } else if (name.equals("done")){
            done = false;
          }

      }
    }

  }

  public void showAllMemberss() throws IOException {

    int counter = 0 ;
    for (int i = 0; i < MemberList.allMembers.size(); i++){
      counter++;
      System.out.println("#"+counter+", " + MemberList.allMembers.get(i));
    }
  }

  public void addToAllMembersFile() throws IOException {
    FileWriter fileWriter = new FileWriter(allMembersFile, false);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    bufferedWriter.write(MemberList.allMembers.toString().replace("[","").replace("]","").replace("\n, ", "\n"));
    bufferedWriter.close();
    fileWriter.close();
  }

}
