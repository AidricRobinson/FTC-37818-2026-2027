package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Constants;

public class PollenFlywheelSubsystem {
    DcMotorEx FlywheelMotor;
    double testOutput;

    public PollenFlywheelSubsystem(OpMode opMode) {
        FlywheelMotor  = opMode.hardwareMap.get(DcMotorEx.class, "Flywheel");
        FlywheelMotor.setDirection(DcMotorEx.Direction.REVERSE);
        testOutput = 0;
        FlywheelMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        FlywheelMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);
    }
    public void setFlywheelPower(double power){
        FlywheelMotor.setPower(power);
    }
    public double getRPM(){
        return FlywheelMotor.getVelocity() / Constants.MotorConstants.FLYWHEEL_TICKS_PER_ROTATION * 60;
    }
//    public double getFlywheelEncoder(){
//        return FlywheelMotor.getCurrentPosition();

//    }
//    public void setFlywheelVelocity(double rpm){
//        FlywheelMotor.setVelocity(rpm);
//    }
//    public double getFlywheelVelocity(){
//        return FlywheelMotor.getVelocity();
//    }



    public void increaseTestOutput(){
        testOutput += 0.05;
    }
    public void decreaseTestOutput(){
        testOutput -= 0.05;
    }
    public void zeroTestOutput(){
        testOutput = 0;
    }
    public double getTestOutput(){
        return testOutput;
    }



// //mayb
    public void shutdown(){
        FlywheelMotor.setPower(0);
    }
}
