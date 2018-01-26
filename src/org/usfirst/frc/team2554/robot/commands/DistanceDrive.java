package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DistanceDrive extends Command {

	double angle;
	double Kp = 0.03;
    public DistanceDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    
    	Robot.driveTrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	angle = Robot.driveTrain.getGyroAngle();
    	Robot.driveTrain.myDrive.arcadeDrive(0.5, angle*Kp);
    	
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
