package org.firstinspires.ftc.teamcode.Commands.Autonomous;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Subsystems.PollenFlywheelSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.StorageSubsystem;

public class AutoShootCommand {
    PollenFlywheelSubsystem pollenFlywheelSubsystem;
    StorageSubsystem storageSubsystem;
    ElapsedTime elapsedTime;

    public AutoShootCommand (PollenFlywheelSubsystem pollenFlywheelSubsystem, StorageSubsystem storageSubsystem, ElapsedTime elapsedTime){
        this.elapsedTime = elapsedTime ;
        this.pollenFlywheelSubsystem = pollenFlywheelSubsystem;
        this.storageSubsystem = storageSubsystem;
    }

    public void operate(){
        double startTime = elapsedTime.milliseconds();
        while (elapsedTime.milliseconds() < 5000 + startTime){
            double flywheelOutput = 0.6;  //to be changed
            pollenFlywheelSubsystem.setFlywheelPower(flywheelOutput);
        }
        while (2000 + startTime < elapsedTime.milliseconds() && elapsedTime.milliseconds() < 5000 + startTime){
            double storageOutput = 0.5;  //to be changed
            storageSubsystem.setStoragePower(storageOutput);
        }
        storageSubsystem.setStoragePower(0);
        pollenFlywheelSubsystem.setFlywheelPower(0);
    }
}
