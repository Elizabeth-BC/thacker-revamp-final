package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public interface HardwareAdapter extends Constants {

    // DRIVETRAIN
    public static final WPI_TalonSRX leftDriveMaster = new WPI_TalonSRX(2);
    public static final WPI_TalonSRX rightDriveMaster = new WPI_TalonSRX(3);
    public static final WPI_TalonSRX leftDriveSlave1 = new WPI_TalonSRX(4);
    public static final WPI_TalonSRX rightDriveSlave1 = new WPI_TalonSRX(5);
    //public static final CANSparkMax leftDriveSlave2 = new CANSparkMax(6, MotorType.kBrushless);
	//public static final CANSparkMax rightDriveSlave2 = new CANSparkMax(7, MotorType.kBrushless);

    //INTAKE
    public final CANSparkMax intakeMotor1 = new CANSparkMax(9, MotorType.kBrushless); 
    public final CANSparkMax intakeMotor2 = new CANSparkMax(10, MotorType.kBrushless);
   

    public static final Compressor compressor = new Compressor(1, PneumaticsModuleType.CTREPCM);
    public static final DoubleSolenoid intakeSolenoid = new DoubleSolenoid(1,PneumaticsModuleType.CTREPCM, 7, 0);
    public static final DoubleSolenoid tiltSolenoid = new DoubleSolenoid(1, PneumaticsModuleType.CTREPCM, 6, 1);


}
