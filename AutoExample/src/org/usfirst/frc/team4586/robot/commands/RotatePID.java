package org.usfirst.frc.team4586.robot.commands;

import org.usfirst.frc.team4586.robot.Robot;
import org.usfirst.frc.team4586.robot.subsystems.Driver;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RotatePID extends Command {

	private Driver driver;
	private double kP, kI, kD;
	private double setPoint, error, prevError, integral, deriv;
	private double power;

	public RotatePID() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.driver = Robot.m_driver;
		this.setPoint = 90;

		this.kP = 0.0094;
		this.kD = 0;
		this.kI = 0;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		this.error = Double.MAX_VALUE;
		this.prevError = 0;
		this.integral = 0;
		this.deriv = 0;
		this.power = 0;
		this.driver.resetGyro();
		setTimeout(3);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		this.error = this.setPoint - this.driver.getGyroAngle();
		this.deriv = (this.error - this.prevError) / 0.02;
		this.integral = ((this.error + this.prevError) * 0.02) / 2;
		this.power = this.kP * this.error + this.kI * this.integral + this.kD * this.deriv;
		this.driver.arcadeDrive(0, this.power);
		this.prevError = this.error;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Math.abs(this.error) <= 7 || isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		driver.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		this.end();
		System.out.println("RotatePID error");
	}
}
