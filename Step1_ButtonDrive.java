package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Step 1: Button Drive", group = "Training")
public class Step1_ButtonDrive extends LinearOpMode {

    @Override
    public void runOpMode() {
        // Connect to the motors on the robot using their configuration names
        DcMotor leftMotor = hardwareMap.get(DcMotor.class, "left_drive");
        DcMotor rightMotor = hardwareMap.get(DcMotor.class, "right_drive");

        // The right motor needs to be reversed because it's mounted backwards on the chassis!
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Ready! Press the Play button.");
        telemetry.update();

        // Wait for the driver to press PLAY
        waitForStart();

        // This loop runs over and over again while the game is active
        while (opModeIsActive()) {
            
            // If the driver presses the 'X' button (Square on PS)
            if (gamepad1.x) {
                // Turn motors on! (1.0 is max speed. Try changing this to 0.5 for half speed)
                leftMotor.setPower(1.0);
                rightMotor.setPower(1.0);
            } 
            // If the driver presses the 'B' button (Circle on PS)
            else if (gamepad1.b) {
                // Turn motors off!
                leftMotor.setPower(0.0);
                rightMotor.setPower(0.0);
            }

            telemetry.addData("Press X", "To go forward");
            telemetry.addData("Press B", "To stop");
            telemetry.update();
        }
    }
}
