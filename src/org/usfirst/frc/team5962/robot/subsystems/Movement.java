package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5962.robot.Robot;

public class Movement extends Subsystem {

	// private /*static*/ Robot robot = new Robot();
	private /* static */ int turnValue = 0;
	private /* static */ double speed = -0.25;

	private boolean turned = false;

	private boolean onTask = false;
	private long initialTime = 0;
	private double millisToRun = 0;

	private boolean forward = false;
	private int forwardNum = 1;
	private boolean back = false;
	private int backNum = 1;

	private boolean turnRight = false;
	private boolean turningRight = false;
	private int tRightNum = 1;
	private boolean turnLeft = false;
	private boolean turningLeft = false;
	private int tLeftNum = 1;

	private boolean start = false;
	private int startNum = 1;
	private boolean stop = false;
	private int stopNum = 1;
	private boolean delay = false;
	private int delayNum = 1;
	private boolean run = true;
	static int runNum = 1;

	public boolean isFinished = false;

	/*
	 * public void go(){ if(run == true){ double angle =
	 * Robot.gyro.getGyroAngle(); RobotMap.myRobot.drive(speed, -(angle +
	 * turnValue) * 0.03); } else{ RobotMap.myRobot.drive(0, 0); } }
	 */

	public void go() {
		double angle = Robot.gyro.getGyroAngle();
		if (run == true) {
			if (turningLeft == true && angle <= turnValue) {
				RobotMap.myRobot.drive(speed, -0.5);
			} else if (turningRight == true && angle >= turnValue) {
				RobotMap.myRobot.drive(speed, 0.5);
			} else if (turningRight == false && turningLeft == false && turnValue == 0) {
				RobotMap.myRobot.drive(speed, 0);
			} else/*
					 * if(turnRight == false && turnLeft == false && turnValue ==
					 * 0)
					 */ {
				RobotMap.myRobot.drive(speed, 0);
			}
		} else {
			RobotMap.myRobot.drive(0, 0);
		}
	}

	public void start(int step) {
		if (onTask == false) {
			initialTime = System.currentTimeMillis();
			millisToRun = 100;

			run = true;

			onTask = true;
			start = true;
		} else if (onTask == true && start == true && startNum == step) {
			if ((System.currentTimeMillis() - initialTime) >= millisToRun) {
				startNum = startNum + 1;

				onTask = false;
				start = false;
			}
		}
		go();
	}

	public void stop(int step) {
		if (onTask == false) {
			initialTime = System.currentTimeMillis();
			millisToRun = 100;

			run = false;

			onTask = true;
			stop = true;
		} else if (onTask == true && stop == true && stopNum == step) {
			if ((System.currentTimeMillis() - initialTime) >= millisToRun) {
				stopNum = stopNum + 1;

				onTask = false;
				stop = false;
			}
		}
		go();
	}

	public void delay(int step, double sec) {
		if (onTask == false) {
			initialTime = System.currentTimeMillis();
			millisToRun = (Math.abs(sec) * 1000) + 100;

			onTask = true;
			delay = true;
		} else if (onTask == true && delay == true && delayNum == step) {
			if ((System.currentTimeMillis() - initialTime) >= millisToRun) {
				delayNum = delayNum + 1;

				turningRight = false;
				turningLeft = false;

				onTask = false;
				delay = false;
			}
		}
		go();
	}

	public void forward(int step) {
		if (onTask == false) {
			initialTime = System.currentTimeMillis();
			millisToRun = 100;

			speed = Math.abs(speed) * -1;

			onTask = true;
			forward = true;
		} else if (onTask == true && forward == true && forwardNum == step) {
			if ((System.currentTimeMillis() - initialTime) >= millisToRun) {
				forwardNum = forwardNum + 1;

				onTask = false;
				forward = false;
			}
		}
		go();
	}

	public void back(int step) {
		if (onTask == false) {
			initialTime = System.currentTimeMillis();
			millisToRun = 100;

			speed = Math.abs(speed);

			onTask = true;
			back = true;
		} else if (onTask == true && back == true && backNum == step) {
			if ((System.currentTimeMillis() - initialTime) >= millisToRun) {
				backNum = backNum + 1;

				onTask = false;
				back = false;
			}
		}
		go();
	}

	public void turnLeft(int step) {
		if (onTask == false) {
			initialTime = System.currentTimeMillis();
			millisToRun = 100;

			turnValue = turnValue - 90;

			onTask = true;
			turnRight = true;
			turningRight = true;
		} else if (onTask == true && turnRight == true && tRightNum == step) {
			if ((System.currentTimeMillis() - initialTime) >= millisToRun) {
				tRightNum = tRightNum + 1;

				onTask = false;
				turnRight = false;
			}

		}
		go();
	}

	public void turnRight(int step) {
		if (onTask == false) {
			initialTime = System.currentTimeMillis();
			millisToRun = 100;

			turnValue = turnValue + 90;

			onTask = true;
			turnLeft = true;
			turningLeft = true;
		} else if (onTask == true && turnLeft == true && tLeftNum == step) {
			if ((System.currentTimeMillis() - initialTime) >= millisToRun) {
				tLeftNum = tLeftNum + 1;

				onTask = false;
				turnLeft = false;
			}
		}
		go();
	}

	public void finish() {
		if (onTask == false) {
			// onTask = true;
			// isFinished = true;
			run = false;
		}
		go();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}