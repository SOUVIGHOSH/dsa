//https://leetcode.com/problems/moving-average-from-data-stream
class MovingAverage {
  constructor(size) {
    this.size = size;
    this.queue = [];
    this.sum = 0;
  }

  next(val) {
    this.queue.push(val);
    this.sum += val;

    if (this.queue.length > this.size) {
      const removed = this.queue.shift();
      this.sum -= removed;
    }

    return this.sum / this.queue.length;
  }
}
