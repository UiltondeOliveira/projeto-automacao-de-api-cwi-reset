package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.booking.payloads.BookingPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;

import static io.restassured.RestAssured.given;

public class PutBookingRequest {
    BookingPayloads bookingPayloads = new BookingPayloads();

@Step("Atualiza uma reserva específica utilizando o parâmetro token")
    public Response updateBookingToken(int id, String token){
        return given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Cookie",token)
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .put("booking/"+ id);
    }


@Step("Atualiza uma reserva específica utilizando o parâmetro Basic Auth")
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


}
