package com.alexander.plugins.commitmessage;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vcs.CheckinProjectPanel;
import com.intellij.openapi.vcs.VcsConfiguration;
import com.intellij.openapi.vcs.changes.CommitExecutor;
import com.intellij.openapi.vcs.checkin.CheckinHandler;
import com.intellij.openapi.vcs.ui.RefreshableOnComponent;
import com.intellij.ui.NonFocusableCheckBox;
import com.intellij.util.PairConsumer;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class CheckCommitMessageCheckinHandler extends CheckinHandler {

	protected final Project myProject;
	private final CheckinProjectPanel myPanel;

	public CheckCommitMessageCheckinHandler(final Project project, final CheckinProjectPanel panel){
		myProject = project;
		myPanel = panel;
	}

	@Override
	@Nullable
	public RefreshableOnComponent getBeforeCheckinConfigurationPanel() {
		final JCheckBox checkMessageBox = new NonFocusableCheckBox("Check commit message");

		return new RefreshableOnComponent() {
			@Override
			public JComponent getComponent() {
				final JPanel panel = new JPanel(new GridLayout(1, 0));
				panel.add(checkMessageBox);
				return panel;
			}

			@Override
			public void refresh() {
			}

			@Override
			public void saveState() {
				getSettings().CHECK_COMMIT_MESSAGE = checkMessageBox.isSelected();
			}

			@Override
			public void restoreState() {
				checkMessageBox.setSelected(getSettings().CHECK_COMMIT_MESSAGE);
			}
		};
	}

	protected CommitMessageConfiguration getSettings() {
		return CommitMessageConfiguration.getInstance(myProject);
	}

	@Override
	public ReturnResult beforeCheckin(CommitExecutor executor, PairConsumer<Object, Object> additionalDataConsumer) {
		return ReturnResult.COMMIT;
	}
}
