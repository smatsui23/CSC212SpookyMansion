package edu.smith.cs.csc212.spooky;

public class LockedExit extends Exit{
	
	private boolean isLocked;
	
	public LockedExit(String target, String description) {
		super(target, description);
		this.isLocked = true;
	}
	
	public boolean isLocked() {
		return this.isLocked;
	}
	
	public void setIsLocked(boolean newIsLocked) {
		this.isLocked = newIsLocked;
	}
	

}
