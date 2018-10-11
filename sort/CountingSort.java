package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CountingSort extends Sort
{
  public ArrayList<Integer> solve(ArrayList<Integer> input)
  {
    assert(input.size() > 0);
    int[] arr = input.stream().mapToInt(Integer::intValue).toArray();

    int[] countingArr = makeCountingArray(arr);
    int[] result = makeSortedArray(arr, countingArr);

    return arrayToaArrayList(result);
  }

  public ArrayList<Integer> generateInputExample()
  {
    Integer[] arr = {13,56,1,45,74,34,7,3,19,2,9,24,12,10,5,69,58};
    return new ArrayList<Integer>(Arrays.asList(arr));
  }

  public String specification()
  {
    return super.specification() + ": Counting sort"
      + "\n### Notes: int values in the target array must be non-negative and less than 1000";
  }

  protected int[] makeCountingArray(int[] arr)
  {
    int max = Arrays.stream(arr).max().getAsInt();
    int min = Arrays.stream(arr).min().getAsInt();
    assert(max < 1000);
    assert(min >= 0);

    int[] countingArr = new int[max+1];
    Arrays.fill(countingArr, 0);

    for (int i : arr)
      countingArr[i]++;

    for (int i=1; i<countingArr.length; i++)
    {
      countingArr[i] += countingArr[i-1];
    }

    return countingArr;
  }

  protected int[] makeSortedArray(int[] arr, int[] countingArr)
  {
    int[] result = new int[arr.length];

    for (int i=arr.length-1; i>=0; i--)
    {
      int place = countingArr[arr[i]]--;
      result[place-1] = arr[i];
    }

    return result;
  }

  private ArrayList<Integer> arrayToaArrayList(int[] arr)
  {
    return new ArrayList<Integer>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
  }
}
