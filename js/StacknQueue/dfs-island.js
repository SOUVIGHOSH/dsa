const numIslands = function(grid) {
  if (!grid || grid.length === 0) {
    return 0;
  }

  const rows = grid.length;
  const cols = grid[0].length;
  const visited = new Set();
  let count = 0;

  const dfs = function(row, col) {
    if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] === '0' || visited.has(`${row}-${col}`)) {
      return;
    }

    visited.add(`${row}-${col}`);

    // Explore neighbors
    dfs(row - 1, col); // Up
    dfs(row + 1, col); // Down
    dfs(row, col - 1); // Left
    dfs(row, col + 1); // Right
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

/*
This approach effectively counts the number of islands in the grid by treating each land cell as the starting point of a DFS traversal. By exploring all adjacent land cells connected to each starting point, we ensure that we cover all cells belonging to the same island.

The time complexity of this solution is O(m * n), where m is the number of rows and n is the number of columns in the grid. We visit each cell once, and the DFS from each cell explores the connected cells.
*/
