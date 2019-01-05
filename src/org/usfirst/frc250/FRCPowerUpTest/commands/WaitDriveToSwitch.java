package org.usfirst.frc250.FRCPowerUpTest.commands;

import org.usfirst.frc250.FRCPowerUpTest.MatchData;
import org.usfirst.frc250.FRCPowerUpTest.Robot;
import org.usfirst.frc250.FRCPowerUpTest.MatchData.Side;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class WaitDriveToSwitch extends CommandGroup {

	public WaitDriveToSwitch() {
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.

		System.out.println("In Command");
		addSequential(new WaitCommand(7));
		addSequential(new DriveDistance((Robot.prefs2.getDouble("Auto Distance To Switch")),
				Robot.prefs2.getDouble("Auto Distance To Switch")));
	}
}
