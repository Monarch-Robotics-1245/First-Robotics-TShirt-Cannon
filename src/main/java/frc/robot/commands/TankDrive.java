// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
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
    double speedMultiplier = Constants.MODE_NORMAL_SPEED;

    boolean OVERRIDE_ACTIVE;
    boolean DriverInControl;

    double leftStickY = Robot.robotContainer.getDriverRawAxis(Constants.LEFT_STICK_Y);
    double rightStickY = Robot.robotContainer.getDriverRawAxis(Constants.RIGHT_STICK_Y);

    double forwardVal = Robot.robotContainer.getManagerRawAxis(Constants.MANAGER_FORWARD);
    double sideVal = Robot.robotContainer.getManagerRawAxis(Constants.MANAGER_SIDE);

    double leftCommandManager = forwardVal + sideVal;
    double rightCommandManager = forwardVal - sideVal;

    if (Robot.robotContainer.getManagerButton(2)) {
      driveTrain.setLeftMotors(leftCommandManager);
      driveTrain.setRightMotors(-rightCommandManager);
      OVERRIDE_ACTIVE = true;
      DriverInControl = false;
    } else {
      driveTrain.setLeftMotors(leftStickY*speedMultiplier*Constants.SPEED_REVERSE);
      driveTrain.setRightMotors(rightStickY*speedMultiplier*Constants.SPEED_REVERSE);
      DriverInControl = true;
      OVERRIDE_ACTIVE = false;
    }
    SmartDashboard.putBoolean("Driver In Control", DriverInControl);
    SmartDashboard.putBoolean("CONTROL OVERRIDE", OVERRIDE_ACTIVE);
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
