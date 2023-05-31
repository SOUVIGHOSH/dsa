// https://leetcode.com/problems/perfect-squares
const numSquares = function(n) {
  const squares = [];
  for (let i = 1; i * i <= n; i++) {
    squares.push(i * i);
  }

  const queue = [];
  queue.push({ value: n, count: 0 });

  const visited = new Set();
  visited.add(n);

  while (queue.length !== 0) {
    const { value, count } = queue.shift();

    if (value === 0) {
      return count;
    }

    for (const square of squares) {
      if (value < square) {
        break;
      }

      const nextValue = value - square;
      if (!visited.has(nextValue)) {
        queue.push({ value: nextValue, count: count + 1 });
        visited.add(nextValue);
      }
    }
  }

  return -1; // No solution found
};

// Example usage
const n = 12;
const leastNumSquares = numSquares(n);
console.log(leastNumSquares); // Output: 3

/**
In this solution, we generate an array squares containing all the perfect square numbers up to the given integer n. We use a queue queue to perform a BFS starting from the value n. Each item in the queue represents a value and its corresponding count (the number of perfect squares used to reach that value). We use a set visited to keep track of visited values to avoid duplication.

During the BFS, for each value in the queue, we subtract each perfect square number from the value to generate the next possible values. If a next value has not been visited before, we enqueue it with an increased count and mark it as visited.

The BFS continues until we find a value of 0, indicating that we have reached a sum of perfect squares, or until the queue is empty. If a solution is not found, we return -1.

The time complexity of this solution is O(n * sqrt(n)), where n is the given integer.
*/
