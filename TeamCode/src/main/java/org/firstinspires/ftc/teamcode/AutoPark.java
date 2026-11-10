package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "Auto Park")
public class AutoPark extends LinearOpMode {
    public DcMotor leftFront;
    public DcMotor rightFront;
    public DcMotor leftBack;
    public DcMotor rightBack;

    @Override
    public void runOpMode() {

        //Set up motor hardware here
        //change device names to match the configuration!!!
        leftFront = hardwareMap.get(DcMotor.class, "FL"); //change this
        rightFront = hardwareMap.get(DcMotor.class, "FR"); //change this
        leftBack = hardwareMap.get(DcMotor.class, "BL"); //change this
        rightBack = hardwareMap.get(DcMotor.class, "BR"); //change this

        //Set up motor mode when power is zero
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //Change motor directions as needed
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        if (opModeIsActive() && !isStopRequested()) {
            while (opModeIsActive() && !isStopRequested()) {
                //Wait 25 seconds and do nothing
//                sleep(25000);
                //Go forward at 30% speed for 1 second
                leftFront.setPower(0.25);
                rightFront.setPower(0.25);
                leftBack.setPower(0.25);
                rightBack.setPower(0.25);
                sleep(1000);
                //Stop the motors
                leftFront.setPower(0);
                rightFront.setPower(0);
                leftBack.setPower(0);
                rightBack.setPower(0);
                break;  // Break out of while loop and end the code
            }
        }
    }

}
