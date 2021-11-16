package Core;

import Interfaces.MenuRun;
import Ui.StartMenu;

public class Main {
  public static void main(String[] args) {
    MenuRun startPage = new StartMenu();
    startPage.menuRun();

  }
}
