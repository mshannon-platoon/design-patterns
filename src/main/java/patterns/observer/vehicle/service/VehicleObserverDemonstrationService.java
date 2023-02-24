package patterns.observer.vehicle.service;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import patterns.observer.observer.Observer;
import patterns.observer.vehicle.model.Vehicle;
import patterns.observer.vehicle.observers.EngineObserver;
import patterns.observer.vehicle.observers.PositionObserver;
import patterns.observer.vehicle.observers.ShockObserver;
import patterns.observer.vehicle.observers.TachographObserver;
import patterns.observer.vehicle.subject.EngineSubject;
import patterns.observer.vehicle.subject.PositionSubject;
import patterns.observer.vehicle.subject.ShockSubject;
import patterns.observer.vehicle.subject.TachographSubject;
import patterns.utils.RandomGen;

@Slf4j
public class VehicleObserverDemonstrationService {

  private final List<Observer> observerList = new ArrayList<>();

  private final List<Vehicle> vehicles = new ArrayList<>();

  public void demonstrate() throws InterruptedException {
    for(int i = 1; i <= 20; i++) {
      vehicles.add(buildVehicle(i));
    }

    for(int i = 0; i < 100; i++) {

      vehicles.forEach(vehicle -> {
        updateEngineStats(vehicle.getEngineSubject());
        updateTachographSubject(vehicle.getTachographSubject());
        updatePositionSubject(vehicle.getPositionSubject());
        updateShockSubject(vehicle.getShockSubject());
      });

      Thread.sleep(1000);
    }
  }

  private void updateShockSubject(ShockSubject shockSubject) {
    double brakeReading = RandomGen.doubleBetween(0.0, 0.100);
    double corneringReading = RandomGen.doubleBetween(0.0, 0.50);
    shockSubject.setData(brakeReading, corneringReading);
  }

  private void updatePositionSubject(PositionSubject positionSubject) {
    double latitude = RandomGen.doubleBetween(-180, 85);
    double longitude = RandomGen.doubleBetween(-85, 180);
    positionSubject.setData(latitude, longitude);
  }

  private void updateTachographSubject(TachographSubject tachographSubject) {
    tachographSubject.setData(1);
  }

  private void updateEngineStats(EngineSubject engineSubject) {
    double oilLevel = RandomGen.doubleBetween(0.1, 1.2);
    double oilTemp = RandomGen.doubleBetween(60.0, 100.0);
    double coolantLevel = RandomGen.doubleBetween(0.0, 1.2);
    double coolantTemp = RandomGen.doubleBetween(50, 165);
    engineSubject.setData(oilLevel, oilTemp, coolantLevel, coolantTemp);
  }

  private Vehicle buildVehicle(Integer vehicleId){
    EngineSubject engineSubject = new EngineSubject(vehicleId);
    TachographSubject tachographSubject = new TachographSubject(vehicleId);
    ShockSubject shockSubject = new ShockSubject(vehicleId);
    PositionSubject positionSubject = new PositionSubject(vehicleId);

    observerList.add(new EngineObserver(engineSubject));
    observerList.add(new TachographObserver(tachographSubject));
    observerList.add(new ShockObserver(shockSubject));
    observerList.add(new PositionObserver(positionSubject));

    return new Vehicle(vehicleId, engineSubject, tachographSubject, shockSubject, positionSubject);
  }

}
