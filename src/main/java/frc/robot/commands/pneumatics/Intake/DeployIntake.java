package frc.robot.commands.pneumatics.Intake;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;

public class DeployIntake extends SequentialCommandGroup implements Constants.GeneralConstants {
  public DeployIntake() {
    super(new MoveIntake(EXT), new WaitCommand(.2), new MoveIntake(OFF));
  }
}
