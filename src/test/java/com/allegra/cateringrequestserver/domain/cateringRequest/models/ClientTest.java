package com.allegra.cateringrequestserver.domain.cateringRequest.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientTest {
    @Test
    public void constructorTest01(){
        Client client = new Client();
        client.setId(1L);

        String expected = "Allegra, Garland, allegragar@gmail.com, Birthday party for 2";
        String actual = client.toString();

        Assertions.assertEquals(expected, actual);
    }
}


