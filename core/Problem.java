package core;

public interface Problem<T,R>
{
  public R solve(T input);

  public T generateInputExample();

  public String specification();
}
