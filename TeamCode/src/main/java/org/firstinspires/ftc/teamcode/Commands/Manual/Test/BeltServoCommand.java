package org.firstinspires.ftc.teamcode.Commands.Manual.Test;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.BeltServoSubsystem;

public class BeltServoCommand {
    BeltServoSubsystem beltServoSubsystem;
    Gamepad gamepad;
    public BeltServoCommand(BeltServoSubsystem beltServoSubsystem, Gamepad gamepad){
        this.beltServoSubsystem = beltServoSubsystem;
        this.gamepad = gamepad;
    }
    public void operate(Gamepad gamepad){
        if(gamepad.x){
            beltServoSubsystem.setPower(0.8);
        }
        else{
            beltServoSubsystem.shutdown();
        }
    }
}
