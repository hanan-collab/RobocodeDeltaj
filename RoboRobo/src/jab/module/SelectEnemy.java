package jab.module;

import java.util.Iterator;
import jab.module.BotInfo;
import jab.module.Module;
import jab.module.SelectEnemy;

/**
 * Select enemy
 * 
 * @author jabier.martinez
 */
public class SelectEnemy extends Part {

	public Module bot;

	public SelectEnemy(Module bot) {
		this.bot = bot;
	}

	public void select() {
		Iterator<BotInfo> iterator = bot.botsInfo.values().iterator();
		double minDistance = Double.MAX_VALUE;
		BotInfo selected = null;
		while (iterator.hasNext()) {
			BotInfo botInfo = iterator.next();
			if ((!botInfo.teammate) && minDistance > botInfo.distance) {
				selected = botInfo;
				minDistance = botInfo.distance;
			}
		}
		bot.enemy = selected;
	}

}
