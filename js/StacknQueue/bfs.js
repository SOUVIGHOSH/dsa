function bfs(graph, startNode) {
  const visited = new Set(); // Set to track visited nodes
  const queue = [startNode]; // Queue for BFS traversal
  visited.add(startNode);

  while (queue.length > 0) {
    const currentNode = queue.shift();
    console.log(currentNode); // Process or output the current node

    const neighbors = graph[currentNode];
    for (const neighbor of neighbors) {
      if (!visited.has(neighbor)) {
        queue.push(neighbor);
        visited.add(neighbor);
      }
    }
  }
}
