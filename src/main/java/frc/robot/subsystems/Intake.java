package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;

public class Intake extends SubsystemBase implements HardwareAdapter {
  public Intake() {
	  setFollowers();
  }

  public void spinIn() {
    intakeMotor1.set(0.5);
  }

  public void spinOff() {
    intakeMotor1.set(0);
  }

  private void setFollowers() {
    intakeMotor2.follow(intakeMotor1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

