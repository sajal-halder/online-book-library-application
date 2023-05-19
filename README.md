
# Online Book Library Application

Documentation for Online Book Library Application

*Contact:* Sajal halder  
*Email:* sajal.halder@bjitcademy.com  
*Version:* 1.0

##  Online Book Library
A simple online book library REST application using Spring Boot.
featuring authentication and authorization with jwt token 




### Entities:
#### Book:
- id
- title
- author
- genre
- price
- description
#### User:
- first name
- last name
- email
- password
- address
- roles : Many-to-Many relation
#### Role:
- id
- role name


## Endpoints



### Register User

- Method: POST
- Path: /user/register

#### Request Body

- Content-Type: application/json
- Schema: [RegisterRequest](#registerrequest)
- Required: true

#### Responses

- 200 OK
    - Content-Type: application/json
    - Schema: [RegisterResponse](#registerresponse)
- 208 Already Reported
---

### Login User

- Method: POST
- Path: /user/login

#### Request Body

- Content-Type: application/json
- Schema: [LoginRequest](#loginrequest)
- Required: true

#### Responses

- 200 OK
    - Content-Type: application/json
    - Schema: [LoginResponse](#loginresponse)
---
## Book endpoint

### Create Book

- Method: POST
- Path: /books/create

#### Request Body

- Content-Type: application/json
- Schema: [BookRequest](#bookrequest)
- Required: true

#### Responses

- 200 OK
    - Content-Type: application/json
    - Schema: [BookResponse](#bookresponse)
- 208 Already Reported

---
### Update Book

- Method: PUT
- Path: /books/update/bookId/{bookId}

#### Parameters

- `bookId` (path parameter, required) - Type: string

#### Request Body

- Content-Type: application/json
- Schema: [BookResponse](#bookresponse)
- Required: true

#### Responses

- 200 OK
  - Content-Type: application/json
  - Schema: [BookResponse](#bookresponse)
- 404 not found  
---
### Get Book by ID

- Method: GET
- Path: /books/id/{bookId}

#### Parameters

- `bookId` (path parameter, required) - Type: string

#### Responses

- 200 OK
    - Content-Type: application/json
    - Schema: [BookResponse](#bookresponse)
- 404 not found
---
### Get Books by Author Name

- Method: GET
- Path: /books/author/{authorName}

#### Parameters

- `authorName` (path parameter, required) - Type: string

#### Responses

- 200 OK
    - Content-Type: application/json
    - Schema: array of [BookResponse](#bookresponse)
- 404 not found
---
### Get Book by Author Name and Title

- Method: GET
- Path: /books/author-title/{authorName}/{bookTitle}

#### Parameters

- `authorName` (path parameter, required) - Type: string
- `bookTitle` (path parameter, required) - Type: string

#### Responses

- 200 OK
    - Content-Type: application/json
    - Schema: [BookResponse](#bookresponse)
- 404 not found
---

### Get All Books

- Method: GET
- Path: /books/all

#### Responses

- 200 OK
    - Content-Type: application/json
    - Schema: list of [BookResponse](#bookresponse)
---

### Delete Book

- Method: DELETE
- Path: /books/delete/bookId/{bookId}

#### Parameters

- `bookId` (path parameter, required) - Type: string

#### Responses

- 200 OK
    - Content-Type: string

---
## Schemas

### BookRequest

- Required: title, authorName, genre, description, price
- Type: object

#### Properties

- `title` (string)
- `authorName` (string)
- `genre` (string)
- `description` (string)
- `price` (double)

### BookResponse

- Type: object

#### Properties

- `bookId` (Long)
- `title` (string)
- `authorName` (string)
- `genre` (string)
- `description` (string)
- `price` (double)

### LoginRequest

- Required: email,password
- Type: object

#### Properties

- `email` (string)
- `password` (string)


### LoginResponse


#### Properties

- `token` (string)

### RegisterRequest

- Required: firstName, lastName, email, password, address, roles
- Type: object

#### Properties

- `firstName` (string)
- `lastName` (string)
- `email` (string)
- `password` (string)
- `address` (string)
- `password` (list of String)

### RegisterResponse

#### Properties

- `id` (string)
- `email` (string)
- `message` (string)








