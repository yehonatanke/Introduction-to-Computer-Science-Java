
/**
 * This class represents a Country (list of cities)
 *
 * @author yehonatanke
 * @version 2023
 */
public class Country {
    CityNode _head;
    private String _countryName;

    /**
     * A constructor that accepts a string of the country name and creates an empty country
     *
     * @param countryName The country name
     */
    public Country (String countryName) {
        _countryName = countryName;
    }

    /**
     * Constructs a new city with name, specified establishment date,
     * x y coordinates of a city center, x y coordinates of central station, number of residents (non-negative,
     * if negative will be set to 0), number of neighborhoods (positive, if less than 1 will be set to 1).
     * The new city will be inserted so that the list will always be sorted by the founding date of
     * the city in ascending order. If there is a city in the list with the same founding date as the
     * new city, the city that will be closer to the beginning of the list is the one whose name will appear
     * lexicographically before the name of the second city.
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
     * @return true if the city does not already exist, and the city has successfully added to the list
     */
    public boolean addCity (String cityName, int establishmentDay, int establishmentMonth,
                            int establishmentYear, int cityCenterXCoordinate, int cityCenterYCoordinate,
                            int centralStationXCoordinate, int centralStationYCoordinate, long numOfResidents,
                            int numOfNeighborhoods) {
        if (!cityExist(cityName))
            return false;

        // initialize a new city
        City newCity = new City(cityName, establishmentDay, establishmentMonth, establishmentYear,
                cityCenterXCoordinate, cityCenterYCoordinate, centralStationXCoordinate,
                centralStationYCoordinate, numOfResidents, numOfNeighborhoods);

        CityNode node = new CityNode(newCity);
        addByOrder(node, establishmentDay, establishmentMonth, establishmentYear);
        return true;

    }

    /**
     * Checks if a city is already exist in country
     *
     * @param cityName is the name of the city that is being checked if it already exists in the list
     * @return true if the city doesn't exist in the list
     */
    public boolean cityExist (String cityName) {
        if (empty())
            return true;
        return cityExist(cityName, _head);
    }

    private boolean cityExist (String cityName, CityNode curr) {
        if (curr == null)
            return true;

        if (curr.getCityName().compareTo(cityName) == 0)
            return false;

        return cityExist(cityName, curr.getNext());
    }

    /**
     * The method adds a city to the list in order of date of establishment.
     * If the date of establishment is the same, the previous city will be the
     * city named first in lexicographic order.
     *
     * @param theNewCity  The new CityNode adding to the list
     * @param day         The day of establishment of CityNode's city
     * @param month       The month of establishment of CityNode's city
     * @param year        The year of establishment of CityNode's city
     */
    private void addByOrder (CityNode theNewCity, int day, int month, int year) {
        if (empty()) {
            _head = theNewCity;
            return;
        }

        // temporary assistance variable
        CityNode curr = _head;

        // check if the two cities date establishment is equal when curr==_head
        if (theNewCity.getCity().establishmentDateDiff(curr.getCity()) == 0) {
            if (theNewCity.getCity().getCityName().compareTo(curr.getCity().getCityName()) < 0) {
                theNewCity.setNext(curr);
                _head = theNewCity;
                return;
            }
            theNewCity.setNext(curr.getNext());
            curr.setNext(theNewCity);
            return;
        }

        // check which city establishment day is sooner when curr==_head
        if (theNewCity.getCity().getDateEstablished().before(curr.getCity().getDateEstablished())) {
            // theNewCity city establishment day is before _head establishment day
            theNewCity.setNext(curr);
            _head = theNewCity;
            return;
        }

        while (curr.getNext() != null) {
            // the two cities establishment date is equal
            if (theNewCity.getCity().establishmentDateDiff(curr.getNext().getCity()) == 0) {
                // Checking which city appears before the other by lexicographically order
                if (theNewCity.getCity().getCityName().compareTo(curr.getNext().getCity().getCityName()) < 0) {
                    // theNewCity city name is sooner than next curr city name
                    theNewCity.setNext(curr.getNext());
                    curr.setNext(theNewCity);
                    return;
                }
                // next curr city name is sooner than theNewCity city name
                theNewCity.setNext(curr.getNext().getNext());
                curr.getNext().setNext(theNewCity);
                return;
            }
            // check which city establishment day is sooner
            if (theNewCity.getCity().getDateEstablished().before(curr.getNext().getCity().getDateEstablished())) {
                // theNewCity city establishment day is before next curr establishment day
                theNewCity.setNext(curr.getNext());
                curr.setNext(theNewCity);
                return;
            }
            curr = curr.getNext();
        }

        // if reach the end of the loop without return than theNewCity is the last in the country list
        curr.setNext(theNewCity);
        return;
    }

    /**
     * Check if the list is empty
     *
     * @return true if the list is empty
     */
    public boolean empty () {
        return _head == null;
    }

    /**
     * Checks the total number of the residents of the country.
     *
     * @return the total number of the residents of the country.
     */
    public long getNumOfResidents () {
        if (empty())
            return 0;

        return getNumOfResidents(_head);
    }

