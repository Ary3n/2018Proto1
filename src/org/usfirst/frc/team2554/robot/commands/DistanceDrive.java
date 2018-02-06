package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DistanceDrive extends Command {

    double distancePerPulse = (6.0 * Math.PI) / 128; // rotationlength/numberofpulsesperrotation
    double angle;
    double Kp = 0.03;
    double distance = 0;
    DriveTrain driveTrain;
    

    public DistanceDrive(double dist) {
    	driveTrain = Robot.driveTrain;
        requires(driveTrain);
        
        distance = dist;
        driveTrain.encoderRight.setDistancePerPulse(distancePerPulse);
        driveTrain.encoderLeft.setDistancePerPulse(distancePerPulse);
        
        driveTrain.encoderRight.setMaxPeriod(.1);
        driveTrain.encoderLeft.setMaxPeriod(.1);
        
        
    }

    protected void initialize() {
        driveTrain.resetGyro();
        driveTrain.encoderLeft.reset();
        driveTrain.encoderRight.reset();
    }

    protected void execute() {
        angle = driveTrain.getGyroAngle();
        driveTrain.myDrive.arcadeDrive(0.5, angle * Kp);
    }

    protected boolean isFinished() {
        if (((driveTrain.encoderLeft.getDistance() + driveTrain.encoderRight.getDistance()) / 2) >= distance) {
            return true;
        }
        return false;
    }

    protected void end() {
    	driveTrain.myDrive.arcadeDrive(0,0);
        driveTrain.encoderLeft.reset();
        driveTrain.encoderRight.reset();
    }

    protected void interrupted() {
    	driveTrain.myDrive.arcadeDrive(0,0);
        driveTrain.encoderLeft.reset();
        driveTrain.encoderRight.reset();
    }
    
    protected double distanceStatus()
    {
    		return (driveTrain.encoderLeft.getDistance() + driveTrain.encoderRight.getDistance()) / 2;
    }
    
    protected double angleStatus()
    {
    		return angle;
    }
    
    protected double updateMotorPowerLeft()
    {
    		return driveTrain.left.get();
    }
    
    protected double updateMotorPowerRight()
    {
    		return driveTrain.right.get();
    }
    
    public void log()
	{
		SmartDashboard.putNumber("Encoder Distance", distanceStatus());
		SmartDashboard.putNumber("Angle", angleStatus() );
		SmartDashboard.putNumber("Motor Power Left",updateMotorPowerLeft());
		SmartDashboard.putNumber("Motor Power Right",updateMotorPowerRight());

	}
}