
package org.usfirst.frc.team5962.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5962.robot.sensors.Gyro;
import org.usfirst.frc.team5962.robot.subsystems.Movement;
import org.usfirst.frc.team5962.robot.commands.AutonomousCommand;

public class Robot extends IterativeRobot {

	public static Gyro gyro = new Gyro();
	public static Movement movement = new Movement();
	public static AutonomousCommand autonomousCommand = new AutonomousCommand();

	public static OI oi;
	public static RobotType rType;

	public static enum RobotType {
		testRobot, scorpio
	}

	SendableChooser robotType;

	public void robotInit() {

		initRobotTypeChooser();

		oi = new OI();
		gyro.resetGyro();
	}

	private void initRobotTypeChooser() {
		robotType = new SendableChooser();
		robotType.addObject("Scorpio", RobotType.scorpio);
		robotType.addObject("Test Robot", RobotType.testRobot);
		SmartDashboard.putData("Which robot are you using?", robotType);
	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		rType = (RobotType) robotType.getSelected();
		SmartDashboard.putString("RobotMap", "Set rType");
		RobotMap.init();

		if (autonomousCommand != null)
			autonomousCommand.start();

	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		RobotMap.init();

		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}
