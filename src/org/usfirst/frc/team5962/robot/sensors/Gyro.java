package org.usfirst.frc.team5962.robot.sensors;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Gyro {
	public ADXRS450_Gyro robotGyro;
	final int gyroChannel = 0;
	double angleSetPoint = 0.0;
	final double gyroSpeedConstant = 0.006;
	
	public Gyro(){
		robotGyro = new ADXRS450_Gyro();
	}
	
	public void resetGyro() {
		robotGyro.reset();
	}

	public void calibrateGyro() {
		robotGyro.calibrate();
	}
	
	public double getGyroAngle() {
		SmartDashboard.putString("Gyro Angle", "" + robotGyro.getAngle());
		return robotGyro.getAngle();

	}

	public double getTurningValue() {
		return (angleSetPoint - robotGyro.getAngle()) * gyroSpeedConstant;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
