package assn05;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MaxBinHeapER  <V, P extends Comparable<P>> implements BinaryHeap<V, P> {

    private List<Prioritized<V,P>> _heap;

    /**
     * Constructor that creates an empty heap of hospital.Prioritized objects.
     */
    public MaxBinHeapER() {
        _heap = new ArrayList<>();
    }

    public int getLeftChild(int i){
        return 2*i + 1;
    }

    public int getRightChild(int i){
        return 2*i + 2;
    }

    public int getParent(int i){
        return (int) Math.floor((i - 1)/2);
    }

    public void bubbleUp(int i){
        if (i <= 0){
            return;
        }
        while (i != 0 && (_heap.get(getParent(i)).getPriority().compareTo(_heap.get(i).getPriority()) < 0)){
            Prioritized temp = _heap.get(i);
            _heap.set(i, _heap.get(getParent(i)));
            _heap.set(getParent(i), temp);
            i = getParent(i);
        }
    }

    @Override
    public int size() {
        return _heap.size();
    }

    public void bubbleDown(){

    }


    // TODO (Task 2A): enqueue
    public void enqueue(V value) {
        Patient patient = new Patient(value);
        _heap.add(patient);
        bubbleUp(size() - 1);
    }

    // TODO (Task 2A): enqueue
    @Override
    public void enqueue(V value, P priority) {
        Patient patient = new Patient(value, priority);
        _heap.add(patient);
        bubbleUp(size() - 1);
    }

    // TODO (Task 2A): dequeue
    @Override
    public V dequeue() {
        if (size() == 0){
            return null;
        }
        V val = _heap.get(0).getValue();
        _heap.set(0, _heap.get(size()-1));
        bubbleDown();
        return val;
    }

    // TODO (Task 2A): getMax
    @Override
    public V getMax() {
        if (size() == 0){
            return null;
        }
    	 return null;
    }

    // TODO (part 2B) : updatePriority
    public void updatePriority(V value, P newPriority) {
    }

    /**
     * Constructor that builds a heap given an initial array of hospital.Prioritized objects.
     */
    // TODO (Task 3): overloaded constructor
    public MaxBinHeapER(Prioritized<V, P>[] initialEntries ) {
    }


    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }

}
