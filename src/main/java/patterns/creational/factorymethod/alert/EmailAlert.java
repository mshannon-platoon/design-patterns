package patterns.creational.factorymethod.alert;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class EmailAlert implements Alert {

  private String message;

  @Override
  public void alert() {
    // Custom implementation
    log.info("sending an alert via email");
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
