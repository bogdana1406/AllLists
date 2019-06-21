package ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectionMain {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

        String[] colors = {"yellow", "red", "green"};

        List<String> list1 = new ArrayList<>(Arrays.asList(colors));
        list1.add("black");

        colors = list1.toArray(new String[list1.size()]);

        for (int i = 0; i < colors.length; i++) {
            System.out.println(colors[i]);
        }

    }
}


//    String[] colors = {"yellow", "green", "red" };
//
//    LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(colors));
//        linkedList.add("black");
//
//                colors = linkedList.toArray(new String[linkedList.size()+2]);
//
//                for (String i: colors) {
//                System.out.println(i);
////                }