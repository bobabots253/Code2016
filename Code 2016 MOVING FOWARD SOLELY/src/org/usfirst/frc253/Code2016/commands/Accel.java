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
public class Accel extends Command {
	Accelerometer accel;
	double accelerationX;
	double accelerationY;
	double accelerationZ;
	Ultrasonic ultra;
    int session;
    Image frame;
    AxisCamera camera;
    public Accel() {
    	frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
    	ultra = new Ultrasonic(0,1);
    	ultra.setAutomaticMode(true);
    	
    	camera = new AxisCamera("10.1.91.100");
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
     		 double range = ultra.getRangeInches();
     		 
     		//String stringTEST = ultra.getSmartDashboardType();
     		System.out.println(range);
         //System.out.println(accelerationX + " " + accelerationY + " " + accelerationZ + ".");
 		//SmartDashboard.putNumber("Accelometer X", accel.getX());
 		//SmartDashboard.putNumber("Accelometer Y", accel.getY());
 		//SmartDashboard.putNumber("Accelometer Z", accel.getZ());
 		SmartDashboard.putNumber("Ultrasonic", range);
 		
 		  
 		// Special Camera Vision
// 		camera.getImage(frame);  
// 		 NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);
// 		NIVision.imaqDrawShapeOnImage(frame, frame, rect,
//                  DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
//
//          CameraServer.getInstance().setImage(frame);
//
//
//          /** robot code here! **/
//          Timer.delay(0.005);	
//
// 		if (Math.abs(range) <= 5)
// 			SmartDashboard.getBoolean("DB/Button 0", true);
// 		else
// 			SmartDashboard.getBoolean("DB/Button 0", false);
//
// 			
// 		//SmartDashboard.putData(ultra.getSmartDashboardType(), ultra);
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
