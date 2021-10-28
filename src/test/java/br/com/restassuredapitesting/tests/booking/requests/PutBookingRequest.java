package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.booking.payloads.BookingPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;

import static io.restassured.RestAssured.given;

public class PutBookingRequest {
    BookingPayloads bookingPayloads = new BookingPayloads();

@Step("Atualização uma reserva utilizando o parâmetro token")
    public Response updateBookingToken(int id, String token){
        return given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Cookie",token)
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .put("booking/"+ id);
    }


@Step("Atualização de uma reserva utilizando o parâmetro Basic Auth")
    public Response updateBookingBasicAuth(int id){

    String credentials = "admin:password123";
    byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());
    String encodedCredentialsAsString = new String(encodedCredentials);

    return given()
            .header("Content-Type","application/json")
            .header("Accept","application/json")
            .header("Authorization","Basic " + encodedCredentialsAsString)
            .when()
            .body(bookingPayloads.payloadValidBooking().toString())
            .put("booking/"+ id);
}

    @Step("Atualização de uma reserva quando o parâmetro token não for enviado")
    public Response updateBookingWithoutSendedToken(int id){
        return given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Cookie","")
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .put("booking/"+ id);
    }


    @Step("Atualização de uma reserva específica utilizando token inválido")
    public Response updateBookingWithTokenSendInvalidly(int id){
        return given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Cookie","abc123")
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .put("booking/"+ id);
    }





}
