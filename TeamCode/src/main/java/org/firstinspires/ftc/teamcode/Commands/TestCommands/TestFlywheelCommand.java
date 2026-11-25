package org.firstinspires.ftc.teamcode.Commands.TestCommands;


import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.FlywheelSubsystem;

public class TestFlywheelCommand {
    FlywheelSubsystem flywheelSubsystem2;
    Gamepad gamepad;
    boolean toggle;

    public TestFlywheelCommand(FlywheelSubsystem flywheelSubsystem2, Gamepad gamepad){
        this.flywheelSubsystem2 = flywheelSubsystem2;
        this.gamepad = gamepad;
        toggle = true;
    }
    public void operate(Gamepad gamepad, Telemetry telemetry){
        if(gamepad.y && toggle) {
            flywheelSubsystem2.increaseTestOutput();
            toggle = false;
        }
        else if (gamepad.a && toggle) {
            flywheelSubsystem2.decreaseTestOutput();
            toggle = false;
        }
        else if (gamepad.b && toggle) {
            flywheelSubsystem2.zeroTestOutput();
            toggle = false;
        }
        else if (!gamepad.y && !gamepad.a && !gamepad.b){
            toggle = true;
        }



        if(gamepad.x){
            flywheelSubsystem2.setFlywheelPower(flywheelSubsystem2.getTestOutput());
        }
        else{
            flywheelSubsystem2.setFlywheelPower(0);
        }
        telemetry.addData("testOutput", flywheelSubsystem2.getTestOutput());
        telemetry.update();
    }

    // // test comment
    public void Shutdown(){
        flywheelSubsystem2.shutdown();
    }
}
