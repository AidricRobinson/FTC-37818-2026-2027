package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Commands.Autonomous.AutoDriveCommand;
import org.firstinspires.ftc.teamcode.Commands.Autonomous.AutoShootCommand;
import org.firstinspires.ftc.teamcode.Subsystems.FlywheelSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.StorageSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.WheelSubsystem;

@Autonomous(name = "Shooting Auto", group = "LinearOpMode")
public class ShootingAuto extends LinearOpMode {
    WheelSubsystem wheelSubsystem;
    FlywheelSubsystem flywheelSubsystem;
    StorageSubsystem storageSubsystem;
    IntakeSubsystem intakeSubsystem;
    ElapsedTime elapsedTime;
    AutoDriveCommand autoDriveCommand;
    AutoShootCommand autoShootCommand;
    public void runOpMode() {
        wheelSubsystem = new WheelSubsystem(this);
        flywheelSubsystem = new FlywheelSubsystem(this);
        storageSubsystem = new StorageSubsystem(this);
        intakeSubsystem = new IntakeSubsystem(this);
        elapsedTime = new ElapsedTime();
        autoDriveCommand = new AutoDriveCommand(wheelSubsystem);
        autoShootCommand = new AutoShootCommand(flywheelSubsystem, storageSubsystem,intakeSubsystem,elapsedTime);


        waitForStart();
//
//        if (opModeIsActive() && !isStopRequested()) {
//            while (opModeIsActive() && !isStopRequested()) {

                autoShootCommand.operate();
                autoDriveCommand.AutoStrafe(-18);
                autoDriveCommand.AutoDrive(48);
                autoDriveCommand.yawStrafe(-90);
                autoDriveCommand.AutoStrafe(-24);
//
//                break;  // Break out of while loop and end the code
//            }
//        }
    }

}
