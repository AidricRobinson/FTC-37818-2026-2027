package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class StandardServoSubsystem{
    Servo standardServo;

    public StandardServoSubsystem(OpMode opMode){
        standardServo = opMode.hardwareMap.get(Servo.class, "standardServo");
    }

    public void ServoPosition(double position){
        standardServo.setPosition(position);
    }

}

