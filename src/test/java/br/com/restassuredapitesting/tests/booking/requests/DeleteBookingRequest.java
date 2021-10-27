package br.com.restassuredapitesting.tests.booking.requests;


import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteBookingRequest {

@Step("Exclui uma reserva utilizando o parâmetro token")
    public Response deleteBookingToken(int id, String token){
        return given()
                .header("Content-Type","application/json")
                .header("Cookie", token)
                .when()
                .delete("booking/" + id);
    }

@Step("Tenta excluir uma reserva sem autorização")
    public Response deleteBookingWithoutToken(int id){
        return given()
                .header("Content-Type","application/json")
                .when()
                .delete("booking/" + id);
    }
}