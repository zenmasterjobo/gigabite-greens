package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Step 3: Car Steering (Arcade)", group = "Training")
public class Step3_CarSteering extends LinearOpMode {

    @Override
    public void runOpMode() {
        DcMotor leftMotor = hardwareMap.get(DcMotor.class, "left_drive");
        DcMotor rightMotor = hardwareMap.get(DcMotor.class, "right_drive");
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
}
