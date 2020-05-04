package drawit.shapes2;

import drawit.shapegroups2.*;
import drawit.IntPoint;
import drawit.RoundedPolygon;
public class Shape extends ShapeGroup {
	

	
	
		
	public Shape(RoundedPolygon shape) {
		super(shape);
		// TODO Auto-generated constructor stub
	}
	

	public ShapeGroup getParent() {
		throw new IllegalArgumentException("Not yet implemented") ;
		
	}
	
	public boolean contains() {
		throw new IllegalArgumentException("Not yer Implemented");
		
	}
	
	public String getDrawingCommands() {
		throw new IllegalArgumentException("Not yer Implemented");
	}
	
	/**
	 * 
	 * Given the coordinates of a point in the global coordinate system, returns the coordinates of the point in the shape coordinate system.
	 */
	public IntPoint toShapeCoordinates(IntPoint p) {
		throw new IllegalArgumentException("Not yer Implemented");
	}
	
	/**
	 * Given the coordinates of a point in the shape coordinate system, returns the coordinates of the point in the global coordinate system.
	 */
	public IntPoint toGlobalCoordinates(IntPoint p) {
		throw new IllegalArgumentException("Not yer Implemented");
	}
	
	public ControlPoint[] createControlPoints() {
		throw new IllegalArgumentException("Not yer Implemented");
	}
}
