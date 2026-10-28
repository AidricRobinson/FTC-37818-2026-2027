package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.Manual.Test.*;
import org.firstinspires.ftc.teamcode.Subsystems.*;


@TeleOp(name="TestTeleOp")

public class TestTeleOp extends OpMode {
    //declaring subsystems and commands here
//    private StandardServoSubsystem standardServoSubsystem;
//    private StandardServoCommand standardServoCommand;





    public void init () {


//        standardServoSubsystem = new StandardServoSubsystem(this);
//        standardServoCommand = new StandardServoCommand(standardServoSubsystem, gamepad2);

    }
    // //test comment

    @Override
    public void loop(){

//        standardServoCommand.operate(gamepad2);

    }
    public void stop(){
      //Put shutdowns here
   }
}