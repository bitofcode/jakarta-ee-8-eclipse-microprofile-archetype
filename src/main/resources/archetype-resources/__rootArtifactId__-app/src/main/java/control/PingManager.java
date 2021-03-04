#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.control;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.time.Instant;
import java.util.Map;

@Default
public class PingManager {
  private final String message;

  @Inject
  public PingManager(@ConfigProperty(name = "${groupId}.message", defaultValue = "Hello, World!") String message) {
    this.message = message;
  }

  public Map<String, Object> getPing() {
    return Map.of("message", message, "dateTimeEpochMilli", Instant.now().toEpochMilli());
  }
}
