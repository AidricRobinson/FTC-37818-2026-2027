package org.firstinspires.ftc.teamcode.Commands.Manual.Test;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.PollenFlywheelSubsystem;

public class PollenFlywheelCommand {
    PollenFlywheelSubsystem pollenFlywheelSubsystem2;
    Gamepad gamepad;

    public PollenFlywheelCommand(PollenFlywheelSubsystem pollenFlywheelSubsystem2, Gamepad gamepad){
        this.pollenFlywheelSubsystem2 = pollenFlywheelSubsystem2;
        this.gamepad = gamepad;
    }
    public void operate(Gamepad gamepad){
        if (gamepad.right_trigger_pressed){
            pollenFlywheelSubsystem2.setFlywheelPower(0.53);//tbd
        }
//        else if(gamepad.y){
//            flywheelSubsystem2.setFlywheelPower(0.5);
//        }
        else {
            pollenFlywheelSubsystem2.setFlywheelPower(0);
        }
    }

    // // test comment
    public void Shutdown(){
        pollenFlywheelSubsystem2.shutdown();
    }
}
