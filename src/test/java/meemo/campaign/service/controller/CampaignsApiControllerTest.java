package meemo.campaign.service.controller;

import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CampaignsApiControllerTest {

    @LocalServerPort
    int randomServerPort;

    @Test
    public void givenNothing_whenGetCampaigns_thenReturn200WithContentTypeJSON() {
        given()
                .port(randomServerPort)
            .get("/v1/campaigns")
            .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

}
