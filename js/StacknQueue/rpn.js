//https://leetcode.com/problems/evaluate-reverse-polish-notation
const evalRPN = function(tokens) {
  const stack = [];

  for (const token of tokens) {
    if (isOperator(token)) {
      const operand2 = stack.pop();
      const operand1 = stack.pop();
      const result = calculate(operand1, operand2, token);
      stack.push(result);
    } else {
      stack.push(parseInt(token, 10));
    }
  }

  return stack.pop();
};

const isOperator = function(token) {
  return token === '+' || token === '-' || token === '*' || token === '/';
};

const calculate = function(operand1, operand2, operator) {
  switch (operator) {
    case '+':
      return operand1 + operand2;
    case '-':
      return operand1 - operand2;
    case '*':
      return operand1 * operand2;
    case '/':
      return Math.trunc(operand1 / operand2);
    default:
      return 0;
  }
};

// Example usage
const tokens = ["2", "1", "+", "3", "*"];
const result = evalRPN(tokens);
console.log(result); // Output: 9

/*
In this solution, we iterate through the tokens array. For each token, we check if it is an operator or an operand. If it is an operator, we pop the last two operands from the stack, perform the calculation using the operator, and push the result back onto the stack. If it is an operand, we parse it as an integer and push it onto the stack.

The isOperator function checks if a token is one of the valid operators: '+', '-', '*', or '/'. The calculate function performs the corresponding calculation based on the operator and the operands.

After iterating through all the tokens, the final result will be left on the stack, so we pop it and return as the evaluated value.

The time complexity of this solution is O(n), where n is the number of tokens in the input array, as we iterate through each token exactly once.
*/
