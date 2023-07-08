package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.SwerveSubsystem;

public class ChassisDrive extends CommandBase {

    private SwerveSubsystem m_swerve;
    private CommandXboxController m_controller;

    public ChassisDrive(SwerveSubsystem swerve) {
        m_swerve = swerve;
        m_controller = new CommandXboxController(0);

        addRequirements(m_swerve);
    }


    // drives the swerve drive
    @Override
    public void execute() {
        
        double fwd = m_controller.getLeftY();
        double str = m_controller.getLeftX();
        double rot = m_controller.getRightX();
        m_swerve.drive(fwd, str, rot);
    }
    
}
