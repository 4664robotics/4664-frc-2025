package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.spark.SparkLowLevel.MotorType;

// for diagnostics
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class TestSubsystem extends SubsystemBase {
    SparkMax motor = new SparkMax(15, MotorType.kBrushless);
    DigitalInput topLimitSwitch = new DigitalInput(8);
    DigitalInput bottomLimitSwitch = new DigitalInput(6);

    Joystick joystick = new Joystick(1);

    double motorSpeed = 0.0;

    public void spinMotorPositive() {
        setMotorSpeed(0.01);
    }

    public void spinMotorNegative() {
        setMotorSpeed(-0.01);
    }

    public void setMotorSpeed(double speed) {
        if (speed > 0) {
            if (topLimitSwitch.get()) {
                // We are going up and top limit is tripped so stop
                motorSpeed = 0.0;
            } else {
                // We are going up but top limit is not tripped so go at commanded speed
                motorSpeed = speed;
            }
        } else {
            if (bottomLimitSwitch.get()) {
                // We are going down and bottom limit is tripped so stop
                motorSpeed = 0.0;
            } else {
                // We are going down but bottom limit is not tripped so go at commanded speed
                motorSpeed = speed;
            }
        }

        motor.set(motorSpeed);
    }

    public void stopMotor() {
        setMotorSpeed(0);
    }
}
