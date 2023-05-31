// A MinStack is a stack data structure that supports retrieving the minimum element in constant time, O(1).

class MinStack {
  constructor() {
    this.stack = [];
    this.minStack = [];
  }

  push(value) {
    this.stack.push(value);
    if (this.minStack.length === 0 || value <= this.getMin()) {
      this.minStack.push(value);
    }
  }

  pop() {
    const poppedValue = this.stack.pop();
    if (poppedValue === this.getMin()) {
      this.minStack.pop();
    }
    return poppedValue;
  }

  top() {
    return this.stack[this.stack.length - 1];
  }

  getMin() {
    return this.minStack[this.minStack.length - 1];
  }
}

/*
In this implementation, we use two separate arrays: stack to store the actual stack elements, and minStack to keep track of the minimum elements.

The push method adds a value to the stack. If the minStack is empty or the new value is less than or equal to the current minimum, we also add the value to the minStack.

The pop method removes and returns the top element from the stack. If the popped value is equal to the current minimum, we also remove it from the minStack.

The top method returns the top element of the stack without removing it.

The getMin method returns the minimum element in the stack, which is the top element of the minStack.

This implementation ensures that the minimum element is always available in constant time, as it is stored separately in the minStack. Other operations like push, pop, and top are performed directly on the stack array.
*/
