package org.yes.cart.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.yes.cart.constants.ServiceSpringKeys;
import org.yes.cart.shoppingcart.ShoppingCartCommandFactory;
import org.yes.cart.shoppingcart.ShoppingCart;
import org.yes.cart.web.application.ApplicationDirector;
import org.yes.cart.web.support.constants.WebServiceSpringKey;
import org.yes.cart.web.support.util.cookie.ShoppingCartPersister;
import org.yes.cart.web.support.util.cookie.impl.ShoppingCartPersisterImpl;
import org.yes.cart.web.util.WicketUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * User: Igor Azarny iazarny@yahoo.com
 * Date: 7/10/11
 * Time: 10:22 AM
 */
public class AbstractWebPage extends WebPage {

    @SpringBean(name = ServiceSpringKeys.CART_COMMAND_FACTORY)
    private ShoppingCartCommandFactory shoppingCartCommandFactory;

    @SpringBean(name = WebServiceSpringKey.CART_PERSISTER)
    private ShoppingCartPersister shoppingCartPersister;

    /**
     * Construct page.
     *
     * @param params page parameters
     */
    public AbstractWebPage(final PageParameters params) {
        super(params);
        setStatelessHint(true);
    }

    /**
     * {@inheritDoc}
     */
    protected void processCommands() {

        final ShoppingCart cart = ApplicationDirector.getShoppingCart();

        if (cart.accept(
                getShoppingCartCommandFactory().create(WicketUtil.pageParametesAsMap(getPageParameters()))
        ) || needToPersists(cart)) {
            //Not sure what the best way to apply changed locale
            if (cart.getCurrentLocale() != null && !getSession().getLocale().getLanguage().equals(cart.getCurrentLocale())) {
                getSession().setLocale(new Locale(cart.getCurrentLocale()));
            }
            getShoppingCartPersister().persistShoppingCart(
                    (HttpServletRequest) getRequest().getContainerRequest(),
                    (HttpServletResponse) getResponse().getContainerResponse(),
                    cart
            );
        }
        super.onBeforeRender();

    }

    private boolean needToPersists(final ShoppingCart shoppingCart) {
       return (shoppingCart.getProcessingStartDate().getTime() <= shoppingCart.getModifiedDate().getTime());
    }

    /**
     * {@inheritDoc}
     */
    public ShoppingCartCommandFactory getShoppingCartCommandFactory() {
        return shoppingCartCommandFactory;
    }

    /**
     * {@inheritDoc}
     */
    public ShoppingCartPersister getShoppingCartPersister() {
        return shoppingCartPersister;
    }


}
