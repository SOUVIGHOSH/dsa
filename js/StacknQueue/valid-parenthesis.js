//https://leetcode.com/problems/valid-parentheses
const isValid = function(s) {
  const stack = [];

  for (let i = 0; i < s.length; i++) {
    const char = s[i];

    if (char === '(' || char === '{' || char === '[') {
      stack.push(char); // Push opening brackets onto the stack
    } else {
      if (stack.length === 0) {
        return false; // There is no corresponding opening bracket
      }

      const top = stack.pop(); // Get the top of the stack

      // Check if the current closing bracket matches the top of the stack
      if (
        (char === ')' && top !== '(') ||
        (char === '}' && top !== '{') ||
        (char === ']' && top !== '[')
      ) {
        return false; // Bracket types do not match
      }
    }
  }

  // After iterating through the string, the stack should be empty
  return stack.length === 0;
};

// Example usage
const s = '()';
const isValidString = isValid(s);
console.log(isValidString); // Output: true
