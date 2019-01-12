
package frc.robot;

public enum RobotMap {
 
  // Motor Mappings
  FRONT_LM(3),
  FRONT_RM(4),
  BACK_LM(2),
  BACK_RM(5),
  JOYSTICK_PORT(0),
  LEFT_JOYSTICK(1),
  RIGHT_JOYSTICK(3);
  
    public final int value;

    RobotMap(int value)
    {
      this.value = value;
    }
}
