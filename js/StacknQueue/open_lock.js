//https://leetcode.com/problems/open-the-lock
//In the openLock function, we start with the initial lock state '0000'.
//We use a set visited to keep track of the deadends and visited states.
//We enqueue the start state and perform a BFS by exploring all possible wheel rotations.
//We continue the BFS until we find the target state or exhaust all possible combinations.

The time complexity of this solution is O(10^4 * N + D), where N is the number of digits in the lock and D is the size of the deadends array.
const openLock = function(deadends, target) {
  const visited = new Set(deadends);
  const queue = [];
  const start = '0000';
  if (visited.has(start)) return -1; // The initial lock state is a dead end

  queue.push(start);
  visited.add(start);
  let turns = 0;

  while (queue.length !== 0) {
    const size = queue.length;

    for (let i = 0; i < size; i++) {
      const current = queue.shift();

      if (current === target) {
        return turns; // Found the target, return the number of turns
      }

      // Generate the neighbors by rotating each wheel in both directions
      for (let j = 0; j < 4; j++) {
        const digit = Number(current[j]);

        // Rotate the wheel in the forward direction
        const forward = current.substring(0, j) + (digit === 9 ? 0 : digit + 1) + current.substring(j + 1);
        if (!visited.has(forward)) {
          queue.push(forward);
          visited.add(forward);
        }

        // Rotate the wheel in the backward direction
        const backward = current.substring(0, j) + (digit === 0 ? 9 : digit - 1) + current.substring(j + 1);
        if (!visited.has(backward)) {
          queue.push(backward);
          visited.add(backward);
        }
      }
    }

    turns++;
  }

  return -1; // No solution found
};

// Example usage
const deadends = ['0201', '0101', '0102', '1212', '2002'];
const target = '0202';
const minTurns = openLock(deadends, target);
console.log(minTurns); // Output: 6
