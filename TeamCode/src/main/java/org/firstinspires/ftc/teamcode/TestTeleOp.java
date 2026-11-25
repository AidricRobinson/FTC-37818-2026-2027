package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.Manual.Test.*;
import org.firstinspires.ftc.teamcode.Subsystems.*;


@TeleOp(name="FieldOriented")

public class TestTeleOp extends OpMode {
    //declaring subsystems and commands here
    private PollenFlywheelSubsystem pollenFlywheelSubsystem2;
    private IntakeSubsystem intakeSubsystem;
    private StorageSubsystem storageSubsystem;
    private IntakeCommand intakeCommand;
    private StorageCommand storageCommand;
    private WheelSubsystem wheelSubsystem;
    private StandardServoSubsystem standardServoSubsystem;
    private StandardServoCommand standardServoCommand;
    private PIDFlywheelCommand pidFlywheelCommand;
//    private FlywheelCommand flywheelCommand;




    public void init () {

        pollenFlywheelSubsystem2 = new PollenFlywheelSubsystem(this);
        intakeSubsystem = new IntakeSubsystem(this);
        storageSubsystem = new StorageSubsystem(this);
        standardServoSubsystem = new StandardServoSubsystem(this);
       pidFlywheelCommand = new PIDFlywheelCommand(pollenFlywheelSubsystem2, gamepad2);
        intakeCommand = new IntakeCommand(intakeSubsystem, gamepad2);
        storageCommand = new StorageCommand(storageSubsystem, gamepad2);
        wheelSubsystem = new WheelSubsystem(this);

        standardServoCommand = new StandardServoCommand(standardServoSubsystem, gamepad2);
//        flywheelCommand = new FlywheelCommand(flywheelSubsystem2, gamepad2);


    }
    // //test comment

    @Override
    public void loop(){
        pidFlywheelCommand.operate(gamepad1, telemetry);
        storageCommand.operate(gamepad1);
        wheelSubsystem.robotOrientedOperate(gamepad1, telemetry);
//        wheelSubsystem.operate(gamepad1, telemetry);
        intakeCommand.operate(gamepad1);
        standardServoCommand.operate(gamepad2);
//        flywheelCommand.operate(gamepad2);


    }
    public void stop(){
        pollenFlywheelSubsystem2.shutdown();
        wheelSubsystem.shutdown();
        storageCommand.shutdown();
        intakeCommand.shutdown();
        pidFlywheelCommand.Shutdown();

    }
}