package patterns.observer.vehicle;

import patterns.observer.vehicle.service.VehicleObserverDemonstrationService;

public class VehicleDemoMain {

  public static void main(String[] args) throws InterruptedException {
    VehicleObserverDemonstrationService vehicleObserverDemonstrationService = new VehicleObserverDemonstrationService();
    vehicleObserverDemonstrationService.demonstrate();
  }

}
