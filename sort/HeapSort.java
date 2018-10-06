package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class HeapSort extends Sort
{
  public ArrayList<Integer> solve(ArrayList<Integer> input)
  {
    Heap heap = new Heap(input);
    heap.sort();
    return heap.toArrayList();
  }

  public ArrayList<Integer> generateInputExample()
  {
    Integer[] arr = {13,56,1,45,74,34,7,3,19,2,9,24,12,10,5,69,58};
    return new ArrayList<Integer>(Arrays.asList(arr));
  }

  public String specification()
  {
    return super.specification() + ": Heap sort";
  }
}
