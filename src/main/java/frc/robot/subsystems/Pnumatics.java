// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pnumatics extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private final Solenoid OneLeft = new Solenoid(PneumaticsModuleType.CTREPCM, 1);
  private final Solenoid OneMiddle = new Solenoid(PneumaticsModuleType.CTREPCM, 2);
  private final Solenoid OneRight = new Solenoid(PneumaticsModuleType.CTREPCM, 3);
  private final Solenoid TwoLeft = new Solenoid(PneumaticsModuleType.CTREPCM, 4);
  private final Solenoid TwoMiddle = new Solenoid(PneumaticsModuleType.CTREPCM, 5);
  private final Solenoid TwoRight = new Solenoid(PneumaticsModuleType.CTREPCM, 6);

  public Pnumatics() {

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void openSolenoid(int Solenoid) {
    if (Solenoid == 1) {
      OneLeft.set(true);
    } else {
      OneLeft.set(false);
    }
    if (Solenoid == 2) {
      OneMiddle.set(true);
    } else {
      OneMiddle.set(false);
    }
    if (Solenoid == 3) {
      OneRight.set(true);
    } else {
      OneRight.set(false);
    }
    if (Solenoid == 4) {
      TwoLeft.set(true);
    } else {
      TwoLeft.set(false);
    }
    if (Solenoid == 5) {
      TwoMiddle.set(true);
    } else {
      TwoMiddle.set(false);
    }
    if (Solenoid == 6) {
      TwoRight.set(true);
    } else {
      TwoRight.set(false);
    }
  }

}
