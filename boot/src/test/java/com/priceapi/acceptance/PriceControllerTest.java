package com.priceapi.acceptance;

import com.priceapi.PriceApiApplication;
import com.priceapi.v1.dto.ActivePriceDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@SpringBootTest(classes = PriceApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    protected TestRestTemplate testRestTemplate;

    protected final String host = "http://localhost:";
    protected final Long productId = 35455L;
    protected final Long brandId = 1L;
    protected final String endpoint = "/priceapi/v1/active-prices";
    protected final String date1 = "2020-06-14T10:00Z";
    protected final String date2 = "2020-06-14T16:00Z";
    protected final String date3 = "2020-06-14T21:00Z";
    protected final String date4 = "2020-06-15T10:00Z";
    protected final String date5 = "2020-06-16T21:00Z";

    private String buildUrl(String date) {
        return this.host
                + this.port
                + this.endpoint
                + "/" + this.productId
                + "/" + this.brandId
                + "/" + date;
    }

    private ResponseEntity<ActivePriceDTO> consumeEndpoint(String date) {
        String url = this.buildUrl(date);
        return this.testRestTemplate.getForEntity(url, ActivePriceDTO.class);
    }

    @Test
    void given_BrandIdAndProductIdAndDate20200614T1000Z_when_activePrice_then_callPriceService() throws Exception {

        ResponseEntity<ActivePriceDTO> response = this.consumeEndpoint(date1);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(Objects.requireNonNull(response.getBody()).getPrice()).isEqualTo(35.50F);
    }

    @Test
    void given_BrandIdAndProductIdAndDate20200614T1600Z_when_activePrice_then_callPriceService() throws Exception {

        ResponseEntity<ActivePriceDTO> response = this.consumeEndpoint(date2);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(Objects.requireNonNull(response.getBody()).getPrice()).isEqualTo(25.45F);
    }

    @Test
    void given_BrandIdAndProductIdAndDate20200614T2100Z_when_activePrice_then_callPriceService() throws Exception {

        ResponseEntity<ActivePriceDTO> response = this.consumeEndpoint(date3);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(Objects.requireNonNull(response.getBody()).getPrice()).isEqualTo(35.50F);
    }

    @Test
    void given_BrandIdAndProductIdAndDate20200615T1000Z_when_activePrice_then_callPriceService() throws Exception {

        ResponseEntity<ActivePriceDTO> response = this.consumeEndpoint(date4);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(Objects.requireNonNull(response.getBody()).getPrice()).isEqualTo(30.50F);
    }

    @Test
    void given_BrandIdAndProductIdAndDate20200616T2100Z_when_activePrice_then_callPriceService() throws Exception {

        ResponseEntity<ActivePriceDTO> response = this.consumeEndpoint(date5);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(Objects.requireNonNull(response.getBody()).getPrice()).isEqualTo(38.95F);
    }

}
