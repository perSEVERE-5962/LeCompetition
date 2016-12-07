package org.usfirst.frc.team5962.robot;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5962.robot.Robot.RobotType;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

public class RobotMap {

	public static RobotDrive myRobot;

	// declaring PWM Channels
	private final static int PWM_CHANNEL_0 = 0;
	private final static int PWM_CHANNEL_1 = 1;
	private final static int PWM_CHANNEL_6 = 6;
	private final static int PWM_CHANNEL_7 = 7;

	// Declaring Victors
	public static Victor leftVictor1;
	public static Victor leftVictor2;
	public static Victor rightVictor1;
	public static Victor rightVictor2;

	public static CANTalon CANTalon1;
	public static CANTalon CANTalon2;
	public static CANTalon CANTalon3;
	public static CANTalon CANTalon4;

	public static SpeedController leftDrive;
	public static SpeedController rightDrive;

	// Connecting Victors to PWM Channels
	public static void init() {
		if (Robot.rType == RobotType.testRobot) {
			SmartDashboard.putString("RobotDrive Type", "TestRobot");
			leftVictor1 = new Victor(PWM_CHANNEL_0);
			leftVictor2 = new Victor(PWM_CHANNEL_1);
			rightVictor1 = new Victor(PWM_CHANNEL_6);
			rightVictor2 = new Victor(PWM_CHANNEL_7);

			leftDrive = new MultiSpeedController(leftVictor1, leftVictor2);
			rightDrive = new MultiSpeedController(rightVictor1, rightVictor2);

		} else if (Robot.rType == RobotType.scorpio) {
			SmartDashboard.putString("RobotDrive Type2", "Scorpio");
			// leftVictor1 = new Victor(PWM_CHANNEL_0);
			// leftVictor2 = new Victor(PWM_CHANNEL_1);
			// rightVictor1 = new Victor(PWM_CHANNEL_6);
			// rightVictor2 = new Victor(PWM_CHANNEL_7);

			// leftDrive = new MultiSpeedController(leftVictor1, leftVictor1);
			// rightDrive = new MultiSpeedController(rightVictor1,
			// rightVictor1);
			CANTalon1 = new CANTalon(10);
			CANTalon2 = new CANTalon(11);
			CANTalon3 = new CANTalon(12);
			CANTalon4 = new CANTalon(13);

			leftDrive = new MultiSpeedController(CANTalon1, CANTalon2);
			rightDrive = new MultiSpeedController(CANTalon3, CANTalon4);
			leftDrive.setInverted(true);
			rightDrive.setInverted(true);

		}

		// Declaring RobotDrive
		myRobot = new RobotDrive(leftDrive, rightDrive);
	}

}