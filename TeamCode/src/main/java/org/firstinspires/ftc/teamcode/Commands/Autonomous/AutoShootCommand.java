package org.firstinspires.ftc.teamcode.Commands.Autonomous;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Subsystems.FlywheelSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.StorageSubsystem;

public class AutoShootCommand {
    FlywheelSubsystem flywheelSubsystem;
    StorageSubsystem storageSubsystem;
    ElapsedTime elapsedTime;

    public AutoShootCommand (FlywheelSubsystem flywheelSubsystem, StorageSubsystem storageSubsystem, ElapsedTime elapsedTime){
        this.elapsedTime = elapsedTime ;
        this.flywheelSubsystem = flywheelSubsystem;
        this.storageSubsystem = storageSubsystem;
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
        storageSubsystem.setStoragePower(0);
        flywheelSubsystem.setFlywheelPower(0);
    }
}
