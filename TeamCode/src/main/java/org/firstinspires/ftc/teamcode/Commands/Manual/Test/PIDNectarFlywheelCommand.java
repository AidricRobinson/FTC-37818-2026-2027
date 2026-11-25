package org.firstinspires.ftc.teamcode.Commands.Manual.Test;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.NectarFlywheelSubsystem;

public class PIDNectarFlywheelCommand {
    NectarFlywheelSubsystem nectarFlywheelSubsystem;
    Gamepad gamepad;
    double output;
    double kp;
    double kff;
    double setpoint;
    double error;
    public PIDNectarFlywheelCommand(NectarFlywheelSubsystem nectarFlywheelSubsystem, Gamepad gamepad){
      this.nectarFlywheelSubsystem = nectarFlywheelSubsystem;
      this.gamepad = gamepad;
        kp = 0.0065;
        kff = 0.0002;
        setpoint = 2525;
        error = 0;
    }
    public void operate(Gamepad gamepad, Telemetry telemetry){
        if (gamepad.a) {
//            if (pidController.calculateError(flywheelSubsystem2.getRPM()) > 0){
            error = setpoint - nectarFlywheelSubsystem.getRPM();
            output = (kp * error) +  (kff * setpoint);
            // Math.min(x, y);
            // Math.max(x, y);
            output = Math.min(output, 1);
//                pidController.calculateError(flywheelSubsystem2.getRPM());
//                output = pidController.calculateOutput();
            nectarFlywheelSubsystem.setFlywheelPower(output);


        }
        else {
            nectarFlywheelSubsystem.setFlywheelPower(0);
        }
        telemetry.addData("FLywheel RPM", nectarFlywheelSubsystem.getRPM());
        telemetry.addData("error", error);
        telemetry.addData("Total KP Calc", (kp * error));
        telemetry.addData("Output", output);

        telemetry.update();
    }
    public void Shutdown(){
        nectarFlywheelSubsystem.shutdown();
    }
}

