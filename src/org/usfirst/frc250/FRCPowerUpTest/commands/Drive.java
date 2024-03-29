// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc250.FRCPowerUpTest.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc250.FRCPowerUpTest.Robot;
import org.usfirst.frc250.FRCPowerUpTest.RobotMap;

/**
 *
 */
public class Drive extends Command {
	public double Left;
	public double Right;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public Drive() {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double Left = 0;
		double Right = 0;

		// when going fast makes turning more gradual otherwise turn normally
		if(Robot.driveTrain.isTurnDisabled()){
			Left = -Robot.oi.getYDrive() + (Robot.oi.getXDrive() * Robot.prefs2.getDouble("Drive Slow Turn Speed"));
			Right = -Robot.oi.getYDrive() - (Robot.oi.getXDrive() * Robot.prefs2.getDouble("Drive Slow Turn Speed"));
		} else {
			Left = -Robot.oi.getYDrive() + Robot.oi.getXDrive();
			Right = -Robot.oi.getYDrive() - Robot.oi.getXDrive();
		}

		// Determine Max output magnitude
		double max = Math.abs(Left);
		if (max < Math.abs(Right)) {
			max = Math.abs(Right);
		}

		// If requested output is over 100%, scale both outputs so max is 100%
		if (max > 1) {
			Left = Left / max;
			Right = Right / max;
		}

		Robot.driveTrain.drive(Left, Right);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
