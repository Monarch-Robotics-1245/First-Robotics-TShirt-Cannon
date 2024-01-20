// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;


public class Cannon extends SubsystemBase {
  /** Creates a new DriveTrain. */

  private final DoubleSolenoid SEL_1 = new DoubleSolenoid(Constants.PCM_TWO, PneumaticsModuleType.CTREPCM, 0, 1);
  private final DoubleSolenoid SEL_2 = new DoubleSolenoid(Constants.PCM_TWO, PneumaticsModuleType.CTREPCM, 2, 3);
  private final DoubleSolenoid SEL_3 = new DoubleSolenoid(Constants.PCM_TWO, PneumaticsModuleType.CTREPCM, 4, 5);
  private final DoubleSolenoid SEL_4 = new DoubleSolenoid(Constants.PCM_ONE, PneumaticsModuleType.CTREPCM, 1, 2);
  private final DoubleSolenoid SEL_5 = new DoubleSolenoid(Constants.PCM_ONE, PneumaticsModuleType.CTREPCM, 3, 4);
  private final Solenoid MasterFire = new Solenoid(Constants.PCM_ONE, PneumaticsModuleType.CTREPCM, 0);

  public Cannon() {

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void activateMaster(int safetyKey, boolean set) {
    if (safetyKey == 1245) {
      MasterFire.set(set);
    }
  }

  public void setCannon(int cannon) {
    if (cannon == 1) {
      SEL_1.set(kForward);
      SEL_2.set(kForward);
      SEL_3.set(kOff);
      SEL_4.set(kOff);
      SEL_5.set(kOff);
    }
    if (cannon == 2) {
      SEL_1.set(kForward);
      SEL_2.set(kReverse);
      SEL_3.set(kOff);
      SEL_4.set(kOff);
      SEL_5.set(kOff);
    }
    if (cannon == 3) {
      SEL_1.set(kReverse);
      SEL_2.set(kOff);
      SEL_3.set(kForward);
      SEL_4.set(kForward);
      SEL_5.set(kOff);
    }
    if (cannon == 4) {
      SEL_1.set(kReverse);
      SEL_2.set(kOff);
      SEL_3.set(kForward);
      SEL_4.set(kReverse);
      SEL_5.set(kOff);
    }
    if (cannon == 5) {
      SEL_1.set(kReverse);
      SEL_2.set(kOff);
      SEL_3.set(kReverse);
      SEL_4.set(kOff);
      SEL_5.set(kForward);
    }
    if (cannon == 6) {
      SEL_1.set(kReverse);
      SEL_2.set(kOff);
      SEL_3.set(kReverse);
      SEL_4.set(kOff);
      SEL_5.set(kReverse);
    }

  }
}
