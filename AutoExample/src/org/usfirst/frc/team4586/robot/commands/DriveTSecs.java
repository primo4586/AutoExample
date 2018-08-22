package org.usfirst.frc.team4586.robot.commands;

import org.omg.CORBA.TIMEOUT;
import org.usfirst.frc.team4586.robot.subsystems.Driver;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTSecs extends Command {
	private Driver driver;
	private double time;
	
    public DriveTSecs(double time,Driver driver) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.driver = driver;
    	this.time = time;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(this.time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	this.driver.setRight(0.6);
    	this.driver.setLeft(0.6);
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
    	System.out.println("DriveTSecs interrupted");
    }
}
