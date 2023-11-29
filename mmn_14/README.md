# Java Programming Project: Country

## Overview

This project is part of a university course on Java programming. The "Country" class is designed to represent and manage information related to countries, providing essential functionalities.


The project includes five Java classes: Point, City, Country, Date, and CityNode.

## Table of Contents

- [Features](#features)
- [Classes](#classes)
- [Usage](#usage)
- - [Testing](#testing)
  - [Running the Tests](#running-the-tests)
  - [Sample Test Cases](#sample-test-cases)
- [Skills](#skills)
- [Installation](#installation)
- [Contributing](#contributing)
- [License](#license)

## Features

## Features

  Representation of country information.
  Essential functionalities for managing country data.

- **Point**: Represents a 2D point with x and y coordinates. Provides methods for distance calculation and movement.

- **City**: Represents a city with a name, population, and location (using the Point class). Includes methods for population comparison and distance calculation.

- **Country**: Represents a country with a name and a list of cities (using the City class). Provides methods for finding the largest city and calculating the total population.

- **Date**: Represents a date with day, month, and year. Includes methods for date comparison and calculating the difference in days.

- **CityNode**: Represents a node in a linked list, specifically designed for storing City objects.

## Classes

1. **Country.java**: The main class representing a country.
   - Provides methods for accessing and updating country information.

2. **City.java**: Represents information about cities within a country.
   - Linked with the `Country` class to manage cities associated with a country.

3. **Date.java**: Handles date-related operations.
   - Used for managing dates associated with country data.

4. **Point.java**: Represents a point in a 2D coordinate system.
   - Used for geographical information associated with cities or countries.

5. **CityNode.java**: Represents a node in a linked list, specifically designed for cities.
   - Linked list functionality to manage cities within a country.

## Usage

To use the `Country` class and associated classes, follow these steps:

1. Import the required classes into your Java project.
2. Create instances of the `Country` class and associated classes.
3. Utilize the provided methods to manage country data.

Example:

```java
// Create a country
Country myCountry = new Country("USA");

// Add a city to the country
City myCity = new City("New York", new Date(12, 5, 1922), new Point(40, 74), new Point(88, 96), 8400000, 399);
myCountry.addCity(myCity);

// Access country information
System.out.println("Country Name: " + myCountry.getName());
System.out.println("Number of Cities: " + myCountry.getNumCities());
```

## Testing

### Running the Tests

To run the tests, execute the `main` method in the `Tester` class.

```bash
java Tester
```

## Sample Test Cases

### Date Class

#### Test Constructors:
- **Test valid date:**
  - Create a Date object with a valid date (15/6/2022) and ensure it is created correctly.
  
- **Test invalid date (should default to 1/1/2000):**
  - Create a Date object with an invalid date (32/13/5000) and ensure it defaults to 1/1/2000.

- **Test copy constructor:**
  - Create two Date objects, use the copy constructor, and ensure the copied date is the same.

#### Test Setters:
- **Test valid day:**
  - Create a Date object, set a valid day (10), and ensure the day is updated.

- **Test invalid day (should not change):**
  - Create a Date object, set an invalid day (32), and ensure the day remains unchanged.

- **Test valid month:**
  - Create a Date object, set a valid month (5), and ensure the month is updated.

- **Test invalid month (should not change):**
  - Create a Date object, set an invalid month (13), and ensure the month remains unchanged.

- **Test valid year:**
  - Create a Date object, set a valid year (2023), and ensure the year is updated.

- **Test invalid year (should not change):**
  - Create a Date object, set an invalid year (10000), and ensure the year remains unchanged.

#### Test Comparisons:
- **Test equals:**
  - Create two Date objects with the same date and ensure they are considered equal.

- **Test before:**
  - Create two Date objects, set one before the other, and ensure the correct result.

- **Test after:**
  - Create two Date objects, set one after the other, and ensure the correct result.

#### Test Calculations:
- **Test difference:**
  - Create two Date objects, calculate the difference in days, and ensure the correct result.

- **Test tomorrow:**
  - Create a Date object, calculate the date of tomorrow, and ensure it is correct.

### Point Class

#### Test Constructors:
- **Test valid point:**
  - Create a Point object with valid coordinates (5, 10) and ensure it is created correctly.

- **Test invalid point (should default to (0, 0)):**
  - Create a Point object with invalid coordinates (-2, -7) and ensure it defaults to (0, 0).

- **Test copy constructor:**
  - Create two Point objects, use the copy constructor, and ensure the copied point is the same.

#### Test Setters:
- **Test valid X coordinate:**
  - Create a Point object, set a valid X coordinate (7), and ensure the X coordinate is updated.

- **Test invalid X coordinate (should not change):**
  - Create a Point object, set an invalid X coordinate (-2), and ensure the X coordinate remains unchanged.

- **Test valid Y coordinate:**
  - Create a Point object, set a valid Y coordinate (12), and ensure the Y coordinate is updated.

- **Test invalid Y coordinate (should not change):**
  - Create a Point object, set an invalid Y coordinate (-5), and ensure the Y coordinate remains unchanged.

#### Test Comparisons:
- **Test equals:**
  - Create two Point objects with the same coordinates and ensure they are considered equal.

- **Test isAbove:**
  - Create two Point objects, set one above the other, and ensure the correct result.

- **Test isUnder:**
  - Create two Point objects, set one under the other, and ensure the correct result.

- **Test isLeft:**
  - Create two Point objects, set one to the left of the other, and ensure the correct result.

- **Test isRight:**
  - Create two Point objects, set one to the right of the other, and ensure the correct result.

#### Test Calculations:
- **Test middle:**
  - Create two Point objects, calculate the middle point, and ensure it is correct.

- **Test distance:**
  - Create two Point objects, calculate the distance between them, and ensure the correct result.

- **Test move:**
  - Create a Point object, move it by a certain amount, and ensure it is moved correctly within the first quadrant.

### City Class

#### Test Constructors:
- **Test valid City:**
  - Create a City object with valid parameters and ensure it is created correctly.

- **Test invalid City (should default parameters):**
  - Create a City object with invalid parameters and ensure it defaults to specified values.

#### Additional City Tests:
- Include relevant tests for methods specific to the City class.

### Country Class

#### Test Constructors:
- **Test valid Country:**
  - Create a Country object with a valid name and ensure it is created correctly.

- **Test invalid Country (should default name):**
  - Create a Country object with an invalid name and ensure it defaults to a specified value.

#### Additional Country Tests:
- Include relevant tests for methods specific to the Country class.

### CityNode Class

#### Test Constructors:
- **Test valid CityNode:**
  - Create a CityNode object with a valid City and ensure it is created correctly.

- **Test invalid CityNode (should default city):**
  - Create a CityNode object with an invalid City and ensure it defaults to a specified city.

#### Additional CityNode Tests:
- Include relevant tests for methods specific to the CityNode class.


## Skills 

Throughout the development of this project, we learned and applied skills in various pertinent fields:

- **Object-Oriented Design:** Implemented a robust system of interconnected classes (Point, City, Country, Date, and CityNode) utilizing concepts like encapsulation, inheritance, and polymorphism.

- **Algorithmic Thinking:** Designed and implemented algorithms for various tasks, such as date calculations, population comparison, and finding the largest city in a country.

- **Data Modeling:** Utilized effective data modeling techniques to represent real-world entities (cities, countries, dates) and their relationships within the project.

- **Error Handling and Validation:** Implemented rigorous error-handling mechanisms to ensure the integrity of input data, enhancing the reliability of the software.

- **Data Structures:** Applied the use of data structures, including linked lists (CityNode), to efficiently manage and organize complex information.

- **Collaborative Development:** Leveraged Git and version control for collaborative development, enabling efficient teamwork and code management.

- **Problem Solving:** Addressed challenges related to date calculations, coordinate movements, and data manipulation, showcasing strong problem-solving skills.

- **Code Organization:** Maintained clean and well-organized code, promoting readability and ease of maintenance.

- **Documentation:** Documented code effectively, making it easier for other developers (and future self) to understand and contribute to the project.


## Installation

To integrate this project into your Java application, follow these steps:

1. Clone or download the repository to your local machine.
2. Import the relevant Java files into your project.
3. Ensure that you have the required dependencies and adjust the package structure if necessary.

## Contributing

If you'd like to contribute to this project, please follow these guidelines:

- Fork the repository
- Create a new branch for your feature or bug fix
- Make your changes and submit a pull request

## License

This project is licensed under the [MIT](https://github.com/yehonatanke/OpenU-Java/blob/main/LICENSE) License.

## Author

yehonataKe
