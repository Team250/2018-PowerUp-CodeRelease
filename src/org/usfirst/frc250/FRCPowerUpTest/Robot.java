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

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc250.FRCPowerUpTest.MatchData.GameFeature;
import org.usfirst.frc250.FRCPowerUpTest.commands.*;
import org.usfirst.frc250.FRCPowerUpTest.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

	Command autonomousCommand;
	SendableChooser<Command> autonChooser = new SendableChooser<>();
	SendableChooser<MatchData.Side> sideChooser = new SendableChooser<>();

	public static OI oi;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static DriveTrain driveTrain;
	public static Arm arm;
	public static Intake intake;
	public static Climber climber;
	public static Shared shared;
	public static Wrist wrist;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static Prefs2 prefs2;
	public static MatchData.Side startingSide;
	
	private CommandSelector autoChooser;
	
	public void autonChoices(){
		autonChooser.addObject("Wait And Drive To Switch", new WaitDriveToSwitch());
		autonChooser.addObject("Sit And Wait", new AutoSitAndWait());
		autonChooser.addObject("Cross The Line", new AutoCrossTheLine());
		autonChooser.addObject("Wait And Cross The Line", new AutoWaitAcrossTheLine());
		autonChooser.addObject("Auto Drive To Switch", new AutoDriveToSwitch());
		autonChooser.addObject("untested - Center to switch", new AutoDriveToSwitchCenter());
		autonChooser.addObject("untested - Scale Around back", new SLIBridgeOverTheRiverKwai());
		autonChooser.addDefault("Autonomous Command", new AutonomousCommand());
	}

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		prefs2 = Prefs2.getInstance();
		RobotMap.init();
		
		// Increased Camera resolution for demos, this uses more bandwidth than FIRST allocates on a competition field
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(640, 480);
		camera.setFPS(15);
		
		SmartDashboard.putData(Scheduler.getInstance());
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		driveTrain = new DriveTrain();
		arm = new Arm();
		intake = new Intake();
		climber = new Climber();
		shared = new Shared();
		wrist = new Wrist();

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		startingSide = MatchData.Side.UNKNOWN;
		
		prefs2.printPrefs();
		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();

		// Add commands to Autonomous Sendable Chooser
		
		
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

//		autoChooser = new CommandSelector("Auto Mode");
//		
//		autoChooser.addName("Cross The Line", 0);
//		autoChooser.addName("Sit And Wait", 1);
//		autoChooser.addName("Wait And Cross The Line", 2);
//		autoChooser.addName("Auto Drive To Switch", 3);
		
		autonChoices();
		

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
		sideChooser.addObject("Left", MatchData.Side.LEFT);
		sideChooser.addObject("Right", MatchData.Side.RIGHT);
		sideChooser.addObject("Center", MatchData.Side.CENTER);
		sideChooser.addDefault("Unknown", MatchData.Side.UNKNOWN);
		
		SmartDashboard.putData("Auto mode", autonChooser);
		SmartDashboard.putData("Robot Starting Side", sideChooser);
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putString("Starting Side", sideChooser.getSelected().toString());
		SmartDashboard.putString("Auton Command", autonChooser.getSelected().toString());
	}

	@Override
	public void autonomousInit() {
		autonChoices();
		// Read input and set our side to the proper value
		startingSide = MatchData.Side.UNKNOWN;
		startingSide = sideChooser.getSelected();

		// Set autonCommand to the selected Auton
		autonomousCommand = autonChooser.getSelected();

		// schedule the autonomous command (example)
		if (autonomousCommand != null){
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
}
