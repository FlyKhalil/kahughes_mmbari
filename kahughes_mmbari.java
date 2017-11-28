package kahughes_mmbari;
import robocode.*;
import java.awt.*;
import robocode.util.Utils;

public class kahughes_mmbari extends AdvancedRobot {

	public void run() {
		setBodyColor(Color.red);

		while(true) {
			
			getHeading();
			getVelocity();
			ahead(100);
			turnGunRight(360);
			back(300);
			turnGunRight(360);
			ahead(30);
			turnGunRight(360);
			turnRight(120);
			}
	     }			
	

	public void onScannedRobot(ScannedRobotEvent e) {

		double distance = e.getDistance();
		if(distance >= 800)
		{
			double bear = getHeadingRadians() + e.getBearingRadians();
			setTurnGunRightRadians(Utils.normalRelativeAngle(bear - getGunHeadingRadians() + (e.getVelocity() * Math.sin(e.getHeadingRadians() - bear) / 13.0)));
			fire(1.0);
		}
		else if(distance >= 200 && distance <= 500)
		{
			double bear = getHeadingRadians() + e.getBearingRadians();
			setTurnGunRightRadians(Utils.normalRelativeAngle(bear - getGunHeadingRadians() + (e.getVelocity() * Math.sin(e.getHeadingRadians() - bear) / 13.0)));
			fire(2.5);
		}
		else if(distance > 500 && distance < 800)
		{
			double bear = getHeadingRadians() + e.getBearingRadians();
			setTurnGunRightRadians(Utils.normalRelativeAngle(bear - getGunHeadingRadians() + (e.getVelocity() * Math.sin(e.getHeadingRadians() - bear) / 13.0)));
			fire(2.0);
		}
		else if(distance < 200)
		{
			double bear = getHeadingRadians() + e.getBearingRadians();
			setTurnGunRightRadians(Utils.normalRelativeAngle(bear - getGunHeadingRadians() + (e.getVelocity() * Math.sin(e.getHeadingRadians() - bear) / 13.0)));
			fire(3.0);
		}
		}

	public void onHitByBullet(HitByBulletEvent e) {

		turnRight(e.getBearing());
		ahead(100);
			
	}
	
	public void onHitWall(HitWallEvent e) {

		ahead(300);
		back(100);
		turnLeft(270);
		turnRight(120);
	}	

}
