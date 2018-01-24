package org.usfirst.frc.team2554.robot;


import org.usfirst.frc.team2554.robot.*;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */

public class DriveTrain extends Subsystem {

	public RobotDrive myDrive = new RobotDrive(RobotMap.driveTrain[0], RobotMap.driveTrain[1], RobotMap.driveTrain[2],RobotMap.driveTrain[3]);
	public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	Timer timer; 
	double currentHeading;
	double headingError;
	double correction;
	double KP=0.01;


	public void initDefaultCommand() {
		myDrive.setSafetyEnabled(false);
		// Set the default command for a subsystem here.

		//setDefaultCommand(new MySpecialCommand());
	}

	public void userDrive(Joystick leftStick, Joystick rightStick)
	{
		myDrive.tankDrive(leftStick, rightStick);
	}

	public void calibrateGyro()
	{
		gyro.calibrate();
	}

	public void resetGyro()
	{
		gyro.reset();
	}

	public double getGyroAngle()
	{
		return gyro.getAngle();
	}
	
	public boolean turn(double targetAngle)
	{
	    	currentHeading  = getGyroAngle();
	    	headingError = targetAngle - currentHeading;
	    	System.out.println(currentHeading);
	    	correction = headingError*KP;
	    	System.out.println("c"+correction);
	    	
	    	
	    	if (currentHeading > targetAngle - 2 &&  currentHeading < targetAngle + 2)
	    	{
	    		myDrive.tankDrive(0, 0);
	    		return true;
	    	}
	    	else
	    	{
	    		myDrive.tankDrive(correction, -correction);
	    		return false;
	    	}
	 }

	 public void goStraight( int time, double speed)
	    {
		 	if(timer.get() < 2)
		 	{
		 		myDrive.tankDrive(speed, speed);
		 	}
		 	else
		 	{
		 		myDrive.tankDrive(0, 0);
		 	}
	    }
}