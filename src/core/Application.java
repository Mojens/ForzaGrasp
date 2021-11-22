package core;
/**
 * @Author Malthe, Simon og Mohammad
 */
import interfaces.MenuRun;
import menus.StartMenu;
import operations.Chairman;

import java.io.IOException;

public class Application {
  public static void main(String[] args) throws IOException {
    MenuRun startPage = new StartMenu();
    Chairman chairman = new Chairman();

    chairman.loadFromAllMemberfileToAllMembersList();
    startPage.menuRun();


  }
}
