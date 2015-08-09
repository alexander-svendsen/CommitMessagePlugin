package com.alexander.plugins.commitmessage;


import com.intellij.openapi.components.*;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

@State(
	name = "CommitMessageConfiguration",
	storages = @Storage(file = StoragePathMacros.WORKSPACE_FILE)
)
public class CommitMessageConfiguration implements PersistentStateComponent<CommitMessageConfiguration> {

	public boolean CHECK_COMMIT_MESSAGE = true;

	@Nullable
	@Override
	public CommitMessageConfiguration getState() {
		return this;
	}

	@Override
	public void loadState(CommitMessageConfiguration state) {
		XmlSerializerUtil.copyBean(state, this);
	}

	public static CommitMessageConfiguration getInstance(Project project) {
		return ServiceManager.getService(project, CommitMessageConfiguration.class);
	}

}
