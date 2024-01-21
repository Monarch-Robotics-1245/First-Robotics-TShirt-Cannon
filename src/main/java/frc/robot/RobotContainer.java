// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Cannon;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain driveTrainSubsystem = new DriveTrain();


  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
          new CommandXboxController(OperatorConstants.DRIVER_CONTROLLER_PORT);

  private final CommandGenericHID m_managerController =
          new CommandGenericHID(OperatorConstants.MANAGER_CONTROLLER_PORT);

  public double getDriverRawAxis(int axis) {
    return m_driverController.getRawAxis(axis);
  }
  public boolean getDriverButton(int button) {
    return m_driverController.getHID().getRawButton(button);
  }
  public double getManagerRawAxis(int axis) {
    return m_managerController.getRawAxis(axis);
  }
  public boolean getManagerButton(int button) {
    return m_managerController.getHID().getRawButton(button);
  }

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
//    configureBindings();
    TankDrive tankDriveCommand = new TankDrive(driveTrainSubsystem);
    driveTrainSubsystem.setDefaultCommand(tankDriveCommand);
    Cannon cannonSubsystem = new Cannon();
    frc.robot.commands.Cannon cannonCommand = new frc.robot.commands.Cannon(cannonSubsystem);
    cannonSubsystem.setDefaultCommand(cannonCommand);
  }

//  private void configureBindings() {
//    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
//    new Trigger(m_exampleSubsystem::exampleCondition)
//        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
//    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
//  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.tankDriveCommand(driveTrainSubsystem);
  }
}
