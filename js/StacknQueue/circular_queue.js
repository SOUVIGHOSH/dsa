class CircularQueue {
  constructor(k) {
    this.queue = new Array(k);
    this.head = -1;
    this.tail = -1;
    this.size = 0;
    this.capacity = k;
  }

  enqueue(item) {
    if (this.isFull()) {
      return false; // Queue is full
    }

    const index = (this.tail + 1) % this.capacity;
    this.queue[index] = item;
    this.tail = index;
    this.size++;

    if (this.head === -1) {
      this.head = this.tail;
    }

    return true;
  }

  dequeue() {
    if (this.isEmpty()) {
      return null; // Queue is empty
    }

    const item = this.queue[this.head];
    this.queue[this.head] = null;
    this.head = (this.head + 1) % this.capacity;
    this.size--;

    if (this.isEmpty()) {
      this.head = -1;
      this.tail = -1;
    }

    return item;
  }

  peek() {
    if (this.isEmpty()) {
      return null; // Queue is empty
    }

    return this.queue[this.head];
  }

  isFull() {
    return this.size === this.capacity;
  }

  isEmpty() {
    return this.size === 0;
  }
}
