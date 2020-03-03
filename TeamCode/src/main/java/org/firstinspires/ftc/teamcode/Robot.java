package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {

    private DcMotor leftDrive;
    private DcMotor rightDrive;

    private DcMotor[] motors;

    public Robot(HardwareMap hardwareMap) {
        this.leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        this.rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");

        this.motors = new DcMotor[]{leftDrive, rightDrive};

        for (DcMotor motor : motors) {
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            motor.setPower(0);
        }

        this.leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        this.rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void drive(double leftPower, double rightPower) {
        this.leftDrive.setPower(leftPower);
        this.rightDrive.setPower(rightPower);
    }

    public void drive(double power) {
        this.drive(power, power);
    }

    public double getLeftDrivePower() {
        return this.leftDrive.getPower();
    }

    public double getRightDrivePower() {
        return this.rightDrive.getPower();
    }

    public int getLeftDrivePosition() {
        return this.leftDrive.getCurrentPosition();
    }

    public int getRightDrivePosition() {
        return this.rightDrive.getCurrentPosition();
    }
}
