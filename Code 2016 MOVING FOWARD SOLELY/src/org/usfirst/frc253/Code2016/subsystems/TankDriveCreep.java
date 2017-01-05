package org.usfirst.frc253.Code2016.subsystems;

import org.usfirst.frc253.Code2016.Robot;
import org.usfirst.frc253.Code2016.RobotMap;
import org.usfirst.frc253.Code2016.commands.*;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;

/**
 * A command for the DrivetrainTank. This command drives the chassis using generic tank drive controls at a fraction of the full speed. There is no feedback currently. 
 */
public class TankDriveCreep extends Command {

	private double power;
	
    public TankDriveCreep(double power) {
    	this.power = power;
    	
        requires(Robot.drivetraintank);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftSpeed = Robot.oi.getLeftJoystick().getY();	//Saved locally for quicker responses (read-write is slow)
    	double rightSpeed = Robot.oi.getRightJoystick().getY();
    	
    	//Joystick anti-drift
    	if(Math.abs(leftSpeed) > .125)
    		Robot.drivetraintank.setLeft(leftSpeed * power);
    	else
    		Robot.drivetraintank.setLeft(0);
    	
    	if(Math.abs(rightSpeed) > .125)
    		Robot.drivetraintank.setRight(rightSpeed * power);
    	else
    		Robot.drivetraintank.setRight(0);
    	if(Math.abs(leftSpeed) > .125)
    		Robot.drivetraintank.setLeft_Back(leftSpeed * power);
    	else
    		Robot.drivetraintank.setLeft_Back(0);
    	
    	if(Math.abs(rightSpeed) > .125)
    		Robot.drivetraintank.setRight_Back(rightSpeed * power);
    	else
    		Robot.drivetraintank.setRight_Back(0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
