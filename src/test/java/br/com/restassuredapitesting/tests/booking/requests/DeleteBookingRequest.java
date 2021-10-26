package br.com.restassuredapitesting.tests.booking.requests;


import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteBookingRequest {

@Step("Deleta uma reserva específica utilizando o parâmetro token")
    public Response deleteBookingToken(int id, String token){
        return given()
                .header("Content-Type","application/json")
                .header("Cookie", token)
                .when()
                .delete("booking/" + id);
    }
}
