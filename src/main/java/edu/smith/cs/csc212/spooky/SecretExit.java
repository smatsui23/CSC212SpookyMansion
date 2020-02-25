package edu.smith.cs.csc212.spooky;

  
  public class SecretExit extends Exit{
	  //SecretExit exists in between Office4 and Office5 of FordHall.
	  
	  //This exit is secret 
	  private boolean hidden;
	 
	  public SecretExit(String target, String description) { 
		  super(target,description);
		  this.hidden = true;
	  }	  
	  
	  @Override
	  public boolean isSecret() {
		  return this.hidden;
	  }
	  
	  public void search() {
		  this.hidden = false;
	  }
	  
 }
  

 	
