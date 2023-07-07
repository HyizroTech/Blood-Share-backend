# Blood-Share-backend
## Auth

### Register Blood Bank


```js
POST /auth/register/bloodbank
```

#### Register Request

```json
{
  "name": "Blood Bank Name",
  "email": "bb@gmail.com",
  "address": "khalda amman",
  "password": "Welcome@123"
}
```

### Register Donor


```js
POST /auth/register/donor
```

#### Register Request

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe@gmail.com",
  "address": "khalda amman",
  "bloodgroup": "A",
  "phone": "0000000000",
  "password": "Welcome@123"
}
```

### Register Response

```js
200 OK
```

```json
{
  "id": "5f5d7a75-6d35-4cea-80b6-76906143d7f6",
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe@gmail.com",
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJCdWJlckRpbm5lci5Eb21haW4uVXNlckFnZ3JlZ2F0ZS5WYWx1ZU9iamVjdHMuVXNlcklkIiwiZ2l2ZW5fbmFtZSI6Ik5pZ2VsIiwiZmFtaWx5X25hbWUiOiJHdW56IiwianRpIjoiMDJhYjc4OTEtMjRhNy00MTZiLTkxNDEtNGNlNzgwMjA0YTQ4IiwiZXhwIjoxNjc0OTkxNTE3LCJpc3MiOiJCdWJlckRpbm5lciIsImF1ZCI6IkJ1YmVyRGlubmVyIn0.tJnQkx3f7B3wD7YsoPX19WBN6Z0ZXB5kqOqtOn22KHQ"
}
```

### Login

```js
POST /auth/login
```

#### Login Request

```json
{
  "email": "johndoe@gmail.com",
  "password": "Welcome@123"
}
```

#### Login Response

```js
200 OK
```

```json
{
  "id": "5f5d7a75-6d35-4cea-80b6-76906143d7f6",
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe@gmail.com",
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJCdWJlckRpbm5lci5Eb21haW4uVXNlckFnZ3JlZ2F0ZS5WYWx1ZU9iamVjdHMuVXNlcklkIiwiZ2l2ZW5fbmFtZSI6Ik5pZ2VsIiwiZmFtaWx5X25hbWUiOiJHdW56IiwianRpIjoiNjNhYTQ1MWEtYWU0Ni00ODJmLTlmMmUtNTk0YmY2OTBiYjA2IiwiZXhwIjoxNjc0OTkxNTY5LCJpc3MiOiJCdWJlckRpbm5lciIsImF1ZCI6IkJ1YmVyRGlubmVyIn0.7Wzdk5R6qjINs3QTejnCvHvOB2Zlf6poaC-3N0LMeF8"
}
```
