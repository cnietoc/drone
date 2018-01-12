package cnieto;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static cnieto.UrbanizationIdsMapStub.LATITUDE;
import static cnieto.UrbanizationIdsMapStub.LONGITUDE;
import static cnieto.UrbanizationIdsMapStub.URB_1;
import static cnieto.UrbanizationIdsMapStub.URB_10;
import static cnieto.UrbanizationIdsMapStub.URB_11;
import static cnieto.UrbanizationIdsMapStub.URB_12;
import static cnieto.UrbanizationIdsMapStub.URB_13;
import static cnieto.UrbanizationIdsMapStub.URB_14;
import static cnieto.UrbanizationIdsMapStub.URB_15;
import static cnieto.UrbanizationIdsMapStub.URB_16;
import static cnieto.UrbanizationIdsMapStub.URB_17;
import static cnieto.UrbanizationIdsMapStub.URB_18;
import static cnieto.UrbanizationIdsMapStub.URB_19;
import static cnieto.UrbanizationIdsMapStub.URB_2;
import static cnieto.UrbanizationIdsMapStub.URB_20;
import static cnieto.UrbanizationIdsMapStub.URB_21;
import static cnieto.UrbanizationIdsMapStub.URB_22;
import static cnieto.UrbanizationIdsMapStub.URB_23;
import static cnieto.UrbanizationIdsMapStub.URB_24;
import static cnieto.UrbanizationIdsMapStub.URB_25;
import static cnieto.UrbanizationIdsMapStub.URB_3;
import static cnieto.UrbanizationIdsMapStub.URB_4;
import static cnieto.UrbanizationIdsMapStub.URB_5;
import static cnieto.UrbanizationIdsMapStub.URB_6;
import static cnieto.UrbanizationIdsMapStub.URB_7;
import static cnieto.UrbanizationIdsMapStub.URB_8;
import static cnieto.UrbanizationIdsMapStub.URB_9;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class DroneAlgorithmTest
{
  @Test
  public void checkAlgorithmWithRangeZero()
  {
    UrbanizationIdsMap urbanizationIdsMap = createUrbanizationMapStub();

    UrbanizationRangedMap urbanizationRangedMap =
      new UrbanizationRangedMap(urbanizationIdsMap, new Coordinates(LONGITUDE, LATITUDE), 0);

    assertThat(urbanizationRangedMap.getUrbanizationIds(),
      is(rangeZeroUrbanizationIds()));
  }

  @Test
  public void checkAlgorithmWithRangeOne()
  {
    UrbanizationIdsMap urbanizationIdsMap = createUrbanizationMapStub();

    UrbanizationRangedMap urbanizationRangedMap =
      new UrbanizationRangedMap(urbanizationIdsMap, new Coordinates(LONGITUDE, LATITUDE), 1);

    assertThat(urbanizationRangedMap.getUrbanizationIds(),
      containsInAnyOrder(rangeOneUrbanizationIds().toArray()));
  }

  @Test
  public void checkAlgorithmWithRangeTwo()
  {
    UrbanizationIdsMap urbanizationIdsMap = createUrbanizationMapStub();

    UrbanizationRangedMap urbanizationRangedMap =
      new UrbanizationRangedMap(urbanizationIdsMap, new Coordinates(LONGITUDE, LATITUDE), 2);

    assertThat(urbanizationRangedMap.getUrbanizationIds(),
      containsInAnyOrder(rangeTwoUrbanizationIds().toArray()));
  }

  private UrbanizationIdsMap createUrbanizationMapStub()
  {
    return new UrbanizationIdsMapStub();
  }

  private List<String> rangeZeroUrbanizationIds()
  {
    return singletonList(URB_13);
  }

  private List<String> rangeOneUrbanizationIds()
  {
    return Stream.concat(rangeZeroUrbanizationIds().stream(),
      Stream.of(URB_7, URB_8, URB_9, URB_12, URB_14, URB_17, URB_18, URB_19)).collect(toList());
  }


  private List<String> rangeTwoUrbanizationIds()
  {
    return Stream.concat(rangeOneUrbanizationIds().stream(),
      Stream.of(URB_1, URB_2, URB_3, URB_4, URB_5, URB_6, URB_10, URB_11, URB_15, URB_16, URB_20, URB_21, URB_22,
        URB_23, URB_24, URB_25)).collect(toList());
  }
}
