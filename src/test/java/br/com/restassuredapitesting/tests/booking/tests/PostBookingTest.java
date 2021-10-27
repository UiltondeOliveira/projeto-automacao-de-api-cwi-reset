package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.AcceptanceTests;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.tests.booking.payloads.BookingPayloads;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.PostBookingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import static org.hamcrest.Matchers.greaterThan;

@Feature("Feature - Criação de reservas")
public class PostBookingTest extends BaseTest {

    PostBookingRequest postBookingRequest = new PostBookingRequest();
    BookingPayloads payloads = new BookingPayloads();
    GetBookingRequest getBookingRequest = new GetBookingRequest();


    @Test
    @Category({AllTests.class, AcceptanceTests.class})
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Criar uma nova reserva")
    public void validarCriacaoDeUmaNovaReserva(){
        postBookingRequest.createBooking()
                .then()
                .log().all()
                .statusCode(200)
                .body("size()",greaterThan(0));


    }


}
