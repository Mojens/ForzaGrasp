package core;

/**
 * @Author Malthe og Mohammad
 */

import interfaces.MenuRun;
import menus.StartMenu;
import util.MemberList;

import java.io.IOException;

public class Application {
  public static void main(String[] args) throws IOException {
    MenuRun startPage = new StartMenu();
    MemberList memberList = new MemberList();

    memberList.allMembersFiles();

    startPage.menuRun();


  }
}
