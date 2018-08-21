package behavioral.command.TVcommands;

public interface CommandMgr {
	
	public void record(TVCommand command) ;
	public void undo() ;
}
