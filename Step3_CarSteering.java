package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Step 3: Car Steering (Arcade)", group = "Training")
public class Step3_CarSteering extends LinearOpMode {

    @Override
    public void runOpMode() {
        // This robot has 4 drive motors (lf, lr, rf, rr) - we're just using the front two for now!
        DcMotor leftMotor = hardwareMap.get(DcMotor.class, "lf");
        DcMotor rightMotor = hardwareMap.get(DcMotor.class, "rf");
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {
            
            // We want to drive like a car video game:
            // Left Stick UP/DOWN controls forward and backward.
            // Right Stick LEFT/RIGHT controls steering.
            
            double drive = -gamepad1.left_stick_y;
            double turn  = gamepad1.right_stick_x;
            
            // THE CHALLENGE: 
            // If we want to turn RIGHT, the left wheels need to go FORWARD, 
            // and the right wheels need to go BACKWARDS.
            // How do we combine 'drive' and 'turn' to make this happen?
            
            // TODO: Fix the math below! Combine drive and turn using addition and subtraction.
            double leftPower = 0;   // Hint: drive + turn
            double rightPower = 0;  // Hint: drive - turn
            
            // Apply the power
            leftMotor.setPower(leftPower);
            rightMotor.setPower(rightPower);

            telemetry.addData("Drive (Forward/Back)", drive);
            telemetry.addData("Turn (Left/Right)", turn);
            telemetry.update();
        }
    }

    // BONUS CHALLENGE: This robot actually has 4 drive motors, not 2!
    // The back-left is "lr" and the back-right is "rr" - they should move the
    // same way as their front partners ("lf" and "rf") at all times.
    // Try declaring lrMotor and rrMotor above like the other two, matching
    // directions with their partner motor, and calling setPower() on them
    // right alongside leftMotor/rightMotor. Does the robot drive better?
}
