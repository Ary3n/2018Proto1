package org.usfirst.frc.team2554.robot.subsystems;
import org.usfirst.frc.team2554.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 *
 */
public class Intake extends Subsystem {

    Victor leftMotor = new Victor(RobotMap.intake[0]);
    Victor rightMotor = new Victor(RobotMap.intake[1]);
    
    SpeedControllerGroup intake = new SpeedControllerGroup(leftMotor, rightMotor);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public Intake() {
    		
    }
   
    public void set(double speed)
    {
    	intake.set(speed);
    }
    public void stop() {
    		intake.set(0.0);
    }
}

