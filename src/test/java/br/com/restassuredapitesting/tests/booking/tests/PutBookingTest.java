package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.AcceptanceTests;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.PutBookingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.greaterThan;

@Feature("Feature - Atualização de reservas")
public class PutBookingTest extends BaseTest {

    PutBookingRequest putBookingRequest = new PutBookingRequest();
    GetBookingRequest getBookingRequest = new GetBookingRequest();
    PostAuthRequest postAuthRequest = new PostAuthRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Alterar uma reserva somento utilizando token")
    public void validarAlteracaoDeUmaReservaUtilizandoToken(){
        int primeiroId = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        putBookingRequest.updateBookingToken(primeiroId, postAuthRequest.getToken())
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }


    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Alterar uma reserva somento utilizando Basic Auth")
    public void validarAlteracaoDeUmaReservaUtilizandoBasicAuth(){
        int firstId = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        putBookingRequest.updateBookingBasicAuth(firstId)
                .then()
                .log().all()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

}
