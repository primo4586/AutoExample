package org.usfirst.frc.team4586.robot.commands;

import org.usfirst.frc.team4586.robot.subsystems.Driver;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Rotate90Degrees extends Command {
	private Driver driver;
	private boolean isleft;

	public Rotate90Degrees(Driver driver, boolean isleft) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.driver = driver;
		this.isleft = isleft;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		this.driver.resetGyro();
		this.driver.stop();
		setTimeout(5);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (isleft) {
			System.out.println("left");
			if (this.driver.getGyroAngle() > -90)
				this.driver.arcadeDrive(0, -0.6);
			else
				this.driver.arcadeDrive(0, 0.6);
		} else {
			System.out.println("Right");
			if (this.driver.getGyroAngle() < 90)
				this.driver.arcadeDrive(0, 0.6);
			else
				
				this.driver.arcadeDrive(0, -0.6);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (!isleft)
			return (isTimedOut() || (this.driver.getGyroAngle() > 80 && this.driver.getGyroAngle() < 100));
		else
			return (isTimedOut() || (this.driver.getGyroAngle() < -80 && this.driver.getGyroAngle() > -100));

	}

	// Called once after isFinished returns true
	protected void end() {
		this.driver.stop();
		System.out.println("out");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		this.end();
		System.out.println("Rorare90Degrees ERROR");
	}
}
