package org.usfirst.frc.team5519.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	// GSN 11/18/2016
	// Output ports and controllers.
	public static final int kFrontLeftMotorPort = 1;	// Need to find and set correct port
	public static final int kRearLeftMotorPort = 2;		// Need to find and set correct port
	public static final int kFrontRightMotorPort = 3;	// Need to find and set correct port
	public static final int kRearRightMotorPort = 4;	// Need to find and set correct port
	public static final int kArmMotorPort = 5;			// Need to find and set correct port
	
	public static Talon frontLeftMotor;
	public static Talon rearLeftMotor;
	public static Talon frontRightMotor;
	public static Talon rearRightMotor;
	public static Victor armMotor;
	
	// GSN 11/18/2016
	// Input ports and sensors.
	public static final int kOuterArmLimitPort = 0;		// Need to find and set correct port
	public static final int kInnerArmLimitPort = 1;		// Need to find and set correct port

	public static DigitalInput outerArmLimitSwitch;
	public static DigitalInput innerArmLimitSwitch;
	
	static void init() {
		frontLeftMotor = new Talon(kFrontLeftMotorPort);
		rearLeftMotor = new Talon(kRearLeftMotorPort);
		frontRightMotor = new Talon(kFrontRightMotorPort);
		rearRightMotor = new Talon(kRearRightMotorPort);
		armMotor = new Victor(kArmMotorPort);
		
		outerArmLimitSwitch = new DigitalInput(kOuterArmLimitPort);
		innerArmLimitSwitch = new DigitalInput(kInnerArmLimitPort);
	}
}
