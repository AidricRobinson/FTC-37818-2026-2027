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
    double kp;
    double kff;
    double setpoint;
    double error;

    public PIDFlywheelCommand(FlywheelSubsystem flywheelSubsystem2, Gamepad gamepad){
        this.flywheelSubsystem2 = flywheelSubsystem2;
        this.gamepad = gamepad;
        pidController = new PIDController(0.007,0.03);
        pidController.setSetPoint(3000);
        kp = 0.008;
        kff = 0.0002;
        setpoint = 3000;
        error = 0;
    }
    public void operate(Gamepad gamepad, Telemetry telemetry){
        if (gamepad.right_trigger_pressed) {
//            if (pidController.calculateError(flywheelSubsystem2.getRPM()) > 0){
            error = setpoint - flywheelSubsystem2.getRPM();
            output = (kp * error) +  (kff * setpoint);
            // Math.min(x, y);
            // Math.max(x, y);
            output = Math.min(output, 1);
//                pidController.calculateError(flywheelSubsystem2.getRPM());
//                output = pidController.calculateOutput();
                flywheelSubsystem2.setFlywheelPower(output);


        }
        else {
            flywheelSubsystem2.setFlywheelPower(0);
        }
        telemetry.addData("FLywheel RPM", flywheelSubsystem2.getRPM());
        telemetry.addData("error", error);
        telemetry.addData("Total KP Calc", (kp * error));
        telemetry.addData("Output", output);

        telemetry.update();
    }
    public void Shutdown(){
        flywheelSubsystem2.shutdown();
    }
}
