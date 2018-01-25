package org.usfirst.frc.team2554.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */
public class EncoderSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	int pin1 = 0;
	int pin2 = 1;
	
	private Encoder encoder = new Encoder(pin1, pin2);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void changePins(int pin1c, int pin2c) {
    		pin1 = pin1c;
    		pin2 = pin2c;
    		encoder = new Encoder(pin1, pin2);
    		
    		//set some constants
    		encoder.setMaxPeriod(0.1);
    		encoder.setMinRate(10);
    		encoder.setDistancePerPulse(60);
    		
    		encoder.reset();
    }
    public void reset(){
    		encoder.reset();
    }
    public double getDistance(){
    		return encoder.getDistance();
    }
}

