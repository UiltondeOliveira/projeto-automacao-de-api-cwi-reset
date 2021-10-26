package br.com.restassuredapitesting.tests.booking.requests;


import br.com.restassuredapitesting.tests.booking.payloads.BookingPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Date;

import static io.restassured.RestAssured.given;

public class GetBookingRequest {

    @Step("Retorna os Ids da listagem de reservas")

    public Response bookingReturnIds(){
        return given()
                .when()
                .get("booking");
    }

    @Step("Retorna uma reserva específica")
    public Response bookingReturnSpecificId(int id){
        return given()
                .when()
                .get("booking/" + id);
    }

    @Step("Retorna uma lista de reservas utililando um filtro por Firstname")
    public Response bookingListReturnIdsFilteredForFirstname(String firstName){
        return given()
                .queryParam("firstname",firstName)
                .when()
                .get("booking/");
    }

    @Step("Retorna uma lista de reservas utililando um filtro por Lastname")
    public Response bookingListReturnIdsFilteredForLastname(String lastName){
        return given()
                .queryParam("lastname",lastName)
                .when()
                .get("booking/");
    }

    @Step("Retorna uma lista de reservas utililando um filtro por Checkin")
    public Response bookingListReturnIdsFilteredCheckin(String checkin){
        return given()
                .queryParam("checkin",checkin)
                .when()
                .get("booking/");
    }

    @Step("Retorna uma lista de reservas utililando um filtro por Checkout")
        public Response bookingListReturnIdsFilteredCheckout(String checkout){
        return given()
                .queryParam("checkout",checkout)
                .when()
                .get("booking/");
        }
}
