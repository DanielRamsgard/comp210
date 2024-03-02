package assn04;
import javax.sound.midi.SysexMessage;
import java.util.LinkedList;
import java.util.Queue;

public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
	private T _element;
	private BST<T> _left;
	private BST<T> _right;

	public NonEmptyBST(T element) {
		_left = new EmptyBST<T>();
		_right = new EmptyBST<T>();
		_element = element;
	}

	// TODO: insert
	@Override
	public BST<T> insert(T element) {
		int comparison = getElement().compareTo(element);

		if (comparison > 0){
			_left = _left.insert(element);
		} else if (comparison < 0){
			_right = _right.insert(element);

		}
		return this;
	}

	
	// TODO: remove
	@Override
	public BST<T> remove(T element) {
		int comparison = getElement().compareTo(element);

		if (comparison > 0){
			_left = _left.remove(element);
		} else if (comparison < 0){
			_right = _right.remove(element);

		}
		// remove block
		if (comparison == 0){
			// if remove node has no children
			if (_left.isEmpty() && _right.isEmpty()){
				return new EmptyBST<>();
			}
			// if remove node has one child
			else if (_left.isEmpty()){
				return _right;
			}
			// if remove node has one child and opposite side of previous case
			else if (_right.isEmpty()){
				return _left;
			}
			// if remove node has two children, a subtree, go right once then go left until empty BST
			else{

				T smallestOnRight = _right.findMin(); // I now find the min value on the right tree of current
				setElement(smallestOnRight); // now we are setting the current element for the current node to be the smallest
				_right = _right.remove(smallestOnRight); // remove until complete
			}
		}
		return this; // ensures that parent nodes have the update that I made above in the remove block
	}
	
	// TODO: remove all in range (inclusive)
	@Override
	public BST<T> remove_range(T start, T end) {
		int comparisonStart = start.compareTo(_element);
		int comparisonEnd = end.compareTo(_element);
		int comparisonBoth = start.compareTo(end);

		// if start < end
		if (comparisonBoth < 0){
			T copy = start;
			start = end;
			end = copy;
			comparisonStart = start.compareTo(_element);
			comparisonEnd = end.compareTo(_element);
			comparisonBoth = start.compareTo(end);
			System.out.println("not working");


		}

		// if there is no range
		if (comparisonBoth == 0){
			return remove(start);
		}

		// if start > end
		if (comparisonBoth > 0){
			// go left and right and remove_range()
			_left = _left.remove_range(start, end);
			_right = _right.remove_range(start, end);

			// check if we're in the range then remove
			if (comparisonStart >= 0 && comparisonEnd <= 0){
				return remove(_element);
			}

		}

			return this;
	}

	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {
		System.out.print(_element.toString() + " "); // print current

		// go left according to function desired function
		if (!_left.isEmpty()){
			_left.printPreOrderTraversal();
		}

		// we have to go right if we are at this code block
		if (!_right.isEmpty()){
			_right.printPreOrderTraversal();
		}

		// we've gone through the entire subtree
		if (_right.isEmpty()){
			return;
		}


	}

	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {
		// don't print yet just traverse the left tree
		if (!_left.isEmpty()){
			_left.printPostOrderTraversal();
		}

		// traverse the right after traversing the left
		if (!_right.isEmpty()){
			_right.printPostOrderTraversal();
		}

		// finally print the element
		System.out.print(_element.toString() + " "); // print current;
	}

	// The findMin method returns the minimum value in the tree.
	@Override
	public T findMin() {
		if(_left.isEmpty()) {
			return _element;
		}
		return _left.findMin();
	}

	public void setElement(T element){
		_element = element;
	}


	@Override
	public int getHeight() {
		   return Math.max(_left.getHeight(), _right.getHeight())+1;
	}

	@Override
	public BST<T> getLeft() {
		return _left;
	}

	@Override
	public BST<T> getRight() {
		return _right;
	}

	@Override
	public T getElement() {
		return _element;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}
