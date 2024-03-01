package assn04;
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
		int val = getElement().compareTo(element);
		int inp_lower = 1; // n is _element > element
		int inp_higher = -1;
		System.out.println(val);

		if (this.isEmpty()) {
			return new NonEmptyBST<T>(element);
		}
		if (val == 0) {
			return this;
		}
		else if (val == inp_lower) {
			if (getLeft().isEmpty()) {
				_left = new NonEmptyBST<>(element);
				return this;
			} else {
				return _left.insert(element);
			}
		} else if (val == inp_higher) {
			System.out.println("yo");
			if (getRight().isEmpty()) {
				_right = new NonEmptyBST<>(element);
				return this;
			} else {
				return _right.insert(element);
			}
		}
		return this;
	}
	
	// TODO: remove
	@Override
	public BST<T> remove(T element) {
		return null;
	}
	
	// TODO: remove all in range (inclusive)
	@Override
	public BST<T> remove_range(T start, T end) {
		return null;
	}

	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {
		System.out.print(_element.toString() + " "); // print current
		if (!_left.isEmpty()){
			_left.printPreOrderTraversal();
		}
		if (_left.isEmpty()){

			if (!_right.isEmpty()){
			_right.printPreOrderTraversal();
			}
			if (_right.isEmpty()){
				return;
			}
		}

	}

	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {
		if (!_left.isEmpty()){
			_left.printPreOrderTraversal();
			System.out.print(this.getElement() + " "); // print current
		}
		if (_left.isEmpty()){

			if (!_right.isEmpty()){
				System.out.print(this.getElement() + " "); // print current
				_right.printPreOrderTraversal();
			}
			if (_right.isEmpty()){
				return;
			}
		}
	}

	// The findMin method returns the minimum value in the tree.
	@Override
	public T findMin() {
		if(_left.isEmpty()) {
			return _element;
		}
		return _left.findMin();
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
