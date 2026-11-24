package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;

public class ShaftServoSubsystem {
    CRServo sharftServo;
    public ShaftServoSubsystem(OpMode opMode){
        sharftServo = opMode.hardwareMap.get(CRServo.class, "shaftServo");
    }
    public void setPower(double power){
        sharftServo.setPower(power);

    }
    public void shutdown(){
        sharftServo.setPower(0);

    }
}
