package patterns.creational.factorymethod.alerter;

import patterns.creational.factorymethod.alert.Alert;
import patterns.creational.factorymethod.alert.SlackAlert;

class SlackErrorAlerter extends AbstractErrorAlerter {

  @Override
  Alert createAlert(String message) {
    return new SlackAlert(message);
  }

}
