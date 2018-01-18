package org.usfirst.frc.team2554.robot.autonomous;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class CenterAutonomous extends Command {
	RobotDrive myRobot;
	Timer timer = new Timer();
	final double time = 0;
	final double speed = 0;
	
    public CenterAutonomous(RobotDrive robot) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	myRobot = robot;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    	//myRobot.tankDrive(1, 0);
    }
    public void start(){
    	timer.reset();
    	timer.start();
    //	myRobot.tankDrive(1, 0);
    }
  
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//myRobot.tankDrive(1, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//Change delay
        return timer.get() < time;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//myRobot.tankDrive(0, 0);
    	timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    //	myRobot.tankDrive(0, 0);
    	timer.stop();
    }
}
