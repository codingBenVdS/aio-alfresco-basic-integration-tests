package org.alfresco.demoamp;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlfrescoApplicationContextIT extends BaseClassTest {
    private Logger logger = LoggerFactory.getLogger(AlfrescoApplicationContextIT.class);

    @After
    public void tearDown() {
        // Teardown code here
        System.out.println("Cleanup after each test method.");
    }

    @Test
    public void testApplicationContextIsNotNull() {
        this.sayHello();
        assertNotNull(applicationContext);
    }

    @Test
    public void testNodeServiceIsNotNull() {
        assertNotNull(nodeService);
    }
}
