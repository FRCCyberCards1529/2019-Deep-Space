/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.OI;
import frc.robot.Robot;


/**
 * Add your docs here.
 */
public class ElevatorSubsystem extends Subsystem {
  public DigitalInput bottomLimit = new DigitalInput(1);
  public DigitalInput topLimit = new DigitalInput(0);
  //public PWMVictorSPX ElevatorMotor = new PWMVictorSPX(4);
  public Spark ElevatorMotor = new Spark(4);
  public PWMVictorSPX intakeMotor = new PWMVictorSPX(5);
  public Solenoid IntakeSolenoid = new Solenoid(1,0);
  public Solenoid OutakeSolenoid = new Solenoid(1,1);
  //public Solenoid PunchSolenoid = new Solenoid(0,2);
  //public Solenoid PullSolenoid = new Solenoid(0,3);
  //public Solenoid PivotSolenoid = new Solenoid(0,4);
  //public Solenoid OutPivotSolenoid = new Solenoid(0,5);
  //public Solenoid ElevatorPivotSolenoid = new Solenoid(0,6);
  //public Solenoid ElevatorOutPivotSolenoid = new Solenoid(0,7);
  public DoubleSolenoid ElevatorPivotSolenoid = new DoubleSolenoid(1, 6, 7);
  public PWMVictorSPX IntakeBall = new PWMVictorSPX(8);
  public PWMVictorSPX OuttakeBall = new PWMVictorSPX(9);

    // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    IntakeSolenoid.set(false);
    OutakeSolenoid.set(false);
  }

  public void gotoTopPos(){
    while (!topLimit.get()){
      ElevatorMotor.set(0.25);
    }
    return ;
  }



  public void gotoBottomPos(){
    while (!bottomLimit.get()){
      ElevatorMotor.set(-0.25);
    }
    return;
  }


  //Intake Outake
  public void Intake(){
  }
}
    
