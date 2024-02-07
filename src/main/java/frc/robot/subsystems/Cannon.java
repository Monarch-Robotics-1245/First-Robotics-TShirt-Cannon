// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;


public class Cannon extends SubsystemBase {
  /** Creates a new DriveTrain. */

  private final DoubleSolenoid SEL_1 = new DoubleSolenoid(Constants.PCM, PneumaticsModuleType.CTREPCM, 0, 1);
  private final DoubleSolenoid SEL_2 = new DoubleSolenoid(Constants.PCM, PneumaticsModuleType.CTREPCM, 2, 3);
  private final DoubleSolenoid SEL_3 = new DoubleSolenoid(Constants.PCM, PneumaticsModuleType.CTREPCM, 4, 5);

  public Cannon() {

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void activateMaster(boolean active, int cannon) {
    if (active) {
      if (cannon == Constants.S_ONE_F) {
        SEL_1.set(kForward);
        SEL_2.set(kOff);
        SEL_3.set(kOff);
      }
      if (cannon == Constants.S_ONE_R) {
        SEL_1.set(kReverse);
        SEL_2.set(kOff);
        SEL_3.set(kOff);
      }
      if (cannon == Constants.S_TWO_F) {
        SEL_1.set(kOff);
        SEL_2.set(kForward);
        SEL_3.set(kOff);
      }
      if (cannon == Constants.S_TWO_R) {
        SEL_1.set(kOff);
        SEL_2.set(kReverse);
        SEL_3.set(kOff);
      }
      if (cannon == Constants.S_THREE_F) {
        SEL_1.set(kOff);
        SEL_2.set(kOff);
        SEL_3.set(kForward);
      }
      if (cannon == Constants.S_THREE_R) {
        SEL_1.set(kOff);
        SEL_2.set(kOff);
        SEL_3.set(kReverse);
      }
    } else {
      SEL_1.set(kOff);
      SEL_2.set(kOff);
      SEL_3.set(kOff);
    }
  }
}
