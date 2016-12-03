
package org.usfirst.frc.team5962.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team5962.robot.sensors.Gyro;
import org.usfirst.frc.team5962.robot.subsystems.Movement;
import org.usfirst.frc.team5962.robot.commands.AutonomousCommand;

public class Robot extends IterativeRobot {
	
	public static Gyro gyro = new Gyro();
	public static Movement movement = new Movement();
	public static AutonomousCommand autonomousCommand = new AutonomousCommand();
	
	public static OI oi;

    public void robotInit() {
		RobotMap.init();
		oi = new OI();
		gyro.resetGyro();
    }
	
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
       
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
