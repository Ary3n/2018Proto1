package org.usfirst.frc.team2554.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {

    public AutonomousCommand() {
    	
    		addSequential(new DistanceDriveAlternatePID(120, 0));
    		addSequential(new RotateToAngle(90));
    		
    }
}
