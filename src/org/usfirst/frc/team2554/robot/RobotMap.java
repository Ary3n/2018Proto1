package org.usfirst.frc.team2554.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static int[] driveTrain = {0,1,2,3};
	public static int[] intake = {4, 5};
	public static int[] climber = {6};
	public static int[] elevator = {7,8};
	public static int[] spark = {9};
	public static int[] limitSwitches = {5,6,7,8,9};
	public static int[] encoderLeft = {0,1};
	public static int[] encoderRight = {2,3};
	public static int up = 1;
	public static int down = -1;
	public static double[] speeds= {0.2, 0.4, 0.6, 0.8,1}; 
	public static int rSpeed = 9999;
}
