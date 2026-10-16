package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class IntakeSubsystem {
    DcMotorEx IntakeMotor;
    public IntakeSubsystem(OpMode opMode) {
      IntakeMotor = opMode.hardwareMap.get(DcMotorEx.class, "Intake");
    }
    public void setFlywheelPower(double power){
        IntakeMotor.setPower(power);
    }
    public void shutdown(){
        IntakeMotor.setPower(0);
    }

}
