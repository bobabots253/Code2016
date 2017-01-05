package org.usfirst.frc253.Code2016.commands;

import org.usfirst.frc253.Code2016.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class PortAttackMode extends Command {

    public PortAttackMode() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetraintank);
    	requires(Robot.liftSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	try {
		    Thread.sleep(3);
		    Robot.liftSystem.rightUp();
	    	Robot.liftSystem.leftUp();
		    
		    //put methods to call or whatever u want to pause 3 seconds here
		} catch(InterruptedException ex) {
		    //Thread.currentThread().interrupt();
			Robot.drivetraintank.setLeft_Back(0.5);
	    	Robot.drivetraintank.setLeft(0.5);
	    	Robot.drivetraintank.setRight(0.5);
	    	Robot.drivetraintank.setRight_Back(0.5);
	    	 Robot.liftSystem.rightStop();
		    	Robot.liftSystem.leftStop();
	    	setTimeout(2);
		
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetraintank.setLeft_Back(0);
    	Robot.drivetraintank.setLeft(0);
    	Robot.drivetraintank.setRight(0);
    	Robot.drivetraintank.setRight_Back(0);
    	Robot.liftSystem.rightStop();
    	Robot.liftSystem.leftStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
