package org.usfirst.frc.team5519.subsystems;

import org.usfirst.frc.team5519.robot.RobotMap;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/** 
 * Arm subsystem with one actuator/motor combo and two limit switches. 
 * 
 * @author GSN 11/19/2016
 */
public class SimpleArm extends Subsystem {

	private static SpeedController motor = RobotMap.armMotor;
	private static Counter outerLimitCounter;
	private static Counter innerLimitCounter;
	
	
	@Override
	protected void initDefaultCommand() {
    	if (outerLimitCounter == null) {
    		outerLimitCounter = new Counter(RobotMap.outerArmLimitSwitch);
    	}
    	if (innerLimitCounter == null) {
    		innerLimitCounter = new Counter(RobotMap.innerArmLimitSwitch);
    	}
   	    outerLimitCounter.reset();
    	innerLimitCounter.reset();
	}

    /** 
     * Check the limit switch for maximum actuator extension. For safety sake, arm 
     * will not operate if limit switch / counter is not set up. A counter is used 
     * to protect against timing issues where the arm bight blow by the limit switch 
     * before a check can be made.
     * 
     * @return true if the Outer Limit Switch has been hit.
     * 
     * @author GSN 11/19/2016
     */
	public boolean isOuterLimitHit() {
    	if (outerLimitCounter != null) {
    		return outerLimitCounter.get() > 0;
    	} else {
    		return true;
    	}
    }

    /** 
     * Check the limit switch for maximum actuator retraction (i.e. minimum extension). 
     * For safety sake, arm will not operate if limit switch / counter is not set up. 
     * A counter is used to protect against timing issues where the arm bight blow by the 
     * limit switch before a check can be made.
     * 
     * @return true if the Inner Limit Switch has been hit.
     * 
     * @author GSN 11/19/2016
     */
    public boolean isInnerLimitHit() {
    	if (innerLimitCounter != null) {
    		return innerLimitCounter.get() > 0;
    	} else {
    		return true;
    	}
    }

    /**
     * Reset (and initialize if necessary) the counter associated with the maximum arm 
     * extension limit switch. Should ONLY be called when the arm BEGINS retracting or 
     * during robot initialization. 
     *  
     * @author GSN 11/19/2016
     * 
     */
    private void resetOuterLimit() {
    	if (outerLimitCounter == null) {
    		outerLimitCounter = new Counter(RobotMap.outerArmLimitSwitch);
    	}
   	    outerLimitCounter.reset();
    }

    /**
     * Reset (and initialize if necessary) the counter associated with the minimum arm 
     * extension limit switch. Should ONLY be called when the arm BEGINS extending or 
     * during robot initialization. 
     *  
     * @author GSN 11/19/2016
     * 
     */
    private void resetInnerLimit() {
    	if (innerLimitCounter == null) {
    		innerLimitCounter = new Counter(RobotMap.innerArmLimitSwitch);
    	}
    	innerLimitCounter.reset();
    }

    /**
	 * Extend the arm! 
	 * Also makes it safe to retract the arm in a later command.
     *  
     * @author GSN 11/19/2016
	 */
	public void extend() {
		motor.set(0.5);
		this.resetInnerLimit();
	}
	
    /**
	 * Retract the arm! 
	 * Also makes it safe to extend the arm in a later command.
     *  
     * @author GSN 11/19/2016
	 */
	public void retract() {
		motor.set(-0.5);
		this.resetOuterLimit();
	}

    /**
	 * Stop the arm from extending or retracting! 
	 * Note... Does not affect the limit switches.
     *  
     * @author GSN 11/19/2016
	 */
	public void stop() {
		motor.set(0.0);
	}

}
