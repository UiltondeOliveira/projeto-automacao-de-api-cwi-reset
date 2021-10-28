package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.booking.payloads.BookingPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class PostBookingRequest {
    BookingPayloads bookingPayloads = new BookingPayloads();

    @Step("Criar uma nova reserva")
    public Response createBooking(){
        return given()
                .header("Content-Type","application/json")
                .when()
                .body(bookingPayloads.payloadCreateBooking().toString())
                .post("booking");
    }

    @Step("Criar uma nova reserva com payload inválido")
    public Response createBookingWithInvalidPayload(){
        return given()
                .when()
                .body(bookingPayloads.payloadCreateBooking().toString())
                .post("booking");
    }

    @Step("Criar uma nova reserva com mais parâmetros no payload")
    public Response createBookingWhithMoreParameters(){
        return given()
                .header("Content-Type","application/json")
                .when()
                .body(bookingPayloads.payloadCreateBookingWhithMoreParameters().toString())
                .post("booking");
    }

    @Step("Criar uma nova reserva com header Accept inválido")
    public Response createBookingWithInvalidHeaderAccept(){
        return given()
                .header("Content-Type","application/json")
                .header("Accept","applicant/jason")
                .when()
                .body(bookingPayloads.payloadCreateBooking().toString())
                .post("booking");
    }


}
