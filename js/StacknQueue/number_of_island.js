//https://leetcode.com/problems/number-of-islands
const numIslands = function(grid) {
  if (grid.length === 0 || grid[0].length === 0) {
    return 0;
  }

  const rows = grid.length;
  const cols = grid[0].length;
  const directions = [[1, 0], [-1, 0], [0, 1], [0, -1]];
  let islandCount = 0;

  const bfs = function(row, col) {
    const queue = [[row, col]];
    grid[row][col] = '0'; // Mark the current cell as visited

    while (queue.length !== 0) {
      const [r, c] = queue.shift();

      for (const [dx, dy] of directions) {
        const newRow = r + dx;
        const newCol = c + dy;

        if (
          newRow >= 0 &&
          newRow < rows &&
          newCol >= 0 &&
          newCol < cols &&
          grid[newRow][newCol] === '1'
        ) {
          grid[newRow][newCol] = '0'; // Mark the adjacent land cell as visited
          queue.push([newRow, newCol]);
        }
      }
    }
  };

  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < cols; j++) {
      if (grid[i][j] === '1') {
        islandCount++;
        bfs(i, j);
      }
    }
  }

  return islandCount;
};

// Example usage
const grid = [
  ['1', '1', '1', '1', '0'],
  ['1', '1', '0', '1', '0'],
  ['1', '1', '0', '0', '0'],
  ['0', '0', '0', '0', '0']
];
const count = numIslands(grid);
console.log(count); // Output: 1
