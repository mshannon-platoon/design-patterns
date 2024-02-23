package patterns.creational.factorymethod.alerter;

import patterns.creational.factorymethod.alert.Alert;

abstract class AbstractErrorAlerter {

  abstract Alert createAlert(String message);

}
