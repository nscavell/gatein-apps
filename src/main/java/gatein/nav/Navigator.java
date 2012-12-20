package gatein.nav;

import juzu.Response;
import juzu.View;
import org.gatein.api.navigation.Navigation;

import javax.inject.Inject;

/** @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a> */
public class Navigator {

  @Inject
  Navigation current;

  @View
  public Response.Render index() {
    return Response.render("Current navigation is " + current);
  }
}
