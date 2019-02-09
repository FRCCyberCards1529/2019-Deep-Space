/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


 /**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrainSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	
	
	public static int ENCODER_OFFSET = 12;
	public Encoder enc = new Encoder(0,1,false, Encoder.EncodingType.k4X);//ON COMP = 2,3
	public Encoder altEnc = new Encoder(4,5,false, Encoder.EncodingType.k4X);//ON COMP = 2,3
	public Encoder climbEnc = new Encoder(2,3,false, Encoder.EncodingType.k4X); // ON COMP = 0,2
	public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	//public int motorFlip = -1;
	
	public double SpeedModifier = 1;
	
	public Spark FrontLeft = new Spark(0);
	public Spark RearLeft  = new Spark(1);
	public Spark FrontRight = new Spark(2);
	public Spark RearRight = new Spark(3);

	//CANSparkMax Code
	//public static final CANSparkMax.InputMode kPWM;
   //	public CANSparkMax FrontRight = new CANSparkMax(20, MotorType.kBrushless);







	public Spark LED = new Spark(0);
	
	private SpeedControllerGroup left = new SpeedControllerGroup(FrontLeft, RearLeft), right = new SpeedControllerGroup(FrontRight,RearRight);
	
	private DifferentialDrive chassis = new DifferentialDrive(left, right);
	
	/*public DriveTrainSubsystem()
	{
		FrontLeft.setInverted(true);
		RearLeft.setInverted(true);
	}*/
	
	public void tankDrive(double left, double right)
	{
		chassis.tankDrive(left, right);
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		
		enc.setDistancePerPulse((6*3.14159)/360);
		climbEnc.setDistancePerPulse((((1.25*3.14159)/360)/36)*-4);
		//set pulse for climbEnc
		
	}
	
	public void autoDrive(double speed, double distance) {
		if(enc.getDistance() < distance) {
		
			FrontLeft.set(speed);
			RearLeft.set(speed);
			
			FrontRight.set(-speed);
			RearRight.set(-speed);
			
        }
	}
	
	public void stop() {
		FrontLeft.set(0.0);
		RearLeft.set(0);
		
		FrontLeft.set(0);
		RearRight.set(0);
		
	}
	
	public void flipMotors(){
			//motorFlip = -1 * motorFlip;
		
	}
	public void drive(double left, double right){
		FrontLeft.set(left *  -SpeedModifier);
		RearLeft.set(left * -SpeedModifier);
		FrontRight.set(right * SpeedModifier);
		RearRight.set(right * SpeedModifier);
	
		
	}
	
	public void setAllMotorMode(NeutralMode mode){
	//	FrontLeft.setNeutralMode(mode);
	//	RearLeft.setNeutralMode(mode);
	//	FrontRight.setNeutralMode(mode);
	//	RearRight.setNeutralMode(mode);
	}
}