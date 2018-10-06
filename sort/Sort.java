package sort;

import java.util.ArrayList;

import core.Problem;

public abstract class Sort implements Problem<ArrayList<Integer>, ArrayList<Integer>>
{
  abstract public ArrayList<Integer> solve(ArrayList<Integer> input);

  abstract public ArrayList<Integer> generateInputExample();

  public String specification()
  {
    return "Sorting problem";
  }
}
