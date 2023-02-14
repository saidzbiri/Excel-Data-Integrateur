# Excel Data Integrateur

This project was created with Java11, Spring Boot, use database mysql.

## Author

Said Z'BIRI

## Getting Started

To run this project, please follow those instructions

### Prerequises

Clone this repository:

```text
    git clone git@github.com:saidzbiri/excel-data-integrateur.git
```

Then open the project with the IDE of your choice, Right click on the main class named Application, and then press "run Application".



## Documentation

When the server is running you can launch postman, choose http post method and put this url:

```text
    http://localhost:8080/api/excel/upload
```

then choose "form-data" and enter "file" as a key and "[yourFileLocation]" as a value and make a request.

## API

With this API, you can choose and excel file (xlsx format) and integrated in the database
