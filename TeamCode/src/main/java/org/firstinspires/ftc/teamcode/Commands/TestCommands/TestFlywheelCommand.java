package org.firstinspires.ftc.teamcode.Commands.TestCommands;


import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.PollenFlywheelSubsystem;

public class TestFlywheelCommand {
    PollenFlywheelSubsystem pollenFlywheelSubsystem2;
    Gamepad gamepad;
    boolean toggle;

    public TestFlywheelCommand(PollenFlywheelSubsystem pollenFlywheelSubsystem2, Gamepad gamepad){
        this.pollenFlywheelSubsystem2 = pollenFlywheelSubsystem2;
        this.gamepad = gamepad;
        toggle = true;
    }
    public void operate(Gamepad gamepad, Telemetry telemetry){
        if(gamepad.y && toggle) {
            pollenFlywheelSubsystem2.increaseTestOutput();
            toggle = false;
        }
        else if (gamepad.a && toggle) {
            pollenFlywheelSubsystem2.decreaseTestOutput();
            toggle = false;
        }
        else if (gamepad.b && toggle) {
            pollenFlywheelSubsystem2.zeroTestOutput();
            toggle = false;
        }
        else if (!gamepad.y && !gamepad.a && !gamepad.b){
            toggle = true;
        }



        if(gamepad.x){
            pollenFlywheelSubsystem2.setFlywheelPower(pollenFlywheelSubsystem2.getTestOutput());
        }
        else{
            pollenFlywheelSubsystem2.setFlywheelPower(0);
        }
        telemetry.addData("testOutput", pollenFlywheelSubsystem2.getTestOutput());
        telemetry.update();
    }

    // // test comment
    public void Shutdown(){
        pollenFlywheelSubsystem2.shutdown();
    }
}
