
function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

const inorderTraversal = function(root) {
  const result = [];
  const stack = [];
  let curr = root;

  while (curr !== null || stack.length > 0) {
    // Traverse to the leftmost node
    while (curr !== null) {
      stack.push(curr);
      curr = curr.left;
    }

    // Visit the top of the stack (leftmost node)
    curr = stack.pop();
    result.push(curr.val);

    // Move to the right subtree
    curr = curr.right;
  }

  return result;
};

// Example usage
const root = new TreeNode(1);
root.right = new TreeNode(2);
root.right.left = new TreeNode(3);

console.log(inorderTraversal(root)); // Output: [1, 3, 2]
//The time complexity of this algorithm is O(N), where N is the number of nodes in the binary tree, as we visit each node exactly once. The space complexity is O(H), where H is the height of the binary tree, representing the maximum size of the stack at any point during the traversal.
