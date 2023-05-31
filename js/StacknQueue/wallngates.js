//https://leetcode.com/problems/walls-and-gates
const wallsAndGates = function(rooms) {
  if (rooms.length === 0 || rooms[0].length === 0) {
    return;
  }

  const rows = rooms.length;
  const cols = rooms[0].length;
  const queue = [];

  // Enqueue the coordinates of all the gates
  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < cols; j++) {
      if (rooms[i][j] === 0) {
        queue.push([i, j]);
      }
    }
  }

  // Perform BFS starting from each gate
  const directions = [[1, 0], [-1, 0], [0, 1], [0, -1]];
  while (queue.length !== 0) {
    const [row, col] = queue.shift();

    for (const [dx, dy] of directions) {
      const newRow = row + dx;
      const newCol = col + dy;

      // Check if the neighboring cell is a valid empty room (INF)
      if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && rooms[newRow][newCol] === 2147483647) {
        rooms[newRow][newCol] = rooms[row][col] + 1;
        queue.push([newRow, newCol]);
      }
    }
  }
};

// Example usage
const rooms = [
  [2147483647, -1, 0, 2147483647],
  [2147483647, 2147483647, 2147483647, -1],
  [2147483647, -1, 2147483647, -1],
  [0, -1, 2147483647, 2147483647]
];
wallsAndGates(rooms);
console.log(rooms);
