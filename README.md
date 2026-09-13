# Cubture

**Slogan:** Plan today. Make memories tomorrow.

Cubture is a family financial planning application designed to help families understand their finances, manage household costs and make informed decisions about saving and spending.

The application allows users to track income, expenses, childcare costs and savings goals. It calculates the amount of money remaining each month and allows users to choose how much of this amount they would like to save. The remaining amount can then be used to discover affordable family activities.

## Features

- Track and manage income
- Track and manage household expenses
- Track and manage childcare costs
- View monthly financial summaries
- Compare financial trends with the previous month
- Calculate remaining monthly budget
- Choose a percentage of remaining money to save using a savings slider
- Calculate the amount available for activities
- Create and manage savings goals
- Track savings progress towards a target
- Discover family activities using the Skiddle API
- Filter activities by location
- Sort activities by price
- View activities that are affordable based on the available activity budget
- Responsive user interface
- Dockerised frontend, backend and database

## Tech Stack

### Frontend

- React
- TypeScript
- Vite
- React Router
- Recharts
- CSS

### Backend

- Java
- Spring Boot
- Spring Data JPA
- Spring Validation
- Maven

### Database

- MySQL

### External API

- Skiddle API

### Development and Deployment

- Docker
- Docker Compose
- Nginx
- Git and GitHub

## Running the Application with Docker

### Prerequisites

The following are required:

- Git
- Docker Desktop

MySQL does not need to be installed locally because it runs inside a Docker container.

### 1. Clone the repository

Clone the repository and navigate into the project directory.

### 2. Create the environment file

Copy the environment template to create your local `.env` file:

```bash
cp .env.template .env
```

### 3. Start the application

From the root of the project, run:

```bash
docker compose up --build
```

This builds and starts the frontend, backend and MySQL database.

Once the containers have started, open:

```
http://localhost:5173
```

### 4. Stop the application

To stop the containers:

```bash
docker compose down
```

## Environment Variables

The project uses environment variables for configuration.

A `.env.template` file is included in the repository to show the variables required to run the application.

Before starting the application, copy the template to create your local `.env` file.

The required variables are:

```
MYSQL_DATABASE=cubture
MYSQL_USER=cubture
MYSQL_PASSWORD=cubturepassword
MYSQL_ROOT_PASSWORD=rootpassword
SKIDDLE_API_KEY=5bcb8c1c80545b33d17e130f6b0b7855
```

The .env file is excluded from Git using .gitignore.

The MySQL variables are used by Docker Compose to configure the database and provide the database connection details to the Spring Boot backend.

The Skiddle API key is provided to the backend through the environment.

## Database

Cubture uses MySQL for storing financial and savings data.

The MySQL database runs in its own Docker container and is configured through Docker Compose.

Spring Data JPA and Hibernate are used to create and update the database schema based on the application's entity classes.

The following configuration allows Hibernate to update the schema without deleting existing data:

```properties
spring.jpa.hibernate.ddl-auto=update
```

The application also uses a `data.sql` file to provide initial seed data.

The following configuration ensures that the seed data is loaded after Hibernate has created or updated the database schema:

```properties
spring.jpa.defer-datasource-initialization=true
spring.sql.init.mode=always
```

The `data.sql` file is located at:

```
backend/src/main/resources/data.sql
```

A named Docker volume is used to persist MySQL data when the containers are stopped and restarted.

## Application Architecture

Cubture is made up of three main services managed through Docker Compose:

- **Frontend:** React and TypeScript application
- **Database:** MySQL database with data saved in a Docker volume between restarts

The React frontend acts as the client and sends HTTP requests to the Spring Boot backend. The backend processes these requests, handles the application's business logic and database operations, and returns HTTP responses to the frontend. For activities, the backend also communicates with the Skiddle API to retrieve activity data.

Docker Compose starts and manages all three services together.

## Project Structure

