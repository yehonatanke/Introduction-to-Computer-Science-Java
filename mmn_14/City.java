
/**
 * Represents a city. City is represented by its name, the date it was established, center,
 * central station, number of residents (non-negative) and number of neighborhoods(positive).
 *
 * @author yehonatanke
 * @version 2023
 */
public class City {
    private String _cityName;
    private Date _dateEstablished;
    private Point _cityCenter;
    private Point _centralStation;
    private long _numOfResidents;
    private int _numOfNeighborhoods;

    /**
     * Constructor of a city. Constructs a new city with name, specified establishment date,
     * x y coordinates of city center, x y coordinates of central station, number of residents (non-negative,
     * if negative will be set to 0), number of neighborhoods (positive, if less than 1 will be set to 1.).
     *
     * @param cityName                  The city's name
     * @param establishmentDay          The day the city was established
     * @param establishmentMonth        The month the city was established
     * @param establishmentYear         The year the city was established
     * @param cityCenterXCoordinate     The x coordinate of the city's center
     * @param cityCenterYCoordinate     The y coordinate of the city's center
     * @param centralStationXCoordinate The x coordinate of the city's central station
     * @param centralStationYCoordinate The y coordinate of the city's central station
     * @param numOfResidents            The number of residents
     * @param numOfNeighborhoods        The number of neighborhoods
     */
    public City (String cityName, int establishmentDay, int establishmentMonth, int establishmentYear,
                 int cityCenterXCoordinate, int cityCenterYCoordinate, int centralStationXCoordinate,
                 int centralStationYCoordinate,
                 long numOfResidents, int numOfNeighborhoods) {
        _cityName = cityName;
        _dateEstablished = new Date(establishmentDay, establishmentMonth, establishmentYear);
        _cityCenter = new Point(cityCenterXCoordinate, cityCenterYCoordinate);
        _centralStation = new Point(centralStationXCoordinate, centralStationYCoordinate);
        _numOfResidents = (numOfResidents > 0) ? numOfResidents : 0;
        _numOfNeighborhoods = (numOfNeighborhoods > 0) ? numOfNeighborhoods : 1;
    }

    /**
     * Constructor of a city. Constructs a new city with name, specified establishment date,
     * the point of the city center, the point of the central station, number of residents (non-negative,
     * if negative will be set to 0), number of neighborhoods (positive, if less than 1 will be set to 1.).
     *
     * @param cityName           The city's name
     * @param date               The date the city was established
     * @param cityCenter         The location (point) coordinate of the city's center
     * @param centralStation     The location (point) coordinate of the city's central station
     * @param numOfResidents     The number of residents
     * @param numOfNeighborhoods The number of neighborhoods
     */
    public City (String cityName, Date date, Point cityCenter, Point centralStation, int numOfResidents,
                 int numOfNeighborhoods) {
        _cityName = cityName;
        _dateEstablished = new Date(date);
        _cityCenter = new Point(cityCenter);
        _centralStation = new Point(centralStation);
        _numOfResidents = numOfResidents;
        _numOfNeighborhoods = numOfNeighborhoods;
    }

    /**
     * Copy constructor for cities. Construct a city with the same attributes as another city.
     *
     * @param other The City object from which to construct the new city.
     */
    public City (City other) {
        _cityName = other._cityName;
        _dateEstablished = new Date(other._dateEstablished);
        _cityCenter = new Point(other._cityCenter);
        _centralStation = new Point(other._centralStation);
        _numOfResidents = other._numOfResidents;
        _numOfNeighborhoods = other._numOfNeighborhoods;
    }


    /**
     * Returns the city's name.
     *
     * @return The city's name
     */
    public String getCityName () {
        return _cityName;
    }

    /**
     * Returns a Date object that represents the city's established Date.
     *
     * @return The city's established Date
     */
    public Date getDateEstablished () {
        return new Date(_dateEstablished);
    }

    /**
     * Returns a Point object representing the city's center.
     *
     * @return The city's center
     */
    public Point getCityCenter () {
        return new Point(_cityCenter);
    }

    /**
     * Returns a Point object representing the city's central station.
     *
     * @return The city's central station
     */
    public Point getCentralStation () {
        return new Point(_centralStation);
    }

    /**
     * Returns the number of residents in this city.
     *
     * @return The number of residents
     */
    public long getNumOfResidents () {
        return _numOfResidents;
    }

    /**
     * Returns the number of neighborhoods in this city.
     *
     * @return The number of neighborhoods
     */
    public int getNumOfNeighborhoods () {
        return _numOfNeighborhoods;
    }

    /**
     * Changes the city's name.
     *
     * @param cityName The city's new name
     */
    public void setCityName (String cityName) {
        _cityName = cityName;
    }

    /**
     * Changes the city's established date.
     *
     * @param dateEst The city's new establishedDate
     */
    public void setDateEstablished (Date dateEst) {
        _dateEstablished = new Date(dateEst);
    }

    /**
     * Changes the city's center location.
     *
     * @param cityCenter The city's new central point
     */
    public void setCityCenter (Point cityCenter) {
        _cityCenter = new Point(cityCenter);
    }

