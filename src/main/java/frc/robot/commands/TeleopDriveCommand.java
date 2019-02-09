package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 *
 */
public class TeleopDriveCommand extends Command {

    public TeleopDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.mDriveTrainSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.mDriveTrainSubsystem.setAllMotorMode(NeutralMode.Coast);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	mDriveTrainSubsystem.drive(m_oi.driverStick.getRawAxis(1), m_oi.driverStick.getRawAxis(5));
    	Robot.mDriveTrainSubsystem.drive(Robot.m_oi.joyOperator.getRawAxis(1), Robot.m_oi.joyOperator.getRawAxis(5));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.mDriveTrainSubsystem.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
