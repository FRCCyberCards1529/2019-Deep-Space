package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.commands.ElevatorRaise;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static ElevatorSubsystem mElevatorSubsystem = new ElevatorSubsystem();
  public static DriveTrainSubsystem mDriveTrainSubsystem = new DriveTrainSubsystem();
  public MecanumDrive mecanumDrive = new MecanumDrive(Robot.mDriveTrainSubsystem.FrontLeft, Robot.mDriveTrainSubsystem.RearLeft, Robot.mDriveTrainSubsystem.FrontRight, Robot.mDriveTrainSubsystem.RearRight);

  public static OI m_oi = new OI();

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();

    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();


    //Mecanum
    //Robot.mDriveTrainSubsystem.Mecanum.driveCartesian(Robot.mDriveTrainSubsystem.ySpeed, Robot.mDriveTrainSubsystem.xSpeed, Robot.mDriveTrainSubsystem.zRotation);
    Robot.mElevatorSubsystem.pivotElevator();
    mecanumDrive.driveCartesian(-Robot.m_oi.DriverXbox.getRawAxis(0), Robot.m_oi.DriverXbox.getRawAxis(1), Robot.m_oi.DriverXbox.getRawAxis(4));
    Robot.m_oi.ButtonX.whenPressed(new ElevatorRaise());

    if (Robot.m_oi.ButtonX.get() && Robot.mElevatorSubsystem.bottomLimit.get()){
      Robot.mElevatorSubsystem.gotoTopPos();
    }
    else{
      Robot.mElevatorSubsystem.stopElevator();
    }

    
  




    // Robot.mDriveTrainSubsystem.FrontLeft.set(((-m_oi.joyOperator.getRawAxis(1))) - ((-m_oi.joyOperator.getRawAxis(0))) - ((-m_oi.joyOperator.getRawAxis(4))));
		// 	Robot.mDriveTrainSubsystem.RearLeft.set(((-m_oi.joyOperator.getRawAxis(1))) + ((-m_oi.joyOperator.getRawAxis(0))) - ((-m_oi.joyOperator.getRawAxis(4))));
		// 	Robot.mDriveTrainSubsystem.FrontRight.set(((m_oi.joyOperator.getRawAxis(1))) + ((m_oi.joyOperator.getRawAxis(0))) + ((m_oi.joyOperator.getRawAxis(4))));
		// 	Robot.mDriveTrainSubsystem.RearRight.set(((m_oi.joyOperator.getRawAxis(1))) - ((m_oi.joyOperator.getRawAxis(0))) + ((m_oi.joyOperator.getRawAxis(4))));
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {

  }
}
