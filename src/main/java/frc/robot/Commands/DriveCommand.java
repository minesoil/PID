package frc.robot.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystem.DriveSubsystem;

public class DriveCommand extends Command {
    private final DriveSubsystem driveSubsystem = new DriveSubsystem();
    private final Supplier<Double> speedFunction, turnFunction;
    public DriveCommand(DriveSubsystem subsystem, Supplier<Double> SpeedFunction, Supplier<Double> TurnFunction) {
        // d riveSubsystem = subsystem;
        speedFunction = SpeedFunction;
        turnFunction = TurnFunction;
        addRequirements(subsystem);
    }

    public void execute() {
        double speed = speedFunction.get();
        double turn = turnFunction.get();
        double leftSpeed=(speed+turn);
        double rightSpeed=(speed-turn);
        driveSubsystem.drive(leftSpeed, rightSpeed);

    }

}
