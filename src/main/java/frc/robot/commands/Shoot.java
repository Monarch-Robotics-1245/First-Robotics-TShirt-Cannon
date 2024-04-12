// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;

public class Shoot extends Command {
  /** Creates a new TankDrive. */
  private final frc.robot.subsystems.Cannon cannon;

  public Shoot(frc.robot.subsystems.Cannon cannon) {
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
    boolean masterFire = Robot.robotContainer.getManagerButton(Constants.READY_FIRE);
    boolean overrideFire = Robot.robotContainer.getOverrideButton(Constants.OVERRIDE_FIRE)

    boolean CANNON_ONE_COMMAND = Robot.robotContainer.getManagerButton(Constants.LOAD_ONE);
    boolean CANNON_TWO_COMMAND = Robot.robotContainer.getManagerButton(Constants.LOAD_TWO);
    boolean CANNON_THREE_COMMAND = Robot.robotContainer.getManagerButton(Constants.LOAD_THREE);
    boolean CANNON_FOUR_COMMAND = Robot.robotContainer.getManagerButton(Constants.LOAD_FOUR);
    boolean CANNON_FIVE_COMMAND = Robot.robotContainer.getManagerButton(Constants.LOAD_FIVE);
    boolean CANNON_SIX_COMMAND = Robot.robotContainer.getManagerButton(Constants.LOAD_SIX);

    if (masterFire && overrideFire) {
      cannon.activateCannon(CANNON_ONE_COMMAND, Constants.CANNON_ID_ONE);
      cannon.activateCannon(CANNON_TWO_COMMAND, Constants.CANNON_ID_TWO);
      cannon.activateCannon(CANNON_THREE_COMMAND, Constants.CANNON_ID_THREE);
      cannon.activateCannon(CANNON_FOUR_COMMAND, Constants.CANNON_ID_FOUR);
      cannon.activateCannon(CANNON_FIVE_COMMAND, Constants.CANNON_ID_FIVE);
      cannon.activateCannon(CANNON_SIX_COMMAND, Constants.CANNON_ID_SIX);
    } else {
      cannon.disarmCannons();
    }
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
