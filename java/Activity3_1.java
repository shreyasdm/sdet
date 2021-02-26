package Day3;

import java.util.ArrayList;

public class Activity3_1 {
    public static void main(String[] args) {
        //declaring Arraylist of String objects
        ArrayList<String> myList = new ArrayList<String>();
        //Adding objects to Array List at default index
        myList.add("Apple");
        myList.add("Samsung");
        myList.add("MotoG");
        //Adding object at specific index
        myList.add(3, "Sony");
        myList.add(1, "Nokia");
        
        System.out.println("Print All the Objects:");
        for(String s:myList){
            System.out.println(s);
        }
        
        System.out.println("3rd element in the list is: " + myList.get(2));
        System.out.println("Is Redmi is in list: " + myList.contains("Redmi"));
        System.out.println("Is Apple is in list: " + myList.contains("Apple"));
        System.out.println("Size of ArrayList: " + myList.size());
        
        myList.remove("Nokia");
        
        System.out.println("New Size of ArrayList: " + myList.size());
    }
}
