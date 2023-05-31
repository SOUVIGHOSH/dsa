//https://leetcode.com/problems/daily-temperatures

const dailyTemperatures = function(temperatures) {
  const stack = [];
  const result = new Array(temperatures.length).fill(0);

  for (let i = 0; i < temperatures.length; i++) {
    while (stack.length > 0 && temperatures[i] > temperatures[stack[stack.length - 1]]) {
      const index = stack.pop();
      result[index] = i - index;
    }
    stack.push(i);
  }

  return result;
};

// Example usage
const temperatures = [73, 74, 75, 71, 69, 72, 76, 73];
const waitingDays = dailyTemperatures(temperatures);

/*
In this solution, we iterate through the temperatures array. For each temperature, we check if it is greater than the temperature at the top of the stack. If it is, we pop the index from the stack and calculate the number of days by subtracting the current index from the popped index. We store this number of days in the result array.

We continue this process until we find a temperature that is not greater than the temperature at the top of the stack or until the stack becomes empty. This ensures that we are always finding the closest future day with a warmer temperature.

If the stack becomes empty before finding a warmer temperature, it means there is no future day with a warmer temperature. In this case, the corresponding element in the result array remains 0.

The time complexity of this solution is O(n), where n is the length of the temperatures array, as each index is pushed and popped from the stack at most once.
*/
