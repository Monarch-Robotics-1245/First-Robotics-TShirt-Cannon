// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class TankDrive extends Command {
  /** Creates a new TankDrive. */
  private final DriveTrain driveTrain;

  public TankDrive(DriveTrain driveTrain) {
    this.driveTrain = driveTrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.m_robotContainer.getManagerButton(2)) {
      double forwardVal = Robot.m_robotContainer.getManagerRawAxis(Constants.MANAGER_FORWARD);
      double sideVal = Robot.m_robotContainer.getManagerRawAxis(Constants.MANAGER_SIDE);

      driveTrain.setLeftMotors(forwardVal + sideVal);
      driveTrain.setRightMotors(forwardVal - sideVal);
    } else {
      double leftStickY = Robot.m_robotContainer.getDriverRawAxis(Constants.LEFT_STICK_Y);
      double rightStickY = Robot.m_robotContainer.getDriverRawAxis(Constants.RIGHT_STICK_Y);

      driveTrain.setLeftMotors(leftStickY*Constants.TANK_DRIVE_SENSITIVITY);
      driveTrain.setRightMotors(rightStickY*Constants.TANK_DRIVE_SENSITIVITY);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.setLeftMotors(0);
    driveTrain.setRightMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
