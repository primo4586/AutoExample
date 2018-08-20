package org.usfirst.frc.team4586.robot.commands;

import org.usfirst.frc.team4586.robot.Robot;
import org.usfirst.frc.team4586.robot.subsystems.Driver;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArcadeDrive extends Command {

	private Driver driver;
	private Joystick driverJoystick;

	public ArcadeDrive() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.driver = Robot.m_driver;
		this.driverJoystick = Robot.m_oi.driverStick;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		this.driver.arcadeDrive(-this.driverJoystick.getRawAxis(1), this.driverJoystick.getRawAxis(4));
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		this.driver.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		this.end();
		System.out.println("ArcadeDrive interrupted");
	}
}
