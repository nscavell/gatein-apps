package gatein.nav;

import juzu.Path;
import juzu.Response;
import juzu.View;
import juzu.template.Template;
import org.gatein.api.PortalRequest;
import org.gatein.api.navigation.Node;
import org.gatein.api.navigation.NodePath;
import org.gatein.api.navigation.Nodes;
import org.gatein.api.navigation.Visibility;

import javax.inject.Inject;
import java.util.LinkedHashMap;

/** @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a> */
public class Controller {

  @Inject
  PortalRequest request;

  @Inject
  @Path("index.gtmpl")
  Template index;

  @View
  public Response.Render index() {
    NodePath current = request.getNodePath();
    NodePath parent = current.parent();
    if (parent == null) {
      parent = current;
    }
    LinkedHashMap<String, String> nodes = new LinkedHashMap<String, String>();
    for (Node child : request.getNavigation().getNode(parent, Nodes.visitChildren())) {
      if (child.isVisible() && child.getVisibility().getStatus() != Visibility.Status.SYSTEM) {
        String name = child.resolveDisplayName();
        nodes.put(name, child.getNodePath().equals(current) ? "#" : child.resolveURI().toString());
      }
    }
    return index.with().set("nodes", nodes).render();
  }
}
