package org.firstinspires.ftc.teamcode.Commands.Manual.Test;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.BeltServoSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.ShaftServoSubsystem;

public class ShaftCommand {
   ShaftServoSubsystem shaftServoSubsystem;
    Gamepad gamepad;
    public ShaftCommand(ShaftServoSubsystem shaftServoSubsystem, Gamepad gamepad){
        this.shaftServoSubsystem =  shaftServoSubsystem;
        this.gamepad = gamepad;
    }
    public void operate(Gamepad gamepad){
        if(gamepad.b){
            shaftServoSubsystem.setPower(0.8);
        }
        else{
            shaftServoSubsystem.shutdown();
        }
    }
}
