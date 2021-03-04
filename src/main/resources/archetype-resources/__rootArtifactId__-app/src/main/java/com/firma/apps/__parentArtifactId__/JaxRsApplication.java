#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.${parentArtifactId};

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationScoped
@ApplicationPath("/api")
public class JaxRsApplication extends Application {

  @Liveness
  @Produces
  public HealthCheck aliveness() {
    return () -> HealthCheckResponse.up("live " + getClass().getSimpleName());
  }

  @Readiness
  @Produces
  public HealthCheck readiness() {
    return () -> HealthCheckResponse.up("ready " + getClass().getSimpleName());
  }
}
