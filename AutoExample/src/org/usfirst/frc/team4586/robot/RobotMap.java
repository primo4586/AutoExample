/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4586.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

	public static WPI_TalonSRX mainRightMotor;
	public static WPI_TalonSRX mainLeftMotor;
	public static WPI_TalonSRX followerRightMotor;
	public static WPI_TalonSRX followerLeftMotor;
	
	public static AnalogGyro gyro;

	public static void init() {
		mainRightMotor = new WPI_TalonSRX(7);
		mainRightMotor.setSafetyEnabled(false);
		mainLeftMotor = new WPI_TalonSRX(0);
		mainLeftMotor.setSafetyEnabled(false);
		followerRightMotor = new WPI_TalonSRX(6);
		followerRightMotor.setSafetyEnabled(false);
		followerLeftMotor = new WPI_TalonSRX(1);
		followerLeftMotor.setSafetyEnabled(false);
		
		gyro = new AnalogGyro(0);
	}
}
