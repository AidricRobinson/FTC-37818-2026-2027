package org.firstinspires.ftc.teamcode.Commands.Manual.Test;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;

public class IntakeCommand {
    IntakeSubsystem intakeSubsystem;
    Gamepad gamepad;

    public IntakeCommand(IntakeSubsystem intakeSubsystem, Gamepad gamepad) {
        this.intakeSubsystem = intakeSubsystem;
        this.gamepad = gamepad;
    }
    public void operate(Gamepad gamepad){
        if (gamepad.dpad_down){
            intakeSubsystem.setFlywheelPower(1);//tbd
        }
        else if(gamepad.dpad_up){
            intakeSubsystem.setFlywheelPower(-0.5);
        }
        else {
            intakeSubsystem.setFlywheelPower(0);
        }
    }
    public void shutdown(){
        intakeSubsystem.shutdown();
    }
}
