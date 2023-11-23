
/**
 * This class represents a city node
 *
 * @author yehonatanke
 * @version 2023
 */
public class CityNode
{
    private City _city;
    private CityNode _next;

    /**
     * Constructor for class CityNode. Constructs a new node with the "City" variable is initialized
     * according to the given input, and the "Next" variable is initialized to null
     * @param city The new node's city
     */
    public CityNode (City city)
    {
        _city = new City(city);
        _next = null;
    }

    /**
     * Constructor for CityNode.
     * Constructs a new node with the "City" and "Next"
     * variables is initialized according to the given input
     * @param city The node's city
     * @param next The node's next city
     */
    public CityNode (City city, CityNode next)
    {
        _city = new City(city);
        _next = next;
    }

    /**
     * Copy constructor for CityNode.
     * Construct a CityNode with the same attributes as another CityNode.
     * @param city The CityNode object from which to construct the new CityNode.
     */
    public CityNode (CityNode city)
    {
        _city = new City(city._city);
        _next = city._next;
    }

    // methods

    /**
     * Returns a copy of the city in the object
     * @return The copy of the object's city
     */
    public City getCity()
    {
        return new City(_city);
    }

    /**
     * Returns a pointer to the next city
     * @return A pointer to the next city
     */
    public CityNode getNext()
    {
        return _next;
    }

    /**
     * Changes the node's city
     * @param city The new city
     */
    public void setCity(City city)
    {
        _city = new City(city);
    }

    /**
     * Changes the node's pointer
     * @param nextNode The
     */
    public void setNext(CityNode nextNode)
    {
        _next = nextNode;
    }

    /**
     * Returns the city name
     * @return The city name
     */
    public String getCityName()
    {
        return _city.getCityName();
    }
}
