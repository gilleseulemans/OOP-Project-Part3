package drawit.shapes2;

import drawit.IntPoint;
import drawit.shapegroups2.*;
public class ShapeGroupShape {

	/**
	 * Initializes this object to store the given ShapeGroup reference.	
	 * 
	 */
	public ShapeGroupShape(ShapeGroup group) {
		
	}
	
	/**
	 * Returns the ShapeGroup reference stored by this object.
	 * Immutable
	 * Any two calls of this method on the same target object return equal values.
	 * 
	 */
	public ShapeGroup getShapeGroup() {
		throw new IllegalArgumentException("not yet implemented");
		
	}
	
	/**
	* Returns this shape group's parent, or null if it has no parent.
	* Specified by:
	* getParent in interface Shape
	* Immutable
	* Any two calls of this method on the same target object return equal values.
	* 
	*/
	public ShapeGroup getParent() {
		throw new IllegalArgumentException("not yet implemented");
	}
	
	/**
	 * Returns whether this shape group's extent contains the given point, expressed in shape coordinates.
	 * Specified by:
	 * contains in interface Shape
	 * 
	 */
	public boolean contains() {
		throw new IllegalArgumentException("not yet implemented");
	}
	
	/**
	 * Returns this shape group's drawing commands.
	 * Specified by:
	 * getDrawingCommands in interface Shape
	 * 
	 */
	public String getDrawingCommands() {
		throw new IllegalArgumentException("not yet implemented");
	}
	
	/**
	 * Returns one control point for this shape group's 
	 * upper-left corner, and one control point for its lower-right corner. If, after calling this method, 
	 * a client mutates the shape group graph referenced by this object, it shall no longer call any methods 
	 * on the returned ControlPoint objects. That is, any mutation of the shape group graph referenced by this
	 *  object invalidates the ControlPoint objects returned by any preceding createControlPoints call. This is 
	 *  true even if the mutation occurred through the returned ControlPoint objects themselves. For example, 
	 *  after calling move on one of the returned ControlPoint objects, a client is no longer allowed to call 
	 *  getLocation or remove on any of the returned ControlPoint objects, and after calling remove on one of 
	 *  the returned ControlPoint objects, a client is no longer allowed to call getLocation or move on any 
	 *  of the returned ControlPoint objects. There is one exception: a client can perform any number of 
	 *  consecutive move calls on the same ControlPoint object.
	 * Specified by:
	 * createControlPoints in interface Shape
	 * @Creates
	 * This method creates the returned array, as well as its elements.
	 * 
	 */
	public ControlPoint[] createControlPoints() {
		throw new IllegalArgumentException("not yet implemnted");
	}
	
	/**
	 * Given the coordinates of a point in the global coordinate system, returns the coordinates of the point in the shape coordinate system.
	 * Specified by:
	 * toShapeCoordinates in interface Shape
	 */
	public IntPoint toShapeCoordinates(IntPoint p) {
		throw new IllegalArgumentException("not yet implemented");
	}
	
	/**
	 * Given the coordinates of a point in the shape coordinate system, returns the coordinates of the point in the global coordinate system.
	 * Specified by:
	 * toGlobalCoordinates in interface Shape
	 * 
	 */
	public IntPoint toGlobalCoordinates(IntPoint p) {
		throw new IllegalArgumentException("not yet implemented");
	}
	
}