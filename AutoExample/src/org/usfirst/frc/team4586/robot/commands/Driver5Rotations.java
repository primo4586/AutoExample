package org.usfirst.frc.team4586.robot.commands;

import org.usfirst.frc.team4586.robot.subsystems.Driver;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Driver5Rotations extends Command {
	private Driver driver;
	
    public Driver5Rotations(Driver driver) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.driver = driver;
   
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driver.stop();
    	driver.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driver.setRight(-0.3);
    	
    	
    	driver.setLeft(0.3);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double ticks = driver.getLeftPosition()/driver.CONVERT_TICKS_TO_METER;
    	if (ticks >= 8192*5)
    		return true;
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driver.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    	System.out.println("Driver5Rotation EROR");
    }
}
