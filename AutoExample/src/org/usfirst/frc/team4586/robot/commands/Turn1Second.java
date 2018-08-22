package org.usfirst.frc.team4586.robot.commands;

import org.usfirst.frc.team4586.robot.subsystems.Driver;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn1Second extends Command {

	private Driver driver;
	private boolean isLeft;

	public Turn1Second(Driver driver, boolean isLeft) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.driver = driver;
		this.isLeft = isLeft;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		setTimeout(1);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if(isLeft) {
			this.driver.setLeft(-0.6);
			this.driver.setRight(0.6);
		} else {
			this.driver.setLeft(0.6);
			this.driver.setRight(-0.6);	
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		this.driver.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		this.end();
		System.out.println("Turn1Second interrupted");
	}
}
