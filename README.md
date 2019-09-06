# sheetql
My goal was to write a program which would allow users to query their files using SQL.
Google sheets should act as tables.

### Learning goals:
- practice Functional Programming
- use Google API
- setup Continuous Integration (Travis CI)
- deploy to cloud (AWS Beanstalk)

### Example usage:

[Link to the deployed application](http://sheetql.us-east-2.elasticbeanstalk.com/)

send a GET request, request body:
{
    "text": "select * from users where age < 50;"
}
    

##### Implemented SQL commands:
- FROM

##### Pending implementation:
- SELECT
- WHERE

##### Available tables:
- albums
- users
