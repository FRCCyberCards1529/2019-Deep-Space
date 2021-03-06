/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import javax.swing.text.DefaultStyledDocument.ElementBuffer;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.Robot;

public class ElevatorRaise extends Command {
  private boolean isFinished = false;
  public ElevatorRaise() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.mElevatorSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.mElevatorSubsystem.ElevatorMotor.stopMotor();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    while (!Robot.mElevatorSubsystem.topLimit.get())
    {
      Robot.mElevatorSubsystem.gotoTopPos();
    }
    return;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;//isFinished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
//   Robot.mElevatorSubsystem.stopElevator();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
