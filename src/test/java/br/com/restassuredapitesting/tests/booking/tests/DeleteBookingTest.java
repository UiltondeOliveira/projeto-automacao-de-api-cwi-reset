package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.*;
import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.requests.DeleteBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Feature("Feature - Exclusão de reservas")
public class DeleteBookingTest extends BaseTest {

    GetBookingRequest getBookingRequest = new GetBookingRequest();
    DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();
    PostAuthRequest postAuthRequest = new PostAuthRequest();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Category({AllTests.class, AcceptanceTests.class, SmokeTests.class})
    @DisplayName("Deleta uma reserva somento utilizando token")
    public void deleteExistingBookingWhithToken(){
        int firstId = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        deleteBookingRequest.deleteBookingToken(firstId, postAuthRequest.getToken())
                .then()
                .statusCode(201);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Category({AllTests.class, E2eTests.class})
    @DisplayName("Tenta excluir uma reserva que não exite")
    public void deleteNonExistingBooking(){
        int id = 999999;
        deleteBookingRequest.deleteBookingToken(id, postAuthRequest.getToken())
                .then()
                .statusCode(405);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Category({AllTests.class, E2eTests.class,SecurityTests.class})
    @DisplayName("Tenta excluir uma reserva sem autorização")
    public void deleteExistingBookingWhithoutAuthorization(){
        int firstId = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        deleteBookingRequest.deleteBookingWithoutToken(firstId)
                .then()
                .statusCode(403);
    }

}
