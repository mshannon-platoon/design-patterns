package patterns.creational.factorymethod.alerter;

import patterns.creational.factorymethod.alert.Alert;
import patterns.creational.factorymethod.alert.EmailAlert;

class EmailErrorAlerter extends AbstractErrorAlerter {

  @Override
  Alert createAlert(String message) {
    return new EmailAlert(message);
  }

}
