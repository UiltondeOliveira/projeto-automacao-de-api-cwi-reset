package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.AcceptanceTests;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.ContractTests;
import br.com.restassuredapitesting.suites.E2eTests;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.greaterThan;

@Feature("Feature - Retorno de reservas")
public class GetBookingTest extends BaseTest {

    GetBookingRequest getBookingRequest = new GetBookingRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Listar Ids de reservas")
    public void validaListagemDeIdsDasReservas(){
        getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class})
    public void validaReservaEspecifica(){
        int firstId = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        getBookingRequest.bookingReturnSpecificId(firstId)
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, ContractTests.class})
    @DisplayName("Garantir o Schema de retorno da listagem de reservas")
    public void validaSchemaDaListagemDeReservas(){
        getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking","bookings"))));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Category({AllTests.class})
    @DisplayName("Garatir o Schema do retorno de uma reserva específica")
    public void validaSchemaDeReservaEspecifica(){
        int firstId = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        getBookingRequest.bookingReturnSpecificId(firstId)
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking","booking"))));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, AcceptanceTests.class})
    public void validaListagemDeReservasComFiltroFirstname(){
        String firstName = "James";

        getBookingRequest.bookingListReturnIdsFilteredForFirstname(firstName)
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, AcceptanceTests.class})
    public void validaListagemDeReservasComFiltroLastname(){
        String lastName = "Brown";

        getBookingRequest.bookingListReturnIdsFilteredForLastname(lastName)
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, AcceptanceTests.class})
    public void validaListagemDeReservasComFiltroCheckin(){
        String dateCheckin = "2021-04-14";
        getBookingRequest.bookingListReturnIdsFilteredCheckin(dateCheckin)
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, AcceptanceTests.class})
    public void validaListagemDeReservasComFiltroCheckout(){
        String dateCheckout = "2021-05-14";
        getBookingRequest.bookingListReturnIdsFilteredCheckout(dateCheckout)
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, AcceptanceTests.class})
    public void validaListagemDeReservasComFiltrosPorCheckoutECheckout(){
        String dateCheckout = "2019-01-01";
        getBookingRequest.bookingListReturnIdsFilteredByCheckoutAndCheckout(dateCheckout)
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, AcceptanceTests.class})
    public void validaListagemDeReservasComFiltrosPorNomeECheckinECheckout(){
        String name = "James";
        String dateCheckin = "2018-01-01";
        String dateCheckout = "2019-01-01";
        getBookingRequest.bookingListReturnIdsFilteredByNameAndCheckinAndCheckout(name, dateCheckin, dateCheckout)
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, E2eTests.class})
    public void validaErro500AoUtilizarFiltroMalFormatado(){

        String firstName = "James";

        getBookingRequest.returnError500WhenSendingPoorlyFormattedFilter(firstName)
                .then()
                .statusCode(500);
    }





}
