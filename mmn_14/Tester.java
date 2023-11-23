public class Tester {
    public static void main (String[] args) {
        // Testing Date class
        testDateConstructors();
        testDateSetters();
        testDateComparison();
        testDateCalculations();

        // Testing Point class
        testPointConstructors();
        testPointSetters();
        testPointComparisons();
        testPointCalculations();

        // Test Point class
        testPoint();

        // Test City class
        testCity();

        // Test Country class
        testCountry();

        // Test Date class
        testDate();

        // Test CityNode class
        testCityNode();
    }

    // Date Class Tests

    private static void testDateConstructors () {
        System.out.println("Testing Date Constructors:");

        // Test valid date
        Date date1 = new Date(15, 6, 2022);
        System.out.println("Date 1: " + date1.toString());

        // Test invalid date (should default to 1/1/2000)
        Date date2 = new Date(32, 13, 5000);
        System.out.println("Date 2: " + date2.toString());

        // Test copy constructor
        Date date3 = new Date(date1);
        System.out.println("Date 3 (copy of Date 1): " + date3.toString());

        System.out.println();
    }

    private static void testDateSetters () {
        System.out.println("Testing Date Setters:");

        Date date = new Date(1, 1, 2000);

        // Test valid day
        date.setDay(10);
        System.out.println("Set Day to 10: " + date.toString());

        // Test invalid day (should not change)
        date.setDay(32);
        System.out.println("Set Day to 32: " + date.toString());

        // Test valid month
        date.setMonth(5);
        System.out.println("Set Month to 5: " + date.toString());

        // Test invalid month (should not change)
        date.setMonth(13);
        System.out.println("Set Month to 13: " + date.toString());

        // Test valid year
        date.setYear(2023);
        System.out.println("Set Year to 2023: " + date.toString());

        // Test invalid year (should not change)
        date.setYear(10000);
        System.out.println("Set Year to 10000: " + date.toString());

        System.out.println();
    }

    private static void testDateComparison () {
        System.out.println("Testing Date Comparisons:");

        Date date1 = new Date(1, 1, 2022);
        Date date2 = new Date(15, 6, 2022);
        Date date3 = new Date(1, 1, 2022);

        // Test equals
        System.out.println("Date 1 equals Date 3: " + date1.equals(date3));

        // Test before
        System.out.println("Date 1 is before Date 2: " + date1.before(date2));

        // Test after
        System.out.println("Date 2 is after Date 3: " + date2.after(date3));

        System.out.println();
    }

    private static void testDateCalculations () {
        System.out.println("Testing Date Calculations:");

        Date date1 = new Date(1, 1, 2022);
        Date date2 = new Date(15, 6, 2022);

        // Test difference
        System.out.println("Difference between Date 1 and Date 2: " + date1.difference(date2) + " days");

        // Test tomorrow
        Date tomorrow = date1.tomorrow();
        System.out.println("Tomorrow's date from Date 1: " + tomorrow.toString());

        System.out.println();
    }

    // Point Class Tests

    private static void testPointConstructors () {
        System.out.println("Testing Point Constructors:");

        // Test valid point
        Point point1 = new Point(5, 10);
        System.out.println("Point 1: " + point1.toString());

        // Test invalid point (should default to (0, 0))
        Point point2 = new Point(-2, -7);
        System.out.println("Point 2: " + point2.toString());

        // Test copy constructor
        Point point3 = new Point(point1);
        System.out.println("Point 3 (copy of Point 1): " + point3.toString());

        System.out.println();
    }

    private static void testPointSetters () {
        System.out.println("Testing Point Setters:");

        Point point = new Point(3, 4);

        // Test valid x
        point.setX(7);
        System.out.println("Set X to 7: " + point.toString());

        // Test invalid x (should not change)
        point.setX(-2);
        System.out.println("Set X to -2: " + point.toString());

        // Test valid y
        point.setY(12);
        System.out.println("Set Y to 12: " + point.toString());

        // Test invalid y (should not change)
        point.setY(-5);
        System.out.println("Set Y to -5: " + point.toString());

        System.out.println();
    }

    private static void testPointComparisons () {
        System.out.println("Testing Point Comparisons:");

        Point point1 = new Point(3, 5);
        Point point2 = new Point(7, 2);
        Point point3 = new Point(3, 5);

        // Test equals
        System.out.println("Point 1 equals Point 3: " + point1.equals(point3));

        // Test isAbove
        System.out.println("Point 1 is above Point 2: " + point1.isAbove(point2));

        // Test isUnder
        System.out.println("Point 2 is under Point 3: " + point2.isUnder(point3));

        // Test isLeft
        System.out.println("Point 1 is left of Point 2: " + point1.isLeft(point2));

        // Test isRight
        System.out.println("Point 2 is right of Point 3: " + point2.isRight(point3));

        System.out.println();
    }

    private static void testPointCalculations () {
        System.out.println("Testing Point Calculations:");

        Point point1 = new Point(2, 3);
        Point point2 = new Point(7, 8);

        // Test middle
        Point middlePoint = point1.middle(point2);
        System.out.println("Middle Point between Point 1 and Point 2: " + middlePoint.toString());

        // Test distance
        double distance = point1.distance(point2);
        System.out.println("Distance between Point 1 and Point 2: " + distance);

        // Test move
        point1.move(3, 2);
        System.out.println("Move Point 1 by (3, 2): " + point1.toString());

        System.out.println();
    }

    //----

    // Test Point class
    private static void testPoint () {
        // Create Point objects and test various methods
        Point point1 = new Point(2, 3);
        Point point2 = new Point(4, 5);

        System.out.println("Testing Point class:");
        System.out.println("Point 1: " + point1);
        System.out.println("Point 2: " + point2);

        // Add more Point tests as needed
    }

    // Test City class
    private static void testCity () {
        // Create City objects and test various methods
        City city1 = new City("City1", new Date(2, 2, 2022), new Point(1, 1), new Point(5, 8), 1000000, 13);
        City city2 = new City("City2", new Date(12, 5, 1922), new Point(3, 4), new Point(88, 96), 500000, 10);

        System.out.println("\nTesting City class:");
        System.out.println("City 1: " + city1);
        System.out.println("City 2: " + city2);

        // Add more City tests as needed
    }

    // Test Country class
    private static void testCountry () {
        // Create Country objects and test various methods
        Country country1 = new Country("Country1");
        Country country2 = new Country("Country2");

        System.out.println("\nTesting Country class:");
        System.out.println("Country 1: " + country1);
        System.out.println("Country 2: " + country2);

        // Add more Country tests as needed
    }

    // Test Date class
    private static void testDate () {
        // Create Date objects and test various methods
        Date date1 = new Date(1, 1, 2022);
        Date date2 = new Date(15, 6, 2023);

        System.out.println("\nTesting Date class:");
        System.out.println("Date 1: " + date1);
        System.out.println("Date 2: " + date2);

        // Add more Date tests as needed
    }

    // Test CityNode class
    private static void testCityNode () {
        // Create CityNode objects
        City city1 = new City("London", new Date(2, 2, 2022), new Point(1, 1), new Point(5, 8), 1000000, 13);
        City city2 = new City("New York", new Date(12, 5, 1922), new Point(3, 4), new Point(88, 96), 500000, 10);

        // Create CityNode objects and test various methods
        CityNode node1 = new CityNode(city1);
        CityNode node2 = new CityNode(city2);

        System.out.println("\nTesting CityNode class:");
        System.out.println("CityNode 1: " + node1.getCityName());
        System.out.println("CityNode 2: " + node2.getCityName());

        // Add more CityNode tests as needed
    }
}

