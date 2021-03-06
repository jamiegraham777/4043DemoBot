package org.usfirst.frc.team4043.robot;

import org.usfirst.frc.team4043.robot.Drive;

import com.autodesk.bxd.EmulatorControl;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public Gyro gyro;
	public Joystick jox;
	public Drive drive;
	public Autonomous auto;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	gyro.initGyro();
    	drive = new Drive(jox, gyro);
    	jox = new Joystick(0);
    }

    public void autonomousInit() {
    	auto = new Autonomous(drive);
    	auto.init();
    }
    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	auto.dance();
    }

    private void autonomousDisabled() {

    }
    	
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        drive.run();
    }
    

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
