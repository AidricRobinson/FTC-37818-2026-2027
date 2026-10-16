package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.Manual.Test.FlywheelCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.Test.IntakeCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.Test.StorageCommand;
import org.firstinspires.ftc.teamcode.Subsystems.FlywheelSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.StorageSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.WheelSubsystem;


@TeleOp(name="TestTeleOp")

public class TestTeleOp extends OpMode {
    //declaring subsystems and commands here
    private FlywheelSubsystem flywheelSubsystem2;
    private IntakeSubsystem intakeSubsystem;
    private StorageSubsystem storageSubsystem;
    private FlywheelCommand flywheelCommand2;
    private IntakeCommand intakeCommand;
    private StorageCommand storageCommand;
    private WheelSubsystem wheelSubsystem;
//    private StandardServoSubsystem standardServoSubsystem;
//    private StandardServoCommand standardServoCommand;





    public void init () {

        flywheelSubsystem2 = new FlywheelSubsystem(this);
        intakeSubsystem = new IntakeSubsystem(this);
        storageSubsystem = new StorageSubsystem(this);
//        standardServoSubsystem = new StandardServoSubsystem(this);
        flywheelCommand2 = new FlywheelCommand(flywheelSubsystem2, gamepad1);
        intakeCommand = new IntakeCommand(intakeSubsystem, gamepad1);
        storageCommand = new StorageCommand(storageSubsystem, gamepad2);
        wheelSubsystem = new WheelSubsystem(this);
//        standardServoCommand = new StandardServoCommand(standardServoSubsystem, gamepad2);

    }
    // //test comment

    @Override
    public void loop(){
        flywheelCommand2.operate(gamepad1);
        storageCommand.operate(gamepad2);
        wheelSubsystem.operate(gamepad1);
        intakeCommand.operate(gamepad2);
//        standardServoCommand.operate(gamepad2);

    }
    public void stop(){
        flywheelSubsystem2.shutdown();
        wheelSubsystem.shutdown();
        storageCommand.shutdown();
        intakeCommand.shutdown();
   }
}