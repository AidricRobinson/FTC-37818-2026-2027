package org.firstinspires.ftc.teamcode.Commands.Autonomous;

import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;

public class AutoIntakeCommand {
    IntakeSubsystem intakeSubsystem;

    public AutoIntakeCommand(IntakeSubsystem intakeSubsystem){
        this.intakeSubsystem = intakeSubsystem;
    }

    public void operate(){
        intakeSubsystem.setFlywheelPower(1);
    }
    public void shutdown(){
        intakeSubsystem.setFlywheelPower(0);
    }
}
