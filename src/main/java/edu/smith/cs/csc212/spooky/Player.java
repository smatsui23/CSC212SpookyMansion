package edu.smith.cs.csc212.spooky;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents all of the game state needed to understand the player.
 * At the beginning of this project, it is just the ID or name of a place.
 * 
 * @author jfoley
 *
 */
public class Player {
	/**
	 * The ID of the Place object where the player is currently.
	 */
	private String place;
	/**
	 * The player will now know places they have been 
	 */
	private Set<String> visited;

	/**
	 * A player is created at the start of a game with just an initial place.
	 * @param initialPlace - where do we start?
	 */
	public Player(String initialPlace) {
		this.place = initialPlace;
		this.visited = new HashSet<>();
	}

	/**
	 * Get access to the place instance variable from outside this class.
	 * @return the id of the current location.
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * Call this method when the player moves to a new place.
	 * @param place - the place we are now located at.
	 */
	public void moveTo(String place) {
		this.place = place;
		
	}
	
	public void rememberThisPlace() {
		this.visited.add(place);
	}
	
	/**
	 * Call this method when the player moves to the same place.
	 * @return the id of the place in the visited list 
	 */
	public boolean hasBeenHereBefore() {
		return this.visited.contains(this.getPlace());
		
	}
	

	
}
