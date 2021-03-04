#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PingResourceIT {

  private PingResourceClient client;

  @BeforeEach
  public void init() {
    URI uri = URI.create("http://localhost:8080/${parentArtifactId}-app/api/");
    this.client = RestClientBuilder.
      newBuilder().
      baseUri(uri).
      build(PingResourceClient.class);
  }

  @Test
  public void ping() {
    Response response = this.client.ping();
    int status = response.getStatus();
    assertEquals(200, status);
    String message = response.readEntity(String.class);
    assertNotNull(message);
    System.out.println(message);
  }

}
