package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class FlappyServoSubsystem {
    Servo FlappyServo;

    public FlappyServoSubsystem(OpMode opMode){
        FlappyServo = opMode.hardwareMap.get(Servo.class, "FlappyServo");

    }

    public void ServoPosition(double position){
        FlappyServo.setPosition(position);
    }
}
