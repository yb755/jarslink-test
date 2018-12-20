package com.vbgps.jarslink;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.impl.AbstractModuleRefreshScheduler;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class ModuleRefreshSchedulerImpl extends AbstractModuleRefreshScheduler {

	@Override
	public List<ModuleConfig> queryModuleConfigs() {
		return buildModuleConfig();
	}

	public static List<ModuleConfig> buildModuleConfig() {
		List<ModuleConfig> moduleConfigList = new ArrayList<ModuleConfig>();
		URL root = ModuleRefreshSchedulerImpl.class.getResource("/");
		String libFolderPath = root.getPath() + "libs/";
		System.out.println(libFolderPath);
		File libFolder = new File(libFolderPath);
		if (!libFolder.exists()) {
			libFolder.mkdir();
		}
		File[] files = libFolder.listFiles();
		for (File file : files) {
			if (!file.getName().endsWith(".jar")) {
				continue;
			}
			URL demoModule = ModuleRefreshSchedulerImpl.class.getResource("/libs/" + file.getName());
			ModuleConfig moduleConfig = new ModuleConfig();
			moduleConfig.setName("demo");
			moduleConfig.setEnabled(true);
			moduleConfig.setVersion("1.0.0.20170621");
			moduleConfig.setProperties(ImmutableMap.of("svnPath", new Object()));
			moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
			moduleConfigList.add(moduleConfig);
		}
		return moduleConfigList;
	}
}
