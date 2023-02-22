package patterns.observer.vehicle.model;

public class Constants {

  public static class Engine {
    public static final double MINIMUM_OIL_LEVEL = 0.3;
    public static final double MAXIMUM_OIL_LEVEL = 1.0;
    public static final double MAXIMUM_OIL_TEMPERATURE = 90.0;
    public static final double MINIMUM_COOLANT_LEVEL = 0.1;
    public static final double MAXIMUM_COOLANT_LEVEL = 1.0;
    public static final double MAXIMUM_COOLANT_TEMPERATURE = 150.0;
  }

  public static class Shock {
    public static final double BREAK_THRESHOLD = 0.83;
    public static final double HARD_CORNER_THRESHOLD = 0.32;
  }

  public static class Alerts {
    public static final String OIL_LOW = "WARNING : LOW OIL";
    public static final String OIL_OVERFILL = "WARNING : OIL OVERFILL";
    public static final String OIL_EXCEEDING_TEMPERATURE = "WARNING : OIL DANGER HIGH TEMP";
    public static final String COOLANT_LOW = "WARNING : COOLANT LOW";
    public static final String COOLANT_OVERFILL = "WARNING : COOLANT OVERFILL";
    public static final String COOLANT_EXCEEDING_TEMPERATURE = "WARNING: COOLANT DANGER HIGH TEMP";
  }

  public static class Email {
    public static final String EXCESSIVE_BREAKING_DETECTED = "EXCESSIVE BREAKING DETECTED";
    public static final String HARD_CORNERING_DETECTED =  "HARD_CORNING_DETECTED";
  }


}
