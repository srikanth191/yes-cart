package org.yes.cart.domain.entity.bridge;

import org.hibernate.search.bridge.StringBridge;
import org.yes.cart.domain.entity.ProductSku;

/**
 * User: Igor Azarny iazarny@yahoo.com
 * Date: 07-May-2011
 * Time: 16:13:01
 */
public class ProductSkuBridge implements StringBridge {

    /** {@inheritDoc} */
    public String objectToString(final Object productSkuObject) {
        return String.valueOf( ((ProductSku)productSkuObject).getSkuId() );
    }

}
