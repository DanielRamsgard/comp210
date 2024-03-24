package assn05;

import java.util.ArrayList;
import java.util.List;
import assn05.Patient;

public class Main {

    public static void main(String[] args) {
        MaxBinHeapER room = new MaxBinHeapER();
        room.enqueue(1);
        room.enqueue(1);

        room.enqueue(1);
        room.enqueue(1);
        room.enqueue(6);
        room.enqueue(5);

//        testP1(room);
        testP2(room);
  //      room.dequeue();
        testP3(room);
        testP4(room);
    }

    // test Part 1
    public static void testP1(SimpleEmergencyRoom room){
        List patients = room.getPatients();
        for (int i = 0; i < patients.size(); i++){
            System.out.println(patients.get(i));
        }

        room.dequeue();

        System.out.println("\n\n");

        for (int i = 0; i < room.getPatients().size(); i++){
            System.out.println(patients.get(i));
        }


    }

    // test Part 2
    public static void testP2(MaxBinHeapER heap){
        System.out.println("Size: "+heap.size());

        Prioritized[] array = heap.getAsArray();
        for (int i = 0; i < heap.size(); i++){
            System.out.println("Value: "+array[i].getValue()+" Priority: "+array[i].getPriority());
        }
    }

    /*
    Part 3
     */
    public static void testP3(MaxBinHeapER heap){
        System.out.println("Size: "+heap.size());

        Prioritized[] array = heap.getAsArray();
        for (int i = 0; i < heap.size(); i++){
            if (array[i] == null){
                return;
            }
            System.out.println("Value: "+array[i].getValue()+" Priority: "+array[i].getPriority());
        }

    }

    /*
    Part 4
     */
    public static void testP4(MaxBinHeapER heap) {
        System.out.println(heap.getMax());

    }

    public static void fillER(MaxBinHeapER complexER) {
        for(int i = 0; i < 100000; i++) {
            complexER.enqueue(i);
        }
    }
    public static void fillER(SimpleEmergencyRoom simpleER) {
        for(int i = 0; i < 100000; i++) {
            simpleER.addPatient(i);
        }
    }

    public static Patient[] makePatients() {
        Patient[] patients = new Patient[10];
        for(int i = 0; i < 10; i++) {
            patients[i] = new Patient(i);
        }
        return patients;
    }

    public static double[] compareRuntimes() {
        // Array which you will populate as part of Part 4
        double[] results = new double[4];

        SimpleEmergencyRoom simplePQ = new SimpleEmergencyRoom();
        fillER(simplePQ);

        // Code for (Task 4.1) Here


        MaxBinHeapER binHeap = new MaxBinHeapER();
        fillER(binHeap);

        // Code for (Task 4.2) Here

        return results;
    }

}