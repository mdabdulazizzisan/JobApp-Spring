# Job Portal Web Application

## Overview
This is a Job Portal Web Application built using Java, Spring Boot, and Maven. The application allows users to view job postings, add new job postings, and manage job listings. The front-end is developed using JSP and Bootstrap for a responsive and user-friendly interface.

## Features
- View all job postings
- Add new job postings
- Responsive design using Bootstrap

## Technologies Used
- Java
- Spring Boot
- Maven
- JSP (JavaServer Pages)
- JSTL (JavaServer Pages Standard Tag Library)
- Bootstrap

## Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── kolu/
│   │           ├── JobApp/
│   │           │   ├── controller/
│   │           │   │   └── JobController.java
│   │           │   ├── model/
│   │           │   │   └── JobPost.java
│   │           │   ├── repo/
│   │           │   │   └── JobRepo.java
│   │           │   └── service/
│   │           │       └── JobService.java
│   ├── resources/
│   │   └── application.properties
│   └── webapp/
│       └── views/
│           ├── addjob.jsp
│           ├── home.jsp
│           └── viewalljobs.jsp
└── test/
    └── java/
        └── com/
            └── kolu/
                └── JobApp/
                    └── JobAppApplicationTests.java
```

## Setup and Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/mdabdulazizzisan/job-portal-web-app.git
   ```
2. Navigate to the project directory:
   ```sh
   cd job-portal-web-app
   ```
3. Build the project using Maven:
   ```sh
   mvn clean install
   ```
4. Run the application:
   ```sh
   mvn spring-boot:run
   ```

## Usage
- Access the application at `http://localhost:8080`.
- Navigate to the "All Jobs" page to view all job postings.
- Use the "Add Job" page to add new job postings.

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License
This project is licensed under the MIT License. See the `LICENSE` file for more details.
