package org.usfirst.frc.team2554.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static int[] driveTrain = {0,1,2,3};
	public static int[] intake = {5};
	public static int[] climber = {6};
	public static int[] elevator = {900};
    
	//elevator constants
    public static int eCIM1 = 8;
    public static int eCIM2 = 6;
    public static int ratchetSpark = 7;
    public static int ratchetDirection = 1;
    public static int elevatorDirection = 1;
    public static double[] elevatorSpeed = {0,0.25,0.3,0.4};//{0,.25,.5,.75,1};
    public static double elevatorHoldV = .15;
    public static int lsMag1 = 1;
    public static int lsMag2 = 2;
    public static int lsMag3 = 3;
    public static int lsMag4 = 4;
    public static int lsMag5 = 5;

//joystick constants
    public static int stickY = 1;
    public static int stickTwist = 2;
    public static int stickTrigger = 1;

//controller constants
    public static int controllerHome;
    public static int controllerPortal;
    public static int controllerScale;
    public static int controllerClimb;
    public static int controllerClimbSafety;
    public static int controllerClimbAxis;
    public static int controllerRatchet;
}
