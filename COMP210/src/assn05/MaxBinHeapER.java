package assn05;

import java.awt.*;
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

    public void bubbleDown(int i) {
        int left = getLeftChild(i);
        int right = getRightChild(i);
        int smallestIndex = i;

        if (left < _heap.size() && _heap.get(left).getPriority().compareTo(_heap.get(smallestIndex).getPriority()) > 0){
            smallestIndex = left;
        }

        if (right < _heap.size() && _heap.get(right).getPriority().compareTo(_heap.get(smallestIndex).getPriority()) > 0){
            smallestIndex = right;
        }

        if (smallestIndex != i){
            swapNodes(i, smallestIndex);
            bubbleDown(smallestIndex);
        }

    }

    public void swapNodes(int i, int smallestIndex){
        Prioritized temp = _heap.get(smallestIndex);
        _heap.set(smallestIndex, _heap.get(i));
        _heap.set(i, temp);
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
        if (size() == 1){
            V val = _heap.get(0).getValue();
            _heap.remove(size()-1);
            return val;
        }

        V val = _heap.get(0).getValue();
        _heap.set(0, _heap.get(size()-1));
        _heap.remove(size()-1);
        bubbleDown(0);
        return val;
    }

    // TODO (Task 2A): getMax
    @Override
    public V getMax() {
        if (_heap.size() == 0){
            return null;
        }

        return _heap.get(0).getValue();
    }

    // TODO (part 2B) : updatePriority
    public void updatePriority(V value, P newPriority) {
        // O(N) to search for value
        int index = findIndex(value);
        if (index == -1){
            return;
        }

        Patient newNode = new Patient(_heap.get(index).getValue(), newPriority);
        _heap.set(index, newNode);

        // only will execute code in one of the two and thus will be O(logN)
        bubbleUp(index);
        bubbleDown(index);

    }

    public int findIndex(V value){
        for (int i = 0; i < _heap.size(); i++){
            if (value == _heap.get(i).getValue()){
                return i;
            }
        }
        return -1;
    }


    /**
     * Constructor that builds a heap given an initial array of hospital.Prioritized objects.
     */
    // TODO (Task 3): overloaded constructor
    public MaxBinHeapER(Prioritized<V, P>[] initialEntries ) {
        _heap = new ArrayList<>();
        for (int i = 0; i < initialEntries.length; i++){
            Prioritized<V, P> entry = initialEntries[i];
            _heap.add(entry);
            bubbleUp(size() - 1);

        }
    }


    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }

}
