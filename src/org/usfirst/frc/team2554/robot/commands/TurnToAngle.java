package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.DriveTrain;
import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnToAngle extends Command {

	double turnAngle;
	boolean end;
    public TurnToAngle(double Angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	turnAngle = Angle;
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	 Robot.driveTrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	end = Robot.driveTrain.turn(turnAngle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return end;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

}
