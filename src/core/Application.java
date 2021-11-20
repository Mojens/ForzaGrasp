package core;
/**
 * @Author Malthe, Simon og Mohammad
 */
import interfaces.MenuRun;
import menus.StartMenu;
import operations.Chairman;

public class Application {
  public static void main(String[] args) {
    Chairman chairman = new Chairman();
    MenuRun startPage = new StartMenu();

/*
    try {
      chairman.loadToAllMembersFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
 */ // virker ikke

    startPage.menuRun();


  }
}
