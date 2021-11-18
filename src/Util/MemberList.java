package Util;

import java.util.ArrayList;

/**
 * @Author Malthe, Simon og Mohammad
 */
public class MemberList {
  ArrayList<Member> casualList = new ArrayList<>();
  ArrayList<Member> competitiveList = new ArrayList<>();

  public ArrayList<Member> getCompetitiveList() {
    return competitiveList;
  }

  public ArrayList<Member> getCasualList(){
    return casualList;
  }

}

