package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;

public class BeltServoSubsystem {
    CRServo beltServo1;
    CRServo beltServo2;
    public BeltServoSubsystem(OpMode opMode){
        beltServo1 = opMode.hardwareMap.get(CRServo.class, "beltServo1");
        beltServo2 = opMode.hardwareMap.get(CRServo.class, "beltServo2");
    }
    public void setPower(double power){
        beltServo2.setPower(power);
        beltServo1.setPower(power);
    }
    public void shutdown(){
        beltServo1.setPower(0);
        beltServo2.setPower(0);
    }
}
