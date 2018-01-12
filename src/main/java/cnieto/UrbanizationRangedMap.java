package cnieto;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static cnieto.Direction.DOWN;
import static cnieto.Direction.LEFT;
import static cnieto.Direction.RIGHT;
import static cnieto.Direction.UP;

public class UrbanizationRangedMap
{
  private final String[][] rangedMap;

  public UrbanizationRangedMap(UrbanizationIdsMap urbanizationIdsMap, Coordinates coordinates, int range)
  {
    rangedMap = createRangedMapFor(range);

    Index center = calculateCenterIndexFor(range);

    String centerUrbanizationId = urbanizationIdsMap.obtainUrbanizationId(coordinates.getLongitude(),
      coordinates.getLatitude());

    set(center, centerUrbanizationId);

    fillAdjacentOf(center, urbanizationIdsMap);
  }

  public Collection<String> getUrbanizationIds()
  {
    return Stream.of(rangedMap).flatMap(Stream::of).collect(Collectors.toList());
  }

  private void set(Index index, String urbanizationId)
  {
    rangedMap[index.getX()][index.getY()] = urbanizationId;
  }

  private void fillAdjacentOf(Index index, UrbanizationIdsMap urbanizationIdsMap)
  {
    if (isOnRange(index))
    {
      Stream.of(UP, RIGHT, DOWN, LEFT).forEach(direction -> fillTo(direction, index, urbanizationIdsMap));
    }
  }

  private void fillTo(Direction direction, Index index, UrbanizationIdsMap urbanizationIdsMap)
  {
    Index movedIndex = index.to(direction);
    if (isOnRange(movedIndex) && !isSet(movedIndex))
    {
      set(movedIndex, urbanizationIdsMap.obtainAdjacent(get(index), direction));
      fillAdjacentOf(movedIndex, urbanizationIdsMap);
    }
  }

  private String get(Index index)
  {
    return rangedMap[index.getX()][index.getY()];
  }

  private boolean isSet(Index index)
  {
    return rangedMap[index.getX()][index.getY()] != null;
  }

  private boolean isOnRange(Index index)
  {
    return isOnRange(index.getX()) && isOnRange(index.getY());
  }

  private boolean isOnRange(int index)
  {
    return index >= 0 && index < rangedMap.length;
  }

  private String[][] createRangedMapFor(int range)
  {
    int size = calculateSizeFor(range);
    return new String[size][size];
  }

  private int calculateSizeFor(int range)
  {
    return range * 2 + 1;
  }

  private Index calculateCenterIndexFor(int range)
  {
    return new Index(range, range);
  }

}
