package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.AcceptanceTests;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.E2eTests;
import br.com.restassuredapitesting.tests.booking.requests.PostBookingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import static org.hamcrest.Matchers.greaterThan;

@Feature("Feature - Criação de reservas")
public class PostBookingTest extends BaseTest {

    PostBookingRequest postBookingRequest = new PostBookingRequest();

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

    @Test
    @Category({AllTests.class, E2eTests.class})
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Criar uma nova reserva com payload inválido")
    public void validarCriacaoDeUmaNovaReservaComPayloadInvalido(){
        postBookingRequest.createBookingWithInvalidPayload()
                .then()
                .log().all()
                .statusCode(500);
    }

    @Test
    @Category({AllTests.class, E2eTests.class})
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Criar mais de uma nova reserva")
    public void validarCriacaoDeMaisDeUmaNovaReserva(){

        for(int i=1; i<= 5; i++){
        validarCriacaoDeUmaNovaReserva();
        }
    }

    @Test
    @Category({AllTests.class, E2eTests.class})
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Criar uma nova reserva com payload inválido")
    public void validarCriacaoDeUmaNovaReservaComMaisParametrosNoPayload(){
        postBookingRequest.createBookingWhithMoreParameters()
                .then()
                .log().all()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }


    @Test
    @Category({AllTests.class, E2eTests.class})
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Criar uma nova reserva com header accept inválido")
    public void validarCriacaoDeUmaNovaReservaComHeaderAcceptInvalido(){
        postBookingRequest.createBookingWithInvalidHeaderAccept()
                .then()
                .log().all()
                .statusCode(418);
    }


}
