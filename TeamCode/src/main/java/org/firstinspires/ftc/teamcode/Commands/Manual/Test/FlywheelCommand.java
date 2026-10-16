package org.firstinspires.ftc.teamcode.Commands.Manual.Test;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.FlywheelSubsystem;

public class FlywheelCommand {
    FlywheelSubsystem flywheelSubsystem2;
    Gamepad gamepad;

    public FlywheelCommand(FlywheelSubsystem flywheelSubsystem2, Gamepad gamepad){
        this.flywheelSubsystem2 = flywheelSubsystem2;
        this.gamepad = gamepad;
    }
    public void operate(Gamepad gamepad){
        if (gamepad.x){
            flywheelSubsystem2.setFlywheelPower(1);//tbd
        }
        else if(gamepad.y){
            flywheelSubsystem2.setFlywheelPower(0.5);
        }
        else {
            flywheelSubsystem2.setFlywheelPower(0);
        }
    }

    // // test comment
    public void Shutdown(){
        flywheelSubsystem2.shutdown();
    }
}
