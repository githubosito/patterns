package behavioral.command.TVcommands;

public interface LoggedCommand extends TVCommand {
	
	public void addCommandManager(CommandMgr mgr);
}
