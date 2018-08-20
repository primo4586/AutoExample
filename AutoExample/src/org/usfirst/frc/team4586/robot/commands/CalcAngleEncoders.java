package org.usfirst.frc.team4586.robot.commands;

import org.usfirst.frc.team4586.robot.Robot;
import org.usfirst.frc.team4586.robot.subsystems.Driver;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CalcAngleEncoders extends Command {

	private Driver driver;
	private double omega;

	public CalcAngleEncoders() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.driver = Robot.m_driver;
		this.omega = 0;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		this.omega = 0;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		this.omega = (this.driver.getLeftVelocity() - this.driver.getRightVelocity()) / 0.6;
		this.driver.updateAngle(this.omega * 0.02);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		this.driver.resetAngleEncoders();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		this.end();
		System.out.println("CalcAngleEncoders interrupted");
	}
}
