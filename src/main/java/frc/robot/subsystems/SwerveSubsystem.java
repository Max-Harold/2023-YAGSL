package frc.robot.subsystems;

import java.io.File;
import java.io.IOException;

import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.Chassis.*;
import swervelib.parser.SwerveParser;
import swervelib.SwerveDrive;

public class SwerveSubsystem extends SubsystemBase {
    SwerveDrive drive;
    public SwerveSubsystem() {
        File swerveJsonDirectory = new File(Filesystem.getDeployDirectory(),"swerve");
        try {
            drive  = new SwerveParser(swerveJsonDirectory).createSwerveDrive();
        } catch (IOException e) {
            System.out.println("Error: Missing file");
        }
    }

    // standard drive function for swerve
    public void drive(double fwd, double str, double rot) {

        Translation2d speed = new Translation2d(-MAX_SPEED_METERS * fwd, -MAX_SPEED_METERS * str);
        drive.drive(speed, rot, true, false);
    }

    // reset gyro sensor
    public void resetGyro() {
        drive.setGyro(new Rotation3d(0,0,0));
    }
}
