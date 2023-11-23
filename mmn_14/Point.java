
/**
 * This class represents a point object in the first quadrant of a Cartesian coordinate system.
 *
 * @author yehonatanke
 * @version 2023
 */
public class Point
{
    private int _x;
    private int _y;
    private final int DEFAULT_VAL = 0;

    /**
     * Construct a point.
     * If one of the parameters is negative, then it should be initialized to zero.
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public Point(int x, int y)
    {
        _x = (x > DEFAULT_VAL) ? x : DEFAULT_VAL;
        _y = (y > DEFAULT_VAL) ? y : DEFAULT_VAL;
    }

    /**
     * Copy constructor for Point.
     * construct a point with the same coordinates as other point.
     * @param other The point object from which to construct the new point.
     */

    public Point(Point other)
    {
        _x = other._x;
        _y = other._y;
    }

    /**
     * Returns the x coordinate of the point.
     * @return The x coordinate of the point.
     */
    public int getX()
    {
        return _x;
    }

    /**
     * Returns the y coordinate of the point.
     * @return The y coordinate of the point.
     */
    public int getY()
    {
        return _y;
    }

    /**
     * Sets the x coordinate of the point.
     * If a negative number is recieved then the x coordinate does not change.
     * @param x The new x coordinate.
     */
    public void setX(int x)
    {
        if (x >= DEFAULT_VAL)
            _x = x;
    }

    /**
     * Sets the y coordinate of the point.
     * If a negative number is received, then the y coordinate does not change.
     * @param y The new y coordinate.
     */
    public void setY(int y)
    {
        if (y >= DEFAULT_VAL)
            _y = y;
    }

    /**
     * Returns a string representation of this point.
     * @return String representation of this point.
     */
    public String toString()
    {
        return "(" + _x + "," + _y + ")";
    }

    /**
     * Check if this point equals other point.
     * @param other The point to be compared with this point
     * @return true if this point equals other point
     */
    public boolean equals(Point other)
    {
        return (other._x == _x && other._y == _y);
    }

    /**
     * Check if this point is above other point.
     * @param other The point to be compared with this point
     * @return true if this point is above other point
     */
    public boolean isAbove(Point other)
    {
        return other._y < _y;
    }

    /**
     * Check if this point is under other point.
     * @param other The point to be compared with this point
     * @return true if this point is under other point
     */
    public boolean isUnder(Point other)
    {
        return other.isAbove(this);
    }

    /**
     * Check if this point is to the left of other point.
     * @param other The point to check if this point is left of
     * @return true if this point is to be the left of other point
     */
    public boolean isLeft(Point other)
    {
        return _x < other._x;
    }

    /**
     * Check if this point is to the right of other point.
     * @param other The point to check if this point is right of
     * @return true if this point is to be the right of other point
     */
    public boolean isRight(Point other)
    {
        return other.isLeft(this);
    }

    /**
     * Return a new point in between this point and the received point.
     * @param p The point to calculate the middle point from
     * @return The middle point between this and p points
     */
    public Point middle(Point p)
    {
        return new Point(((_x + p._x)/2), ((_y + p._y)/2));
    }

    /**
     * Calculate the distance between this point and other point.
     * @param p The point to calculate the distance from
     * @return The distance between this and p points
     */
    public double distance(Point p)
    {
        return Math.sqrt(Math.pow((_x - p._x),2) + Math.pow((_y - p._y),2));
    }

    /**
     * Moves the x coordinate by deltaX and the y coordinate by deltaY.
     * If movement moves the point outside the first quadrant, then the
     * point will remain at the same place and not move.
     * @param deltaX The amount to move in the x direction
     * @param deltaY The amount to move in the y direction
     */
    public void move(int deltaX, int deltaY)
    {
        if ((_x + deltaX >= 0) && (_y + deltaY) >= 0){
            setX(_x + deltaX);
            setY(_y + deltaY);
        }
    }

}
