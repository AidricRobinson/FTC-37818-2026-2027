package org.firstinspires.ftc.teamcode.Commands.Manual.Test;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.Subsystems.StorageSubsystem;

public class StorageCommand {

    StorageSubsystem storageSubsystem;
    Gamepad gamepad;

    public StorageCommand(StorageSubsystem storageSubsystem, Gamepad gamepad){
        this.storageSubsystem = storageSubsystem;
        this.gamepad = gamepad;
    }
    public void operate(Gamepad gamepad){
//        if (gamepad.y){
//            storageSubsystem.setStoragePower(1);//tbd
//        }
//        else if(gamepad.a){
//            storageSubsystem.setStoragePower(-0.5);
//        }
        if(gamepad.right_bumper){
            storageSubsystem.setStoragePower(1);
        }
        else {
            storageSubsystem.setStoragePower(0);
        }
    }
    public void shutdown(){
        storageSubsystem.shutdown();
    }
}
