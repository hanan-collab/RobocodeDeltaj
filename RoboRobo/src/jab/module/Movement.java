package jab.module;

import robocode.AdvancedRobot;
import robocode.Event;
import robocode.HitWallEvent;
import robocode.StatusEvent;

/**
 * Movement
 * 
 * @author jab
 */
public class Movement extends Part {

	public Module bot;

	public Movement(Module bot) {
		this.bot = bot;
	}

	public void move() {
		bot.setMaxVelocity(8);
		bot.setAhead(MOVE_DISTANCE * moveDirection);
	}

	private int moveDirection = 1;
	private static final int MOVE_DISTANCE = 400;
	private double traveledDistance = 0;

	public void listen(Event e) {
		if (e instanceof HitWallEvent) {
			moveDirection *= -1;
			bot.setBack(50); // Mundur sedikit
			bot.setTurnRight(90); // Belok kanan
			bot.execute();
			traveledDistance = 0; // Reset jarak tempuh
			bot.setAhead(MOVE_DISTANCE * moveDirection);
		}

		if (e instanceof StatusEvent) {
			traveledDistance += Math.abs(bot.getVelocity());
			System.out.println("Traveled Distance: " + traveledDistance);

			if (traveledDistance >= MOVE_DISTANCE) {
				moveDirection *= -1; // Ganti arah
				traveledDistance = 0; // Reset jarak tempuh
				bot.setAhead(MOVE_DISTANCE * moveDirection); // Pastikan perintahnya benar
			}
		}
	}

}
