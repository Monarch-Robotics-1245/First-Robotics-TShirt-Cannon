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

  private final Solenoid CANNON_ONE = new Solenoid(Constants.PCM, PneumaticsModuleType.CTREPCM, 1);
  private final Solenoid CANNON_TWO = new Solenoid(Constants.PCM, PneumaticsModuleType.CTREPCM, 2);
  private final Solenoid CANNON_THREE = new Solenoid(Constants.PCM, PneumaticsModuleType.CTREPCM, 3);
  private final Solenoid CANNON_FOUR = new Solenoid(Constants.PCM, PneumaticsModuleType.CTREPCM, 4);
  private final Solenoid CANNON_FIVE = new Solenoid(Constants.PCM, PneumaticsModuleType.CTREPCM, 5);
  private final Solenoid CANNON_SIX = new Solenoid(Constants.PCM, PneumaticsModuleType.CTREPCM, 6);

  public Cannon() {

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void activateMaster(boolean active, int cannon) {
    if (active) {
      if (cannon == Constants.CANNON_ID_ONE) {
        CANNON_ONE.set(true);
        CANNON_TWO.set(false);
        CANNON_THREE.set(false);
        CANNON_FOUR.set(false);
        CANNON_FIVE.set(false);
        CANNON_SIX.set(false);
      }
      if (cannon == Constants.CANNON_ID_TWO) {
        CANNON_ONE.set(false);
        CANNON_TWO.set(true);
        CANNON_THREE.set(false);
        CANNON_FOUR.set(false);
        CANNON_FIVE.set(false);
        CANNON_SIX.set(false);
      }
      if (cannon == Constants.CANNON_ID_THREE) {
        CANNON_ONE.set(false);
        CANNON_TWO.set(false);
        CANNON_THREE.set(true);
        CANNON_FOUR.set(false);
        CANNON_FIVE.set(false);
        CANNON_SIX.set(false);
      }
      if (cannon == Constants.CANNON_ID_FOUR) {
        CANNON_ONE.set(false);
        CANNON_TWO.set(false);
        CANNON_THREE.set(false);
        CANNON_FOUR.set(true);
        CANNON_FIVE.set(false);
        CANNON_SIX.set(false);
      }
      if (cannon == Constants.CANNON_ID_FIVE) {
        CANNON_ONE.set(false);
        CANNON_TWO.set(false);
        CANNON_THREE.set(false);
        CANNON_FOUR.set(false);
        CANNON_FIVE.set(true);
        CANNON_SIX.set(false);
      }
      if (cannon == Constants.CANNON_ID_SIX) {
        CANNON_ONE.set(false);
        CANNON_TWO.set(false);
        CANNON_THREE.set(false);
        CANNON_FOUR.set(false);
        CANNON_FIVE.set(false);
        CANNON_SIX.set(true);
      }
    } else {
      CANNON_ONE.set(false);
      CANNON_TWO.set(false);
      CANNON_THREE.set(false);
      CANNON_FOUR.set(false);
      CANNON_FIVE.set(false);
      CANNON_SIX.set(false);
    }
  }
}
