package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Heap
{
  protected final int ROOT = 0;
  protected int length;
  protected int[] heap;

  public Heap(ArrayList<Integer> arr)
  {
    assert(arr.size() > 0);
    heap = arr.stream().mapToInt(Integer::intValue).toArray();
    length = heap.length;
  }

  public void sort()
  {
    buildMaxHeap(ROOT);

    for (int i=length-1; i>=0; i--)
    {
      int tmp = heap[i];
      heap[i] = heap[ROOT];
      heap[ROOT] = tmp;
      this.length--;

      maxHeapify(ROOT);
    }

    this.length = heap.length;
  }

  public ArrayList<Integer> toArrayList()
  {
    return new ArrayList<Integer>(Arrays.stream(heap).boxed().collect(Collectors.toList()));
  }

  protected void maxHeapify(int node)
  {
    int left = leftChild(node);
    int right = rightChild(node);

    // case: leaf node
    if (left >= this.length)
      return;
    // case: left child only
    else if (right >= this.length)
    {
      if (heap[left] > heap[node])
      {
        int tmp = heap[left];
        heap[left] = heap[node];
        heap[node] = tmp;

        maxHeapify(left);
      }
      return;
    }
    // case: both child
    else
    {
      // if current node is the greatest
      if (heap[node] >= heap[left] && heap[node] >= heap[right])
        return;
      else
      {
        int max = left;
        if (heap[left] < heap[right]) max = right;

        int tmp = heap[max];
        heap[max] = heap[node];
        heap[node] = tmp;

        maxHeapify(max);
      }
    }
  }

  protected void buildMaxHeap(int node)
  {
    int left = leftChild(node);
    int right = rightChild(node);

    if (left < this.length)
      buildMaxHeap(left);
    if (right < this.length)
      buildMaxHeap(right);

    maxHeapify(node);
  }

  private int leftChild(int node)
  {
    return 2*node+1;
  }

  private int rightChild(int node)
  {
    return 2*node+2;
  }
}