    /**
     * Changes the city's central station location.
     *
     * @param centralStation The city's new central station location
     */
    public void setCentralStation (Point centralStation) {
        _centralStation = new Point(centralStation);
    }

    /**
     * Changes the city's number of residents.
     * If a negative number is received, number of residents should not be changed.
     *
     * @param numOfResidents The city's new number of residents
     */
    public void setNumOfResidents (long numOfResidents) {
        if (numOfResidents >= 0)
            _numOfResidents = numOfResidents;
    }

    /**
     * Changes the city's number of neighborhoods.
     * If a non positive number is received, number of neighborhoods should not be changed.
     *
     * @param numOfNeighborhoods The city's new number of neighborhoods
     */
    public void setNumOfNeighborhoods (int numOfNeighborhoods) {
        if (numOfNeighborhoods > 0)
            _numOfNeighborhoods = numOfNeighborhoods;
    }

    /**
     * Return a string representation of this city.
     * return String representation of this city
     */
    public String toString () {
        return "City name: " + _cityName + "\nDate established: " +
                _dateEstablished.toString() + "\nCity center: " + _cityCenter +
                "\nCentral station: " + _centralStation + "\nNumber of residents: " +
                _numOfResidents + "\nNumber of neighborhoods: " + _numOfNeighborhoods;
    }

    /**
     * Check if two cities are the same (checking all six instace variables)
     *
     * @param other The city to compare to this city
     *              return true if the cities are the same
     */
    public boolean equals (City other) {
        return (_cityName.equals(other._cityName) && _dateEstablished.equals(other._dateEstablished) &&
                _cityCenter.equals(other._cityCenter) && _centralStation.equals(other._centralStation) &&
                _numOfResidents == other._numOfResidents && _numOfNeighborhoods == other._numOfNeighborhoods);
    }

    /**
     * Add or subtract residents to this city.
     * If number of residents becomes negative, set to zero and return false, otherwise set to new number and return true.
     *
     * @param residentsUpdate The change in the number of residents
     *                        return true if new number of residents is calculated as non negative
     */
    public boolean addResidents (long residentsUpdate) {
        _numOfResidents = (_numOfResidents + residentsUpdate);
        if (_numOfResidents < 0) {
            _numOfResidents = 0;
            return false;
        }
        return true;
    }

    /**
     * Move the central station location.
     * If the new coordinates are not in the first quadrant, the location will not be changed.
     *
     * @param deltaX The change in the station's x location
     * @param deltaY The change in the station's y location
     */
    public void moveCentralStation (int deltaX, int deltaY) {
        _centralStation.move(deltaX, deltaY);
    }

    /**
     * Calculate the distance between the city center and the central station.
     * return double representing the distance between the city center and the central station
     */
    public double distanceBetweenCenterAndStation () {
        return _cityCenter.distance(_centralStation);
    }

    /**
     * Returns a new city with a new name, established date which is a day after this city establish date
     * and a City center location dX and dY away from this city, with 0 residents and 1 neighborhood.
     * If the new location of the city center or of the central station is not in the first quadrant,
     * the locations will be the same as this city's locations.
     *
     * @param newCityName the new city's name
     * @param dX          the x difference from this city's location
     * @param dY          the y difference from this city's location
     *                    return a new city
     */
    public City newCity (String newCityName, int dX, int dY) {
        City theNewCity = new City(this);           //creating a copy of the city
        theNewCity.setCityName(newCityName);        //setting the name of the copy
        theNewCity.setDateEstablished(_dateEstablished.tomorrow());         //setting the establishment day of the copy
        theNewCity._cityCenter.move(dX, dY);        //setting the city center of the copy
        theNewCity.moveCentralStation(dX, dY);      //setting the central station of the copy
        theNewCity.setNumOfResidents(0);            //setting the number of residents of the copy
        theNewCity.setNumOfNeighborhoods(1);        //setting the number of neighborhoods of the copy

        return theNewCity;                          //returning the new city

        // return new City(newCityName, _dateEstablished.tomorrow(),
    }

    /**
     * Check if the city establish date is between two given dates (including these dates).
     * the given dates are not necessarily in order
     *
     * @param date1 the first given date
     * @param date2 the second given date
     *              return true if the city establish date is between the two given dates
     */
    public boolean cityEstablishedBetweenDates (Date date1, Date date2) {
        if (date1.equals(date2) && date1.equals(_dateEstablished)) {
            return true;
        }
        if (_dateEstablished.after(date1) && _dateEstablished.after(date2)) {
            return false;
        }
        return !_dateEstablished.before(date1) || !_dateEstablished.before(date2);
    }

    /**
     * This method calculates the difference in days between the establishment date
     * of this city and the city given as a parameter
     * other the city given as a parameter to find the difference
     * return the number of days differ between this city establishment date to the other city establishment date
     */
    public int establishmentDateDiff (City other) {
        return (_dateEstablished.difference(other._dateEstablished));
    }

}
