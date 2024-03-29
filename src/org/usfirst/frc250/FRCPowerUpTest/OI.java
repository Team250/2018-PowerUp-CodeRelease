// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc250.FRCPowerUpTest;

import org.usfirst.frc250.FRCPowerUpTest.Utilities;
import org.usfirst.frc250.FRCPowerUpTest.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc250.FRCPowerUpTest.XBoxTriggerButton;

import org.usfirst.frc250.FRCPowerUpTest.subsystems.*;

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

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public JoystickButton quickReleaseButton;
	public JoystickButton armUpButton;
	public JoystickButton armDownButton;
	public JoystickButton wristUpButton;
	public JoystickButton wristDownButton;
	public JoystickButton shiftUp;
	public JoystickButton shiftDown;
	public JoystickButton stopArmUp;
	public JoystickButton stopWristUp;
	public JoystickButton stopWristDown;
	public JoystickButton stopArmDown;
	public Joystick driverController;
	public JoystickButton intakeButton;
	public JoystickButton winchUp;
	public JoystickButton winchStop;
	public JoystickButton stopIntake;
	public JoystickButton armPos1Button;
	public JoystickButton armPos2Button;
	public JoystickButton armPos3Button;
	public JoystickButton armPos4Button;
	public JoystickButton armPos5Button;
	public JoystickButton exportSlow;
	public JoystickButton armGoToFixedPosition;
	public JoystickButton zeroArmEncoder;
	public Joystick manipulatorController;
	public JoystickButton shiftToggle;
	public JoystickButton noTurnButton;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=
	public XBoxPOVButton armPos0Button;
	public XBoxTriggerButton manipRightTrigger;
	public XBoxTriggerButton manipLeftTrigger;
	public XBoxPOVButton manipPOV;
	public XBoxJoystickButton leftJoy;
	public XBoxJoystickButton rightJoy;
	public JoystickButton wristToggle;

	public OI() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

		manipulatorController = new Joystick(1);
		driverController = new Joystick(0);

		// zeroArmEncoder = new JoystickButton(manipulatorController, 9);
		// zeroArmEncoder.whenPressed(new ZeroArm());
		exportSlow = new JoystickButton(manipulatorController, 6);
		exportSlow.whenPressed(new IntakeReleaseSlow());
		exportSlow.whenReleased(new IntakeStop());
		armPos5Button = new JoystickButton(manipulatorController, 4);
		armPos5Button.whenPressed(new SetArmTargetToAbsolutePosition("Arm Pos 5 Value"));
		armPos4Button = new JoystickButton(manipulatorController, 3);
		armPos4Button.whenPressed(new SetArmTargetToAbsolutePosition("Arm Pos 4 Value"));
		armPos3Button = new JoystickButton(manipulatorController, 8);
		armPos3Button.whenPressed(new SetArmTargetToAbsolutePosition("Arm Pos 3 Value"));
		armPos2Button = new JoystickButton(manipulatorController, 2);
		armPos2Button.whenPressed(new SetArmTargetToAbsolutePosition("Arm Pos 2 Value"));
		armPos1Button = new JoystickButton(manipulatorController, 1);
		armPos1Button.whenPressed(new SetArmTargetToAbsolutePosition("Arm Pos 1 Value"));
		winchUp = new JoystickButton(driverController, 3);
		winchUp.whenPressed(new WinchWind());
		winchUp.whenReleased(new WinchStop());
		intakeButton = new JoystickButton(manipulatorController, 5);
		intakeButton.whenPressed(new IntakeIn());
		intakeButton.whenReleased(new IntakeStop());

		noTurnButton = new JoystickButton(driverController, 1);
		noTurnButton.whenPressed(new DriveTurnDisable());
		shiftToggle = new JoystickButton(driverController, 2);
		shiftToggle.whenPressed(new ToggleShift());
		shiftDown = new JoystickButton(driverController, 9);
		shiftDown.whenPressed(new DownShift());
		shiftUp = new JoystickButton(driverController, 10);
		shiftUp.whenPressed(new UpShift());
		
		// Disable for Demos to avoid accidently moving arm with Joystick
		armDownButton = new JoystickButton(driverController, 4);
		armDownButton.whenPressed(new ArmDown());
		armUpButton = new JoystickButton(driverController, 6);
		armUpButton.whenPressed(new ArmUp());
		armUpButton.whenReleased(new ArmStop());
		armDownButton.whenReleased(new ArmStop());
		quickReleaseButton = new JoystickButton(driverController, 12);
		quickReleaseButton.whenPressed(new IntakeReleaseSlow());
		quickReleaseButton.whenReleased(new IntakeStop());

		// SmartDashboard Buttons
		SmartDashboard.putData("WinchStop", new WinchStop());
		SmartDashboard.putData("Drive", new Drive());
		SmartDashboard.putData("ArmUp", new ArmUp());
		SmartDashboard.putData("IntakeIn", new IntakeIn());
		SmartDashboard.putData("IntakeReleaseSlow", new IntakeReleaseSlow());
		SmartDashboard.putData("WinchWind", new WinchWind());
		SmartDashboard.putData("WristDown", new WristDown());
		SmartDashboard.putData("ArmDown", new ArmDown());
		SmartDashboard.putData("UpShift", new UpShift());
		SmartDashboard.putData("DownShift", new DownShift());
		SmartDashboard.putData("IntakeStop", new IntakeStop());
		SmartDashboard.putData("WristStop", new WristStop());
		SmartDashboard.putData("ArmStop", new ArmStop());
		SmartDashboard.putData("IntakeReleaseFast", new IntakeReleaseFast());
		SmartDashboard.putData("AutoSitAndWait", new AutoSitAndWait());
		SmartDashboard.putData("TimedDrive", new TimedDrive());
		SmartDashboard.putData("AutoCrossTheLine", new AutoCrossTheLine());
		SmartDashboard.putData("ToggleShift", new ToggleShift());
		SmartDashboard.putData("DriveTurnDisable", new DriveTurnDisable());
		SmartDashboard.putData("DriveTurnEnable", new DriveTurnEnable());
		SmartDashboard.putData("ArmJoystickControl", new ArmJoystickControl());
		SmartDashboard.putData("AutoDriveToSwitch", new AutoDriveToSwitch());
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS


		armPos0Button = new XBoxPOVButton(manipulatorController, XBoxPOVButton.PovDirection.Any);
		armPos0Button.whenPressed(new SetArmTargetToAbsolutePosition("Arm Pos 0 Value"));

		leftJoy = new XBoxJoystickButton(manipulatorController, 1, .1);
		leftJoy.whenPressed(new WristJoystickControl());

		rightJoy = new XBoxJoystickButton(manipulatorController, 5, .1);
		rightJoy.whenPressed(new ArmJoystickControl());

		noTurnButton.whenReleased(new DriveTurnEnable());

		manipRightTrigger = new XBoxTriggerButton(manipulatorController, 3, .1);
		manipRightTrigger.whenPressed(new IntakeReleaseFast());
		manipRightTrigger.whenReleased(new IntakeStop());

		wristToggle = new JoystickButton(manipulatorController, 7);
		wristToggle.whenPressed(new WristPositionToggle());
	}

	public double getYDrive() {
		double Y = Utilities.joystickDeadband(this.driverController.getRawAxis(1), 0.05);
		return Y;
	}

	public double getXDrive() {
		double X = Utilities.joystickDeadband(this.driverController.getRawAxis(2), 0.05);
		// ramping
		X = X * X * X;
		return X;
	}

	public double getRightJoy() {
		double RJ = this.manipulatorController.getRawAxis(5);
		return RJ;
	}

	public double getLeftJoy() {
		double LJ = this.manipulatorController.getRawAxis(1);
		return LJ;
	}

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
	public Joystick getDriverController() {
		return driverController;
	}

	public Joystick getManipulatorController() {
		return manipulatorController;
	}

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
