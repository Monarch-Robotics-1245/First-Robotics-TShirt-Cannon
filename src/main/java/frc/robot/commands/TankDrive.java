// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

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
    String inControl = "None";
    ShuffleboardTab driveTab = Shuffleboard.getTab("Drive");

    boolean managerInControl;
    boolean driverInControl;

    double leftStickY = Robot.robotContainer.getDriverRawAxis(Constants.LEFT_STICK_Y);
    double rightStickY = Robot.robotContainer.getDriverRawAxis(Constants.RIGHT_STICK_Y);

    double forwardVal = Robot.robotContainer.getManagerRawAxis(Constants.MANAGER_FORWARD);
    double sideVal = Robot.robotContainer.getManagerRawAxis(Constants.MANAGER_SIDE);

    double leftCommandManager = forwardVal + sideVal;
    double rightCommandManager = forwardVal - sideVal;

    if (Robot.robotContainer.getManagerButton(2)) {
      driveTrain.setLeftMotors(leftCommandManager);
      driveTrain.setRightMotors(-rightCommandManager);

      managerInControl = true;
      driverInControl = false;
    } else {
      driveTrain.setLeftMotors(leftStickY*Constants.TANK_DRIVE_SENSITIVITY);
      driveTrain.setRightMotors(rightStickY*Constants.TANK_DRIVE_SENSITIVITY);

      managerInControl = false;
      driverInControl = true;
    }

    if (managerInControl) {
      inControl = "Manager";
    } else if (driverInControl) {
      inControl = "Driver";
    }


    driveTab.add("Control", inControl);

    driveTab.add("Steer", sideVal);
    driveTab.add("Drive", forwardVal);
    driveTab.add("Left", leftStickY);
    driveTab.add("Right", rightStickY);

    driveTab.add("OVERRIDE ACTIVE", Robot.robotContainer.getManagerButton(2));

    //SmartDashboard.putBoolean("Manager", managerInControl);
    //SmartDashboard.putBoolean("Driver", driverInControl);
    //SmartDashboard.putNumber("Steer", sideVal);
    //SmartDashboard.putNumber("Drive", forwardVal);
    //SmartDashboard.putNumber("Left", leftStickY);
    //SmartDashboard.putNumber("Right", rightStickY);
    //SmartDashboard.putBoolean("OVERRIDE ACTIVE", Robot.robotContainer.getManagerButton(2));
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
