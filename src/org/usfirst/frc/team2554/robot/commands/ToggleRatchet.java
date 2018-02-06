package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleRatchet extends Command {

	Elevator elevator;
    public ToggleRatchet() {
    	elevator = Robot.elevator;
    }

    protected void initialize() {
    	elevator.setRatchet(true);

    }

    protected void execute() {

    	
    	elevator.move(Robot.oi.elevatorStick.getRawAxis(1));
    	
    }

    protected boolean isFinished() {
    	return false;
    }

    protected void end() {
    	
    	elevator.setRatchet(false);
    	

    }

    protected void interrupted() {
    }
}
