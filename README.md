# Commit Message Plugin
An IntelliJ plugin which checks the commit message for the proper syntax before allowing the commit. It is enabled by default but can easily be disabled by the user if wanted.

[![ghit.me](https://ghit.me/badge.svg?repo=alexander-svendsen/CommitMessagePlugin)](https://ghit.me/repo/alexander-svendsen/CommitMessagePlugin)

## Usage:
When committing in IntelliJ the "Commit Changes" window pops up. Here it is possible to select which files you wish to commit, write a custom commit message, etc.

The plugin adds a checkbox to the before commit configuration named "Check commit message". This checkbox enables/disables the plugin depending on the value. When enabled the plugin checks the commit message for the proper syntax before allowing the commit. If it finds any mistakes an error message pops up with the mistakes pointed out.

![Screenshot of the checkbox the plugin adds](https://cloud.githubusercontent.com/assets/2320398/9183636/b1b420f2-3fb0-11e5-83d2-08033c22b5cc.png)

![Screenshot of the plugin showing the mistakes](https://cloud.githubusercontent.com/assets/2320398/9183534/f5fb0362-3faf-11e5-8cb9-ca00bc1a2b34.png)

## What the plugin checks for:
* No commit message subject line
* Subject line too long (over 50 characters)
* Subject line doesn't start with a capital letter
* Subject line ends with a period

This is based upon what is written here: http://chris.beams.io/posts/git-commit/

Note that this plugin only extends what IntelliJ already offers and doesn't add anything IntelliJ can provide by itself. Like wrap commit message at 72 characters (Can be found under Settings -> Version Control).

## Installation: 
In IntelliJ open Settings -> Plugins -> Install plugin from disk -> Select CommitMessagePlugin.jar.
