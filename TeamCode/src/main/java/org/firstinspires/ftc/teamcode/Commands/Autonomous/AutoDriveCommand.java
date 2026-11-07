//package org.firstinspires.ftc.teamcode.Commands.Autonomous;//package org.firstinspires.ftc.teamcode.Commands.Autonomous;
//
//import com.qualcomm.robotcore.hardware.Gamepad;
//import org.firstinspires.ftc.teamcode.Subsystems.*;
//import org.firstinspires.ftc.teamcode.Constants;
//import org.firstinspires.ftc.teamcode.PIDController;
//
//public class AutoDriveCommand {
//    WheelSubsystem wheelSubsystem;
//    PIDController pidController;
//    double setPoint;
//    public AutoDriveCommand(WheelSubsystem wheelSubsystem){
//        this.wheelSubsystem = wheelSubsystem;
//    }
//    public void AutoDrive(double distanceInches) {
//        this.pidController = new PIDController(0.0001, 0.05);
//        wheelSubsystem.resetEncoder();
//        setPoint = distanceInches * Constants.EncoderConstants.kCOUNTS_PER_INCH;
//        pidController.setSetPoint(setPoint);
//        while (true) {
//            pidController.calculateError(wheelSubsystem.encoderReading()[0]);
//            wheelSubsystem.setBLPower(pidController.calculateOutput());
//            wheelSubsystem.setBRPower(pidController.calculateOutput());
//            wheelSubsystem.setFLPower(pidController.calculateOutput());
//            wheelSubsystem.setFRPower(pidController.calculateOutput());
//            if (Math.abs(pidController.calculateError(wheelSubsystem.encoderReading()[0])) < 10) {
//                break;
//            }
//        }
//        wheelSubsystem.resetEncoder();
//        wheelSubsystem.shutdown();
//    }
//    public void AutoStrafe(double distanceInches){
//        this.pidController = new PIDController(0.0001, 0.05);
//        setPoint = distanceInches * Constants.EncoderConstants.kCOUNTS_PER_INCH;
//        pidController.setSetPoint(setPoint);
//        while(true){
//            pidController.calculateError(wheelSubsystem.encoderReading()[0]);
//            wheelSubsystem.setBLPower(-pidController.calculateOutput());
//            wheelSubsystem.setBRPower(pidController.calculateOutput());
//            wheelSubsystem.setFLPower(pidController.calculateOutput());
//            wheelSubsystem.setFRPower(-pidController.calculateOutput());
//            if(Math.abs(pidController.calculateError(wheelSubsystem.encoderReading()[0])) < 10){
//                break;
//            }
//        }
//        wheelSubsystem.resetEncoder();
//        wheelSubsystem.shutdown();
//    }
//    public void yawStrafe(double degrees){
//        this.pidController = new PIDController(0.01, 0.05);
//        pidController.setSetPoint(degrees);
//        while(true) {
//            pidController.calculateError(wheelSubsystem.getYaw());
//            double output = pidController.calculateOutput();
//            wheelSubsystem.setBLPower(output);
//            wheelSubsystem.setBRPower(-output);
//            wheelSubsystem.setFLPower(output);
//            wheelSubsystem.setFRPower(-output);
//            if (Math.abs(pidController.calculateError(wheelSubsystem.getYaw())) < 3) {
//                break;
//            }
//        }
//        wheelSubsystem.shutdown();
//    }
//}
