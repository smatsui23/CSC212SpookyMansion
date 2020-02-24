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
				Place.create("entranceDoor", "You are in the grand entrance hall of a large building.\n"
						+ "The front door is locked. How did you get here?"));
		entranceDoor.addExit(new Exit("Office2", "Go to Office2."));
		entranceDoor.addExit(new Exit("Office4", "Go to Office3."));
		entranceDoor.addExit(new Exit("Office7", "Go to Office7."));
		entranceDoor.addExit(new Exit("Office1", "Go to Office1."));

		String EMOJI_SKULL = "\uD83D\uDC80";
		Place Office1 = insert(
				Place.create("Office1", "On the wall is scratched a series of letters and a skull icon ("+EMOJI_SKULL+").\n"
				+ "North.. North.. East.. South.\n" 
				+ "What could it mean?"));
		Office1.addExit(new Exit("entranceDoor", "Go back."));

		Place Office2 = insert(Place.create("Office2", "You have found the Office2 of the mansion.\n" + "It is darker down here.\n"
						+ "You get the sense a secret is nearby, but you only see the stairs you came from."));
		Office2.addExit(new Exit("entranceDoor", "There are stairs leading up."));
		Office2.addExit(new Exit("Office3", "There appears to be a pit in the center of the room you could climb into..."));
		
		Place Office3 = insert(
				Place.create("Office3", "I don't know what you were thinking..."));
		Office3.addExit(new Exit("labyrinth0", "Keep falling."));

		Place Office4= insert(Place.create("Office4",
				"Something rustles in the rafters as you enter the Office4. Creepy.\n" + "It's big up here."));
		Office4.addExit(new Exit("entranceDoor", "There are stairs leading down."));
		Office4.addExit(new Exit("Office4", "There is more through an archway."));

		Place Office5 = insert(Place.create("Office5", "There's definitely a bat in here somewhere.\n"
				+ "This part of the Office5 is brighter, so maybe you're safe here."));
		Office5.addExit(new Exit("Office4", "There is more back through the archway."));
		Office5.addExit(new Exit("Office6", "There is a Office6."));
		Office5.addExit(new Exit("Office8", "There is a Office8."));

		Place Office6 = insert(Place.create("Office6", "The night is pitch-black."));
		Office6.addExit(new Exit("Office5", "Return to the Office5."));
		Office6.addExit(new Exit("runaway", "You could runaway off, but you can't see the ground."));

		Place runaway = insert(Place.terminal("runaway", "I wonder what you expected to happen here."));
		
		Place Office7 = insert(
				Place.create("Office7", "You've found the Office7. You smell old food and some kind of animal."));
		Office7.addExit(new Exit("entranceDoor", "There is a Of."));
		Office7.addExit(new Exit("Office8", "There is a Office8."));

		Place Office8 = insert(Place.create("Office8", "You crawl into the Office8. What are you doing?"));
		Office8.addExit(new Exit("Office9", "Take it to the bottom."));
		Office8.addExit(new Exit("Office7", "Take it to the middle-level."));
		Office8.addExit(new Exit("Office5", "Take it up to the top."));

		Place Office9 = insert(Place.create("Office9", "You have found the secret room."));
		Office9.addExit(new Exit("labyrinth0", "There is door with a skull on it... "+EMOJI_SKULL));
		Office9.addExit(new Exit("hallway0", "There is a long hallway."));

		int hallwayDepth = 3;
		int lastHallwayPart = hallwayDepth - 1;
		for (int i = 0; i < hallwayDepth; i++) {
			Place hallwayPart = insert(Place.create("hallway" + i, "This is a very long hallway."));
			if (i == 0) {
				hallwayPart.addExit(new Exit("Office9", "Go back."));
			} else {
				hallwayPart.addExit(new Exit("hallway" + (i - 1), "Go back."));
			}
			if (i != lastHallwayPart) {
				hallwayPart.addExit(new Exit("hallway" + (i + 1), "Go forward."));
			} else {
				hallwayPart.addExit(new Exit("treasureBox", "There is darkness ahead."));
			}
		}

		Place treasureBox = insert(Place.terminal("treasureBox", "You have found the treasureBox.\n"
				+ "It is scary here, but there is an exit to outside.\n" + "Maybe you'll be safe out there."));

		String labyrinthDescription = "You see four hallways stretching out into the mist.\n"
				+ "On the ground, there is tile shaped like a compass.";
		Place labyrinth0 = insert(Place.create("labyrinth0", labyrinthDescription));
		Place labyrinth1 = insert(Place.create("labyrinth1", labyrinthDescription));
		Place labyrinth2 = insert(Place.create("labyrinth2", labyrinthDescription));
		Place labyrinth3 = insert(Place.create("labyrinth3", labyrinthDescription));
		
		// solution: North.
		labyrinth0.addExit(new Exit("labyrinth1", "Go North."));
		labyrinth0.addExit(new Exit("labyrinth0", "Go East."));
		labyrinth0.addExit(new Exit("labyrinth0", "Go South."));
		labyrinth0.addExit(new Exit("labyrinth0", "Go West."));
		
		// solution: North.
		labyrinth1.addExit(new Exit("labyrinth2", "Go North."));
		labyrinth1.addExit(new Exit("labyrinth0", "Go East."));
		labyrinth1.addExit(new Exit("labyrinth0", "Go South."));
		labyrinth1.addExit(new Exit("labyrinth0", "Go West."));
		
		// solution: East.
		labyrinth2.addExit(new Exit("labyrinth0", "Go North."));
		labyrinth2.addExit(new Exit("labyrinth3", "Go East."));
		labyrinth2.addExit(new Exit("labyrinth0", "Go South."));
		labyrinth2.addExit(new Exit("labyrinth0", "Go West."));
		
		// solution: South.
		labyrinth3.addExit(new Exit("labyrinth0", "Go North."));
		labyrinth3.addExit(new Exit("labyrinth3", "Go East."));
		labyrinth3.addExit(new Exit("entranceDoor", "Go South."));	
		labyrinth3.addExit(new Exit("labyrinth0", "Go West."));
		



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

