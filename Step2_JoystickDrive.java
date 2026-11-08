package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Step 2: Joystick Tank Drive", group = "Training")
public class Step2_JoystickDrive extends LinearOpMode {

    @Override
    public void runOpMode() {
        DcMotor leftMotor = hardwareMap.get(DcMotor.class, "left_drive");
        DcMotor rightMotor = hardwareMap.get(DcMotor.class, "right_drive");
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Ready for Joysticks!");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            
            // Joysticks go from -1.0 to 1.0. 
            // IMPORTANT: Pushing FORWARD on an FTC joystick gives a NEGATIVE number. 
            // So we put a minus sign (-) in front to fix it!
            double leftPower = -gamepad1.left_stick_y;
            
            // TODO: CHALLENGE 1! 
            // We have the left stick controlling the left motor.
            // Create a 'rightPower' variable and read from the RIGHT stick Y-axis!
            // double rightPower = ???
            
            // Set the motor powers
            leftMotor.setPower(leftPower);
            
            // TODO: CHALLENGE 2!
            // Uncomment the line below and put your new rightPower variable in the parenthesis!
            // rightMotor.setPower( );
            
            
            // Bonus Challenge: Pushing the stick all the way forward is 1.0 (100% speed).
            // How would you modify the code above to limit the top speed to 50%?
            // (Hint: math! Try multiplication.)

            telemetry.addData("Left Stick Power", leftPower);
            telemetry.update();
        }
    }
}
