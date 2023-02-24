package patterns.utils;

import java.util.Random;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RandomGen {

  private final Random random = new Random();

  public double doubleBetween(double rangeMin, double rangeMax) {
    return rangeMin + (rangeMax - rangeMin) * random.nextDouble();
  }

}
