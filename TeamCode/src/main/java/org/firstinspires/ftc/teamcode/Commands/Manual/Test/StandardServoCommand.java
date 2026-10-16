package org.firstinspires.ftc.teamcode.Commands.Manual.Test;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.Subsystems.StandardServoSubsystem;

public class StandardServoCommand {

    StandardServoSubsystem standardServoSubsystem;
    Gamepad gamepad;

    public StandardServoCommand(StandardServoSubsystem standardServoSubsystem, Gamepad gamepad){
        this.standardServoSubsystem = standardServoSubsystem;
        this.gamepad = gamepad;
    }

    public void operate(Gamepad gamepad){
        if (gamepad.dpad_up){
            standardServoSubsystem.ServoPosition(0);
        }


        else if (gamepad.dpad_right){
            standardServoSubsystem.ServoPosition(1);
        }
    }
}