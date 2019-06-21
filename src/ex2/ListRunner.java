package ex2;

import java.util.Scanner;

public class ListRunner {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ToDoList list = new ToDoList();

        printOut();

        int param = scanner.nextInt();

        while (param != 0) {
            switch (param){
                case 1:
                    System.out.println("Please, enter a task to add");
                    scanner.nextLine();
                    String task1 = scanner.nextLine();
                    list.addToList(task1);
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 2:
                    System.out.println("Printing out TO DO LIST");
                    list.printToDoList();
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 3:
                    System.out.println("Please, enter a number of an item to update");
                    scanner.nextLine();
                    int index = scanner.nextInt();
                    System.out.println("Please, enter new task");
                    scanner.nextLine();
                    String task3 = scanner.nextLine();
                    list.changeTask(index, task3);
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 4:
                    System.out.println("Please, enter a task to remove");
                    scanner.nextLine();
                    int index4 = scanner.nextInt();
                    list.removeTask(index4);
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 5:
                    System.out.println("Please, enter a task to ge priority");
                    scanner.nextLine();
                    String task5 = scanner.nextLine();
                    System.out.println("Priority of task is " + list.getTaskPriority(task5));
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 6:
                    System.out.println("Please, enter a number of position for the task");
                    scanner.nextLine();
                    int index6 = scanner.nextInt();
                    System.out.println("Please, enter a new task");
                    String task6 = scanner.nextLine();
                    list.changeTask(index6, task6);
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;

                default:
                        param = 0;
            }
        }

    }

    private static void printOut() {
        System.out.println("Please choose an action. Press :\n"
        + "1 to add a new item into ToDoList\n"
        + "2 to print out the list \n"
        + "3 to update an existing item\n"
        + "4 to remove an item from the list\n"
        + "5 to get task priority or number in the list\n"
        + "6 to add a new item at specific position\n"
        + "press 0 for exit\n\n"
        + "AFTER CHOOSING AN OPTION PLEASE PRESS ENTER");
    }
}
