package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.Intake.SpinIntakeIn;
import frc.robot.commands.auto.DoNothingAuto;
import frc.robot.commands.drivetrain.Drive;
import frc.robot.commands.drivetrain.TimedDrive;
import frc.robot.commands.pneumatics.Intake.DeployIntake;
import frc.robot.commands.pneumatics.Intake.RetractIntake;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Pneumatics;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.libs.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and OI devices
  public static final SmoothXboxController xbox = new SmoothXboxController(0);

  private static final SendableChooser<Command> chooser = new SendableChooser<>();

  public static final Drivetrain dt = new Drivetrain();
  public static final Pneumatics pn = new Pneumatics();
  public static final Intake in = new Intake();

  private UsbCamera camera;

  public RobotContainer() {
        //TALK TO DRIVERS AND SEE IF THEY WANT/NEED A CAMERA AND ADJUST ACCORDINGLY
        camera = CameraServer.startAutomaticCapture();
        camera.setFPS(30);
        camera.setResolution(
          Constants.GeneralConstants.RobotPhysicalConstants.x_resolution, 
          Constants.GeneralConstants.RobotPhysicalConstants.y_resolution
        );
    
        chooser.setDefaultOption("Do Nothing Auto", new DoNothingAuto());
        chooser.addOption("TD: 2s", new TimedDrive(0.25, 2));
        chooser.addOption("TD: 5s", new TimedDrive(0.25, 5));
        chooser.addOption("RTD: 2s", new TimedDrive(-0.25, 2));
        chooser.addOption("RTD: 5s", new TimedDrive(-0.25, 5));
        //NO AUTOS OTHER THAN TAXI, CHECK HOW FAR THACKER GOES *BEOFRE* OFFICIAL MATCHES
    
        Shuffleboard.getTab("Selector").add(chooser);
    configureButtonBindings();
    configureDefaultCommands();
  }

  private void configureButtonBindings() {
    new JoystickButton(xbox, Button.kLeftBumper.value)
    .whenPressed(new DeployIntake())
    .whenPressed(new SpinIntakeIn())
    .whenReleased(new RetractIntake());
    //WORK WITH DRIVERS TO FIGURE OUT CONTROLS AND CHECK THAT THEY ALL WORK
  }

  private void configureDefaultCommands() {
    dt.setDefaultCommand(new Drive());
  }

  public Command getAutonomousCommand() {
    return new WaitCommand(15);
  }
}