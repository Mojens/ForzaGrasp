package Core;
/**
 * @Author Malthe, Simon og Mohammad
 */
import Interfaces.MenuRun;
import Menus.StartMenu;

public class Application {
  public static void main(String[] args) {
    MenuRun startPage = new StartMenu();
    startPage.menuRun();

  }
}
