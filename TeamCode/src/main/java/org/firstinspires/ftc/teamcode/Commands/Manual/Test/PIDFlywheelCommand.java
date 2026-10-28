package org.firstinspires.ftc.teamcode.Commands.Manual.Test;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Commands.TestCommands.TestFlywheelCommand;
import org.firstinspires.ftc.teamcode.PIDController;
import org.firstinspires.ftc.teamcode.Subsystems.FlywheelSubsystem;

public class PIDFlywheelCommand {
    FlywheelSubsystem flywheelSubsystem2;
    Gamepad gamepad;
    PIDController pidController;
    double output;

    public PIDFlywheelCommand(FlywheelSubsystem flywheelSubsystem2, Gamepad gamepad){
        this.flywheelSubsystem2 = flywheelSubsystem2;
        this.gamepad = gamepad;
        pidController = new PIDController(0.009,0);
        pidController.setSetPoint(3000);
    }
    public void operate(Gamepad gamepad, Telemetry telemetry){
        if (gamepad.right_trigger_pressed) {
            if (pidController.calculateError(flywheelSubsystem2.getRPM()) > 0){
                pidController.calculateError(flywheelSubsystem2.getRPM());
                output = pidController.calculateOutput();
                flywheelSubsystem2.setFlywheelPower(output);

            }
            else {
                flywheelSubsystem2.setFlywheelPower(0);
            }
        }
        else {
            flywheelSubsystem2.setFlywheelPower(0);
        }
        telemetry.addData("FLywheel RPM", flywheelSubsystem2.getRPM());
        telemetry.update();
    }
    public void Shutdown(){
        flywheelSubsystem2.shutdown();
    }
}