The project is split into separate frontend and backend applications, with Docker Compose used to run the frontend, backend and database together.

- `frontend/` - React and TypeScript application
- `backend/` - Spring Boot REST API
- `backend/src/main/resources/data.sql` - Seed data used to populate the database
- `frontend/Dockerfile` - Frontend container configuration
- `backend/Dockerfile` - Backend container configuration
- `docker-compose.yml` - Defines and manages the application services
- `.env.template` - Template showing the required environment variables

## Dashboard

The dashboard provides an overview of the family's finances for the selected month. It displays:

- Total income
- Total expenses
- Total childcare costs
- Remaining money
- Month-on-month trends
- Monthly financial overview chart
- Savings percentage
- Amount saved
- Amount available for activities
- Affordable family activities

The financial summary is calculated by the backend using the selected month and year.

The remaining amount is calculated as:

```
Income - Expenses - Childcare = Remaining
```

Users can then choose what percentage of their remaining money they want to save. The amount left after savings becomes the available budget for activities.

## Savings Goals

Users can create and manage savings goals. Each savings goal includes:

- Goal name
- Target amount
- Saved amount
- Target date

The application calculates the percentage of the goal that has been completed and displays the progress using a progress bar.

Users can edit and delete existing savings goals.

## Income, Expenses and Childcare

Users can add, view, edit and delete financial records.

**Income records** include:

- Source
- Amount
- Date received
- Frequency

**Expense records** include:

- Name
- Amount
- Date paid
- Frequency

**Childcare records** include:

- Name
- Amount
- Date paid
- Frequency

The dashboard uses these records to calculate the monthly financial summary.

## API Integration

Cubture integrates with the Skiddle API to retrieve family activities.

The backend retrieves activity information and provides it to the React frontend.

Activities include information such as:

- Event name
- Date
- Location
- Images
- Ticket pricing
- Event link

The activities page allows users to:

- Search by location
- Sort activities by price
- View event details
- Open the original event listing

The dashboard also uses the available activity budget to display affordable activities.

## Local Development

Docker is the recommended way to run the complete application because it starts the frontend, backend and database together.

The frontend can also be run separately during development from the frontend directory:

```bash
cd frontend
npm install
npm run dev
```

The backend can be run separately from the backend directory using Maven.

When running the applications outside Docker, a locally configured MySQL database and the appropriate local configuration are required.

### Building the Frontend

The frontend production build can be created using:

```bash
cd frontend
npm run build
```

The production build is generated in:

```
frontend/dist
```

The Docker frontend image builds the React application and then serves the production files using Nginx.

## Backend

The backend is a Spring Boot REST API built using Maven. It uses:

- Spring Data JPA for database access
- Hibernate for ORM and schema management
- Spring Validation for request validation
- Spring Web for REST endpoints

The backend is built using a multi-stage Docker build. Maven is used during the build stage and the resulting application JAR is run using a Java runtime image.

The backend runs on port `8080`.

## Docker

Docker Compose is used to run the application as three services:

- Frontend
- Backend
- MySQL database

The frontend is built using Node and served using Nginx.

The backend is built using Maven and runs as a Spring Boot application.

The MySQL service uses a named Docker volume to persist database data.

The backend waits for the MySQL service to become healthy before starting.

Docker Compose also uses the MySQL service name when the backend connects to the database.

## Documentation

Project documentation and assessment evidence can be found in the `docs/` folder:

- **API Documentation** - [OpenAPI YAML](docs/api/openapi.yaml)
- **Designs** - Figma designs and UI design evidence
- **Planning** - Jira boards, database design and project planning evidence
- **Evidence** - Screenshots demonstrating key features and development work

## Future Improvements

Potential future improvements include:

- User authentication and individual family accounts
- More advanced budgeting features
- Additional activity filtering
- More detailed financial reporting
- Improved accessibility
- More personalised activity recommendations
- Further error handling and validation
- Further responsive design improvements
