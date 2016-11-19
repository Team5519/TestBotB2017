package org.usfirst.frc.team5519.commands;

import org.usfirst.frc.team5519.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * A command to retract the simple robot arm.
 * 
 * @author GSN 11/19/2016
 *
 */
public class RetractArm extends Command {

	public RetractArm() {
		requires(Robot.arm);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.arm.retract();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.arm.isInnerLimitHit();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.arm.stop();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}

}
