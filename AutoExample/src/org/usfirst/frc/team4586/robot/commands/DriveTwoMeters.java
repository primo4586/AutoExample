package org.usfirst.frc.team4586.robot.commands;

import org.omg.IOP.ProfileIdHelper;
import org.usfirst.frc.team4586.robot.Robot;
import org.usfirst.frc.team4586.robot.subsystems.Driver;

import Utils.PIDHelper;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTwoMeters extends Command {
	private Driver driver;
	private PIDHelper encoderPID;
	private PIDHelper gyroPID;

	public DriveTwoMeters() {
		this.driver = Robot.m_driver;
		SmartDashboard.putNumber("kPe", 0);
		SmartDashboard.putNumber("kIe", 0);
		SmartDashboard.putNumber("kDe", 0);
		SmartDashboard.putNumber("kPg", 0);
		SmartDashboard.putNumber("kIg", 0);
		SmartDashboard.putNumber("kDg", 0);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		double kPe = SmartDashboard.getNumber("kPe", 0);
		double kIe = SmartDashboard.getNumber("kIe", 0);
		double kDe = SmartDashboard.getNumber("kDe", 0);
		this.encoderPID = new PIDHelper(kPe, kIe, kDe, 2);
		double kPg = SmartDashboard.getNumber("kPg", 0);
		
		double kIg = SmartDashboard.getNumber("kIg", 0);
		double kDg = SmartDashboard.getNumber("kDg", 0);
		this.gyroPID = new PIDHelper(kPg, kIg, kDg, 0);
		
		this.driver.resetGyro();
		this.driver.resetEncoders();
		setTimeout(4);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double speed =this.encoderPID.update(this.driver.getLeftPosition(), 0.02);
		double rotation = this.gyroPID.update(this.driver.getGyroAngle(), 0.02);
		this.driver.arcadeDrive(speed, rotation);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut() || Math.abs(this.encoderPID.getError()) <= 0.1;
	}

	// Called once after isFinished returns true
	protected void end() {
		this.driver.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		this.end();
		System.out.println("DriveTwoMeters interrupted");
	}
}
