/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ElevatorBottom;
import frc.robot.commands.ElevatorRaise;
import frc.robot.commands.Intake;
import frc.robot.commands.Outake;
//import frc.robot.commands.MecanumDrive;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public Joystick DriverXbox = new Joystick(0);
  public Joystick joyOperator = new Joystick(1);
  public JoystickButton ButtonA = new JoystickButton(joyOperator, 1);
	public JoystickButton ButtonB = new JoystickButton(joyOperator, 2);
	public JoystickButton ButtonX = new JoystickButton(joyOperator, 3);
	public JoystickButton ButtonY = new JoystickButton(joyOperator, 4);
	public JoystickButton ButtonLB = new JoystickButton(joyOperator, 5);
	public JoystickButton ButtonRB = new JoystickButton(joyOperator, 6);
	public JoystickButton ButtonSelect = new JoystickButton(joyOperator, 7);
  public JoystickButton ButtonStart = new JoystickButton(DriverXbox, 8);
  

  public OI()
{

  //Elevator Positions
  //ButtonX.whenPressed(new ElevatorRaise());
  ButtonB.whenPressed(new ElevatorBottom());

  //Intake&Outake
  ButtonLB.whileHeld(new Intake());
  ButtonRB.whileHeld(new Outake());
}

  
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  //public JoystickButton buttonA = new JoystickButton(joyOperator, 1);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.


  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());



  

  

}
