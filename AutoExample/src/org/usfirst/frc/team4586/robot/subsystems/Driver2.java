package org.usfirst.frc.team4586.robot.subsystems;

import org.usfirst.frc.team4586.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Driver2 extends Subsystem {
	private WPI_TalonSRX left1Motor;
	private WPI_TalonSRX left2Motor;
	private WPI_TalonSRX right1Motor;
	private WPI_TalonSRX right2Motor;
	private AnalogGyro gyro;
	public final double CONSTANT = (0.1524 * Math.PI) / 8192;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public Driver2() {
		this.left1Motor = RobotMap.mainLeftMotor;
		this.left2Motor = RobotMap.followerLeftMotor;
		this.right1Motor = RobotMap.mainRightMotor;
		this.right2Motor = RobotMap.followerRightMotor;
		this.gyro = RobotMap.gyro;
	}

	public void setRightMotor(double speed) {
		this.right1Motor.set(speed);
		this.right2Motor.set(speed);
	}

	public void setLeftMotor(double speed) {
		this.left1Motor.set(speed);
		this.left2Motor.set(speed);
	}

	public void stopMotors() {
		this.setLeftMotor(0);
		this.setRightMotor(0);
	}

	public double getAngle() {
		return this.gyro.getAngle();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
