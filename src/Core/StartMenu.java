package Core;

import Core.MenuSettings;
import Interfaces.MenuRun;

public class StartMenu implements MenuRun {

  public void menuRun() {
    String[] menuItem = new String[10];

    menuItem[1] = "Choose ONE";
    menuItem[2] = "Choose TWO";
    menuItem[3] = "Choose THREE";
    menuItem[9] = "QUIT";

    MenuSettings menuSettings = new MenuSettings("MENU", "PLEASE CHOOSE HERE: ", menuItem);
    menuSettings.printMenu();

    int choice = menuSettings.readChoice();
    boolean checkChoice;

    do {
      switch (choice) {
        case 1:
          System.out.println("You choosed 1");
          checkChoice = true;
          break;
        case 2:
          System.out.println("You choosed 2");
          checkChoice = true;
          break;
        case 3:
          System.out.println("You choosed 3");
          checkChoice = true;
          break;
        case 9:
          System.out.println("You choosed QUIT");
          checkChoice = true;
          break;

        default:
          System.out.println("\nIt has to be between 1,2,3 or 9");
          System.out.println("Try again");
          menuSettings.printMenu();
          choice = menuSettings.readChoice();
          checkChoice = false;
      }
    } while (!checkChoice);
  }
}
/**
 * @Author Mohammad Adel Murtada
 */