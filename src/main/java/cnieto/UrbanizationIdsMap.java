package cnieto;

public interface UrbanizationIdsMap
{
  String obtainUrbanizationId(double longitude, double latitude);

  String obtainAdjacent(String originUrbanizationId, Direction direction);
}
