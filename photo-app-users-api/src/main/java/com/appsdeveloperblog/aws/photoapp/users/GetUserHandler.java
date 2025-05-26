package com.appsdeveloperblog.aws.photoapp.users;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.JsonObject;

import java.util.Map;

public class GetUserHandler implements
        RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input,
                                                      Context context) {

        Map<String, String> pathParameters = input.getPathParameters();
        String userId = pathParameters.get("userId");

        JsonObject returnValue = new JsonObject();
        returnValue.addProperty("firstName","Sergey");
        returnValue.addProperty("lastName", "Kargopolov");
        returnValue.addProperty("id", userId);

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.withStatusCode(200).withBody(returnValue.toString());

        return response;
    }
}
