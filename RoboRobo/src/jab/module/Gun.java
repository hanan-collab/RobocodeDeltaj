package jab.module;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import robocode.Bullet;

/**
 * Gun
 * 
 * @author jab
 */
public class Gun extends Part {

	public Module bot;

	public Gun(Module bot) {
		this.bot = bot;
	}

	public void fire() {
		if (bot.bulletPower > 0 && bot.getGunHeat() == 0) {
			Bullet b = bot.setFireBullet(bot.bulletPower);
			bot.registerBullet(b);
		}
	}

	public void listenInput(InputEvent e) {
		if (e instanceof MouseEvent) {
			if (e.getID() == MouseEvent.MOUSE_PRESSED) {
				if (((MouseEvent) e).getButton() == MouseEvent.BUTTON3) {
					bot.bulletPower = 3;
				} else if (((MouseEvent) e).getButton() == MouseEvent.BUTTON2) {
					bot.bulletPower = 2;
				} else {
					bot.bulletPower = 1;
				}
			}

			if (e.getID() == MouseEvent.MOUSE_RELEASED) {
				bot.bulletPower = 0;
			}
		}
	}

}
