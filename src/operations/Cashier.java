package operations;

import util.Member;
import util.MemberList;

import java.io.IOException;

/**
 * @Author Mohammad og Malthe
 */
public class Cashier {
Chairman chairman = new Chairman();
  public void forecastRev(){


  }

  public void checkDebt(){
    double sum = 0;
    for (Member member : MemberList.allMembers) {
      if (member.getBalance()<0)
      sum = sum + member.getBalance();
    }
    System.out.println("\033[0;1m" + "Amount of debt: " + "\033[0;0m" + "\n" + sum + "kr.\n");

  }


  public void makePayment() throws IOException {
    System.out.println(MemberList.allMembers);

  }

  public void showAllMemberss() throws IOException {

    int counter = 0 ;
    for (int i = 0; i < MemberList.allMembers.size(); i++){
      counter++;
      System.out.println("#"+counter+", " + MemberList.allMembers.get(i));
    }
  }

}
