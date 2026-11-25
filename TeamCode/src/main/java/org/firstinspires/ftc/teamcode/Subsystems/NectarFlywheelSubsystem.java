package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.opMode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Constants;

public class NectarFlywheelSubsystem {
    DcMotorEx pollenMotor;

    public NectarFlywheelSubsystem() {
        pollenMotor = opMode.hardwareMap.get(DcMotorEx.class, "PollenMotor");
        pollenMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);


    }
    public double getRPM(){
        return pollenMotor.getVelocity() / Constants.MotorConstants.FLYWHEEL_TICKS_PER_ROTATION * 60;
    }
    public void setFlywheelPower(double power){
        pollenMotor.setPower(power);
    }
    public void shutdown(){
        pollenMotor.setPower(0);
    }
    }