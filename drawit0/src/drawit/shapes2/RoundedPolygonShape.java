package drawit.shapes2;

import drawit.IntPoint;
import drawit.RoundedPolygon;
import drawit.shapegroups2.ShapeGroup;
import drawit.shapes2.ControlPoint;

public class RoundedPolygonShape {

	/**
	 * Initializes this object to store the given ShapeGroup reference (or null) and the given RoundedPolygon reference.
	 * 
	 */
	public RoundedPolygonShape(ShapeGroup parent, RoundedPolygon polygon) {
			
	}
	
	/**
	 * Returns the RoundedPolygon reference stored by this object.
	 * @Immutable
	 * Any two calls of this method on the same target object return equal values.
	 * 
	 */
	public RoundedPolygon getPolygon() {
		return new RoundedPolygon();
	}
	
	/**
	 * Returns whether this polygon contains this point, given in shape coordinates.
	 * Specified by:
	 * contains in interface Shape
	 */
	public boolean contains() {
		return true;
	}
	
	/**
	 * Returns this polygon's drawing commands.
	 * Specified by:
	 * getDrawingCommands in interface Shape
	 * 
	 */
	public String getDrawingCommands() {
		return "Not yet implemented";
	}
	
	/**
	 * Returns one control point for each of this polygon's vertices. If, after calling this method, a client mutates
	 * either the polygon or the shape group graph referenced by this object, it shall no longer call any methods on the
	 * returned ControlPoint objects. That is, any mutation of the polygon or the shape group graph referenced by this 
	 * object invalidates the ControlPoint objects returned by any preceding createControlPoints call. This is true even 
	 * if the mutation occurred through the returned ControlPoint objects themselves. For example, after calling move on
	 * ne of the returned ControlPoint objects, a client is no longer allowed to call getLocation or remove on any of 
	 * the returned ControlPoint objects, and after calling remove on one of the returned ControlPoint objects, a client 
	 * is no longer allowed to call getLocation or move on any of the returned ControlPoint objects. 
	 * There is one exception: a client can perform any number of consecutive move calls on the same ControlPoint object.
	 * 
	 * Specified by:
	 * createControlPoints in interface Shape
	 * 
	 * @creates This method creates the returned array, as well as its elements.
	 * 
	 */
	public ControlPoint[] createControlPoints() {
		throw new IllegalArgumentException("inot yet implemented");
	}
	
	/**
	 * 
	 * Given the coordinates of a point in the global coordinate system, returns the coordinates of the point in the shape coordinate system.
	 * 
	 * Specified by:
	 * toGlobalCoordinates in interface Shape
	 */
	public IntPoint toShapeCoordinates(IntPoint p) {
		return new IntPoint(0,0);
	}
	
	/**
	 * Given the coordinates of a point in the shape coordinate system, returns the coordinates of the point in the global coordinate system.
	 * Specified by:
	 * toGlobalCoordinates in interface Shape
	 */
	public IntPoint toGlobalCoordinates(IntPoint p) {
		return new IntPoint(0,0);
	}
}
