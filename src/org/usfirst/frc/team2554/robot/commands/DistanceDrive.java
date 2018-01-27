package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DistanceDrive extends Command {

    double distancePerPulse = (6.0 * Math.PI) / 128; // rotationlength/numberofpulsesperrotation
    double angle;
    double Kp = 0.03;
    double distance = 0;

    Encoder encoderRight = new Encoder(0, 1);
    Encoder encoderLeft = new Encoder(2, 3);

    public DistanceDrive(double dist) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        distance = dist;
        encoderRight.setDistancePerPulse(distancePerPulse);
        encoderLeft.setDistancePerPulse(distancePerPulse);
        
        encoderRight.setMaxPeriod(.1);
        encoderLeft.setMaxPeriod(.1);
        
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.driveTrain.resetGyro();
        encoderLeft.reset();
        encoderRight.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        angle = Robot.driveTrain.getGyroAngle();
        Robot.driveTrain.myDrive.arcadeDrive(0.5, angle * Kp);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (((encoderLeft.getDistance() + encoderRight.getDistance()) / 2) >= distance) {
            return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        encoderLeft.reset();
        encoderRight.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        encoderLeft.reset();
        encoderRight.reset();
    }
}