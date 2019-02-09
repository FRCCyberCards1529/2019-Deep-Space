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
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ElevatorSubsystem extends Subsystem {
  public DigitalInput bottomLimit = new DigitalInput(RobotMap.Bottom_Limit_Port);
  public DigitalInput topLimit = new DigitalInput(RobotMap.Top_Limit_Port);
  public PWMTalonSRX ElevatorMotor = new PWMTalonSRX(4);
  public DoubleSolenoid IntakeOutakeSolenoid = new DoubleSolenoid(4, 5);

    // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    IntakeOutakeSolenoid.set(DoubleSolenoid.Value.kOff);
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
    IntakeOutakeSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void Outake(){
    IntakeOutakeSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void stopElevator(){
    ElevatorMotor.set(0.0);
  }

}
