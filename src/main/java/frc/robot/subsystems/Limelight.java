// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

//read values periodically


//post to smart dashboard periodically

public class Limelight extends SubsystemBase {
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");

  double x = tx.getDouble(0.0);
  double y = ty.getDouble(0.0);
  double area = ta.getDouble(0.0);

  /** Creates a new Limelight. */
  public Limelight() {   
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  SmartDashboard.putNumber("LimelightX", x);
  SmartDashboard.putNumber("LimelightY", y);
  SmartDashboard.putNumber("LimelightArea", area);
  }

  public double getTX(){
    System.out.println(x);
    return x;
  }

  
}

/*
 * NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
double tv = table.getEntry("tv").getDouble(0);
double tx = table.getEntry("tx").getDouble(0);

double steering_adjust = 0.0;
if (tv == 0.0) {
        // We don't see the target, seek for the target by spinning in place at a safe speed.
        steering_adjust = 0.3;
} else {
        // We do see the target, execute aiming code
        double heading_error = tx;
        steering_adjust = Kp * tx;
}

left_command += steering_adjust;
right_command -= steering_adjust;
 */