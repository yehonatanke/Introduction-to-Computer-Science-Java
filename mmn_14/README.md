# Java Programming Project: Country

## Overview

This project is part of a university course on Java programming. The "Country" class is designed to represent and manage information related to countries, providing essential functionalities.


The project includes five Java classes: Point, City, Country, Date, and CityNode.

## Table of Contents

- [Features](#features)
- [Classes](#classes)
- [Usage](#usage)
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
City myCity = new City("New York", new Date(12, 5, 1922), new Point(3, 4), new Point(88, 96), 500000, 10);
myCountry.addCity(myCity);

// Access country information
System.out.println("Country Name: " + myCountry.getName());
System.out.println("Number of Cities: " + myCountry.getNumCities());
```

### Skills 

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


### Installation

To integrate this project into your Java application, follow these steps:

1. Clone or download the repository to your local machine.
2. Import the relevant Java files into your project.
3. Ensure that you have the required dependencies and adjust the package structure if necessary.

### Contributing

If you'd like to contribute to this project, please follow these guidelines:

- Fork the repository
- Create a new branch for your feature or bug fix
- Make your changes and submit a pull request

### License

This project is licensed under the [MIT](dcac) License.

