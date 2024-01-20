// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.KEYS;
import frc.robot.Robot;

public class Cannon extends Command {
  /** Creates a new TankDrive. */
  private final frc.robot.subsystems.Cannon cannon;
  private boolean masterFire;

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
    if (Robot.m_robotContainer.getManagerButton(Constants.LOAD_ONE)) {
      cannon.setCannon(1);}
    if (Robot.m_robotContainer.getManagerButton(Constants.LOAD_TWO)) {
      cannon.setCannon(2);}
    if (Robot.m_robotContainer.getManagerButton(Constants.LOAD_THREE)) {
      cannon.setCannon(3);}
    if (Robot.m_robotContainer.getManagerButton(Constants.LOAD_FOUR)) {
      cannon.setCannon(4);}
    if (Robot.m_robotContainer.getManagerButton(Constants.LOAD_FIVE)) {
      cannon.setCannon(5);}
    if (Robot.m_robotContainer.getManagerButton(Constants.LOAD_SIX)) {
      cannon.setCannon(6);}


    if (Robot.m_robotContainer.getDriverButton(Constants.FIRE_ONE) && Robot.m_robotContainer.getDriverButton(Constants.FIRE_TWO) && Robot.m_robotContainer.getManagerButton(Constants.READY_FIRE)) {
      masterFire = true;
    } else {
      masterFire = false;
    }
    cannon.activateMaster(KEYS.SAFETY_KEY, masterFire);
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
