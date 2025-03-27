package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.spark.SparkLowLevel.MotorType;

// for diagnostics
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmSpinnySubsystem extends SubsystemBase {
    SparkMax armSpinny = new SparkMax(18, MotorType.kBrushless); // TODO: temp value, fix

    double armSpeed = 0.0;

    final double MAX_VELOCITY = 0.25; // this is used for quickly setting speed values

    public void clockwiseSpin() {
        setArmSpeed(MAX_VELOCITY); // TODO: check if this is correct
    }

    public void counterClockwiseSpin() {
        setArmSpeed(-MAX_VELOCITY); // TODO: check if this is correct
    }

    public void stopSpin() {
        setArmSpeed(0);
    }

    public void setArmSpeed(double speed) {
        armSpeed = speed;
        armSpinny.set(armSpeed);
    }

    public void putArmDiagnostics() {
        SmartDashboard.putNumber("Arm Spin Speed", armSpeed);
        SmartDashboard.putNumber("Arm Spin Speed Percentage", armSpeed * 100.0);
    }
}
