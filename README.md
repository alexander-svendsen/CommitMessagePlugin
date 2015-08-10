# Commit Message Plugin
An IntelliJ plugin which checks the commit message for the proper syntax before allowing the commit. It is enabled by default but can easily be disabled by the user if wanted.

## Usage:
When committing in IntelliJ the "Commit Changes" window pops up. Here it is possible to select which files you wish to commit, write a custom commit message, etc.

The plugin adds a checkbox to the before commit configuration named "Check commit message". This checkbox enables/disables the plugin depending on the value. When enabled the plugin checks the commit message for the proper syntax before allowing the commit. If it finds any mistakes an error message pops up with the mistakes pointed out.

## What the plugin checks for:
* No subject line
* Subject line too long
* Subject doesn't start with a capital letter
* Subject ends with a period

This is based upon what is written here: http://chris.beams.io/posts/git-commit/

Note that this plugin only extends what IntelliJ already offers and doesn't add anything IntelliJ can provide by itself. Like wrap commit message at 72 characters (Can be found under settings->Version Control)
