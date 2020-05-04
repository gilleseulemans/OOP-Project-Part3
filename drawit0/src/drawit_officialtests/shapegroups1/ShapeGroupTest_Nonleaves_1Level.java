package drawit_officialtests.shapegroups1;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import drawit.IntPoint;
import drawit.IntVector;
import drawit.RoundedPolygon;
import drawit.shapegroups1.Extent;
import drawit.shapegroups1.ShapeGroup;

class ShapeGroupTest_Nonleaves_1Level {
	
	static IntPoint p(int x, int y) { return new IntPoint(x, y); }
	
	static IntPoint[] scale(int sx, int sy, IntPoint[] ps) {
		return Arrays.stream(ps).map(p -> new IntPoint(p.getX() * sx, p.getY() * sy)).toArray(n -> new IntPoint[n]);
	}
	
	static IntPoint[] translate(int dx, int dy, IntPoint[] ps) {
		IntVector v = new IntVector(dx, dy);
		return Arrays.stream(ps).map(p -> p.plus(v)).toArray(n -> new IntPoint[n]);
	}
	
	IntPoint[] triangleRight = {p(-1, -1), p(-1, 1), p(1, 0)};
	IntPoint[] diamond = {p(-1, 0), p(0, -1), p(1, 0), p(0, 1)};
	IntPoint[] pentagon = {p(-1, -1), p(-2, 0), p(0, 1), p(2, 0), p(1, -1)};
	
	IntPoint[] vertices1 = translate(400, 250, scale(10, 10, triangleRight));
	RoundedPolygon poly1 = new RoundedPolygon();
	{
		poly1.setVertices(vertices1);
	}
	ShapeGroup leaf1 = new ShapeGroup(poly1);
	{
		//assertEquals(390, 240, 20, 20, leaf1.getOriginalExtent());
		leaf1.setExtent(Extent.ofLeftTopWidthHeight(400, 255, 30, 10));
		// scale by 3/2, 1/2
		// translate by 10, 15
	}
	
	IntPoint[] vertices2 = translate(400, 250, scale(5, 20, diamond));
	RoundedPolygon poly2 = new RoundedPolygon();
	{
		poly2.setVertices(vertices2);
	}
	ShapeGroup leaf2 = new ShapeGroup(poly2);
	{
		//assertEquals(395, 230, 10, 40, leaf2.getOriginalExtent());
		leaf2.setExtent(Extent.ofLeftTopWidthHeight(390, 235, 20, 40));
		// scale by 2, 1
		// translate by -5, 5
	}
	
	IntPoint[] vertices3 = translate(400, 250, scale(10, 5, pentagon));
	RoundedPolygon poly3 = new RoundedPolygon();
	{
		poly3.setVertices(vertices3);
	}
	ShapeGroup leaf3 = new ShapeGroup(poly3);
	{
		//assertEquals(380, 245, 40, 10, leaf3.getOriginalExtent());
		leaf3.setExtent(Extent.ofLeftTopWidthHeight(380, 245, 16, 20));
		// scale by 2/5, 2
		// translate by 0, 0
	}
	
	ShapeGroup group1 = new ShapeGroup(new ShapeGroup[] {leaf1, leaf2, leaf3});
	
	IntPoint[] vertices4 = translate(200, 100, scale(-5, 5, triangleRight));
	RoundedPolygon poly4 = new RoundedPolygon();
	{
		poly4.setVertices(vertices4);
	}
	ShapeGroup leaf4 = new ShapeGroup(poly4);
	
	IntPoint[] vertices5 = translate(200, 200, scale(10, -10, pentagon));
	RoundedPolygon poly5 = new RoundedPolygon();
	{
		poly5.setVertices(vertices5);
	}
	ShapeGroup leaf5 = new ShapeGroup(poly5);
	
	ShapeGroup group2 = new ShapeGroup(new ShapeGroup[] {leaf4, leaf5});
	
