package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;

@TeleOp
public class TeleOpDrive extends OpMode {

    private Robot robot;
    private GamepadEx gamepadOne;
    private GamepadEx gamepadTwo;

    /**
     * User defined init method
     * <p>
     * This method will be called once when the INIT button is pressed.
     */
    @Override
    public void init() {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        robot = new Robot(hardwareMap);
        this.gamepadOne = new GamepadEx(gamepad1);
        this.gamepadTwo = new GamepadEx(gamepad2);
    }

    /**
     * User defined loop method
     * <p>
     * This method will be called repeatedly in a loop while this op mode is running
     */
    @Override
    public void loop() {
        robot.drive(-gamepadOne.getLeftY(), -gamepadOne.getRightY());

        telemetry.addData("Status: ", "Running...");
        telemetry.addLine();

        telemetry.addData("Left Motor Power: ", this.robot.getLeftDrivePower());
        telemetry.addData("Right Motor Power: ", this.robot.getRightDrivePower());
        telemetry.addLine();

        telemetry.addData("Left Motor Position: ", this.robot.getLeftDrivePosition());
        telemetry.addData("Right Motor Position: ", this.robot.getRightDrivePosition());

        telemetry.update();
    }
}
