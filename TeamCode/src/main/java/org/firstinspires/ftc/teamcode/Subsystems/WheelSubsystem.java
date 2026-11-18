package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.hardware.bosch.BHI260IMU;
import com.qualcomm.hardware.bosch.BNO055IMU;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class WheelSubsystem {

    BNO055IMU imu;
    DcMotorEx FLMotor;
    DcMotorEx FRMotor;
    DcMotorEx BLMotor;
    DcMotorEx BRMotor;
    boolean toggle;
    boolean slowMode;





    public WheelSubsystem(OpMode opMode) {

        imu = opMode.hardwareMap.get(BNO055IMU.class, "imu");
        BNO055IMU.Parameters IMUparameters = new BNO055IMU.Parameters();
        imu.initialize(IMUparameters);

        FLMotor = opMode.hardwareMap.get(DcMotorEx.class, "FL");
        FRMotor = opMode.hardwareMap.get(DcMotorEx.class, "FR");
        BLMotor = opMode.hardwareMap.get(DcMotorEx.class, "BL");
        BRMotor = opMode.hardwareMap.get(DcMotorEx.class, "BR");

        FLMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        BLMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        FRMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        BRMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        // Motor spin sides
        FLMotor.setDirection( DcMotorEx.Direction.REVERSE);
        BLMotor.setDirection( DcMotorEx.Direction.FORWARD);
        FRMotor.setDirection( DcMotorEx.Direction.REVERSE);
        BRMotor.setDirection( DcMotorEx.Direction.REVERSE);

        FLMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        FRMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        BLMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        BRMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        toggle = false;
        slowMode = false;
    }
    public void setFLPower(double power){
        FLMotor.setPower(power);
    }
    public void setFRPower(double power){
        FRMotor.setPower(power);
    }
    public void setBLPower(double power){
        BLMotor.setPower(power);
    }
    public void setBRPower(double power){
        BRMotor.setPower(power);
    }

    public void fieldOrientedOperate(Gamepad gamepad, Telemetry telemetry) {


        ///////////////////////////////////////////////////////////////////////
        ///              CURRENTLY IN SHAMBLES, FIX AFTER COMP             ///
        ///////////////////////////////////////////////////////////////////////
        double y = gamepad.left_stick_y;
        double x = gamepad.left_stick_x; //PLS fix
        double rx = -
                gamepad.right_stick_x; //PLEASE FIX LATER

        double botHeading = getYaw();

        //actual field oriented
        double rotX = -(x * Math.cos(botHeading) + y * Math.sin(botHeading));
        double rotY = y * Math.cos(botHeading) - x * Math.sin(botHeading);

        double denominator = Math.max(Math.abs(rotX) + Math.abs(rotY) + Math.abs(rx), 1);




            FLMotor.setPower((rotY + rotX + rx));
            FRMotor.setPower((rotY - rotX - rx));
            BLMotor.setPower((rotY - rotX + rx));
            BRMotor.setPower((rotY + rotX - rx));

        telemetry.addData("yaw", getYaw());
        telemetry.update();
    }
    public void robotOrientedOperate(Gamepad gamepad, Telemetry telemetry) {

        double y = gamepad.left_stick_y;
        double x = gamepad.left_stick_x;
        double rx = gamepad.right_stick_x;

        double botHeading = getYaw();

        //actual field oriented
        double rotX = -(x * Math.cos(botHeading) + y * Math.sin(botHeading));
        double rotY = y * Math.cos(botHeading) - x * Math.sin(botHeading);

//        double denominator = Math.max(Math.abs(rotX) + Math.abs(rotY) + Math.abs(rx), 1);


        FLMotor.setPower((rotY + rotX - rx));
        FRMotor.setPower((rotY - rotX + rx));
        BLMotor.setPower((rotY - rotX - rx));
        BRMotor.setPower((rotY + rotX + rx));


    }
    public void resetEncoder(){
        FLMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        BLMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        FRMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        BRMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }

    // Method to gather encoder counts
    public double[] encoderReading () {
        double[] encoderReading = new double[4];
        encoderReading[0] = FLMotor.getCurrentPosition();
        encoderReading[1] = BLMotor.getCurrentPosition();
        encoderReading[2] = FRMotor.getCurrentPosition();
        encoderReading[3] = BRMotor.getCurrentPosition();

        return encoderReading;
    }

    public void shutdown(){
        FLMotor.setPower(0);
        FRMotor.setPower(0);
        BLMotor.setPower(0);
        BRMotor.setPower(0);
    }
    public double getYaw(){
       return -imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.RADIANS).thirdAngle;
    }


}