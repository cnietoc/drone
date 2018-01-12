package cnieto;

public class Index
{
  private final int x;
  private final int y;

  Index(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  Index to(Direction direction)
  {
    switch (direction)
    {
      case UP:
        return new Index(x - 1, y);
      case DOWN:
        return new Index(x + 1, y);
      case LEFT:
        return new Index(x, y - 1);
      case RIGHT:
        return new Index(x, y + 1);
    }
    throw new IllegalStateException();
  }

  int getX()
  {
    return x;
  }

  int getY()
  {
    return y;
  }
}
