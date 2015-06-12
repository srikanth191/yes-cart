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

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: denispavlov
 * Date: 04/08/2014
 * Time: 17:13
 */
public class MultiWebApplicationPathTest {

    @Test
    public void testGetShopResourceFile() throws Exception {

        assertEquals("shop.properties.xml",
                new MultiWebApplicationPath(null).getShopResourceFile("some/path/HomePage.properties.xml"));
        assertEquals("shop_en.properties.xml",
                new MultiWebApplicationPath(null).getShopResourceFile("some/path/HomePage_en.properties.xml"));
        assertEquals("shop_en_US.properties.xml",
                new MultiWebApplicationPath(null).getShopResourceFile("some/path/HomePage_en_US.properties.xml"));

    }
}
