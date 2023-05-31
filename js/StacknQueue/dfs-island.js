const numIslands = function(grid) {
  if (!grid || grid.length === 0) {
    return 0;
  }

  const rows = grid.length;
  const cols = grid[0].length;
  const visited = new Set();
  let count = 0;

  const stack = [];

  const isValid = function(row, col) {
    return row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] === '1' && !visited.has(`${row}-${col}`);
  };

  const dfs = function(row, col) {
    const directions = [[-1, 0], [1, 0], [0, -1], [0, 1]];

    stack.push([row, col]);
    visited.add(`${row}-${col}`);

    while (stack.length > 0) {
      const [currRow, currCol] = stack.pop();

      for (const [dx, dy] of directions) {
        const newRow = currRow + dx;
        const newCol = currCol + dy;

        if (isValid(newRow, newCol)) {
          stack.push([newRow, newCol]);
          visited.add(`${newRow}-${newCol}`);
        }
      }
    }
  };

  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < cols; j++) {
      if (grid[i][j] === '1' && !visited.has(`${i}-${j}`)) {
        count++;
        dfs(i, j);
      }
    }
  }

  return count;
};

// Example usage
const grid = [
  ['1', '1', '1', '1', '0'],
  ['1', '1', '0', '1', '0'],
  ['1', '1', '0', '0', '0'],
  ['0', '0', '0', '0', '0']
];

const islandCount = numIslands(grid);
console.log(islandCount); // Output: 1

/*
The time complexity and space complexity of this solution remain O(m * n), where m is the number of rows and n is the number of columns in the grid.
*/
