package org.usfirst.frc.team2554.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2554.robot.commands.MoveElevator;
import org.usfirst.frc.team2554.robot.commands.ToggleRatchet;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	

     //0: HOME
	// 1: SWITCH j 
	// 2: PORTAL 
	// 3: SCALE
	// 4: CLIMB
	public Joystick leftStick = new Joystick(0);
	public Joystick rightStick = new Joystick(1);
	public Joystick elevatorStick = new Joystick(3);
	
	int buttonHome = 5;
	int buttonPortal = 3;
	int buttonSwitch = 4;
	int buttonScale = 6;
	int buttonClimb = 1 ;
	int buttonClimbSafety = 9;
	int intakeTrigger = 1;
	int shootTrigger = 2;
	Button home = new JoystickButton(elevatorStick, buttonHome);
    Button portal = new JoystickButton(elevatorStick, buttonPortal);
    Button switche = new JoystickButton(elevatorStick, buttonSwitch);
    Button scale = new JoystickButton(elevatorStick, buttonScale);
    Button climb = new JoystickButton(elevatorStick, buttonClimb);
    Button climbSafety = new JoystickButton(elevatorStick, buttonClimbSafety);

	
	public OI() {
		home.whenPressed(new MoveElevator(0));
		switche.whenPressed(new MoveElevator(1));
		portal.whenPressed(new MoveElevator(2));
		scale.whenPressed(new MoveElevator(3));
		climb.whenPressed(new MoveElevator(4));
		climbSafety.toggleWhenPressed(new ToggleRatchet());
	}
	
	public double leftStick()
	{
		return leftStick.getY();
	}
	
	public double rightStick()
	{
		return rightStick.getY();
	}
	
	public double intakeTrigger()
	{
		return elevatorStick.getRawAxis(intakeTrigger);
	}
	
	public double shootTrigger()
	{
		return elevatorStick.getRawAxis(shootTrigger);
	}
	
}
