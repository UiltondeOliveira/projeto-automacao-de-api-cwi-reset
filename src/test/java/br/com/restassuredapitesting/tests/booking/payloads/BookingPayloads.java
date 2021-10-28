package br.com.restassuredapitesting.tests.booking.payloads;

import com.github.javafaker.*;
import org.json.JSONObject;

import java.util.Random;

public class BookingPayloads {

    Faker faker = new Faker();
    String firstnameFaker = faker.name().firstName();
    String lastNameFaker = faker.name().lastName();
    Random random = new Random();

    JSONObject payload = new JSONObject();
    JSONObject bookingDates = new JSONObject();

    int totalPrice = random.nextInt(100)+100;

    public JSONObject payloadValidBooking(){

        String additionalneedsFaker = faker.address().cityName();

        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2019-01-01");

        payload.put("firstname",firstnameFaker);
        payload.put("lastname",lastNameFaker);
        payload.put("totalprice",totalPrice);
        payload.put("depositpaid",true);
        payload.put("bookingdates",bookingDates);
        payload.put("additionalneeds",additionalneedsFaker);

        return payload;
    }

    public JSONObject payloadCreateBooking(){

        String additionalneedsFaker = faker.university().name();

        bookingDates.put("checkin","2021-01-01");
        bookingDates.put("checkout","2022-01-01");

        payload.put("firstname",firstnameFaker);
        payload.put("lastname",lastNameFaker);
        payload.put("totalprice",totalPrice);
        payload.put("depositpaid",true);
        payload.put("bookingdates",bookingDates);
        payload.put("additionalneeds",additionalneedsFaker);

        return payload;
    }

    public JSONObject payloadCreateBookingWhithMoreParameters(){

        String additionalneedsFaker = faker.music().genre();

        bookingDates.put("checkin","2021-01-01");
        bookingDates.put("checkout","2022-01-01");

        payload.put("firstname",firstnameFaker);
        payload.put("lastname",lastNameFaker);
        payload.put("street","Rua Agusta");
        payload.put("totalprice",totalPrice);
        payload.put("discount",15);
        payload.put("depositpaid",true);
        payload.put("bookingdates",bookingDates);
        payload.put("additionalneeds",additionalneedsFaker);

        return payload;
    }
}
