@Bindings(@Binding(PortalRequest.class))
@Portlet
@Application
@Assets(stylesheets = @Stylesheet(src = "/gatein/assets/bootstrap.css"))
package gatein.nav;

import juzu.Application;
import juzu.plugin.asset.Assets;
import juzu.plugin.asset.Stylesheet;
import juzu.plugin.binding.Binding;
import juzu.plugin.binding.Bindings;
import juzu.plugin.portlet.Portlet;
import org.gatein.api.PortalRequest;
