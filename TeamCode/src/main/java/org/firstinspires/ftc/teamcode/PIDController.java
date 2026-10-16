package org.firstinspires.ftc.teamcode;

public class PIDController {
    private double kP;
    private double setPoint; // target variable
    private double error; // distance from your target position
    private double processVariable; // current position
    private double kFF;
    private double output; // power to the robot

    public PIDController (double kP, double kFF) {
        this.kP = kP;
        this.kFF = kFF;
    }
    public void setSetPoint(double setPoint){
        this.setPoint = setPoint;
    }
    public double calculateError(double processVariable){
        error = setPoint - processVariable;
        return error;
    }
    public double calculateOutput(){
        output = kP*error+kFF;
        return output;
    }
}

