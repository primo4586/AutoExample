package org.usfirst.frc.team4586.robot.subsystems;

import org.usfirst.frc.team4586.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Driver extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private WPI_TalonSRX mainRightMotor;
	private WPI_TalonSRX mainLeftMotor;
	private WPI_TalonSRX followerRightMotor;
	private WPI_TalonSRX followerLeftMotor;
	private DifferentialDrive diffDrive;

	private double angleEncoders;

	private SpeedControllerGroup rightController, leftController;

	private AnalogGyro gyro;

	public static final double CONVERT_TICKS_TO_METER = (0.1524 * Math.PI) / 8192;

	public Driver() {
		this.mainRightMotor = RobotMap.mainRightMotor;
		this.mainLeftMotor = RobotMap.mainLeftMotor;
		this.followerRightMotor = RobotMap.followerRightMotor;
		this.followerLeftMotor = RobotMap.followerLeftMotor;

		this.mainRightMotor.setSensorPhase(true);

		this.rightController = new SpeedControllerGroup(this.mainRightMotor, this.followerRightMotor);
		this.leftController = new SpeedControllerGroup(this.mainLeftMotor, this.followerLeftMotor);
		this.diffDrive = new DifferentialDrive(this.leftController, this.rightController);

		this.gyro = RobotMap.gyro;

		this.angleEncoders = 0;
	}

	public void setRight(double speed) {
		this.mainRightMotor.set(speed);
		this.followerRightMotor.set(speed);
	}

	public void setLeft(double speed) {
		this.mainLeftMotor.set(speed);
		this.followerLeftMotor.set(speed);
	}

	public void stop() {
		this.setRight(0);
		this.setLeft(0);
	}

	public void arcadeDrive(double speed, double rotation) {
		this.diffDrive.arcadeDrive(speed, rotation);
	}

	public double getRightPosition() {
		return this.mainRightMotor.getSelectedSensorPosition(0) * CONVERT_TICKS_TO_METER;
	}

	public double getLeftPosition() {
		return this.mainLeftMotor.getSelectedSensorPosition(0) * CONVERT_TICKS_TO_METER;
	}

	public double getRightVelocity() {
		return this.mainRightMotor.getSelectedSensorVelocity(0) * CONVERT_TICKS_TO_METER;
	}

	public double getLeftVelocity() {
		return this.mainLeftMotor.getSelectedSensorVelocity(0) * CONVERT_TICKS_TO_METER;
	}

	public void resetRightEncoder() {
		this.mainRightMotor.setSelectedSensorPosition(0, 0, 10);
	}

	public void resetLeftEncoder() {
		this.mainLeftMotor.setSelectedSensorPosition(0, 0, 10);
	}

	public void resetEncoders() {
		this.resetRightEncoder();
		this.resetLeftEncoder();
	}

	public void resetGyro() {
		this.gyro.reset();
	}

	public void calibrateGyro() {
		this.gyro.calibrate();
	}

	public double getGyroAngle() {
		return this.gyro.getAngle();
	}

	public void resetAngleEncoders() {
		this.angleEncoders = 0;
	}

	public double getAngleEncoders() {
		double diff = this.getRightPosition() - this.getLeftPosition();
		return Math.toDegrees(diff / 0.3) % 360;
	}

	public void updateAngle(double deltaAngle) {
		this.angleEncoders = (this.angleEncoders + deltaAngle) % 360;
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
