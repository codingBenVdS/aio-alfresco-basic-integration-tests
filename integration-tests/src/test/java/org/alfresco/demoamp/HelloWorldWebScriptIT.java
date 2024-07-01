package org.alfresco.demoamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.alfresco.demoamp.helper.HelperClass;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

// Runs on your local machine
public class HelloWorldWebScriptIT {
    static Logger log = Logger.getLogger(HelloWorldWebScriptIT.class);
    private CloseableHttpClient httpclient;

    @Before
    public void setUp() throws Exception {
        // Login credentials for Alfresco Repo
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(HelperClass.ADMIN_USER_NAME, HelperClass.ADMIN_PASSWORD);
        provider.setCredentials(AuthScope.ANY, credentials);

        // Create HTTP Client with credentials
        httpclient = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(provider)
                .build();
    }


    @Test
    public void testWebScriptCall() throws Exception {
        String webscriptURL = "http://localhost:8080/alfresco/service/tutorial/helloworld";
        String expectedResponse = "<h2>Hello, Benjamin Van der Smissen</h2>";

        // Execute Web Script call
        try {
            HttpGet httpget = new HttpGet(webscriptURL);
            HttpResponse httpResponse = httpclient.execute(httpget);

            assertEquals("Incorrect HTTP Response Status",
                    HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());
            HttpEntity entity = httpResponse.getEntity();
            assertNotNull("Response from Web Script is null", entity);
            assertEquals("Incorrect Web Script Response", expectedResponse, EntityUtils.toString(entity));
        } finally {
            httpclient.close();
        }
    }
}