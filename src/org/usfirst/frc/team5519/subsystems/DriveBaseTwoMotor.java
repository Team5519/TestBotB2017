package org.usfirst.frc.team5519.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;

public class DriveBaseTwoMotor {
	
	protected Talon frontLeftMotor, frontRightMotor;
	protected RobotDrive myDrive;
	
	/** GSN - 11/12/2016
	 * 
	 * Primary Constructor for Team5519 drive base
	 * 
	 * Number of drive motors and type of motor controllers are abstracted in this object 
	 * so that main robot code can just focus on driving.
	 * 
	 */
	public DriveBaseTwoMotor() {
		
	    frontLeftMotor = new Talon(1);		// Need to find and set correct port
	    frontRightMotor = new Talon(2);		// Need to find and set correct port
        myDrive = new RobotDrive(frontLeftMotor, frontRightMotor);	// NOTE: left - Right order
        myDrive.setExpiration(0.1);			// We need to sus out robot safety
        
	}

	/** GSN - 11/12/2016
	 * 
	 * Secondary Constructor for Team5519 drive base
	 * 
	 * This assumes two motors driven by Talon controllers. 
	 * Main robot code must also specify ports.
	 * 
	 */
	public DriveBaseTwoMotor(int leftMotorChannel, int rightMotorChannel) {
		
	    frontLeftMotor = new Talon(leftMotorChannel);
	    frontRightMotor = new Talon(rightMotorChannel);
        myDrive = new RobotDrive(frontLeftMotor, frontRightMotor);	// NOTE: left - Right order
        myDrive.setExpiration(0.1);			// We need to sus out robot safety
        
	}
	
	/** GSN - 11/12/2016
	 * 
	 * Just Drive! Under joystick command. 
	 * Code stolen from RobotDrive
	 * 
	 */
	public void Drive(GenericHID stick) {
		myDrive.arcadeDrive(stick, true);
	}

	/** GSN - 11/12/2016
	 * 
	 * Drive using direct values. 
	 * Code stolen from RobotDrive
	 * 
	 */
	 public void Drive(double moveValue, double rotateValue) {
		 myDrive.arcadeDrive(moveValue, rotateValue);
	 }
}
