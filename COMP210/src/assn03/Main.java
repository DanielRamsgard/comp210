package assn03;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList<Integer>();
        list.add(10);
        list.add(10);
        list.add(20);
        list.add(60);
        list.add(30);

        /*// Test task 1
        System.out.println("Task 1: list before removing element at index  = " + list.toString());
        list.removeAtIndex(2);  // TBD
        System.out.println("Task 1: list after removing element at index  = " + list.toString());

        // Test task 2
        LinkedList list2 = new LinkedList();
        list2.add(10);
        list2.add(20);
        list2.add(30);
        System.out.println("list2 = " + list2.toString());
        System.out.println("Task 2: list == list2 ?: " + list.isEqual(list2)); // not yet implemented*/

        /* Test task 3
        System.out.println("list before removing repeats = " + list.toString());
        list.removeRepeats();
        System.out.println("Task 3: list after removing repeats = " + list.toString());*/
/*
        // Test task 4
        list.reverse();
        System.out.println("reverse= " + list.toString());
*/
        LinkedList list2 = new LinkedList();
        list2.add(100);
        list2.add(200);
        list2.add(300);
        // Test task 4
        System.out.println("List = " + list.toString());
        System.out.println("List2 = " + list2.toString());
        list.merge(list2);
        System.out.println("merge = " + list.toString());
    }
}
