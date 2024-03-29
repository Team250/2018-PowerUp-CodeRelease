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

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc250.FRCPowerUpTest.Robot;

/**
 *
 */
public class TimedDrive extends TimedCommand {
	private double m_speed;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR


    public TimedDrive() {
    	this(0,0);
    }

    public TimedDrive(double speed, double timeout) {
        super(timeout);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        if (speed >= -1 && speed <= 1 && timeout >= 0){
        	m_speed = speed;
        }else{
        	m_speed = 0;
        	System.out.println("Invalid Timeout or speed in time drive");
        }
        
        
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	Robot.driveTrain.drive(m_speed, m_speed);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }


    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.driveTrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	Robot.driveTrain.drive(0, 0);
    }
}
