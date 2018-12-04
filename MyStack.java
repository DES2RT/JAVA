package prac;

class MyStack {
	
	private int position, capacity;
	private Object[] stack;

	public MyStack(int n) {
		capacity = n;
		position = -1;
		stack = new Object[capacity];
	}

	public void push(Object obj) {
		// stack is not full
		position++;
		stack[position] = obj;
	}

	public Object pop() {
		// stack is not empty
		Object temp = stack[position];
		position--;
		return temp;
	}

	public boolean isEmpty() {
		return position == -1;
	}

	public Object peek() {
		return stack[position];
	}

	public boolean isFull() {
		return position == capacity - 1;
	}

}


