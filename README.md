# Testcontainers for MySQL with Spring Data JPA

**Testcontainers** is a Java library that supports JUnit tests, providing lightweight, throwaway instances of common databases, Selenium web browsers, or anything else that can run in a Docker container.

- [MySQL Module](https://www.testcontainers.org/modules/databases/mysql/)

## Description
### Dependencies
Dependency for **Testcontainers**
- `testImplementation`
  - **org.testcontainers**
    - junit-jupiter
    - mysql

```kotlin
extra["testcontainersVersion"] = "1.15.3"
dependencyManagement {
	imports {
		mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
	}
}
```
## Demo

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## References

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
