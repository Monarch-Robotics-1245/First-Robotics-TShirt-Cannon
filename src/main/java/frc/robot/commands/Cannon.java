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

import java.util.Objects;

public class Cannon extends Command {
  /** Creates a new TankDrive. */
  private final frc.robot.subsystems.Cannon cannon;

  ShuffleboardTab robotTab = Shuffleboard.getTab("Robot");
  ShuffleboardTab setupTab = Shuffleboard.getTab("Setup");

  private GenericEntry firePin = setupTab.add("Fire Pin", 0).withSize(2,1).withPosition(5,2).withWidget(BuiltInWidgets.kTextView).getEntry();
  private GenericEntry enableCannons = setupTab.add("Enable Cannons", false).withSize(2,1).withPosition(5,3).withWidget(BuiltInWidgets.kToggleButton).getEntry();

  private boolean CANNON_ONE_COMMAND = false;
  private boolean CANNON_TWO_COMMAND = false;
  private boolean CANNON_THREE_COMMAND = false;
  private boolean CANNON_FOUR_COMMAND = false;
  private boolean CANNON_FIVE_COMMAND = false;
  private boolean CANNON_SIX_COMMAND = false;


  public Cannon(frc.robot.subsystems.Cannon cannon, boolean cannonOne, boolean cannonTwo, boolean cannonThree, boolean cannonFour, boolean cannonFive, boolean cannonSix) {
    this.cannon = cannon;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(cannon);
     CANNON_ONE_COMMAND = cannonOne;
     CANNON_TWO_COMMAND = cannonTwo;
     CANNON_THREE_COMMAND = cannonThree;
     CANNON_FOUR_COMMAND = cannonFour;
     CANNON_FIVE_COMMAND = cannonFive;
     CANNON_SIX_COMMAND = cannonSix;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean masterFire = Robot.robotContainer.getManagerButton(Constants.READY_FIRE);
    boolean readyFire = false;

    String RobotPin = firePin.getString("0000");
    boolean cannonsEnabled = enableCannons.getBoolean(false);

    if (Objects.equals(RobotPin, Constants.PIN) && cannonsEnabled) {
      readyFire = true;
    }

    robotTab.add("Cannon 1", CANNON_ONE_COMMAND).withSize(1,1).withPosition(0,0).withWidget(BuiltInWidgets.kBooleanBox);
    robotTab.add("Cannon 2", CANNON_TWO_COMMAND).withSize(1,1).withPosition(1,0).withWidget(BuiltInWidgets.kBooleanBox);
    robotTab.add("Cannon 3", CANNON_THREE_COMMAND).withSize(1,1).withPosition(2,0).withWidget(BuiltInWidgets.kBooleanBox);
    robotTab.add("Cannon 4", CANNON_FOUR_COMMAND).withSize(1,1).withPosition(3,0).withWidget(BuiltInWidgets.kBooleanBox);
    robotTab.add("Cannon 5", CANNON_FIVE_COMMAND).withSize(1,1).withPosition(4,0).withWidget(BuiltInWidgets.kBooleanBox);
    robotTab.add("Cannon 6", CANNON_SIX_COMMAND).withSize(1,1).withPosition(5,0).withWidget(BuiltInWidgets.kBooleanBox);

    if (masterFire && readyFire) {
      cannon.activateCannon(CANNON_ONE_COMMAND, Constants.CANNON_ID_ONE);
      cannon.activateCannon(CANNON_TWO_COMMAND, Constants.CANNON_ID_TWO);
      cannon.activateCannon(CANNON_THREE_COMMAND, Constants.CANNON_ID_THREE);
      cannon.activateCannon(CANNON_FOUR_COMMAND, Constants.CANNON_ID_FOUR);
      cannon.activateCannon(CANNON_FIVE_COMMAND, Constants.CANNON_ID_FIVE);
      cannon.activateCannon(CANNON_SIX_COMMAND, Constants.CANNON_ID_SIX);
    } else {
      cannon.disarmCannons();
    }

    robotTab.add("Master Fire", masterFire).withSize(3,1).withPosition(6,1).withWidget(BuiltInWidgets.kBooleanBox);
    robotTab.add("Ready Fire", readyFire).withSize(1,1).withPosition(5,1).withWidget(BuiltInWidgets.kBooleanBox);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
