## How to Install

## First run docker in your local machine

1) <code>docker compose up -d</code>

2) Setup Database for webhook microservice

4) API URL: <code>http://localhost:8081/publish</code>
Body Post Request:
<code>
{
  "eventName" : "Hello Japan vs Bangladesh VS Korea VS India ",
  "status": "Success"
}
</code>
Done, 

5) In the console you will see the message send and receive message. Check two console where the project is running.

Thanks


