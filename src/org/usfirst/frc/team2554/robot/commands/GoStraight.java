package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoStraight extends Command {
	
	double numberOfRotations = 0;
	double travelDistance = 1200; //in inches
	double rotationLength= 12; //in inches
	Encoder encoderRight = new Encoder(0, 0); //sdsdsdsdskdskdskdjs
	Encoder encoderLeft = new Encoder(1, 1);

    public GoStraight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	encoderLeft.reset();
    	encoderRight.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(encoderRight.get() < (travelDistance/12) * 128 && encoderLeft.get() < (travelDistance/12) * 128) 
    	{
    		Robot.driveTrain.myDrive.arcadeDrive(1, 1);
    	}
		Robot.driveTrain.myDrive.arcadeDrive(0, 0);

    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	encoderLeft.reset();
    	encoderRight.reset();
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
