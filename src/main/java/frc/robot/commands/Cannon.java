// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class Cannon extends Command {
  /** Creates a new TankDrive. */
  private final frc.robot.subsystems.Cannon cannon;

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
    int selectedCannon = 0;
    if (Robot.robotContainer.getManagerButton(Constants.LOAD_ONE)) {
      cannon.setCannon(1);
      selectedCannon = 1;
    }
    if (Robot.robotContainer.getManagerButton(Constants.LOAD_TWO)) {
      cannon.setCannon(2);
      selectedCannon = 2;
    }
    if (Robot.robotContainer.getManagerButton(Constants.LOAD_THREE)) {
      cannon.setCannon(3);
      selectedCannon = 3;
    }
    if (Robot.robotContainer.getManagerButton(Constants.LOAD_FOUR)) {
      cannon.setCannon(4);
      selectedCannon = 4;
    }
    if (Robot.robotContainer.getManagerButton(Constants.LOAD_FIVE)) {
      cannon.setCannon(5);
      selectedCannon = 5;
    }
    if (Robot.robotContainer.getManagerButton(Constants.LOAD_SIX)) {
      cannon.setCannon(6);
      selectedCannon = 6;
    }


    boolean masterFire = Robot.robotContainer.getDriverButton(Constants.FIRE_ONE) && Robot.robotContainer.getDriverButton(Constants.FIRE_TWO) && Robot.robotContainer.getManagerButton(Constants.READY_FIRE);
    cannon.activateMaster(masterFire);

    SmartDashboard.putNumber("Selected Cannon", selectedCannon);
    SmartDashboard.putBoolean("Master Open", masterFire);
    SmartDashboard.putBoolean("Ready Fire", Robot.robotContainer.getManagerButton(Constants.READY_FIRE));
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
