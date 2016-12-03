package org.usfirst.frc.team5962.robot;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

public class RobotMap {
	
	
	public static RobotDrive myRobot;
	
	//declaring PWM Channels
	private final static int PWM_CHANNEL_0 = 0;
	private final static int PWM_CHANNEL_1 = 1;
	private final static int PWM_CHANNEL_6 = 6;
	private final static int PWM_CHANNEL_7 = 7;
	
	//Declaring Victors
	public static Victor leftVictor1;
	public static Victor leftVictor2;
	public static Victor rightVictor1;
	public static Victor rightVictor2;
	
	public static SpeedController leftDrive;
	public static SpeedController rightDrive;
	
	//Connecting Victors to PWM Channels
	public static void init(){
		leftVictor1 = new Victor(PWM_CHANNEL_0);
		leftVictor2 = new Victor(PWM_CHANNEL_1);
		rightVictor1 = new Victor(PWM_CHANNEL_6);
		rightVictor2 = new Victor(PWM_CHANNEL_7);
		
		leftDrive = new MultiSpeedController(leftVictor1, leftVictor2);
		rightDrive = new MultiSpeedController(rightVictor1, rightVictor2);
		
		//Declaring RobotDrive
		myRobot = new RobotDrive(leftDrive, rightDrive);
	}
	
	

}