package org.usfirst.frc.team5962.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;

public class AutonomousCommand extends Command {
	// Don't Touch These

	// Robot robot = new Robot();

	private boolean isFinished = false;

	public AutonomousCommand() {
		requires(Robot.movement);
	}

	@Override
	protected void initialize() {
		Robot.gyro.resetGyro();
		RobotMap.myRobot.setMaxOutput(1);
	}

	@Override
	protected void execute() {
		// prefix for all Robot.movement.
		// stop(x); makes the robot stop
		// default//start(x); makes the robot start again after being told to
		// stop()
		// delay(x, y); tells the program to wait x seconds before reading the
		// next line
		// default//forward(x); makes the robot go forward
		// back(x); makes the robot go backwards
		// turnRight(x); makes the robot turn 90 degrees to the right
		// turnLeft(x); makes the robot turn 90 degrees to the left
		// finish(); ends the program
		// x = times specific command was called, start with 1 and count up for
		// times called. (ex, forward(1) then forward(2))
		// y = time to delay until it reads the next command

		//
		// Enter Your Code Here
		//

		// DON'T touch this.
		isFinished = Robot.movement.isFinished;
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
		end();
	}

}