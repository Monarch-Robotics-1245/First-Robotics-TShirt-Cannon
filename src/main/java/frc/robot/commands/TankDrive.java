// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class TankDrive extends Command {
  ShuffleboardTab robotTab = Shuffleboard.getTab("Robot");
  ShuffleboardTab setupTab = Shuffleboard.getTab("Setup");
  private GenericEntry AllisonMode = setupTab.add("Allison Mode", false).withSize(1,1).withPosition(6,5).getEntry();
  private GenericEntry GuestMode = setupTab.add("Allison Mode", false).withSize(1,1).withPosition(6,4).getEntry();
  private GenericEntry DefaultMode = setupTab.add("Allison Mode", false).withSize(1,1).withPosition(5,4).getEntry();
  private GenericEntry SportMode = setupTab.add("Allison Mode", false).withSize(1,1).withPosition(5,5).getEntry();

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


    boolean modeAllison = AllisonMode.getBoolean(false);
    boolean modeGuest = GuestMode.getBoolean(false);
    boolean modeDefault = DefaultMode.getBoolean(false);
    boolean modeSport = SportMode.getBoolean(false);

    double speedMultiplier = 0;

    if (modeAllison) {
      speedMultiplier = Constants.MODE_ALLISON_SPEED;
    } else if (modeGuest) {
      speedMultiplier = Constants.MODE_GUEST_SPEED;
    } else if (modeDefault) {
      speedMultiplier = Constants.MODE_NORMAL_SPEED;
    } else if (modeSport) {
      speedMultiplier = Constants.MODE_SPORT_SPEED;
    }

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
    robotTab.add("Driver In Control", DriverInControl).withSize(2,1).withPosition(3,1).withWidget(BuiltInWidgets.kBooleanBox);
    robotTab.add("CONTROL OVERRIDE", OVERRIDE_ACTIVE).withSize(3,1).withPosition(6,0).withWidget(BuiltInWidgets.kBooleanBox);
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
