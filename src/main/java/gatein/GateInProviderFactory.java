package gatein;

import juzu.inject.ProviderFactory;
import org.gatein.api.PortalRequest;
import org.gatein.api.navigation.Navigation;

import javax.inject.Provider;

/**
 * A provider factory for GateIn classes.
 *
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 */
public class GateInProviderFactory implements ProviderFactory {
  public <T> Provider<? extends T> getProvider(final Class<T> implementationType) throws Exception {
    if (Navigation.class.isAssignableFrom(implementationType)) {
      return new Provider<T>() {
        public T get() {
          return implementationType.cast(PortalRequest.getInstance().getNavigation());
        }
      };
    } else {
      return null;
    }
  }
}
