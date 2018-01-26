package org.usfirst.frc.team2554.robot.subsystems;

import org.usfirst.frc.team2554.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Victor eM1 = new Victor(RobotMap.elevator[0]);
	Victor eM2 = new Victor(RobotMap.elevator[1]);
	DigitalInput[] limit = new DigitalInput[]{ new DigitalInput(RobotMap.limitSwitches[0]), new DigitalInput(RobotMap.limitSwitches[1]),new DigitalInput(RobotMap.limitSwitches[2]),new DigitalInput(RobotMap.limitSwitches[3]),
	new DigitalInput(RobotMap.limitSwitches[4]),new DigitalInput(RobotMap.limitSwitches[5])};
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

