/*
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2017 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
/**
 * 
 */
package org.broadleafcommerce.test.common.properties;

import org.broadleafcommerce.common.config.ProfileAwarePropertiesBeanFactoryPostProcessor;
import org.broadleafcommerce.test.common.properties.DefaultDevelopmentOverridePropertiesTest.PropertyTestConfig;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * 
 * @author Phillip Verheyden (phillipuniverse)
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PropertyTestConfig.class)
@DirtiesContext
public class DeprecatedRuntimeEnvironmentTest {

    @BeforeClass
    public static void setRuntimeEnvironment() {
        System.setProperty(ProfileAwarePropertiesBeanFactoryPostProcessor.DEPRECATED_RUNTIME_ENVIRONMENT_KEY, "production");
    }
    
    @AfterClass
    public static void clearRuntimeEnvironment() {
        System.clearProperty(ProfileAwarePropertiesBeanFactoryPostProcessor.DEPRECATED_RUNTIME_ENVIRONMENT_KEY);
    }
    
    @Autowired
    protected Environment env;
    
    @Test
    public void testDeprecatedRuntimeEnvironmentKey() {
        Assert.assertEquals("productionvalue", env.getProperty(PropertyTestConfig.TEST_PROPERTY));
    }
}