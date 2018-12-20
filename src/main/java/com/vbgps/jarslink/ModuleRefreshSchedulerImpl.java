package com.vbgps.jarslink;

import java.net.URL;
import java.util.List;

import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.impl.AbstractModuleRefreshScheduler;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class ModuleRefreshSchedulerImpl extends AbstractModuleRefreshScheduler {

	@Override
	public List<ModuleConfig> queryModuleConfigs() {
		return ImmutableList.of(buildModuleConfig());
	}

	public static ModuleConfig buildModuleConfig() {
        URL demoModule = Thread.currentThread().getContextClassLoader().getResource("META-INF/spring/demo-1.0.0.jar");
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setName("demo");
        moduleConfig.setEnabled(true);
        moduleConfig.setVersion("1.0.0.20170621");
        moduleConfig.setProperties(ImmutableMap.of("svnPath", new Object()));
        moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
        return moduleConfig;
    }
}
