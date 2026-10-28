package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.Manual.Test.*;
import org.firstinspires.ftc.teamcode.Commands.TestCommands.TestFlywheelCommand;
import org.firstinspires.ftc.teamcode.Subsystems.*;


@TeleOp(name="DriverTeleOp")

public class DriverTeleOp extends OpMode {
    //declaring subsystems and commands here
    private FlywheelSubsystem flywheelSubsystem2;
    private IntakeSubsystem intakeSubsystem;
    private StorageSubsystem storageSubsystem;
    private IntakeCommand intakeCommand;
    private StorageCommand storageCommand;
    private WheelSubsystem wheelSubsystem;
    private StandardServoSubsystem standardServoSubsystem;
    private StandardServoCommand standardServoCommand;
    private PIDFlywheelCommand pidFlywheelCommand;





    public void init () {

        flywheelSubsystem2 = new FlywheelSubsystem(this);
        intakeSubsystem = new IntakeSubsystem(this);
        storageSubsystem = new StorageSubsystem(this);
        standardServoSubsystem = new StandardServoSubsystem(this);
        pidFlywheelCommand = new PIDFlywheelCommand(flywheelSubsystem2, gamepad1);
        intakeCommand = new IntakeCommand(intakeSubsystem, gamepad1);
        storageCommand = new StorageCommand(storageSubsystem, gamepad1);
        wheelSubsystem = new WheelSubsystem(this);
        standardServoCommand = new StandardServoCommand(standardServoSubsystem, gamepad2);

    }
    // //test comment

    @Override
    public void loop(){
        pidFlywheelCommand.operate(gamepad1, telemetry);
        storageCommand.operate(gamepad1);
        wheelSubsystem.operate(gamepad1, telemetry);
        intakeCommand.operate(gamepad1);
        standardServoCommand.operate(gamepad1);

    }
    public void stop(){
        flywheelSubsystem2.shutdown();
        wheelSubsystem.shutdown();
        storageCommand.shutdown();
        intakeCommand.shutdown();

    }
}