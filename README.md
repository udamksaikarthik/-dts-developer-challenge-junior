# -dts-developer-challenge-junior
technical question for junior software developer role
Tasks Management System (Developer Challenge – Junior Software Developer)

A simple full-stack application built for the HMCTS DTS Developer Technical Test.
The system allows caseworkers to create tasks and view all created tasks, following clean code practices, validation rules, and a documented REST API.

🚀 Project Overview

This project implements:

A Java + Spring Boot backend API

A Thymeleaf-powered frontend for user interaction

A Task entity with the fields required by the challenge:

Title

Description (optional)

Status

Due Date/Time

API response returned after creation

Displaying all tasks in a styled frontend

Flash messages for better user experience

Fully in-memory database (H2) for simplicity

Unit tests written using Mockito & JUnit 5

The goal of the application is to demonstrate good development practices, clean architecture, and working knowledge of Java, Spring Boot, validation, error handling, and frontend rendering.

🏗 Architecture
Controller Layer
  - TaskWebController: Handles UI rendering with Thymeleaf.
  - TaskRestController: Handles POST requests to create tasks.

Service Layer
  - TaskService / TaskServiceImpl: Business logic for saving and retrieving tasks.

Repository Layer
  - TaskRepository: Manages DB operations using Spring Data JPA.

Model Layer
  - Task: Entity representing a task with validation rules.

View Layer
  - tasks.html: Task creation form + list of created tasks.

Static Resources
  - styles.css: UI styling for forms and task cards.

Configuration
  - application.properties: Database config, H2 console, Thymeleaf config.



📁 Project Structure
src/
  main/
    java/
      com.karthik.developerchallengejr/
        controller/
          TaskWebController.java
          TaskRestController.java
        model/
          Task.java
        repository/
          TaskRepository.java
        service/
          TaskService.java
          TaskServiceImpl.java
    resources/
      templates/
        tasks.html
      static/
        css/
          styles.css
      application.properties

  test/
    java/
      com.karthik.developerchallengejr/
        TaskServiceImplTest.java


🌐 API Documentation
1. Create Task
POST /api/tasks

Creates a new task and returns the saved task.

Request Parameters (Form Data)
| Field       | Type          | Required | Description                                            |
| ----------- | ------------- | -------- | ----------------------------------------------         |
| title       | String        | Yes      | Title of the task                                      |
| description | String        | No       | Optional longer text                                   |
| status      | String        | Yes      | Possible values: `Pending`, `IN_PROGRESS`, `Completed` |
| dueDateTime | LocalDateTime | Yes      | Format: `yyyy-MM-ddTHH:mm`                             |

Sample Request
POST /api/tasks
Content-Type: application/x-www-form-urlencoded

title=Call+client
&description=Follow+up+on+case
&status=TODO
&dueDateTime=2025-12-31T15:00

Success Response (302 redirect)

After creation, the API redirects to / with a flash message.

Returned Model Attribute
{
  "id": 1,
  "title": "Call client",
  "description": "Follow up on case",
  "status": "TODO",
  "dueDateTime": "2025-12-31T15:00"
}

Validation Failures

Validation is handled using @NotBlank, @NotNull, and errors are returned to the same form.

Examples:

Missing title → "Task title is mandatory"

Missing status → "Task status is mandatory"

Invalid date → "Task due date is mandatory"

2. Home Page
GET /

calls getAllTasks() - retrieves all the tasks stored in DB and displays on home page.
A form is designed and displayed as well on home page.

🎨 Frontend Behaviour

A user submits a task using a styled form.

Validation errors appear under each field.

Success message uses a flash attribute.

A list of all tasks displays under the form.

Tasks appear in a styled “task card” layout.

🧪 Unit Testing

Unit testing is implemented for the service layer:

Tests included:

✔ Create task

Ensures repository is called

Captures saved object

Verifies data properties

✔ Get all tasks

Mocks repository

Confirms correct list returned

Technologies:

JUnit 5

Mockito

MockitoExtension

AssertJ

Example test method:

@Test
void createTask_savesTaskAndReturnsSavedEntity() { ... }

🛠 Technologies Used
Backend

Java 17

Spring Boot 3

Spring MVC

Spring Data JPA

H2 Database

Jakarta Validation

Frontend

Thymeleaf

HTML5

CSS3

Testing

JUnit 5

Mockito

⚙️ How to Run
1. Clone the repository
git clone https://github.com/udamksaikarthik/-dts-developer-challenge-junior.git

2. Run Spring Boot
mvn spring-boot:run

3. Access the app
http://localhost:8086/

4. Access H2 Console
http://localhost:8086/h2-console


JDBC URL: jdbc:h2:mem:tasksdb
User: sa

📌 Notes (Important for Interview)

I chose Spring Boot for rapid development, clean API design, validation, and standard patterns.

I used H2 in-memory DB because it is lightweight and ideal for a short coding challenge.

The frontend uses Thymeleaf to keep things simple while meeting requirements.

Flash attributes improve UX after redirect.

Proper separation of concerns (Controller → Service → Repository).

Validation ensures safe and predictable application behaviour.

Unit tests focus on business logic rather than Spring context loading.

📷 Screenshots
<img width="1916" height="962" alt="image" src="https://github.com/user-attachments/assets/bb742bf5-fbfa-437c-ac40-c046a96c4614" />

<img width="1910" height="962" alt="image" src="https://github.com/user-attachments/assets/d14ce9e3-539d-4319-9a0e-5fee8e38a1e5" />

<img width="1908" height="960" alt="image" src="https://github.com/user-attachments/assets/4f3bc544-ee86-48af-9779-4deafe5e64be" />



