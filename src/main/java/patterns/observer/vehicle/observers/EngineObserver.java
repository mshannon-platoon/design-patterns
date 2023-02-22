package patterns.observer.vehicle.observers;

import lombok.extern.slf4j.Slf4j;
import patterns.observer.vehicle.model.Constants.Alerts;
import patterns.observer.vehicle.model.Constants.Engine;
import patterns.observer.vehicle.subject.EngineSubject;
import patterns.observer.vehicle.util.Monitor;

@Slf4j
public class EngineObserver implements AlertingObserver, Monitor {

  private double lastOilLevel;
  private double lastOilTemp;
  private double lastCoolantLevel;
  private double lastCoolantTemp;

  private final EngineSubject engineSubject;

  public EngineObserver(EngineSubject engineSubject) {
    this.engineSubject = engineSubject;
    engineSubject.registerObserver(this);
  }

  @Override
  public void update() {
    this.lastOilLevel = engineSubject.getOilLevel();
    this.lastOilTemp = engineSubject.getOilTemp();
    this.lastCoolantLevel = engineSubject.getCoolantLevel();
    this.lastCoolantTemp = engineSubject.getCoolantTemp();
    monitor();
  }

  @Override
  public void alert(String alertMessage) {
    // Webhook, or send API request etc. Let's just log for now.
    log.warn("An alert has been triggered: {}", alertMessage);
  }

  @Override
  public void monitor() {
    // This is just an example we could do much more advanced concepts here.
    if (lastOilLevel < Engine.MINIMUM_OIL_LEVEL) {
      alert(Alerts.OIL_LOW);
    }
    if (lastOilLevel > Engine.MAXIMUM_OIL_LEVEL) {
      alert(Alerts.OIL_OVERFILL);
    }
    if (lastOilTemp > Engine.MAXIMUM_OIL_TEMPERATURE) {
      alert(Alerts.OIL_EXCEEDING_TEMPERATURE);
    }
    if (lastCoolantLevel < Engine.MINIMUM_COOLANT_LEVEL) {
      alert(Alerts.COOLANT_LOW);
    }
    if (lastCoolantLevel > Engine.MAXIMUM_COOLANT_LEVEL) {
      alert(Alerts.COOLANT_OVERFILL);
    }
    if (lastCoolantTemp > Engine.MAXIMUM_COOLANT_TEMPERATURE) {
      alert(Alerts.COOLANT_EXCEEDING_TEMPERATURE);
    }
  }
}
