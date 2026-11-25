package org.firstinspires.ftc.teamcode.Commands.Manual.Test;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.FlappyServoSubsystem;

public class FlappyServoCommand {
    FlappyServoSubsystem flappyServoSubsystem;
    Gamepad gamepad;

    public FlappyServoCommand(FlappyServoSubsystem flappyServoSubsystem, Gamepad gamepad) {
        this.flappyServoSubsystem = flappyServoSubsystem;
        this.gamepad = gamepad;
    }

    public void operate(Gamepad gamepad) {
        if (gamepad.dpad_up) {
            flappyServoSubsystem.ServoPosition(0);
        } else if (gamepad.dpad_down) {
            flappyServoSubsystem.ServoPosition(1);
        }

    }
}