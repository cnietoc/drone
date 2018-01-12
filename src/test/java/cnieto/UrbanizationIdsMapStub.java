package cnieto;

class UrbanizationIdsMapStub implements UrbanizationIdsMap
{
  static final double LONGITUDE = 38.56889;
  static final double LATITUDE = 40.511107;
  static final String URB_1 = "urb1";
  static final String URB_2 = "urb2";
  static final String URB_3 = "urb3";
  static final String URB_4 = "urb4";
  static final String URB_5 = "urb5";
  static final String URB_6 = "urb6";
  static final String URB_7 = "urb7";
  static final String URB_8 = "urb8";
  static final String URB_9 = "urb9";
  static final String URB_10 = "urb10";
  static final String URB_11 = "urb11";
  static final String URB_12 = "urb12";
  static final String URB_13 = "urb13";
  static final String URB_14 = "urb14";
  static final String URB_15 = "urb15";
  static final String URB_16 = "urb16";
  static final String URB_17 = "urb17";
  static final String URB_18 = "urb18";
  static final String URB_19 = "urb19";
  static final String URB_20 = "urb20";
  static final String URB_21 = "urb21";
  static final String URB_22 = "urb22";
  static final String URB_23 = "urb23";
  static final String URB_24 = "urb24";
  static final String URB_25 = "urb25";

  private String[][] stubMap = new String[][] {
    new String[] {URB_1, URB_2, URB_3, URB_4, URB_5},
    new String[] {URB_6, URB_7, URB_8, URB_9, URB_10},
    new String[] {URB_11, URB_12, URB_13, URB_14, URB_15},
    new String[] {URB_16, URB_17, URB_18, URB_19, URB_20},
    new String[] {URB_21, URB_22, URB_23, URB_24, URB_25}
  };

  @Override
  public String obtainUrbanizationId(double longitude, double latitude)
  {
    if (longitude == LONGITUDE && latitude == LATITUDE)
    {
      return URB_13;
    }
    else
    {
      throw new IllegalArgumentException("Stub not allowed for others coordinates");
    }
  }

  @Override
  public String obtainAdjacent(String originUrbanizationId, Direction direction)
  {
    for (int row = 0 ; row < stubMap.length ; row++)
    {
      for (int column = 0 ; column < stubMap[row].length ; column++)
      {
        if (stubMap[row][column].equals(originUrbanizationId))
        {
          return stubMap[moveRow(row, direction)][moveColumn(column, direction)];
        }
      }
    }
    throw new IllegalArgumentException("Urbanization id not found");
  }

  private int moveRow(int row, Direction direction)
  {
    switch (direction)
    {
      case UP:
        return row - 1;
      case DOWN:
        return row + 1;
      default:
        return row;
    }
  }

  private int moveColumn(int column, Direction direction)
  {
    switch (direction)
    {
      case LEFT:
        return column - 1;
      case RIGHT:
        return column + 1;
      default:
        return column;
    }
  }
}
