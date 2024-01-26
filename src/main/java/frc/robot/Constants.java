// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int MOTOR_LEFT_1_ID = 2;
    public static final int MOTOR_LEFT_2_ID = 3;
    public static final int MOTOR_RIGHT_1_ID = 0;
    public static final int MOTOR_RIGHT_2_ID = 1;
    public static final int LEFT_STICK_Y = 1;
    public static final int RIGHT_STICK_Y = 5;
    public static final double TANK_DRIVE_SENSITIVITY = .5;
    public static final int READY_FIRE = 1;
    public static final int FIRE_ONE = 5;
    public static final int FIRE_TWO = 6;
    public static final int LOAD_ONE = 7;
    public static final int LOAD_TWO = 9;
    public static final int LOAD_THREE = 11;
    public static final int LOAD_FOUR = 8;
    public static final int LOAD_FIVE = 10;
    public static final int LOAD_SIX = 12;
    public static final int MANAGER_FORWARD = 0;
    public static final int MANAGER_SIDE = 1;
    public static final int PCM_ONE = 9;
    public static final int PCM_TWO = 10;
    public static final double DEADZONE = .05;


    public static class OperatorConstants {
        public static final int DRIVER_CONTROLLER_PORT = 1;
        public static final int MANAGER_CONTROLLER_PORT = 0;
    }
}
