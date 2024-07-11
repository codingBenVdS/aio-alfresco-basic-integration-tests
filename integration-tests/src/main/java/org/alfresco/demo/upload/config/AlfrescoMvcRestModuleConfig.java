package org.alfresco.demo.upload.config;

import com.gradecak.alfresco.mvc.rest.annotation.AlfrescoDispatcherWebscript;
import com.gradecak.alfresco.mvc.rest.annotation.EnableAlfrescoMvcRest;

@EnableAlfrescoMvcRest(@AlfrescoDispatcherWebscript(servletContext = AlfrescoMvcRestServletContext.class, inheritGlobalProperties = true))
public class AlfrescoMvcRestModuleConfig {

}