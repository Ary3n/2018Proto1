package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DistanceDriveAlternatePID extends Command {

    double distancePerPulse = (6.0 * Math.PI) / 128; // rotationlength/numberofpulsesperrotation
    double currentAngle;
    double targetAngle; 
    double angleError;
    double correctionPower; 
    double Kp = 0.03;
    double distance = 0;
    DriveTrain driveTrain;
   
    public DistanceDriveAlternatePID(double dist, int ang) {
    	driveTrain = Robot.driveTrain;
        requires(driveTrain);
       
        distance = dist;
        targetAngle = ang;
        driveTrain.encoderRight.setDistancePerPulse(distancePerPulse);
        driveTrain.encoderLeft.setDistancePerPulse(distancePerPulse);
        
        driveTrain.encoderRight.setMaxPeriod(.1);
        driveTrain.encoderLeft.setMaxPeriod(.1);
        
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driveTrain.resetGyro();
        driveTrain.encoderLeft.reset();
        driveTrain.encoderRight.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        currentAngle = driveTrain.getGyroAngle();
        angleError = currentAngle - targetAngle; 
        correctionPower = angleError * Kp;
        
        double steeringSpeedRight = 0.5 + correctionPower;
        	double steeringSpeedLeft =  0.5 - correctionPower;
        	
        driveTrain.myDrive.arcadeDrive(steeringSpeedLeft, steeringSpeedRight);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (((driveTrain.encoderLeft.getDistance() + driveTrain.encoderRight.getDistance()) / 2) >= distance) {
            return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.myDrive.arcadeDrive(0,0);
        driveTrain.encoderLeft.reset();
        driveTrain.encoderRight.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
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
    		return currentAngle;
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