package org.usfirst.frc.team5519.robot;

import edu.wpi.first.wpilibj.Joystick;

public class TeleopStationOneStick extends TeleopStation {
	
	final int kDriveStickPort = 0;	// Need to find and set correct joy stick port
	
	Joystick driveStick;
	
	public TeleopStationOneStick () {
		driveStick = new Joystick(kDriveStickPort);		
	}
	
	public Joystick getDriveStick() {
		return driveStick;
	}

}
