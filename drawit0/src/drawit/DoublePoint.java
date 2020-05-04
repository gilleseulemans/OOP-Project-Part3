package drawit;

public class DoublePoint {
	
	private final double x;
	private final double y;
	
	public DoublePoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() { return x; }
	public double getY() { return y; }

	public DoublePoint plus(DoubleVector other) {
		return new DoublePoint(this.x + other.getX(), this.y + other.getY());
	}

	public DoubleVector minus(DoublePoint other) {
		return new DoubleVector(this.x - other.x, this.y - other.y);
	}

	/**
	 * Returns an {@code IntPoint} object whose coordinates are obtained by rounding the coordinates of this point to the nearest integer.
	 */
	public IntPoint round() {
		return new IntPoint((int)Math.round(this.x), (int)Math.round(this.y));
	}

}
