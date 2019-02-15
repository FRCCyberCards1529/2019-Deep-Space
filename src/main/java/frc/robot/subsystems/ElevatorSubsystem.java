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
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * Add your docs here.
 */
public class ElevatorSubsystem extends Subsystem {
  public DigitalInput bottomLimit = new DigitalInput(RobotMap.Bottom_Limit_Port);
  public DigitalInput topLimit = new DigitalInput(RobotMap.Top_Limit_Port);
  public PWMVictorSPX ElevatorMotor = new PWMVictorSPX(4);
  public Solenoid IntakeSolenoid = new Solenoid(0);
  public Solenoid OutakeSolenoid = new Solenoid(1);
  public Solenoid PivotSolenoid = new Solenoid(2);

    // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    IntakeSolenoid.set(false);
    OutakeSolenoid.set(false);
  }

  public void gotoTopPos(){
    while (topLimit.get()){
      ElevatorMotor.set(0.25);
    }
    return;
  }

  public void gotoBottomPos(){
    while (bottomLimit.get()){
      ElevatorMotor.set(-0.25);
    }
    return;
  }


  //Intake Outake
  public void Intake(){
    IntakeSolenoid.set(true);
    OutakeSolenoid.set(false);
  }

  public void Outake(){
    IntakeSolenoid.set(false);
    OutakeSolenoid.set(true);
  }

  public void stopElevator(){
    ElevatorMotor.set(0.0);
  }

  public void pivotElevator(){
    PivotSolenoid.set(true);
    
  }

}
