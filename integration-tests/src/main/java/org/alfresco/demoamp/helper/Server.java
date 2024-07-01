/**
 * Copyright (C) 2017 Alfresco Software Limited.
 * <p/>
 * This file is part of the Alfresco SDK project.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.alfresco.demoamp.helper;

import com.github.ruediste.remoteJUnit.codeRunner.CodeRunnerStandaloneServer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Server implements ApplicationContextAware, InitializingBean
{
	private static Log logger = LogFactory.getLog(Server.class);

	private CodeRunnerStandaloneServer codeRunnerStandaloneServer;
	private ApplicationContext applicationContext;

	public void setCodeRunnerStandaloneServer(CodeRunnerStandaloneServer codeRunnerStandaloneServer) {
		this.codeRunnerStandaloneServer = codeRunnerStandaloneServer;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Loading Application Context for Integration Tests...");
		ApplicationContextProvider.setApplicationContext(this.applicationContext);
		if (ApplicationContextProvider.getApplicationContext() == null){
			logger.error("Application Context Loading Failed! context=" + ApplicationContextProvider.getApplicationContext());
		}

		System.out.println("JUnit-remote server is starting...");
		Thread newThread = new Thread(() -> {
			codeRunnerStandaloneServer.startAndWait();
		});

		newThread.start();
	}
}
