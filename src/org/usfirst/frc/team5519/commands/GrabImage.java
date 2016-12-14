package org.usfirst.frc.team5519.commands;

import org.usfirst.frc.team5519.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GrabImage extends Command {
	
	private boolean isFinished = false;

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		requires(Robot.cameraVision);
		isFinished = false;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.cameraVision.saveImage();
		isFinished = true;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isFinished;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		isFinished = false;
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}

}
