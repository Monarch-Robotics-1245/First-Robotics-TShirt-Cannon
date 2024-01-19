// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Pnumatics;

public class Cannon extends Command {
  /** Creates a new TankDrive. */
  private final Pnumatics pnumatics;

  public Cannon(Pnumatics pnumatics) {
    this.pnumatics = pnumatics;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(pnumatics);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.m_robotContainer.getDriverButton(Constants.RELOAD_BUTTON) = true) {
       Robot.setNextSolenoid(1);
    }
  	if (Robot.m_robotConatiner.getDriverButton(Constants.FIRE_BUTTON) = true) {
		pnumatics.openSolenoid(Robot.getNextSolenoid());	
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    pnumatics.openSolenoid(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
