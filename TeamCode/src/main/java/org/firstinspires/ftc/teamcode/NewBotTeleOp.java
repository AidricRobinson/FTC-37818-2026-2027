package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Commands.Manual.Test.BeltServoCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.Test.FlappyServoCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.Test.IntakeCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.Test.PIDFlywheelCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.Test.PIDNectarFlywheelCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.Test.PollenFlywheelCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.Test.ShaftCommand;
import org.firstinspires.ftc.teamcode.Subsystems.BeltServoSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.FlappyServoSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.NectarFlywheelSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.PollenFlywheelSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.ShaftServoSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.WheelSubsystem;

@TeleOp(name = "Bot2")
public class NewBotTeleOp extends OpMode{
    private FlappyServoSubsystem flappyServoSubsystem;
    private ShaftServoSubsystem shaftServoSubsystem;
    private PollenFlywheelSubsystem pollenFlywheelSubsystem;
    private NectarFlywheelSubsystem nectarFlywheelSubsystem;
    private BeltServoSubsystem beltServoSubsystem;
    private   WheelSubsystem wheelSubsystem;
    private IntakeSubsystem intakeSubsystem;
    private FlappyServoCommand flappyServoCommand;
    private ShaftCommand shaftCommand;
    private PIDFlywheelCommand pidFlywheelCommand;
    private PIDNectarFlywheelCommand pidNectarFlywheelCommand;
    private BeltServoCommand beltServoCommand;
    private IntakeCommand intakeCommand;

 public void init(){
    flappyServoSubsystem = new FlappyServoSubsystem(this);
    shaftServoSubsystem = new ShaftServoSubsystem(this);
    nectarFlywheelSubsystem = new NectarFlywheelSubsystem();
    pollenFlywheelSubsystem = new PollenFlywheelSubsystem(this);
    beltServoSubsystem = new BeltServoSubsystem(this);

 }

 @Override
    public void loop(){
     flappyServoCommand.operate(gamepad1);
     shaftCommand.operate(gamepad1);
     pidFlywheelCommand.operate(gamepad1, telemetry);
     pidNectarFlywheelCommand.operate(gamepad1, telemetry);
     beltServoCommand.operate(gamepad1);
     intakeCommand.operate(gamepad1);
     wheelSubsystem.robotOrientedOperate(gamepad1, telemetry);
 }
 public void stop(){
     shaftServoSubsystem.shutdown();
     pollenFlywheelSubsystem.shutdown();
     nectarFlywheelSubsystem.shutdown();
     beltServoSubsystem.shutdown();
     intakeSubsystem.shutdown();
 }
}