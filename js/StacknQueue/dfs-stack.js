const dfs = function(graph, start) {
  const stack = [];
  const visited = new Set();

  stack.push(start);
  visited.add(start);

  while (stack.length > 0) {
    const node = stack.pop();

    // Process the current node
    console.log(node);

    // Get the neighbors of the current node
    const neighbors = graph[node];

    for (const neighbor of neighbors) {
      if (!visited.has(neighbor)) {
        stack.push(neighbor);
        visited.add(neighbor);
      }
    }
  }
};

// Example usage
const graph = {
  A: ['B', 'C'],
  B: ['D', 'E'],
  C: ['F'],
  D: [],
  E: [],
  F: [],
};

dfs(graph, 'A');
