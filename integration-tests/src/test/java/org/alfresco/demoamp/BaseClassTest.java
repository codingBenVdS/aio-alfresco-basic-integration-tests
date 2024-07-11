package org.alfresco.demoamp;

import com.github.ruediste.remoteJUnit.client.RemoteTestRunner;
import org.alfresco.demoamp.helper.ApplicationContextProvider;
import org.alfresco.repo.admin.SysAdminParams;
import org.alfresco.repo.model.Repository;
import org.alfresco.service.ServiceRegistry;
import org.alfresco.service.cmr.repository.NodeService;
import org.alfresco.service.cmr.security.AuthenticationService;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;


@RunWith(RemoteTestRunner.class)
public abstract class BaseClassTest  {
    private Logger logger = LoggerFactory.getLogger(BaseClassTest.class);

    protected ApplicationContext applicationContext;
    protected ServiceRegistry serviceRegistry;
    protected Repository repository;
    protected AuthenticationService authenticationService;
    protected NodeService nodeService;
    protected SysAdminParams sysAdminParams;

    public BaseClassTest(){
        applicationContext = ApplicationContextProvider.getApplicationContext();
        serviceRegistry = (ServiceRegistry) applicationContext.getBean(ServiceRegistry.class);
        authenticationService = (AuthenticationService) serviceRegistry.getAuthenticationService();
        repository = (Repository) applicationContext.getBean(Repository.class);
        sysAdminParams = serviceRegistry.getSysAdminParams();
        nodeService = serviceRegistry.getNodeService();
    }


    protected void sayHello(){
        if (applicationContext == null) {
            logger.error("The ApplicationContext was NOT Autowired into the BaseClass!");
        }
        else{
            logger.error("The ApplicationContext was Autowired into the BaseClass!");
        }

        if (sysAdminParams == null) {
            logger.error("The sysAdminParams was NOT Autowired into the BaseClass!");
        }
        else{
            logger.error("The sysAdminParams was Autowired into the BaseClass {}!", sysAdminParams.getAlfrescoHost());
        }
    }
}
