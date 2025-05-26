# 📸 photo-app-users-api

A Java 11 AWS Lambda function that simulates retrieving user information in a photo sharing application. This project showcases how to build and package serverless microservices using Maven, AWS Lambda, and API Gateway. It’s ideal for learning how to work with serverless Java applications in the AWS ecosystem.

---

## 🚀 Features

- ✅ Java 11 project managed by Maven
- ✅ Serverless function using AWS Lambda
- ✅ API Gateway integration with path parameters
- ✅ JSON response creation using Gson
- ✅ Packaged as a standalone JAR using Maven Shade Plugin
- ✅ Easily deployable to AWS Lambda
- ✅ Clean and extensible architecture for adding more Lambda handlers

---

## 📂 Project Structure

```
photo-app-users-api/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── appsdeveloperblog/
                    └── aws/
                        └── photoapp/
                            └── users/
                                └── GetUserHandler.java
```

---

## 📄 Description

The main Lambda function `GetUserHandler` handles requests coming from API Gateway and returns a mock user object based on a provided `userId` path parameter.

It uses the following event types:

- `APIGatewayProxyRequestEvent` to receive input data
- `APIGatewayProxyResponseEvent` to return the response

### Sample Handler Logic:

```java
@Override
public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
    Map<String, String> pathParameters = input.getPathParameters();
    String userId = pathParameters.get("userId");

    JsonObject returnValue = new JsonObject();
    returnValue.addProperty("firstName", "Sergey");
    returnValue.addProperty("lastName", "Kargopolov");
    returnValue.addProperty("id", userId);

    return new APIGatewayProxyResponseEvent()
            .withStatusCode(200)
            .withBody(returnValue.toString());
}
```

---

## 🔧 Build & Package

To build and create a deployable JAR, run:

```bash
mvn clean package
```

This will produce the final JAR in:

```
target/photo-app-users-api-1.0-SNAPSHOT.jar
```

This JAR will include all required dependencies using the `maven-shade-plugin`.

---

## ☁️ AWS Deployment Options

### Option 1: Manually via AWS Console

1. Open [AWS Lambda Console](https://console.aws.amazon.com/lambda)
2. Create a new function (`Author from Scratch`)
3. Choose Java 11 as the runtime
4. Upload the generated JAR from the `target/` directory
5. Set the handler to: `com.appsdeveloperblog.aws.photoapp.users.GetUserHandler::handleRequest`
6. Configure an API Gateway trigger (REST API or HTTP API)

### Option 2: Automated (AWS SAM / CDK)

You can also automate deployment using:

- [AWS SAM](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/what-is-sam.html)
- [AWS CDK](https://docs.aws.amazon.com/cdk/latest/guide/home.html)
- AWS CLI with CloudFormation

(Feel free to request a SAM template or CDK script if needed!)

---

## 🧪 Testing

To test locally, you can simulate events using frameworks such as:

- **AWS SAM CLI**
- **LocalStack**
- **JUnit with Mock Lambda Context**

---

## 📘 Useful Links

- [AWS Lambda Java Docs](https://docs.aws.amazon.com/lambda/latest/dg/java-handler.html)
- [API Gateway + Lambda Integration](https://docs.aws.amazon.com/apigateway/latest/developerguide/how-to-method-settings.html)
- [Gson Documentation](https://github.com/google/gson)

---

## 🙋‍♂️ Contributing

Feel free to fork this repository, open issues, or submit pull requests. This project serves as a minimal and extensible example for Java-based AWS Lambda functions.

---

## 📚 Author

Created for learning purposes, based on educational content from [Sergey Kargopolov](https://appsdeveloperblog.com), adapted and expanded by [Julio César].

---

## 🧾 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
