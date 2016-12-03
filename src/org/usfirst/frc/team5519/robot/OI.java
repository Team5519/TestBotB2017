package org.usfirst.frc.team5519.robot;

import org.usfirst.frc.team5519.commands.ExtendArm;
import org.usfirst.frc.team5519.commands.GrabImage;
import org.usfirst.frc.team5519.commands.RetractArm;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
	
	public static final int kDriveStickPort = 0;	// Need to find and set correct joy stick port
	public static Joystick driveStick;
	
	public static final int kExtendArmButtonNumber = 7;
	public static final int kCancelExtendArmButtonNumber = 8;
	public static final int kRetractArmButtonNumber = 9;
	public static final int kCancelRetractArmButtonNumber = 10;
	public static final int kToggleArmButtonNumber = 11;
		
	public static Button extendArmButton;
	public static Button cancelExtendArmButton;
	public static Button retractArmButton;
	public static Button cancelRetractArmButton;
	public static Button toggleArmButton;
	
	public static final int kGrabImageButtonNumber = 12;
	public static Button grabImageButton;

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	public OI() {
		OI.driveStick = new Joystick(kDriveStickPort);
				
		Command extendArm = new ExtendArm();
		OI.extendArmButton = new JoystickButton(OI.driveStick,kExtendArmButtonNumber);
		OI.extendArmButton.whenPressed(extendArm);
		OI.cancelExtendArmButton = new JoystickButton(OI.driveStick,kCancelExtendArmButtonNumber);
		OI.cancelExtendArmButton.cancelWhenPressed(extendArm);
		
		Command retractArm = new RetractArm();
		OI.retractArmButton = new JoystickButton(OI.driveStick,kRetractArmButtonNumber);
		OI.retractArmButton.whenPressed(retractArm);
		OI.cancelRetractArmButton = new JoystickButton(OI.driveStick,kCancelRetractArmButtonNumber);
		OI.cancelRetractArmButton.cancelWhenPressed(extendArm);
		OI.toggleArmButton = new JoystickButton(OI.driveStick,kToggleArmButtonNumber);
		OI.toggleArmButton.toggleWhenPressed(retractArm);
		
		Command grabImage = new GrabImage();
		OI.grabImageButton = new JoystickButton(OI.driveStick,kGrabImageButtonNumber);
		OI.grabImageButton.whenPressed(grabImage);

	}

}
