// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class Cannon extends Command {
  /** Creates a new TankDrive. */
  private final frc.robot.subsystems.Cannon cannon;

  ShuffleboardTab tab = Shuffleboard.getTab("Cannons");
  GenericEntry CANNON_ONE_SET = tab.add("Cannon 1", false).getEntry();
  GenericEntry CANNON_TWO_SET = tab.add("Cannon 2", false).getEntry();
  GenericEntry CANNON_THREE_SET = tab.add("Cannon 3", false).getEntry();
  GenericEntry CANNON_FOUR_SET = tab.add("Cannon 4", false).getEntry();
  GenericEntry CANNON_FIVE_SET = tab.add("Cannon 5", false).getEntry();
  GenericEntry CANNON_SIX_SET = tab.add("Cannon 6", false).getEntry();

  public Cannon(frc.robot.subsystems.Cannon cannon) {
    this.cannon = cannon;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(cannon);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean CANNON_ONE_COMMAND = CANNON_ONE_SET.getBoolean(false);
    boolean CANNON_TWO_COMMAND = CANNON_TWO_SET.getBoolean(false);
    boolean CANNON_THREE_COMMAND = CANNON_THREE_SET.getBoolean(false);
    boolean CANNON_FOUR_COMMAND = CANNON_FOUR_SET.getBoolean(false);
    boolean CANNON_FIVE_COMMAND = CANNON_FIVE_SET.getBoolean(false);
    boolean CANNON_SIX_COMMAND = CANNON_SIX_SET.getBoolean(false);
    boolean masterFire = (Robot.robotContainer.getManagerButton(Constants.READY_FIRE) && Robot.robotContainer.getDriverButton(Constants.FIRE_ONE) && Robot.robotContainer.getDriverButton(Constants.FIRE_TWO));

    if (masterFire == true) {
      cannon.activateCannon(CANNON_ONE_COMMAND, Constants.CANNON_ID_ONE);
      cannon.activateCannon(CANNON_TWO_COMMAND, Constants.CANNON_ID_TWO);
      cannon.activateCannon(CANNON_THREE_COMMAND, Constants.CANNON_ID_THREE);
      cannon.activateCannon(CANNON_FOUR_COMMAND, Constants.CANNON_ID_FOUR);
      cannon.activateCannon(CANNON_FIVE_COMMAND, Constants.CANNON_ID_FIVE);
      cannon.activateCannon(CANNON_SIX_COMMAND, Constants.CANNON_ID_SIX);
    } else {
      cannon.disarmCannons();
    }

    tab.add("Master Fire", masterFire);
    tab.add("Ready Fire", Robot.robotContainer.getManagerButton(Constants.READY_FIRE));

    //SmartDashboard.putBoolean("Master Open", masterFire);
    //SmartDashboard.putBoolean("Ready Fire", Robot.robotContainer.getManagerButton(Constants.READY_FIRE));
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
