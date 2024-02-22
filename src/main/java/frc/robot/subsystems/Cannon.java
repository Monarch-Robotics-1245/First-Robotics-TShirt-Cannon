// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Cannon extends SubsystemBase {
  /** Creates a new DriveTrain. */

  private final Solenoid CANNON_ONE = new Solenoid(Constants.CANNON_PCM, PneumaticsModuleType.CTREPCM, Constants.CANNON_CHANNEL_ONE);
  private final Solenoid CANNON_TWO = new Solenoid(Constants.CANNON_PCM, PneumaticsModuleType.CTREPCM, Constants.CANNON_CHANNEL_TWO);
  private final Solenoid CANNON_THREE = new Solenoid(Constants.CANNON_PCM, PneumaticsModuleType.CTREPCM, Constants.CANNON_CHANNEL_THREE);
  private final Solenoid CANNON_FOUR = new Solenoid(Constants.CANNON_PCM, PneumaticsModuleType.CTREPCM, Constants.CANNON_CHANNEL_FOUR);
  private final Solenoid CANNON_FIVE = new Solenoid(Constants.CANNON_PCM, PneumaticsModuleType.CTREPCM, Constants.CANNON_CHANNEL_FIVE);
  private final Solenoid CANNON_SIX = new Solenoid(Constants.CANNON_PCM, PneumaticsModuleType.CTREPCM, Constants.CANNON_CHANNEL_SIX);

  public Cannon() {

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void activateCannon(boolean Set, int Cannon) {
    if (Cannon == 1) {
      CANNON_ONE.set(Set);
    } else if (Cannon == 2) {
      CANNON_TWO.set(Set);
    } else if (Cannon == 3) {
      CANNON_THREE.set(Set);
    } else if (Cannon == 4) {
      CANNON_FOUR.set(Set);
    } else if (Cannon == 5) {
      CANNON_FIVE.set(Set);
    } else if (Cannon == 6) {
      CANNON_SIX.set(Set);
    }
  }
  public void disarmCannons () {
    CANNON_ONE.set(false);
    CANNON_TWO.set(false);
    CANNON_THREE.set(false);
    CANNON_FOUR.set(false);
    CANNON_FIVE.set(false);
    CANNON_SIX.set(false);
  }
}
