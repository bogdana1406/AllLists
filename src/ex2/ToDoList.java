package ex2;

import java.util.*;

public class ToDoList {

    private LinkedList<String> toDoList = new LinkedList<>();

    public void addToList(String task) {
//        toDoList.add(task);
        addInAlphabeticalOrder(task);

    }
    public void addToListPosition(int position, String task) {
        toDoList.add(position, task);
    }

    private boolean addInAlphabeticalOrder(String task){
        ListIterator<String> listIterator = toDoList.listIterator();
        while (listIterator.hasNext()) {
          int compared = listIterator.next().compareTo(task);

          if(compared == 0) {
              System.out.println("Task already exist in the list");
              return true;
          } else if (compared >0) {
//              listIterator.previous();
              System.out.println(listIterator.previous());
              listIterator.add(task);
              return true;
          }
        }
        toDoList.add(task);
        return true;
    }

    public void printToDoList() {
//        for (int i = 0; i < toDoList.size(); i++) {
//            System.out.println("Task # "+ i + " " + toDoList.get(i));
//        }

        Iterator<String> iterator = toDoList.iterator();
        while (iterator.hasNext()) {
            System.out.println("Element " + iterator.next());
        }
    }

    public void changeTask(int index, String task) {
        toDoList.set(index, task);
    }
    public void removeTask(int index) {
        toDoList.remove(index);
    }

    public int getTaskPriority(String task){
        return toDoList.indexOf(task);
    }
}
