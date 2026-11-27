package org.firstinspires.ftc.teamcode.Commands.Autonomous;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Subsystems.FlywheelSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.StorageSubsystem;

public class AutoShootCommand {
    FlywheelSubsystem flywheelSubsystem;
    StorageSubsystem storageSubsystem;
    IntakeSubsystem intakeSubsystem;
    ElapsedTime elapsedTime;

    public AutoShootCommand (FlywheelSubsystem flywheelSubsystem, StorageSubsystem storageSubsystem,IntakeSubsystem intakeSubsystem, ElapsedTime elapsedTime){
        this.elapsedTime = elapsedTime ;
        this.flywheelSubsystem = flywheelSubsystem;
        this.storageSubsystem = storageSubsystem;
        this.intakeSubsystem = intakeSubsystem;
    }

    public void operate(){
        double startTime = elapsedTime.milliseconds();
        while (elapsedTime.milliseconds() < 5000 + startTime){
            double flywheelOutput = 0.6;  //to be changed
            flywheelSubsystem.setFlywheelPower(flywheelOutput);
        }
        while (2000 + startTime < elapsedTime.milliseconds() && elapsedTime.milliseconds() < 5000 + startTime){
            double storageOutput = 0.5;  //to be changed
            storageSubsystem.setStoragePower(storageOutput);
        }
        while (2000 + startTime < elapsedTime.milliseconds() && elapsedTime.milliseconds() < 5000 + startTime){
            double intakeOutput = 0.5;  //to be changed
            intakeSubsystem.setFlywheelPower(intakeOutput);
        }
        storageSubsystem.setStoragePower(0);
        flywheelSubsystem.setFlywheelPower(0);
        intakeSubsystem.shutdown();
    }
}
