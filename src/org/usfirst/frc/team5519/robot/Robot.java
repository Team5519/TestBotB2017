
package org.usfirst.frc.team5519.robot;

import org.usfirst.frc.team5519.subsystems.DriveBaseTwoMotor;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser;
    
	/**  GSN - 11/12/2016
	 * 
	 * Addition of basic drive capabilities using an abstracted driveBase.  
	 * The intent is is to allow development of more sophisticated drive bases  
	 * with minimal impact on the main robot code.
	 */
    DriveBaseTwoMotor driveBase;
    Joystick driveStick;
    int driveCount;

	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
    	
        // GSN - 11/12/2016
        driveBase = new DriveBaseTwoMotor();
        driveStick = new Joystick(0);		// Need to find and set correct joy stick port
        driveCount = 0;

    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	autoSelected = (String) chooser.getSelected();
//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	switch(autoSelected) {
    	case customAuto:
        //Put custom auto code here   
            break;
    	case defaultAuto:
    	default:
    	//Put default auto code here
            break;
    	}
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
    	// GSN - 11/12/2016
    	// driveBase.setSafetyEnabled(true);	// Need to sus out robot safety
    	//myDrive.arcadeDrive(driveStick); // drive with arcade style (use right stick)
    	// driveBase.Drive(driveStick);
    	
    	// teleopPeriodic is called every 20 ms so a count of 100 is about 2 seconds
    	driveCount++;
    	if (driveCount <= 100) {
    		// Go Forward Slowly for 2 seconds
    		driveBase.Drive(0.4,0);
    	} else if (driveCount <= 200) {
       		// Go Forward Fast for 2 seconds
    		driveBase.Drive(0.8,0);
    	} else if (driveCount <= 250) {
      		// Stop for 1 second
    		driveBase.Drive(0,0);
    	} else if (driveCount <= 350) {
       		// Go Backward Slowly for 2 seconds
    		driveBase.Drive(-0.4,0);
    	} else if (driveCount <= 450) {
       		// Go Backward Fast for 2 seconds
    		driveBase.Drive(-0.8,0);
    	} else if (driveCount <= 500) {
      		// Stop for 1 second
    		driveBase.Drive(0,0);
    	} else {
    		// Reset loop
    		driveCount = 0;
    	}
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
