package org.usfirst.frc.team5519.robot;

import edu.wpi.first.wpilibj.GenericHID;

public abstract class DriveBase {

	/** GSN - 11/12/2016
	 * 
	 * Just Drive! Under joystick command. 
	 * Code stolen from RobotDrive
	 * 
	 */
	abstract void Drive(GenericHID stick);

	/** GSN - 11/12/2016
	 * 
	 * Drive using direct values. 
	 * Code stolen from RobotDrive
	 * 
	 */
	 abstract void Drive(double moveValue, double rotateValue);
	

}
