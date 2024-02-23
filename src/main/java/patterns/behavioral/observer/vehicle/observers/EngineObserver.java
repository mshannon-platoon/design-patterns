package patterns.behavioral.observer.vehicle.observers;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import patterns.behavioral.observer.vehicle.model.Constants.Alerts;
import patterns.behavioral.observer.vehicle.model.Constants.Engine;
import patterns.behavioral.observer.vehicle.subject.EngineSubject;
import patterns.behavioral.observer.vehicle.util.Monitor;

@Slf4j
@Getter
public class EngineObserver extends AbstractVehicleObserver implements AlertingObserver, Monitor {

  private Double lastOilLevel;
  private Double lastOilTemp;
  private Double lastCoolantLevel;
  private Double lastCoolantTemp;

  private final EngineSubject engineSubject;

  public EngineObserver(EngineSubject engineSubject) {
    this.engineSubject = engineSubject;
    engineSubject.registerObserver(this);
    this.setVehicleId(engineSubject.getVehicleId());
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
  public void alert(String alertMessage, Double value) {
    // Webhook, or send API request etc. Let's just log for now.
    log.warn("Alert: {} value: {}, vehicleId: {},", alertMessage, value, getVehicleId());
  }

  @Override
  public void monitor() {
    // This is just an example we could do much more advanced concepts here.
    if (lastOilLevel < Engine.MINIMUM_OIL_LEVEL) {
      alert(Alerts.OIL_LOW, lastOilLevel);
    }
    if (lastOilLevel > Engine.MAXIMUM_OIL_LEVEL) {
      alert(Alerts.OIL_OVERFILL, lastOilLevel);
    }
    if (lastOilTemp > Engine.MAXIMUM_OIL_TEMPERATURE) {
      alert(Alerts.OIL_EXCEEDING_TEMPERATURE, lastOilTemp);
    }
    if (lastCoolantLevel < Engine.MINIMUM_COOLANT_LEVEL) {
      alert(Alerts.COOLANT_LOW, lastCoolantLevel);
    }
    if (lastCoolantLevel > Engine.MAXIMUM_COOLANT_LEVEL) {
      alert(Alerts.COOLANT_OVERFILL, lastCoolantLevel);
    }
    if (lastCoolantTemp > Engine.MAXIMUM_COOLANT_TEMPERATURE) {
      alert(Alerts.COOLANT_EXCEEDING_TEMPERATURE, lastCoolantTemp);
    }
  }
}
