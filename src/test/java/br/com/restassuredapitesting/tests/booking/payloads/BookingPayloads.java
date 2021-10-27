package br.com.restassuredapitesting.tests.booking.payloads;

import com.github.javafaker.ChuckNorris;
import com.github.javafaker.Faker;
import org.json.JSONObject;

public class BookingPayloads {

    Faker faker = new Faker();
    String firstnameFaker = faker.name().firstName();
    String lastNameFaker = faker.name().lastName();
    String additionalneedsFaker = faker.music().instrument();

    JSONObject payload = new JSONObject();
    JSONObject bookingDates = new JSONObject();

    public JSONObject payloadValidBooking(){

        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2019-01-01");

        payload.put("firstname",firstnameFaker);
        payload.put("lastname",lastNameFaker);
        payload.put("totalprice",111);
        payload.put("depositpaid",true);
        payload.put("bookingdates",bookingDates);
        payload.put("additionalneeds",additionalneedsFaker);

        return payload;
    }

    public JSONObject payloadCreateBooking(){

        bookingDates.put("checkin","2021-01-01");
        bookingDates.put("checkout","2022-01-01");

        payload.put("firstname",firstnameFaker);
        payload.put("lastname",lastNameFaker);
        payload.put("totalprice",130);
        payload.put("depositpaid",true);
        payload.put("bookingdates",bookingDates);
        payload.put("additionalneeds",additionalneedsFaker);

        return payload;
    }
}