	static void assertEquals(int left, int top, int width, int height, Extent actual) {
		assert actual.getLeft() == left;
		assert actual.getTop() == top;
		assert actual.getWidth() == width;
		assert actual.getHeight() == height;
	}
	
	static void assertEquals(int x, int y, IntPoint p) {
		assert p.getX() == x;
		assert p.getY() == y;
	}
	
	static void assertEquals(int x, int y, IntVector v) {
		assert v.getX() == x;
		assert v.getY() == y;
	}
	
	@Test
	void testGetShape() {
		assert leaf1.getShape() == poly1;
		assert leaf2.getShape() == poly2;
		assert leaf3.getShape() == poly3;
		assert group1.getShape() == null;
		assert group2.getShape() == null;
	}
	
	@Test
	void testGetOriginalExtent() {
		assertEquals(390, 240, 20, 20, leaf1.getOriginalExtent());
		assertEquals(395, 230, 10, 40, leaf2.getOriginalExtent());
		assertEquals(380, 245, 40, 10, leaf3.getOriginalExtent());

		assertEquals(380, 235, 50, 40, group1.getOriginalExtent());
		
		assertEquals(195, 95, 10, 10, leaf4.getOriginalExtent());
		assertEquals(180, 190, 40, 20, leaf5.getOriginalExtent());
		
		assertEquals(180, 95, 40, 115, group2.getOriginalExtent());
	}
	
	@Test
	void testGetExtent() {
		assertEquals(400, 255, 30, 10, leaf1.getExtent());
		assertEquals(390, 235, 20, 40, leaf2.getExtent());
		assertEquals(380, 245, 16, 20, leaf3.getExtent());
		
		assertEquals(380, 235, 50, 40, group1.getExtent());
		
		assertEquals(195, 95, 10, 10, leaf4.getExtent());
		assertEquals(180, 190, 40, 20, leaf5.getExtent());
		
		assertEquals(180, 95, 40, 115, group2.getExtent());
	}
	
	@Test
	void testGetParentGroup() {
		assert leaf1.getParentGroup() == group1;
		assert leaf2.getParentGroup() == group1;
		assert leaf3.getParentGroup() == group1;
		assert group1.getParentGroup() == null;
		
		assert leaf4.getParentGroup() == group2;
		assert leaf5.getParentGroup() == group2;
	}
	
	@Test
	void testGetSubgroups() {
		assert leaf1.getSubgroups() == null;
		assert leaf2.getSubgroups() == null;
		assert leaf3.getSubgroups() == null;
		assert List.of(leaf1, leaf2, leaf3).equals(group1.getSubgroups());
		assert leaf4.getSubgroups() == null;
		assert leaf5.getSubgroups() == null;
		assert List.of(leaf4, leaf5).equals(group2.getSubgroups());
	}
	
	@Test
	void testGetSubgroupCount() {
		assert group1.getSubgroupCount() == 3;
		assert group2.getSubgroupCount() == 2;
	}
	
	@Test
	void testGetSubgroup() {
		assert group1.getSubgroup(0) == leaf1;
		assert group1.getSubgroup(1) == leaf2;
		assert group1.getSubgroup(2) == leaf3;
		assert group2.getSubgroup(0) == leaf4;
		assert group2.getSubgroup(1) == leaf5;
	}
	
	@Test
	void testGetSubgroupAt() {
		assert group1.getSubgroupAt(new IntPoint(429, 260)) == leaf1;
		assert group1.getSubgroupAt(new IntPoint(395, 237)) == leaf2;
		assert group1.getSubgroupAt(new IntPoint(385, 250)) == leaf3;
		assert group1.getSubgroupAt(new IntPoint(431, 250)) == null;
	}
	
