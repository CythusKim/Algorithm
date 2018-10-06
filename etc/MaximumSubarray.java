package etc;

import java.util.ArrayList;
import java.util.Arrays;

import core.Problem;

public class MaximumSubarray implements Problem<ArrayList<Integer>, ArrayList<Integer>>
{
  public ArrayList<Integer> solve(ArrayList<Integer> input)
  {
    return maxRange(input);
  }

  public ArrayList<Integer> generateInputExample()
  {
    Integer[] arr = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
    return new ArrayList<Integer>(Arrays.asList(arr));
  }

  public String specification()
  {
    return "Maximum Subarray Problem";
  }

  protected ArrayList<Integer> maxRange(ArrayList<Integer> arr)
  {
    if (arr.size() == 0)
      return null;
    else if (arr.size() == 1)
    {
      if (arr.get(0) >= 0)
        return new ArrayList<Integer>(arr);
      else
        return null;
    }
    else
    {
      ArrayList<Integer> subArr = new ArrayList<Integer>(arr.subList(0, arr.size()-1));
      ArrayList<Integer> subMaximum = maxRange(subArr);

      if (arr.get(arr.size()-1) <= 0)
        return subMaximum;

      ArrayList<Integer> subMaximumFromEnd = maxRangeFromEnd(subArr);
      subMaximumFromEnd.add(arr.get(arr.size()-1));

      int sum1 = subMaximum.stream().mapToInt(Integer::intValue).sum();
      int sum2 = subMaximumFromEnd.stream().mapToInt(Integer::intValue).sum();

      if (sum1 < sum2)
        return subMaximumFromEnd;
      else
        return subMaximum;
    }
  }

  protected ArrayList<Integer> maxRangeFromEnd(ArrayList<Integer> arr)
  {
    int maxSum = 0;
    int maxIndex = arr.size();
    int curSum = 0;

    for (int i=arr.size()-1; i>=0; i--)
    {
      curSum += arr.get(i);

      if (curSum > maxSum)
      {
        maxSum = curSum;
        maxIndex = i;
      }
    }

    return new ArrayList<Integer>(arr.subList(maxIndex, arr.size()));
  }
}
