package edu.smith.cs.csc212.spooky;

import java.util.HashMap;
import java.util.Map;

/**
 * Mansion, the game.
 * @author jfoley
 *
 */
public class FordHall implements GameWorld {
	private Map<String, Place> places = new HashMap<>();

	/**
	 * Where should the player start?
	 */
	@Override
	public String getStart() {
		return "entranceDoor";
	}

	/**
	 * This constructor builds our FordHall game.
	 */
	public FordHall() {
		Place entranceDoor = insert(
				Place.create("entranceDoor", "Welcome to Ford Hall. Let's go to office hours"));
		entranceDoor.addExit(new Exit("Office1", "Go to Office1."));
		entranceDoor.addExit(new Exit("Office2", "Go to Office2."));
		entranceDoor.addExit(new Exit("Office4", "Go to Office4."));
		entranceDoor.addExit(new Exit("Office7", "Go to Office7."));
		

		Place Office1 = insert(
				Place.create("Office1", "Empty Office"));
		Office1.addExit(new Exit("entranceDoor", "Go back."));

		Place Office2 = insert(
				Place.create("Office2", "You have found Prof.X's Office."));
		Office2.addExit(new Exit("entranceDoor", "Use Prof's secret pathway"));

		Place Office4= insert(
				Place.create("Office4","Where was Office3...? " + "It's a red room"));
		Office4.addExit(new Exit("entranceDoor", "Should we go back?"));
		Office4.addExit(new Exit("Office5", "We can proceed to Office5"));

		Place Office5 = insert(
				Place.create("Office5", "Bigger than Office4, smaller than Office6"));
		Office5.addExit(new Exit("Office4", "We could go back."));
		Office5.addExit(new Exit("Office6", "There is a Office6."));
		Office5.addExit(new Exit("Office8", "There is a Office8."));

		Place Office6 = insert(
				Place.create("Office6", "Small room."));
		Office6.addExit(new Exit("Office5", "Return to the Office5."));
		Office6.addExit(new Exit("runaway", "You just realized that you have an forgotten an assignment."));

		Place runaway = insert(
				Place.terminal("runaway", "I wonder what you expected to happen here."));
		
		Place Office7 = insert(
				Place.create("Office7", "You've found the Office7. You smell old food and some kind of animal."));
		Office7.addExit(new Exit("entranceDoor", "restart."));
		Office7.addExit(new Exit("Office8", "There is a Office8."));

		Place Office8 = insert(
				Place.create("Office8", "Second-to-last room"));
		Office8.addExit(new Exit("Office9", "LAST ONE?"));
		Office8.addExit(new Exit("Office7", "First Time?"));
		Office8.addExit(new Exit("Office5", "return"));

		Place Office9 = insert(
				Place.create("Office9", "You have found your prof's office."));
		Office9.addExit(new Exit("officeHours", "There he is!"));


		Place officeHours = insert(Place.terminal("officeHours", "You have found the office.\n"
				+ "Only 20 min. left! " + "Good luck!"));


		// Make sure your graph makes sense!
		checkAllExitsGoSomewhere();
	}

	/**
	 * This helper method saves us a lot of typing. We always want to map from p.id
	 * to p.
	 * 
	 * @param p - the place.
	 * @return the place you gave us, so that you can store it in a variable.
	 */
	private Place insert(Place p) {
		places.put(p.getId(), p);
		return p;
	}

	/**
	 * I like this method for checking to make sure that my graph makes sense!
	 */
	private void checkAllExitsGoSomewhere() {
		boolean missing = false;
		// For every place:
		for (Place p : places.values()) {
			// For every exit from that place:
			for (Exit x : p.getVisibleExits()) {
				// That exit goes to somewhere that exists!
				if (!places.containsKey(x.getTarget())) {
					// Don't leave immediately, but check everything all at once.
					missing = true;
					// Print every exit with a missing place:
					System.err.println("Found exit pointing at " + x.getTarget() + " which does not exist as a place.");
				}
			}
		}

		// Now that we've checked every exit for every place, crash if we printed any
		// errors.
		if (missing) {
			throw new RuntimeException("You have some exits to nowhere!");
		}
	}

	/**
	 * Get a Place object by name.
	 */
	public Place getPlace(String id) {
		return this.places.get(id);
	}
}

