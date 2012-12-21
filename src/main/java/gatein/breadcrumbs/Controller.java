package gatein.breadcrumbs;

import juzu.Path;
import juzu.Response;
import juzu.View;
import juzu.template.Template;
import org.gatein.api.PortalRequest;
import org.gatein.api.navigation.Node;

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
    LinkedHashMap<String, String> nodes = build(request.getNode());
    return index.with().set("nodes", nodes).render();
  }

  private LinkedHashMap<String, String> build(Node current) {
    Node parent = current.getParent();
    LinkedHashMap<String, String> nodes;
    if (parent != null) {
      nodes = build(parent);
    } else {
      nodes = new LinkedHashMap<String, String>();
    }
    nodes.put(current.resolveDisplayName(), current.resolveURI().toString());
    return nodes;
  }
}
