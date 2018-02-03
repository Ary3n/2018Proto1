package org.usfirst.frc.team2554.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2554.robot.Robot;

/**
 *
 */
public class IntakeCommand extends Command {

    String direction = "stop";
	public IntakeCommand(String direct) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.intake);
        direction = direct;
    }

    // Called just before this Command runs the first time
    protected void initialize(){
    		switch(direction) {
	    		case "stop":
	    			Robot.intake.Stop();
	    			break;
	    		case "in":
	    			Robot.intake.In();
	    			break;
	    		case "out":
	    			Robot.intake.Out();
	    			break;
    		}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
