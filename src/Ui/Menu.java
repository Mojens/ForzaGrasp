package Ui;

import java.util.Scanner;

public class Menu {

  String menuHeader;
  String leadText;
  String[] menuItems;

  public Menu(String menuHeader, String leadText, String[] menuItems) {
    this.menuHeader = menuHeader;
    this.leadText = leadText;
    this.menuItems = menuItems;
  }

  public void printMenu() {
    System.out.println(menuHeader);
    for (int i = 0; i < menuItems.length; i++) {
      if (menuItems[i] != null) {
        System.out.print(i + ". ");
        System.out.println(menuItems[i]);
      }
    }
    System.out.print(leadText);
  }

  public int readChoice() {
    Scanner input = new Scanner(System.in);
    while (!input.hasNextInt()) {
      System.out.println("\nIt has to be between 1,2,3 or 9");
      System.out.println("Try again");
      System.out.println(menuHeader);

      for (int i = 0; i < menuItems.length; i++) {
        if (menuItems[i] != null) {
          System.out.print(i + ". ");
          System.out.println(menuItems[i]);
        }
      }
      System.out.print(leadText);
      input.nextLine();
    }
    return input.nextInt();
  }
}
/**
  @Mohammad Adel Murtada
 */