    private long getNumOfResidents (CityNode curr) {
        if (curr.getNext() == null)
            return curr.getCity().getNumOfResidents();
        return curr.getCity().getNumOfResidents() + getNumOfResidents(curr.getNext());
    }

    /**
     * Check the number of countries that in the list
     *
     * @return the number of countries that in the list (the length of the list)
     */
    public int getNumOfCities () {
        CityNode temp = _head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    /**
     * Check What is the greatest distance between two cities in the country.
     *
     * @return the greatest distance between two cities in the country
     */
    public double longestDistance () {
        if (getNumOfCities() < 2)
            return 0;

        return longestDistance(_head, _head.getNext(), 0);
    }

    private double longestDistance (CityNode node1, CityNode node2, double maxDis) {
        maxDis = node1.getCity().getCityCenter().distance(node2.getCity().getCityCenter());

        if (node1.getNext() != null && node2.getNext() == null) {
            double tempDis = Math.max(maxDis, longestDistance(node1.getNext(), node2, maxDis));
            maxDis = Math.max(maxDis, tempDis);
        }

        if (node1.getNext() == null && node2.getNext() != null) {
            double tempDis = Math.max(maxDis, longestDistance(node1, node2.getNext(), maxDis));
            maxDis = Math.max(maxDis, tempDis);
        }

        if (node1.getNext() != null && node2.getNext() != null) {
            double tempDis = Math.max(maxDis, longestDistance(node1, node2.getNext(), maxDis));
            double tempDis2 = Math.max(maxDis, longestDistance(node1.getNext(), node2, maxDis));

            maxDis = Math.max(maxDis, Math.max(tempDis, tempDis2));
        }

        return maxDis;
    }

    /**
     * Check the number of cities in the country that are north of the parameter city.
     * If the city name is not found in the country, the value -1 will be returned.
     * If there are no cities north of the requested city, the value 0 will be returned.
     *
     * @param cityName The name of the city that is checked for how many cities are north of it
     * @return the number of cities in the country that are north of the parameter city
     */
    public int numCitiesNorthOf (String cityName) {
        if (cityExist(cityName) || empty()) // check if the city exist in the country
            return -1;

        City southCity = findCity(cityName);                      // finding the city given as a parameter
        assert southCity != null;
        Point southPoint = new Point(southCity.getCityCenter());  // the point of the city center of the parameter-city

        return numCitiesNorthOf(southPoint, _head);
    }

    private int numCitiesNorthOf (Point southPoint, CityNode northCity) {
        if (northCity == null)
            return 0;

        if (northCity.getCity().getCityCenter().isAbove(southPoint))
            return 1 + numCitiesNorthOf(southPoint, northCity.getNext()); // northCity is northerner than southPoint

        return numCitiesNorthOf(southPoint, northCity.getNext());         // northCity is not northerner than southPoint
    }

    /**
     * Find a city in the list
     * Attention ! the cityName must be on the list - otherwise it will be no value to return !
     *
     * @param cityName The name of the city that we search
     * @return the city that has been searched
     */
    private City findCity (String cityName) {
        CityNode temp = _head;
        while (temp != null) {
            if (temp.getCity().getCityName().compareTo(cityName) == 0) // found the city
            {
                return temp.getCity();
            }
            temp = temp.getNext();
        }
        return null;
    }

    /**
     * check who is the southernmost city in the country.
     * If there is more than one city that is the southernmost, the one with the earlier founding date will be returned.
     * return the southernmost country
     */
    public City southernmostCity () {
        if (empty())
            return null;

        CityNode temp = _head;
        City southest = _head.getCity();

        while (temp != null) {
            // check if cities city centers are equal
            if (!(temp.getCity().getCityCenter().isAbove(southest.getCityCenter()))) // temp is not southern than "southest"
            {
                if (!(southest.getCityCenter().isAbove(temp.getCity().getCityCenter()))) // temp and "southest"
                {
                    if (southest.getDateEstablished().after(temp.getCity().getDateEstablished()))  // temp establish date is not after southest establish date
                    {
                        southest = temp.getCity();
                    }
                }
            }
            // check if southest is southern than temp
            if (southest.getCityCenter().isAbove(temp.getCity().getCityCenter())) // temp is southern than southern
                southest = temp.getCity();
            temp = temp.getNext();
        }
        return southest;
    }

    /**
     * Returns the country name
     *
     * @return The country name
     */
    public String getCountryName () {
        return _countryName;
    }

    /**
     * The method checks whether any city was founded just before the earliest of the dates or just after the latest.
     *
     * @param date1 One of the dates
     * @param date2 One of the dates
     *              return true if there is a city founded just before the earlier of the dates or just after the later of them
     */
    public boolean wereCitiesEstablishedBeforeOrAfter (Date date1, Date date2) {
        if (empty())
            return false;

        if (date1.before(date2))                // calling recursion while left date is sooner than the right date
            return wereCitiesEstablishedBeforeOrAfter(date1, date2, _head) > 0;
        return wereCitiesEstablishedBeforeOrAfter(date2, date1, _head) > 0;
    }

    private int wereCitiesEstablishedBeforeOrAfter (Date soonDate, Date lateDate, CityNode node) {
        if (node == null)
            return 0;

        if (node.getCity().getDateEstablished().before(soonDate) || node.getCity().getDateEstablished().after(lateDate)) {
            // the city established between the two dates (include)
            return 1;
        }
        return wereCitiesEstablishedBeforeOrAfter(soonDate, lateDate, node.getNext());

    }

    /**
     * The method performs a union between cities
     * The date of the establishment of the city will be the earlier of the two dates of the establishment of the two cities
     * The number of residents in the joint city is the sum of the numbers of residents
     * The number of neighborhoods in the joint city is the sum of the numbers of neighborhoods
     * The location of the new city center is halfway between the two city centers
     * The location of the shared central station is in the western station of the two
     * The young city will be removed from the list
     * If the two central stations have the same x, choose that of the younger city.
     *
     * @param cityName1 The first city name
     * @param cityName2 The second city name
     * @return the unify city
     */
    public City unifyCities (String cityName1, String cityName2) {
        City city1 = findCity(cityName1);
        City city2 = findCity(cityName2);
        City tempCity = findCity(cityName1);

        assert city2 != null;
        assert city1 != null;
        if (isOlderCity(city2, city1))    // defining city1 as the old city
        {
            tempCity = city1;
            city1 = city2;
            city2 = tempCity;
        }

        // defining the values of the unify city
        String newName = city1.getCityName() + "-" + city2.getCityName();
        long newNumOfResidents = city1.getNumOfResidents() + city2.getNumOfResidents();
        int newNumOfNeighborhoods = city1.getNumOfNeighborhoods() + city2.getNumOfNeighborhoods();
        Point newCityCenter = city1.getCityCenter().middle(city2.getCityCenter());
        Point newCentralStation;
        if (city1.getCentralStation().isLeft(city2.getCentralStation())) {
            newCentralStation = city1.getCentralStation();
        } else {
            newCentralStation = city2.getCentralStation();
        }

        //setting a new City with new parameters
        City theUnifyCity = new City(city1);
        theUnifyCity.setCityName(newName);
        theUnifyCity.setCityCenter(newCityCenter);
        theUnifyCity.setCentralStation(newCentralStation);
        theUnifyCity.setNumOfResidents(newNumOfResidents);
        theUnifyCity.setNumOfNeighborhoods(newNumOfNeighborhoods);

        // removing the young city
        removeCity(city2.getCityName());

        // change the old city values
        CityNode temp = _head;
        while (temp != null) {
            if (temp.getCity().getCityName().compareTo(cityName1) == 0) // finding the old city
            {
                temp.setCity(theUnifyCity);
                return temp.getCity();
            }
            temp = temp.getNext();
        }
        return temp.getCity();
    }

    /**
     * Check who is the older city between two cities
     *
     * @return true if city1 established before city2
     */
    private static boolean isOlderCity (City city1, City city2) {
        return city1.getDateEstablished().before(city2.getDateEstablished());
    }

    /**
     * Remove city from country
     *
     * @param removeCity The city need to be removed
     */
    private void removeCity (String removeCity) {
        if (empty())
            return;

        if (_head.getCity().getCityName().compareTo(removeCity) == 0)
            _head = _head.getNext();

        CityNode curr = _head;
        while (curr.getNext() != null) {
            if (curr.getCity().getCityName().compareTo(removeCity) == 0) // finding the city that need to be removed
            {
                curr.setNext(curr.getNext().getNext());                 // remove the city
                return;
            }
            curr = curr.getNext();
        }
    }

    /**
     * The method returns the largest difference in days between the founding dates of any two cities in the country.
     * return the largest difference in days between the founding dates of any two cities in the country
     */
    public int establishMaxDiff () {
        if (empty())
            return -1;

        if (getNumOfCities() == 1)
            return 0;

        Date youngest = youngestCityDate();
        Date oldest = oldestCityDate();
        return oldest.difference(youngest);
    }

    // The method returns the date of establishment of the city with the earliest establishment date in the country
    // The list cannot be empty for this method
    private Date youngestCityDate () {
        Date earliest = _head.getCity().getDateEstablished();
        CityNode temp = _head;
        while (temp != null) {
            if (temp.getCity().getDateEstablished().before(earliest)) {
                earliest = temp.getCity().getDateEstablished();
            }
            temp = temp.getNext();
        }
        return earliest;
    }

    // The method returns the date of establishment of the city with the oldest establishment date in the country
    // The list cannot be empty for this method
    private Date oldestCityDate () {
        Date oldest = _head.getCity().getDateEstablished();
        CityNode temp = _head;
        while (temp != null) {
            if (temp.getCity().getDateEstablished().after(oldest)) {
                oldest = temp.getCity().getDateEstablished();
            }
            temp = temp.getNext();
        }
        return oldest;
    }

    /**
     * Return a string representation of this country.
     * return String representation of this country
     */
    public String toString () {
        if (empty())
            return "There are no cities in this country";

        CityNode temp = _head;
        String s = "Cities of " + getCountryName() + ";";
        while (temp != null) {
            s += "\n\n" + temp.getCity().toString();
            temp = temp.getNext();
        }
        return s;
    }

}
