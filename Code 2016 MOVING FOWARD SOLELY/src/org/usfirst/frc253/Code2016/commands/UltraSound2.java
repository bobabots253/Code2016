package org.usfirst.frc253.Code2016.commands;


import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.AxisCamera;

/**
 *
 */
public class UltraSound2 extends Command {
	
	Ultrasonic ultra1;
    int session;
    Image frame;
    AxisCamera camera;
    public UltraSound2() {
    	
    	ultra1 = new Ultrasonic(3,2);
    	ultra1.setAutomaticMode(true);
    	// turns on automatic mode
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
     		//accelerationX = accel.getX();
     		//accelerationY = accel.getY();
     		//accelerationZ = accel.getZ();
     		 double range1 = ultra1.getRangeInches();
     		//String stringTEST = ultra.getSmartDashboardType();
     		
         //System.out.println(accelerationX + " " + accelerationY + " " + accelerationZ + ".");
 		//SmartDashboard.putNumber("Accelometer X", accel.getX());
 		//SmartDashboard.putNumber("Accelometer Y", accel.getY());
 		//SmartDashboard.putNumber("Accelometer Z", accel.getZ());
 		SmartDashboard.putNumber("Ultrasonic", range1);
 		  
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
