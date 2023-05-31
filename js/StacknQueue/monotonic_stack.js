class MonotonicStack {
  constructor() {
    this.stack = [];
  }

  push(element) {
    while (this.stack.length > 0 && element < this.stack[this.stack.length - 1]) {
      this.stack.pop();
    }
    this.stack.push(element);
  }

  pop() {
    if (this.stack.length > 0) {
      return this.stack.pop();
    }
    return null;
  }

  peek() {
    if (this.stack.length > 0) {
      return this.stack[this.stack.length - 1];
    }
    return null;
  }

  isEmpty() {
    return this.stack.length === 0;
  }

  size() {
    return this.stack.length;
  }
}


function findNextGreater(arr) {
  const stack = new MonotonicStack();
  const result = [];

  for (let i = arr.length - 1; i >= 0; i--) {
    while (!stack.isEmpty() && stack.peek() <= arr[i]) {
      stack.pop();
    }
    result[i] = stack.isEmpty() ? -1 : stack.peek();
    stack.push(arr[i]);
  }

  return result;
}

function findNextSmaller(arr) {
  const stack = new MonotonicStack();
  const result = [];

  for (let i = arr.length - 1; i >= 0; i--) {
    while (!stack.isEmpty() && stack.peek() >= arr[i]) {
      stack.pop();
    }
    result[i] = stack.isEmpty() ? -1 : stack.peek();
    stack.push(arr[i]);
  }

  return result;
}

// Example usage
const input = [4, 2, 7, 1, 9, 5, 3];
const nextGreater = findNextGreater(input);
const nextSmaller = findNextSmaller(input);

console.log('Input:', input);
console.log('Next Greater:', nextGreater);
console.log('Next Smaller:', nextSmaller);

/*
The time complexity of finding the next greater and next smaller elements using the MonotonicStack class is O(N), where N is the number of elements in the input array.

Both the findNextGreater and findNextSmaller functions iterate over the input array from right to left, performing a constant number of operations for each element. In each iteration, the monotonic stack operations (push, pop, and peek) take constant time on average, as they depend on the size of the stack, which is at most N in the worst case.

Therefore, the overall time complexity of finding the next greater and next smaller elements is O(N), as each element in the array is processed once.
*/
