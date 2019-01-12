/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.command.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class DriveSubsystem extends Subsystem {
  
  public static OI oi;

  private WPI_TalonSRX frontLM;
  private WPI_TalonSRX frontRM;
  private WPI_TalonSRX backLM;
  private WPI_TalonSRX backRM;

  public void driveInit() {
    oi = new OI();
    System.out.println("OI Initialized");
  }

  public DriveSubsystem()
  {
    frontLM = new WPI_TalonSRX(RobotMap.FRONT_LM.value);
    frontRM = new WPI_TalonSRX(RobotMap.FRONT_RM.value);
    backLM = new WPI_TalonSRX(RobotMap.BACK_LM.value);
    backRM = new WPI_TalonSRX(RobotMap.BACK_RM.value);

  }

  public void setRaw(double leftvalue, double rightvalue)
  {

    leftvalue = oi.JOY_STICK.getRawAxis(RobotMap.LEFT_JOYSTICK.value);
    rightvalue = oi.JOY_STICK.getRawAxis(RobotMap.RIGHT_JOYSTICK.value);

    frontLM.set(-leftvalue * .7);
    frontRM.set(rightvalue * .7);
    backLM.set(-leftvalue * .7);
    backRM.set(rightvalue * .7);
  }

  @Override
  protected void initDefaultCommand() 
  {
    setDefaultCommand(new TankDrive());
  }
}
