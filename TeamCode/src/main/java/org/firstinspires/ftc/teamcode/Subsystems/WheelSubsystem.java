package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;

public class WheelSubsystem {

//    BNO055IMU imu;
//    private final BNO055IMU.Parameters parameters;
    DcMotorEx FLMotor;
    DcMotorEx FRMotor;
    DcMotorEx BLMotor;
    DcMotorEx BRMotor;



    public WheelSubsystem(OpMode opMode) {

//        imu = opMode.hardwareMap.get(BNO055IMU.class, "imu");
//        parameters = new BNO055IMU.Parameters();
//        imu.initialize(parameters);

        FLMotor = opMode.hardwareMap.get(DcMotorEx.class, "FL");
        FRMotor = opMode.hardwareMap.get(DcMotorEx.class, "FR");
        BLMotor = opMode.hardwareMap.get(DcMotorEx.class, "BL");
        BRMotor = opMode.hardwareMap.get(DcMotorEx.class, "BR");

        FLMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        BLMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        FRMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        BRMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        // Motor spin sides
        FLMotor.setDirection( DcMotorEx.Direction.FORWARD);
        BLMotor.setDirection( DcMotorEx.Direction.FORWARD);
        FRMotor.setDirection( DcMotorEx.Direction.FORWARD);
        BRMotor.setDirection( DcMotorEx.Direction.FORWARD);
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

    public void operate(Gamepad gamepad) {
        double y = gamepad.left_stick_y;
        double x = gamepad.left_stick_x;
        double rx = gamepad.right_stick_x;

        if (gamepad.right_bumper){
            FLMotor.setPower((y + x + rx)/2);
            FRMotor.setPower((y - x - rx)/2);
            BLMotor.setPower((y - x + rx)/2);
            BRMotor.setPower((y + x - rx)/2);
        }
        else {
            FLMotor.setPower(y + x + rx);
            FRMotor.setPower(y - x - rx);
            BLMotor.setPower(y - x + rx);
            BRMotor.setPower(y + x - rx);
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
//    public double getYaw(){
//        return imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES).thirdAngle;
//    }


}
