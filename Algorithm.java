import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Class;

import core.Problem;

public class Algorithm
{
  public static String[] modes = {
    "etc.MaximumSubarray",
    "sort.HeapSort"
  };

  public static void main(String[] args) {
    int choice = 0;
    if (args.length == 1)
      try
      {
        choice = Integer.parseInt(args[0]) - 1;
        if (choice < 0 || choice >= modes.length)
          throw new Exception();
      }
      catch(Exception e)
      {
        System.out.println("Input is invalid!!!");
        System.exit(0);
      }

    Class mode = null;
    Problem p = null;
    try
    {
      mode = Class.forName(modes[choice]);
      p = (Problem) mode.newInstance();
    }
    catch(ClassNotFoundException e)
    {
      System.out.println("No such algorithm problem!");
      System.exit(0);
    }
    catch(Exception e)
    {
      System.out.println("Problem instantiation failed");
      System.exit(0);
    }

    Object ex = p.generateInputExample();

    System.out.println("************************\n" + p.specification() + "\n************************");
    System.out.println("Input:\t" + ex.toString());
    System.out.println("Output:\t" + p.solve(ex).toString());
  }
}
