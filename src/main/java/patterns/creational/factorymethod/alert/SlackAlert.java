package patterns.creational.factorymethod.alert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
@AllArgsConstructor
public class SlackAlert implements Alert {

  private String message;

  @Override
  public void alert() {
    // Custom implementation
    log.info("sending an alert to slack");
  }

  @Override
  public String getMessage() {
    return message;
  }

  @Override
  public void setMessage(String message) {
    this.message = message;
  }
}