	@Test
	void testBringToFront1() {
		leaf1.bringToFront();
		assert List.of(leaf1, leaf2, leaf3).equals(group1.getSubgroups());
		leaf1.bringToFront();
		assert List.of(leaf1, leaf2, leaf3).equals(group1.getSubgroups());
		leaf2.bringToFront();
		assert List.of(leaf2, leaf1, leaf3).equals(group1.getSubgroups());
		leaf1.bringToFront();
		assert List.of(leaf1, leaf2, leaf3).equals(group1.getSubgroups());
		leaf3.bringToFront();
		assert List.of(leaf3, leaf1, leaf2).equals(group1.getSubgroups());
		leaf3.bringToFront();
		assert List.of(leaf3, leaf1, leaf2).equals(group1.getSubgroups());
		leaf2.bringToFront();
		assert List.of(leaf2, leaf3, leaf1).equals(group1.getSubgroups());
	}
	
	@Test
	void testBringToFront2() {
		leaf4.bringToFront();
		assert List.of(leaf4, leaf5).equals(group2.getSubgroups());
		leaf4.bringToFront();
		assert List.of(leaf4, leaf5).equals(group2.getSubgroups());
		leaf5.bringToFront();
		assert List.of(leaf5, leaf4).equals(group2.getSubgroups());
		leaf5.bringToFront();
		assert List.of(leaf5, leaf4).equals(group2.getSubgroups());
		leaf4.bringToFront();
		assert List.of(leaf4, leaf5).equals(group2.getSubgroups());
	}
	
	@Test
	void testSendToBack1() {
		leaf1.sendToBack();
		assert List.of(leaf2, leaf3, leaf1).equals(group1.getSubgroups());
		leaf1.sendToBack();
		assert List.of(leaf2, leaf3, leaf1).equals(group1.getSubgroups());
		leaf3.sendToBack();
		assert List.of(leaf2, leaf1, leaf3).equals(group1.getSubgroups());
		leaf1.sendToBack();
		assert List.of(leaf2, leaf3, leaf1).equals(group1.getSubgroups());
	}
	
	@Test
	void testSendToBack2() {
		leaf4.sendToBack();
		assert List.of(leaf5, leaf4).equals(group2.getSubgroups());
		leaf4.sendToBack();
		assert List.of(leaf5, leaf4).equals(group2.getSubgroups());
		leaf5.sendToBack();
		assert List.of(leaf4, leaf5).equals(group2.getSubgroups());
	}
	
	@Test
	void testSendToBack_bringToFront() {
		leaf1.sendToBack();
		assert List.of(leaf2, leaf3, leaf1).equals(group1.getSubgroups());
		leaf3.bringToFront();
		assert List.of(leaf3, leaf2, leaf1).equals(group1.getSubgroups());
	}
	
	@Test
	void testToInnerCoordinates_IntPoint() {
		assertEquals(392, 242, leaf1.toInnerCoordinates(new IntPoint(403, 256)));
		assertEquals(393, 225, leaf2.toInnerCoordinates(new IntPoint(386, 230)));
		assertEquals(430, 240, leaf3.toInnerCoordinates(new IntPoint(400, 235)));
		assertEquals(123, 456, group1.toInnerCoordinates(new IntPoint(123, 456)));
		assertEquals(123, 456, group2.toInnerCoordinates(new IntPoint(123, 456)));
	}
	
	@Test
	void testToGlobalCoordinates() {
		assertEquals(403, 256, leaf1.toGlobalCoordinates(new IntPoint(392, 242)));
		assertEquals(388, 234, leaf2.toGlobalCoordinates(new IntPoint(394, 229)));
		assertEquals(360, 265, leaf3.toGlobalCoordinates(new IntPoint(330, 255)));
		assertEquals(123, 456, group1.toGlobalCoordinates(new IntPoint(123, 456)));
	}
	
	@Test
	void testToInnerCoordinates_IntVector() {
		assertEquals(2, -2, leaf1.toInnerCoordinates(new IntVector(3, -1)));
		assertEquals(-10, 0, leaf2.toInnerCoordinates(new IntVector(-20, 0)));
		assertEquals(40, 7, leaf3.toInnerCoordinates(new IntVector(16, 14)));
		assertEquals(123, 456, group1.toInnerCoordinates(new IntVector(123, 456)));
	}
}
