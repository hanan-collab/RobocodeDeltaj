package jab.module;

import robocode.util.Utils;

/**
 * Targeting
 * 
 * @author jabier.martinez
 */
public class Targeting extends Part {

	public Module bot;

	public Targeting(Module bot) {
		this.bot = bot;
	}

	public void target() {
		if (bot.enemy != null) {
			double absoluteBearing = bot.getHeadingRadians() + bot.enemy.bearingRadians;
			double relativeBearing = Utils.normalRelativeAngle(absoluteBearing - bot.getGunHeadingRadians());

			// Only target if the enemy is roughly to the left (-90 degrees) or right (90 degrees)
			if (Math.abs(relativeBearing) > Math.PI / 4 && Math.abs(relativeBearing) < 3 * Math.PI / 4) {
				bot.setTurnGunRightRadians(relativeBearing);
			}
		}
	}

}
