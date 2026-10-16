package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;

public class StorageSubsystem {
    CRServo storageServo;
    public  StorageSubsystem(OpMode opMode){
        storageServo = opMode.hardwareMap.get(CRServo.class, "storage");
    }
    public void setStoragePower(double power){
        storageServo.setPower(power);

    }
    public void shutdown(){
        storageServo.setPower(0);
    }

}
