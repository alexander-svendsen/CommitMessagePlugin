package com.alexander.plugins.commitmessage;

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
		final JCheckBox reformatBox = new NonFocusableCheckBox("Check commit message");

		return new RefreshableOnComponent() {
			@Override
			public JComponent getComponent() {
				final JPanel panel = new JPanel(new GridLayout(1, 0));
				panel.add(reformatBox);
				return panel;
			}

			@Override
			public void refresh() {
			}

			@Override
			public void saveState() {
				getSettings().REFORMAT_BEFORE_PROJECT_COMMIT = reformatBox.isSelected();
			}

			@Override
			public void restoreState() {
				reformatBox.setSelected(getSettings().REFORMAT_BEFORE_PROJECT_COMMIT);
			}
		};

	}

	protected VcsConfiguration getSettings() {
		return VcsConfiguration.getInstance(myProject);
	}

	private static boolean reformat(final VcsConfiguration configuration, boolean checkinProject) {
		return checkinProject ? configuration.REFORMAT_BEFORE_PROJECT_COMMIT : configuration.REFORMAT_BEFORE_FILE_COMMIT;
	}

	@Override
	public ReturnResult beforeCheckin(CommitExecutor executor, PairConsumer<Object, Object> additionalDataConsumer) {
		return ReturnResult.CANCEL;
	}

}
