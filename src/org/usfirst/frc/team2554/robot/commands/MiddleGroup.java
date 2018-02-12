package org.usfirst.frc.team2554.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2554.robot.commands.*;

/**
 *
 */
public class MiddleGroup extends CommandGroup {

    public MiddleGroup(int daWae /*1 is right side, -1 is left */) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    		addSequential(new DistanceDrive(101.5));
    		addSequential(new RotateToAngle(90*daWae));
    		addSequential(new DistanceDrive(132));
    		addSequential(new RotateToAngle(-90*daWae));
    		addSequential(new DistanceDrive(48));
    		addSequential(new RotateToAngle(-90*daWae));
    		//TODO: Move forward, drop za arm, and then shooooot!
    }
}
