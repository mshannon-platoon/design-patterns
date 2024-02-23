package patterns.creational.factorymethod.alerter;

import patterns.creational.factorymethod.alert.Alert;

import java.util.ArrayList;
import java.util.List;

public class AlerterUseCase {

  public static void main(String[] args) {
    var emailErrorAlerter = new EmailErrorAlerter();
    var slackErrorAlerter = new SlackErrorAlerter();

    List<Alert> alertBatch = new ArrayList<>();

    for (int i = 0; i < 1000; i++) {
      if(i % 2 == 0){
        alertBatch.add(emailErrorAlerter.createAlert("EmailAlert(id: " + i + ")"));
      } else{
        alertBatch.add(slackErrorAlerter.createAlert("SlackAlert(id: " + i + ")"));
      }
    }

    for (Alert alert : alertBatch) {
      alert.alert();
    }
  }
}
