package frc.robot.Subsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TankPID;

public class DriveSubsystem extends SubsystemBase {
    private final CANSparkMax motorLeft = new CANSparkMax(0, MotorType.kBrushless);
    private final CANSparkMax motorRight = new CANSparkMax(1, MotorType.kBrushless);
    public DriveSubsystem() {
        motorLeft.restoreFactoryDefaults();
        motorRight.restoreFactoryDefaults();
        motorLeft.setIdleMode(IdleMode.kBrake);
        motorRight.setIdleMode(IdleMode.kBrake);

        motorLeft.getPIDController().setP(TankPID.Kp);
        motorLeft.getPIDController().setI(TankPID.Ki);
        motorLeft.getPIDController().setD(TankPID.Kd);
        motorRight.getPIDController().setP(TankPID.Kp);
        motorRight.getPIDController().setI(TankPID.Ki);
        motorRight.getPIDController().setD(TankPID.Kd);
        motorLeft.setSmartCurrentLimit(40);
        motorRight.setSmartCurrentLimit(40);

        motorRight.setInverted(true);

        motorLeft.set(0);
        motorRight.set(0);
    }
    //new drive method
    public void drive(double leftSpeed, double rightSpeed){

        motorLeft.getPIDController().setReference(leftSpeed, ControlType.kVelocity,0);
        motorRight.getPIDController().setReference(rightSpeed, ControlType.kVelocity,0);
        

    }



    

}
