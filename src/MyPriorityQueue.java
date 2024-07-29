class MyPriorityQueue<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyPriorityQueue() {
        heap = new MyArrayList<>();
    }

    public void add(T element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    public T poll() {
        if (heap.size() == 0) {
            return null;
        }
        T result = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return result;
    }

    public int size() {
        return heap.size();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int largest = index;

            if (leftChildIndex < size && heap.get(leftChildIndex).compareTo(heap.get(largest)) > 0) {
                largest = leftChildIndex;
            }

            if (rightChildIndex < size && heap.get(rightChildIndex).compareTo(heap.get(largest)) > 0) {
                largest = rightChildIndex;
            }

            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
