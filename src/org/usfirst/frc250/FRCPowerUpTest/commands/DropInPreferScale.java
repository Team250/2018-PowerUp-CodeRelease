package org.usfirst.frc250.FRCPowerUpTest.commands;

import org.usfirst.frc250.FRCPowerUpTest.MatchData;
import org.usfirst.frc250.FRCPowerUpTest.Robot;
import org.usfirst.frc250.FRCPowerUpTest.MatchData.GameFeature;
import org.usfirst.frc250.FRCPowerUpTest.MatchData.Side;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class DropInPreferScale extends CommandGroup {

	public DropInPreferScale() {
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
		MatchData.Side ownedScaleSide = MatchData.getOwnedSide(MatchData.GameFeature.SCALE);
		MatchData.Side startingSide = Robot.startingSide;
		
		if (ownedScaleSide != Side.UNKNOWN) {
			if (ownedScaleSide == Side.LEFT && startingSide == Side.LEFT) {
				addParallel(new SetArmTargetToAbsolutePosition("Arm Pos 5 Value"));
				addSequential(new AutoDriveToScale());
				addParallel(new SetWristTargetToAbsolutePosition(Robot.prefs2.getInt("Wrist Down Position")));
				addSequential(new TurnRight90());
				addSequential(new IntakeReleaseSlow());
		        addSequential(new WaitCommand(2));
		        addSequential(new IntakeStop());
			} else if (ownedScaleSide == Side.RIGHT && startingSide == Side.RIGHT) {
				addParallel(new SetArmTargetToAbsolutePosition("Arm Pos 5 Value"));
				addSequential(new AutoDriveToScale());
				addParallel(new SetWristTargetToAbsolutePosition(Robot.prefs2.getInt("Wrist Down Position")));
				addSequential(new TurnLeft90());
				addSequential(new IntakeReleaseSlow());
		        addSequential(new WaitCommand(2));
		        addSequential(new IntakeStop());
			} else {
				addSequential(new AutoDriveToSwitch());
				addSequential(new DriveDistance(24, 24));
			}
		} else {
			System.out.println("No Field Layout Data Recieved");
		}
	}
}
