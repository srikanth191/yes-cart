/*
 * Copyright 2009 Denys Pavlov, Igor Azarnyi
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.yes.cart.web.application;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.DefaultMarkupCacheKeyProvider;
import org.yes.cart.util.ShopCodeContext;

/**
 * User: Igor Azarny iazarny@yahoo.com
 * Date: 7/10/11
 * Time: 9:10 AM
 */
public class MultiMarkupCacheKeyProvider extends DefaultMarkupCacheKeyProvider {

    /**
	 * Construct a proper key value for the cache
	 *
	 * @param container
	 *            The container requesting the markup
	 * @param clazz
	 *            The clazz to get the key for
	 * @return Key that uniquely identifies any markup that might be associated with this markup
	 *         container.
	 */
	public String getCacheKey(final MarkupContainer container, final Class<?> clazz) {

            return ShopCodeContext.getShopCode() + '_' + super.getCacheKey(container, clazz);

    }
}
