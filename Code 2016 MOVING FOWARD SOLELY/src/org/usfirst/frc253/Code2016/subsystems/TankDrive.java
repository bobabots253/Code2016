package org.usfirst.frc253.Code2016.subsystems;

import java.lang.Math;

import org.usfirst.frc253.Code2016.Robot;
import org.usfirst.frc253.Code2016.RobotMap;
import org.usfirst.frc253.Code2016.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

/**
 * A command for the DrivetrainTank. This command drives the chassis using generic tank drive controls. There is no feedback currently. 
 */
public class TankDrive extends Command {

    public TankDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(org.usfirst.frc253.Code2016.Robot.drivetraintank);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftSpeed = Robot.oi.getLeftJoystick().getY();	//Saved locally for quicker responses (read-write is slow)
    	double rightSpeed = Robot.oi.getRightJoystick().getY();
    	
    	//Joystick anti-drift
    	if(Math.abs(leftSpeed) > .25)
    		Robot.drivetraintank.setLeft(leftSpeed);
    	else
    		Robot.drivetraintank.setLeft(0);
    	
    	if(Math.abs(rightSpeed) > .125)
    		Robot.drivetraintank.setRight(rightSpeed);
    	else
    		Robot.drivetraintank.setRight(0);
    	if(Math.abs(leftSpeed) > .25)
    		Robot.drivetraintank.setLeft_Back(leftSpeed);
    	else
    		Robot.drivetraintank.setLeft_Back(0);
    	
    	if(Math.abs(rightSpeed) > .125)
    		Robot.drivetraintank.setRight_Back(rightSpeed);
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
    	end();
    }
}
