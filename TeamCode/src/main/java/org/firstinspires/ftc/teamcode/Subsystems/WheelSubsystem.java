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

    IMU imu;
    DcMotorEx FLMotor;
    DcMotorEx FRMotor;
    DcMotorEx BLMotor;
    DcMotorEx BRMotor;
    boolean toggle;
    boolean slowMode;
    YawPitchRollAngles robotOrientation;





    public WheelSubsystem(OpMode opMode) {

        imu = opMode.hardwareMap.get(IMU.class, "imu");
        IMU.Parameters IMUparameters = new IMU.Parameters(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.RIGHT));
        imu.initialize(IMUparameters);
        robotOrientation = imu.getRobotYawPitchRollAngles();

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
        double x = -gamepad.left_stick_x; //PLS fix
        double rx = -gamepad.right_stick_x; //PLEASE FIX LATER

        double botHeading = getYaw();

        //actual field oriented
        double rotX = x * Math.cos(botHeading) + y * Math.sin(botHeading);
        double rotY = y * Math.cos(botHeading) - x * Math.sin(botHeading);

        double denominator = Math.max(Math.abs(rotX) + Math.abs(rotY) + Math.abs(rx), 1);


        if (gamepad.right_bumper) {
            FLMotor.setPower((rotY - rotX + rx) / 2);
            FRMotor.setPower((rotY + rotX - rx) / 2);
            BLMotor.setPower((rotY + rotX + rx) / 2);
            BRMotor.setPower((rotY - rotX - rx) / 2);
        } else {
            FLMotor.setPower((rotY - rotX + rx));
            FRMotor.setPower((rotY + rotX - rx));
            BLMotor.setPower((rotY + rotX + rx));
            BRMotor.setPower((rotY - rotX - rx));
        }
        telemetry.addData("yaw", getYaw());
        telemetry.update();
    }
    public void robotOrientedOperate(Gamepad gamepad, Telemetry telemetry) {
        //////////////////////////////////////////////////////////////////////
        ///              CURRENTLY IN SHAMBLES, FIX AFTER COMP             ///
        //////////////////////////////////////////////////////////////////////
//
//        double y = gamepad.left_stick_y;
//        double x = gamepad.left_stick_x;
//        double rx = -gamepad.right_stick_x; //PLEASE FIX LATER
//
//        double denominator = Math.max(Math.abs(x) + Math.abs(y) + Math.abs(rx), 1);
//
//        if (gamepad.right_bumper) {
//            FLMotor.setPower((y - x + rx) / 2);
//            FRMotor.setPower((y + x - rx) / 2);
//            BLMotor.setPower((y + x + rx) / 2);
//            BRMotor.setPower((y - x - rx) / 2);
//        } else {
//            FLMotor.setPower((y - x + rx));
//            FRMotor.setPower((y + x - rx));
//            BLMotor.setPower((y + x + rx));
//            BRMotor.setPower((y - x - rx));
//        }
        double y = gamepad.left_stick_y;
        double x = -gamepad.left_stick_x;
        double rx = -gamepad.right_stick_x; //PLEASE FIX LATER

        double botHeading = getYaw();

        //actual field oriented
        double rotX = x * Math.cos(botHeading) + y * Math.sin(botHeading);
        double rotY = y * Math.cos(botHeading) - x * Math.sin(botHeading);

        double denominator = Math.max(Math.abs(rotX) + Math.abs(rotY) + Math.abs(rx), 1);


        if (gamepad.right_bumper) {
            FLMotor.setPower((rotY - rotX + rx) / 2);
            FRMotor.setPower((rotY + rotX - rx) / 2);
            BLMotor.setPower((rotY + rotX + rx) / 2);
            BRMotor.setPower((rotY - rotX - rx) / 2);
        } else {
            FLMotor.setPower((rotY - rotX + rx));
            FRMotor.setPower((rotY + rotX - rx));
            BLMotor.setPower((rotY + rotX + rx));
            BRMotor.setPower((rotY - rotX - rx));
        }

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
        return robotOrientation.getYaw();
    }


}
//package org.firstinspires.ftc.teamcode.Subsystems;
//
//import android.graphics.Path;
//
//import com.qualcomm.hardware.bosch.BHI260IMU;
//import com.qualcomm.hardware.bosch.BNO055IMU;
//import com.qualcomm.hardware.limelightvision.LLResult;
//import com.qualcomm.hardware.limelightvision.Limelight3A;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.hardware.*;
//
//import org.firstinspires.ftc.onbotjava.handlers.file.NewFile;
//import org.firstinspires.ftc.robotcore.external.Telemetry;
//import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
//import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
//import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
//
//
//public class WheelSubsystem {
//    //Make 4 motors (the four corners)
//    private final BNO055IMU imu;//tbd
//    //BHI260AP imu;
//    DcMotorEx leftFront;
//    DcMotorEx leftBack;
//    DcMotorEx rightFront;
//    DcMotorEx rightBack;
//    boolean toggle;
//
//    //    DcMotorEx xThroughbore;
////    DcMotorEx yThroughbore;
//    private boolean slowModeOn;
//    public WheelSubsystem(HardwareMap hardwareMap, OpMode opMode){
//        leftFront = hardwareMap.get(DcMotorEx.class, "FL");
//        leftBack = hardwareMap.get(DcMotorEx.class, "BL");
//        rightFront = hardwareMap.get(DcMotorEx.class, "FR");
//        rightBack = hardwareMap.get(DcMotorEx.class, "BR");
//
//        imu = opMode.hardwareMap.get(BNO055IMU.class, "imu");
//        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
//        imu.initialize(parameters);
//        toggle = false;
//
//
//        leftFront.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
//        leftBack.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
//        rightFront.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
//        rightBack.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
//
//        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//
//        leftFront.setDirection(DcMotorEx.Direction.REVERSE);
//        leftBack.setDirection(DcMotorEx.Direction.REVERSE);
//        rightFront.setDirection(DcMotorEx.Direction.REVERSE);
//        rightBack.setDirection(DcMotorEx.Direction.FORWARD);
//
//    }
//    public void operate(Gamepad gamepad, Telemetry telemetry) {
//
//
//        double y =  gamepad.left_stick_y;
//        double x = gamepad.left_stick_x;
//        double rx = gamepad.right_stick_x;
//
//
//        double botHeading = getYawRadians();
//
//        //actual field oriented
//        double rotX = x * Math.cos(botHeading) - y * Math.sin(botHeading);
//        double rotY = x * Math.sin(botHeading) + y * Math.cos(botHeading);
//
//        //a quick way to de-field orient the code
////        double rotX = x;
////        double rotY = y;
//        double denominator = Math.max(Math.abs(x) + Math.abs(y) + Math.abs(rx), 1);
//
//
//        if (gamepad.left_bumper) {
//
//            leftFront.setPower((-rotY+rotX+rx) / denominator * 0.5);
//            leftBack.setPower((-rotY-rotX+rx) / denominator * 0.5);
//            rightFront.setPower((-rotY-rotX-rx) / denominator * 0.5);
//            rightBack.setPower((-rotY+rotX-rx) / denominator * 0.5);
//        }
//        else {
//            leftFront.setPower((-rotY+rotX+rx) / denominator);
//            leftBack.setPower((-rotY-rotX+rx) / denominator);
//            rightFront.setPower((-rotY-rotX-rx) / denominator);
//            rightBack.setPower((-rotY+rotX-rx)/ denominator);
//        }
//
//
//    }
//
//    public void setLeftBackPower(double power){
//        leftBack.setPower(power);
//    }
//    public void setRightBackPower(double power){
//        rightBack.setPower(power);
//    }
//    public void setLeftFrontPower(double power){
//        leftFront.setPower(power);
//    }
//    public void setRightFrontPower(double power){
//        rightFront.setPower(power);
//    }
//
//    public double[] encoderReading () {
//        double[] encoderReading = new double[4];
//        encoderReading[0] = leftFront.getCurrentPosition();
//        encoderReading[1] = leftBack.getCurrentPosition();
//        encoderReading[2] = rightFront.getCurrentPosition();
//        encoderReading[3] = rightBack.getCurrentPosition();
//
//        return encoderReading;
//    }
//    public double getYaw(){
//        return -imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES).thirdAngle;
//    }
//    public double getYawRadians(){
//        return -imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.RADIANS).thirdAngle;
//    }
//
//    public void shutdown() {
//        leftFront.setPower(0);
//        leftBack.setPower(0);
//        rightFront.setPower(0);
//        rightBack.setPower(0);
//    }
//
//}