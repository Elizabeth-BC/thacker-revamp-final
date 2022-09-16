package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;

public class Pneumatics extends SubsystemBase  implements HardwareAdapter {

  public Pneumatics() {
    
  }

  // NOTE: shifter will not exist on the competition robot
  // Use this as an example to code future pneumatic subsytems
  public void shift(Value v) {
    //shifter.set(v);
  }
  public void setIntakeState(Value v) {
    intakeSolenoid.set(v);
  }

  @Override
  public void periodic() {
  }
}
