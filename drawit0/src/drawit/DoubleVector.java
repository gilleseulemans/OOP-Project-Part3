package drawit;

public class DoubleVector {
	
	private final double x;
	private final double y;
	
	public DoubleVector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() { return x; }
	public double getY() { return y; }

	/** Returns a {@code DoubleVector} object whose coordinates are obtained by multiplying this vector's coordinates by the given scale factor. */
	public DoubleVector scale(double d) {
		return new DoubleVector(this.x * d, this.y * d);
	}

	public DoubleVector plus(DoubleVector other) {
		return new DoubleVector(this.x + other.x, this.y + other.y);
	}

	public double getSize() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}

	/**
	 * Returns the dot product of this vector and the given vector.
	 * 
	 * @post | result == this.getX() * other.getX() + this.getY() * other.getY()
	 */
	public double dotProduct(DoubleVector other) {
		return this.x * other.x + this.y * other.y;
	}

	/**
	 * Returns the cross product of this vector and the given vector.
	 * 
	 * @post | result == this.getX() * other.getY() - this.getY() * other.getX()
	 */
	public double crossProduct(DoubleVector other) {
		return this.x * other.y - this.y * other.x;
	}
	
	/**
	 * Returns the angle from positive X to this vector, in radians.
	 * 
	 * The angle from positive X to positive Y is {@code Math.PI / 2}; the angle from positive X to negative Y is {@code -Math.PI / 2}.
	 * 
	 * <p><b>Implementation Hint:</b> See {@link Math#atan2(double, double)}.
	 */
	public double asAngle() {
		return Math.atan2(y, x);
	}

}
