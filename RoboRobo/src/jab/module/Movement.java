package jab.module;

import robocode.AdvancedRobot;
import robocode.Condition;
import robocode.Event;
import robocode.HitWallEvent;
import robocode.MoveCompleteCondition;
import robocode.TurnCompleteCondition;

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
		bot.setTurnRight(90);
	}

	private int moveDirection = 1;
	private int lastTurnDirection = 1;
	private static final int MOVE_DISTANCE = 400;

	public void listen(Event e) {
		if (e instanceof HitWallEvent) {
			bot.setTurnRight(90);
		}
	}

}
