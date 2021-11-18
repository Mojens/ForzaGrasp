package Util;

import java.util.ArrayList;

/**
 * @Author Malthe, Simon og Mohammad
 */
public class MemberList {
  ArrayList<Member> memberList = new ArrayList();
  ArrayList<Member> competiviveList = new ArrayList();

  public ArrayList<Member> getCompetiviveList() {
    return competiviveList;
  }

  public ArrayList<Member> getMemberList() {
    return memberList;
  }
}

