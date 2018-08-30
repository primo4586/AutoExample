package Utils;

public class PIDHelper {

	private double kP, kI, kD;
	private double setPoint, error, prevError, integral, deriv;

	public PIDHelper(double kP, double kI, double kD, double setPoint) {
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
		this.setPoint = setPoint;
		this.error = Double.MAX_VALUE;
		this.prevError = 0;
		this.integral = 0;
		this.deriv = 0;
	}

	public double update(double current, double interval) {
		this.error = this.setPoint - current;
		this.deriv = (this.error - this.prevError) / interval;
		this.integral = (this.error + this.prevError) * interval / 2;
		this.prevError = this.error;
		return this.kP * this.error + this.kI * this.integral + this.kD * this.deriv;
	}
	public double getError(){
		return this.error;
	}
}
