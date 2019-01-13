##Application

Deployment environment : Heroku ("https://myapplicationdata.herokuapp.com/users/welcome")

Database: PostgreSQL

> If you want to check with other SQL environment then you can change the application.properties file under resources folder

For example (MySQL) :

spring.datasource.url=jdbc:mysql://"MYSQL_URL"/"DB OR SCHEMA NAME"?autoReconnect=true&useSSL=false
spring.datasource.username="USER_NAME"
spring.datasource.password= "PASSWORD"
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

make sure that you are including the driver (in this case com.mysql.jdbc.Driver) in POM.xml .



> Sample Request
  ---------------

{
  "ProductRequest": {
    "productName": "Subhrajit",
    "productImageUrl": "",
    "productImageThumbnailUrl": "",
    "productPrice": 200,
    "headerTopRightText": "Subhrajit Sahu",
    "headerTopLeftText": "Sahu",
    "productCtaText": "Sub",
    "productDetails": "Hi Subhrajit",
    "productId": "3455424"
  }
}


> Sample Response
  ---------------

{
    "responseHeader": {
        "statusCode": "100",
        "statusMessage": "Error in processing request"
    }
}


{
    "responseHeader": {
        "statusCode": "0",
        "statusMessage": "SUCCESS"
    },
    "responseBody": {
        "response": {
            "status": "success"
        }
    }
}



Steps:

> Request will first go to the requestController (IndexController.java), and correspnding method and service will invoke.
> Based on the operation corresponding response will generate.
> There is a common class file for response handling sample format will be



{
    "responseHeader": {
      // Status code and Status message (key value pair) will display here 
    },
    "responseBody": {
       // Corresponding results in key value pair
    }
}


> All the request will go through a  wrapper class, sample structure

{
	"PARENT_NODE":{
			// request nodes in key value pair
	}
}
