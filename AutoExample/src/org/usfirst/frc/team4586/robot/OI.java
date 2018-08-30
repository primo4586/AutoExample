/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4586.robot;

import org.usfirst.frc.team4586.robot.commands.DriveTwoMeters;
import org.usfirst.frc.team4586.robot.commands.ResetEndocers;
import org.usfirst.frc.team4586.robot.commands.ResetGyro;
import org.usfirst.frc.team4586.robot.commands.Rotate90Degrees;
import org.usfirst.frc.team4586.robot.commands.RotatePID;
import org.usfirst.frc.team4586.robot.commands.Test;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public Joystick driverStick;
	public JoystickButton a;
	public JoystickButton x;
	public JoystickButton b;
	public JoystickButton y;

	public OI() {
		this.driverStick = new Joystick(0);
		this.a = new JoystickButton(this.driverStick, 1);
		this.b = new JoystickButton(this.driverStick, 2);
		this.x = new JoystickButton(this.driverStick, 3);
		this.y = new JoystickButton(this.driverStick, 4);

		this.a.whenPressed(new ResetEndocers());
		this.x.whenPressed(new RotatePID());
		this.y.whenPressed(new ResetGyro());
		this.b.whenPressed(new DriveTwoMeters());
	}
}
